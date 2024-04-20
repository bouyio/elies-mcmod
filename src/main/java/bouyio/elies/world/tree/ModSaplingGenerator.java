package bouyio.elies.world.tree;

import bouyio.elies.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerator {
    public static final SaplingGenerator OLIVE = new SaplingGenerator("olive", 0F, Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.OLIVE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());

}
