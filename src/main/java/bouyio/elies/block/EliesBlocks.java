package bouyio.elies.block;

import bouyio.elies.Elies;
import bouyio.elies.world.tree.ModSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class EliesBlocks {

    public static final Block olive_log = registerBlock("olive_log",new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_LOG)));
    public static final Block stripped_olive_log = registerBlock("stripped_olive_log",new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final Block olive_planks = registerBlock("olive_planks", new Block(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)));
    public static final Block olive_slab = registerBlock("olive_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_SLAB)));
    public static final Block olive_stairs = registerBlock("olive_stairs", new StairsBlock(olive_planks.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SPRUCE_STAIRS)));
    public static final Block olive_wood = registerBlock("olive_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WOOD)));
    public static final Block stripped_olive_wood = registerBlock("stripped_olive_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final Block olive_door = registerBlock("olive_door", new DoorBlock(BlockSetType.SPRUCE, FabricBlockSettings.copyOf(Blocks.SPRUCE_DOOR)));
    public static final Block olive_trapdoor = registerBlock("olive_trapdoor", new TrapdoorBlock(new BlockSetType("olive"), FabricBlockSettings.copyOf(Blocks.SPRUCE_TRAPDOOR)));
    public static final Block olive_fence =  registerBlock("olive_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_FENCE)));
    public static final Block olive_fence_gate = registerBlock("olive_fence_gate", new FenceGateBlock(new WoodType("olive", new BlockSetType("olive")),FabricBlockSettings.copyOf(Blocks.SPRUCE_FENCE_GATE)));
    public static final Block olive_button = registerBlock("olive_button", new ButtonBlock(new BlockSetType("olive") ,20,FabricBlockSettings.copyOf(Blocks.SPRUCE_BUTTON)));
    public static final Block olive_pressure_plate = registerBlock("olive_pressure_plate", new PressurePlateBlock(new BlockSetType("olive"), FabricBlockSettings.copyOf(Blocks.SPRUCE_PRESSURE_PLATE)));
    public static final Block olive_leaves = registerBlock("olive_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_LEAVES)));
    public static final Block olive_sapling = registerBlock("olive_sapling", new SaplingBlock(ModSaplingGenerator.OLIVE, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block potted_olive_sapling = Registry.register(Registries.BLOCK, new Identifier(Elies.MODID, "potted_olive_sapling"), Blocks.createFlowerPotBlock(olive_sapling));


    public static final EmptyPressBlock empty_press_block = Registry.register(Registries.BLOCK,new Identifier(Elies.MODID, "empty_press"),new EmptyPressBlock(FabricBlockSettings.create().pistonBehavior(PistonBehavior.IGNORE).sounds(BlockSoundGroup.WOOD).strength(0.5f).nonOpaque().notSolid().blockVision(Blocks::never)));
    public static final OlivePressBlock olive_press_block = Registry.register(Registries.BLOCK,new Identifier(Elies.MODID, "olive_press"),new OlivePressBlock(FabricBlockSettings.create().pistonBehavior(PistonBehavior.IGNORE).sounds(BlockSoundGroup.WOOD).strength(0.5f).nonOpaque().notSolid().blockVision(Blocks::never)));
    public static final OliveOilPressBlock olive_oil_press_block = Registry.register(Registries.BLOCK,new Identifier(Elies.MODID, "olive_oil_press"),new OliveOilPressBlock(FabricBlockSettings.create().pistonBehavior(PistonBehavior.IGNORE).sounds(BlockSoundGroup.WOOD).strength(0.5f).nonOpaque().notSolid().blockVision(Blocks::never)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Elies.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){

        return Registry.register(Registries.ITEM, new Identifier(Elies.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Elies.LOGGER.info("Registering block for " + Elies.MODID);
    }
}
