package net.tythos.ducksunlimited;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DucksUnlimitedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(DucksUnlimited.DUCK, DuckRenderer::new);
	}
}
