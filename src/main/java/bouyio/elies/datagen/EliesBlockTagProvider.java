package bouyio.elies.datagen;

import bouyio.elies.block.EliesBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class EliesBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public EliesBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(EliesBlocks.olive_door);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(EliesBlocks.olive_press_block)
                .add(EliesBlocks.empty_press_block)
                .add(EliesBlocks.olive_oil_press_block)
                .add(EliesBlocks.olive_log)
                .add(EliesBlocks.olive_planks)
                .add(EliesBlocks.olive_slab)
                .add(EliesBlocks.olive_stairs)
                .add(EliesBlocks.stripped_olive_log)
                .add(EliesBlocks.olive_wood)
                .add(EliesBlocks.stripped_olive_wood)
                .add(EliesBlocks.olive_door)
                .add(EliesBlocks.olive_trapdoor)
                .add(EliesBlocks.olive_fence)
                .add(EliesBlocks.olive_fence_gate)
                .add(EliesBlocks.olive_button)
                .add(EliesBlocks.olive_pressure_plate)
                .add(EliesBlocks.olive_oil_press_block)
                .add(EliesBlocks.olive_press_block)
                .add(EliesBlocks.empty_press_block);


        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(EliesBlocks.olive_log)
                .add(EliesBlocks.stripped_olive_log)
                .add(EliesBlocks.olive_wood)
                .add(EliesBlocks.stripped_olive_wood);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(EliesBlocks.olive_planks);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(EliesBlocks.olive_slab);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(EliesBlocks.olive_stairs);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(EliesBlocks.olive_trapdoor);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(EliesBlocks.olive_fence);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(EliesBlocks.olive_fence_gate);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(EliesBlocks.olive_pressure_plate);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(EliesBlocks.olive_button);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(EliesBlocks.olive_leaves);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(EliesBlocks.olive_sapling);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(EliesBlocks.potted_olive_sapling);



    }
}
