package bouyio.elies.datagen;

import bouyio.elies.block.AbstractPressBlock;
import bouyio.elies.block.EliesBlocks;
import bouyio.elies.item.EliesItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.loot.LootTable;

import static bouyio.elies.block.EliesBlocks.*;


public class EliesLootTableProvider extends FabricBlockLootTableProvider {
    public EliesLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {


        addDrop(olive_door, doorDrops(olive_door));

        addDrop(olive_log);
        addDrop(olive_planks);
        addDrop(olive_slab, slabDrops(olive_slab));
        addDrop(olive_stairs);
        addDrop(stripped_olive_log);
        addDrop(olive_wood);
        addDrop(stripped_olive_wood);
        addDrop(olive_trapdoor);
        addDrop(olive_fence);
        addDrop(olive_fence_gate);
        addDrop(olive_button);
        addDrop(olive_pressure_plate);
        addDrop(olive_sapling);


    }



}
