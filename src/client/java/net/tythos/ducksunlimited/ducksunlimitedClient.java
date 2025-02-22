package net.tythos.ducksunlimited;

import net.fabricmc.api.ClientModInitializer;
// import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.client.gui.widget.GridWidget;
import net.tythos.ducksunlimited.ModRendering;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.EndRodParticle;

public class ducksunlimitedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// BlockEntityRendererFactories.register(
		// ModBlockEntities.COUNTER_BLOCK_ENTITY,
		// CounterBlockEntityRenderer::new);
		ModCommandsClient.initialize();
		// ClientModRendering.initialize();
		ParticleFactoryRegistry.getInstance().register(
				ModRendering.SPARKLE_PARTICLE,
				EndRodParticle.Factory::new);
	}
}
