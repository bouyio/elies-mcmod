package bouyio.elies;

import bouyio.elies.datagen.EliesBlockTagProvider;
import bouyio.elies.datagen.EliesItemTagProvider;
import bouyio.elies.datagen.EliesLootTableProvider;
import bouyio.elies.datagen.EliesWorldGeneration;
import bouyio.elies.world.ModConfiguredFeatures;
import bouyio.elies.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class EliesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EliesBlockTagProvider::new);
		pack.addProvider(EliesLootTableProvider::new);
		pack.addProvider(EliesItemTagProvider::new);
		pack.addProvider(EliesWorldGeneration::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
	}
}
