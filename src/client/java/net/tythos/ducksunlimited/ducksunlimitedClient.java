package net.tythos.ducksunlimited;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ducksunlimitedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockEntityRendererFactories.register(
				ModBlockEntities.COUNTER_BLOCK_ENTITY,
				CounterBlockEntityRenderer::new);
		ModCommandsClient.initialize();
		ClientModRendering.initialize();
	}
}
