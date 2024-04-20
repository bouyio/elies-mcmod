package bouyio.elies.datagen;

import bouyio.elies.Elies;

import bouyio.elies.block.EliesBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class EliesItemTagProvider extends FabricTagProvider.ItemTagProvider {
    private static final TagKey<Item> OLIVE_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(Elies.MODID, "olive_logs"));
    public EliesItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(OLIVE_LOGS)
                .add(EliesBlocks.stripped_olive_log.asItem())
                .add(EliesBlocks.stripped_olive_wood.asItem())
                .add(EliesBlocks.olive_wood.asItem())
                .add(EliesBlocks.olive_log.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(EliesBlocks.stripped_olive_log.asItem())
                .add(EliesBlocks.stripped_olive_wood.asItem())
                .add(EliesBlocks.olive_wood.asItem())
                .add(EliesBlocks.olive_log.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(EliesBlocks.olive_planks.asItem());

    }
}