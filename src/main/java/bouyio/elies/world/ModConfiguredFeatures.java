package bouyio.elies.world;

import bouyio.elies.Elies;
import bouyio.elies.block.EliesBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.IntProviderType;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> OLIVE_KEY = registerKey("olive");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, OLIVE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(EliesBlocks.olive_log),
                new BendingTrunkPlacer(2, 2, 1, 3, ConstantIntProvider.create(1)),
                BlockStateProvider.of(EliesBlocks.olive_leaves),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), 2),

                new TwoLayersFeatureSize(1, 0, 2)

        ).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Elies.MODID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
