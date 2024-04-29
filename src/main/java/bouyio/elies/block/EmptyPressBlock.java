package bouyio.elies.block;

import bouyio.elies.item.EliesItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EmptyPressBlock extends AbstractPressBlock{

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getMainHandStack();
        if (itemStack.isOf(EliesItems.olive)){
            if(state.get(HALF).equals(DoubleBlockHalf.LOWER)){
                state = EliesBlocks.olive_press_block.getDefaultState().with(CONTENTLEVEL, 1).with(FACING, state.get(FACING));
                world.setBlockState(pos, state);
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER));
            } else {
                state = EliesBlocks.olive_press_block.getDefaultState().with(CONTENTLEVEL, 1).with(FACING, state.get(FACING));
                world.setBlockState(pos, state.with(HALF, DoubleBlockHalf.UPPER));
                world.setBlockState(pos.down(), state);
            }
            ItemUsage.exchangeStack(itemStack, player, new ItemStack(Items.AIR));
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    public EmptyPressBlock(Settings settings) {
        super(settings, 0, 1);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

}
