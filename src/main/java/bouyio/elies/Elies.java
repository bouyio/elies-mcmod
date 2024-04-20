package bouyio.elies;

import bouyio.elies.block.EliesBlocks;
import bouyio.elies.datagen.EliesBlockTagProvider;
import bouyio.elies.item.EliesItemGroups;
import bouyio.elies.item.EliesItems;
import bouyio.elies.world.ModConfiguredFeatures;
import bouyio.elies.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.impl.content.registry.FlammableBlockRegistryImpl;
import net.minecraft.block.SaplingGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Elies implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "elies";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		EliesItems.registerModItems();
		EliesBlocks.registerModBlocks();
		EliesItemGroups.registerItemGroups();

		StrippableBlockRegistry.register(EliesBlocks.olive_log, EliesBlocks.stripped_olive_log);
		StrippableBlockRegistry.register(EliesBlocks.olive_wood, EliesBlocks.stripped_olive_wood);

		ModWorldGeneration.generateModWorldGen();

		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_wood, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.stripped_olive_wood, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_log, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.stripped_olive_log, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_planks, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_slab, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_stairs, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_pressure_plate, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_button, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_door, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_fence, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_fence_gate, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_leaves, 30, 60);

		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.empty_press_block, 5, 3);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_press_block, 3, 3);
		FlammableBlockRegistry.getDefaultInstance().add(EliesBlocks.olive_oil_press_block, 10, 20);




		LOGGER.info("Initialized.");
	}
}