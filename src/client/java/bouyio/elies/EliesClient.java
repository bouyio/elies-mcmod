package bouyio.elies;

import bouyio.elies.block.EliesBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EliesClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(EliesBlocks.olive_press_block, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(EliesBlocks.olive_oil_press_block, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(EliesBlocks.empty_press_block, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(EliesBlocks.olive_sapling, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(EliesBlocks.potted_olive_sapling, RenderLayer.getCutout());

	}
}