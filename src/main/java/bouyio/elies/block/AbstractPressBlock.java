package bouyio.elies.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.WorldView;

public abstract class AbstractPressBlock extends HorizontalFacingBlock {
    private static int MAXLEVEL = 1;
    private static int MINLEVEL = 0;
    public static final EnumProperty<DoubleBlockHalf> HALF;

    public static final BooleanProperty POWERED;

    public static final IntProperty CONTENTLEVEL;

    public static final VoxelShape UPPERSHAPE;

    public static final VoxelShape LOWERSHAPE;

    public static boolean decreaseContentLevel(World world, BlockPos pos, BlockState state){
        if (state.get(CONTENTLEVEL) > 0) {
            world.setBlockState(pos, state.with(CONTENTLEVEL, state.get(CONTENTLEVEL) - 1));
            if(state.get(HALF).equals(DoubleBlockHalf.LOWER)) world.setBlockState(pos.up(), world.getBlockState(pos.up()).with(CONTENTLEVEL, state.get(CONTENTLEVEL) - 1));
            else world.setBlockState(pos.down(), world.getBlockState(pos.down()).with(CONTENTLEVEL, state.get(CONTENTLEVEL) - 1));
            return true;
        }
        return false;
    }
    public AbstractPressBlock(Settings settings, int minLevel, int maxLevel) {
        super(settings);
        MAXLEVEL = maxLevel;
        MINLEVEL = minLevel;
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(POWERED, false).with(CONTENTLEVEL, MINLEVEL).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING).add(HALF).add(POWERED).add(CONTENTLEVEL);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return state.get(HALF) == DoubleBlockHalf.LOWER ? blockState.isSideSolidFullSquare(world, blockPos, Direction.UP) : blockState.isOf(this);

    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos.up(), (BlockState)state.with(HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_ALL);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return state.get(HALF) == DoubleBlockHalf.LOWER ? LOWERSHAPE : UPPERSHAPE;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!world.isClient) {
            DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf) state.get(HALF);
            if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
                BlockPos blockPos = pos.down();
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.LOWER) {
                    BlockState blockState2 = blockState.getFluidState().isOf(Fluids.WATER) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                    world.setBlockState(blockPos, blockState2, player.isCreative() ? Block.NOTIFY_ALL | Block.SKIP_DROPS : Block.NOTIFY_ALL);
                    world.syncWorldEvent(player, WorldEvents.BLOCK_BROKEN, blockPos, Block.getRawIdFromState(blockState));
                }
            } else {
                BlockPos blockPos = pos.up();
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.UPPER) {
                    BlockState blockState2 = blockState.getFluidState().isOf(Fluids.WATER) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                    world.setBlockState(blockPos, blockState2, player.isCreative() ? Block.NOTIFY_ALL | Block.SKIP_DROPS : Block.NOTIFY_ALL);
                    world.syncWorldEvent(player, WorldEvents.BLOCK_BROKEN, blockPos, Block.getRawIdFromState(blockState));
                }
            }
        }




        return world.getBlockState(pos);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if(!world.isClient()){
            if(world.isReceivingRedstonePower(pos)){
                world.setBlockState(pos, state.with(POWERED, true), Block.NOTIFY_LISTENERS);
            }else {
                world.setBlockState(pos, state.with(POWERED, false), Block.NOTIFY_LISTENERS);
            }
        }
    }

    public static int getMAXLEVEL() {
        return MAXLEVEL;
    }

    public static int getMINLEVEL() {
        return MINLEVEL;
    }

    static  {
        HALF = Properties.DOUBLE_BLOCK_HALF;
        POWERED = BooleanProperty.of("powered");
        CONTENTLEVEL = IntProperty.of("content_level", 0, 5);
        UPPERSHAPE = Block.createCuboidShape(0.0,-32.0,0.0,16.0,16.0,16.0);
        LOWERSHAPE = Block.createCuboidShape(0.0,0.0,0.0,16.0,32.0,16.0);
    }
}
