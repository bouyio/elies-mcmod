package bouyio.elies.item;

import bouyio.elies.Elies;
import bouyio.elies.block.EliesBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class EliesItems {


    public static final Item olive = registerItem("olive", new Item(new Item.Settings().food(new FoodComponent.Builder().snack().hunger(4).alwaysEdible().saturationModifier(0.7f).build())));
    public static final Item glass_jug = registerItem("glass_jug", new GlassJug(new Item.Settings()));
    public static final Item water_jug = registerItem("water_jug", new JugPotionItem(new Item.Settings().maxCount(1)));
    public static final Item olive_oil_jug = registerItem("olive_oil_jug", new OliveOilJugItem(new Item.Settings().food(new FoodComponent.Builder().hunger(4).alwaysEdible().build())));
    public static final Item press = registerItem("press", new BlockItem(EliesBlocks.empty_press_block, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Elies.MODID, name), item);

    }

    public static void registerModItems(){
        Elies.LOGGER.info("Registering items for " + Elies.MODID);
    }
}
