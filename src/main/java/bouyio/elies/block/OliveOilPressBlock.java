package bouyio.elies.block;

import bouyio.elies.item.EliesItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class OliveOilPressBlock extends AbstractPressBlock {
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getMainHandStack();
        if(itemStack.isOf(EliesItems.glass_jug)){
            if(decreaseContentLevel(world,pos,state)) {
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                world.emitGameEvent(player, GameEvent.FLUID_PICKUP, pos);
                ItemUsage.exchangeStack(itemStack, player, new ItemStack(EliesItems.olive_oil_jug));

            }
            if(state.get(CONTENTLEVEL) == 1){
                if(state.get(HALF).equals(DoubleBlockHalf.LOWER)){
                    state = EliesBlocks.empty_press_block.getDefaultState().with(CONTENTLEVEL, 0).with(FACING, state.get(FACING));
                    world.setBlockState(pos, state);
                    world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER));
                } else {
                    state = EliesBlocks.empty_press_block.getDefaultState().with(CONTENTLEVEL, 0).with(FACING, state.get(FACING));
                    world.setBlockState(pos, state.with(HALF, DoubleBlockHalf.UPPER));
                    world.setBlockState(pos.down(), state);
                }

                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                world.emitGameEvent(player, GameEvent.FLUID_PICKUP, pos);
                ItemUsage.exchangeStack(itemStack, player, new ItemStack(EliesItems.olive_oil_jug));
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    public OliveOilPressBlock(Settings settings) {
        super(settings,0,5);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
