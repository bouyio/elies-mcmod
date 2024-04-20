package bouyio.elies.block;

import bouyio.elies.item.EliesItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OlivePressBlock extends AbstractPressBlock{

    public OlivePressBlock(Settings settings) {
        super(settings, 1, 5);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if(!world.isClient()){
            if(world.isReceivingRedstonePower(pos)){
                world.setBlockState(pos, state.with(POWERED, true), Block.NOTIFY_LISTENERS);
            }else {
                if (state.get(POWERED)) {
                    world.setBlockState(pos, state.with(POWERED, false), Block.NOTIFY_LISTENERS);
                    if (state.get(CONTENTLEVEL) == 5) {

                        if(state.get(HALF).equals(DoubleBlockHalf.LOWER)){
                            state = EliesBlocks.olive_oil_press_block.getDefaultState().with(CONTENTLEVEL, 5).with(FACING, state.get(FACING));
                            world.setBlockState(pos, state);
                            world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER));
                        } else {
                            state = EliesBlocks.olive_oil_press_block.getDefaultState().with(CONTENTLEVEL, 5).with(FACING, state.get(FACING));
                            world.setBlockState(pos, state.with(HALF, DoubleBlockHalf.UPPER));
                            world.setBlockState(pos.down(), state);
                        }
                    }
                }
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getMainHandStack();
        if(itemStack.isOf(EliesItems.olive) && state.get(CONTENTLEVEL) < 5){
            world.setBlockState(pos, state.cycle(CONTENTLEVEL));
            if(state.get(HALF).equals(DoubleBlockHalf.LOWER)) world.setBlockState(pos.up(), world.getBlockState(pos.up()).cycle(CONTENTLEVEL));
            else world.setBlockState(pos.down(), world.getBlockState(pos.down()).cycle(CONTENTLEVEL));
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

}
