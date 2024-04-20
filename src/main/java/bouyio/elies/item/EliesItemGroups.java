package bouyio.elies.item;

import bouyio.elies.Elies;
import bouyio.elies.block.EliesBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class EliesItemGroups {
    public static final ItemGroup moddin_items = Registry.register(Registries.ITEM_GROUP, new Identifier(Elies.MODID , "elies_items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.elies"))
                    .icon(() -> new ItemStack(EliesItems.olive)).entries((displayContext, entries) -> {


                        entries.add(EliesBlocks.olive_log);
                        entries.add(EliesBlocks.stripped_olive_log);
                        entries.add(EliesBlocks.olive_planks);
                        entries.add(EliesBlocks.olive_slab);
                        entries.add(EliesBlocks.olive_stairs);
                        entries.add(EliesBlocks.olive_wood);
                        entries.add(EliesBlocks.stripped_olive_wood);
                        entries.add(EliesBlocks.olive_door);
                        entries.add(EliesBlocks.olive_trapdoor);
                        entries.add(EliesBlocks.olive_fence);
                        entries.add(EliesBlocks.olive_fence_gate);
                        entries.add(EliesBlocks.olive_button);
                        entries.add(EliesBlocks.olive_pressure_plate);
                        entries.add(EliesBlocks.olive_leaves);
                        entries.add(EliesBlocks.olive_sapling);
                        entries.add(EliesItems.olive);
                        entries.add(EliesItems.press);
                        entries.add(EliesItems.glass_jug);
                        entries.add(EliesItems.water_jug);
                        entries.add(EliesItems.olive_oil_jug);



                    }).build());



    public static void registerItemGroups(){
        Elies.LOGGER.info("Registering item groups for " + Elies.MODID + '.');
    }
}
