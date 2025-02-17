// package net.tythos.ducksunlimited;

// import net.minecraft.client.MinecraftClient;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Optional;
// import net.minecraft.sound.SoundEvent;
// import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
// import net.minecraft.client.world.ClientWorld;
// import net.fabricmc.fabric.api.client.sound.v1.FabricSoundInstance;
// import net.minecraft.sound.SoundCategory;

// public class DynamicSoundManager implements SoundInstanceCallback {
// private static final MinecraftClient client = MinecraftClient.getInstance();
// private static DynamicSoundManager instance;
// private final List<AbstractDynamicSoundInstance> activeSounds = new
// ArrayList<>();

// private DynamicSoundManager() {
// }

// public static DynamicSoundManager getInstance() {
// if (instance == null) {
// instance = new DynamicSoundManager();
// }
// return instance;
// }

// @Override
// public <T extends AbstractDynamicSoundInstance> void onFinished(T
// soundInstance) {
// this.stop(soundInstance);
// }

// public <T extends AbstractDynamicSoundInstance> void play(T soundInstance) {
// if (this.activeSounds.contains(soundInstance))
// return;
// client.getSoundManager().play(soundInstance);
// this.activeSounds.add(soundInstance);
// }

// public <T extends AbstractDynamicSoundInstance> void stop(T soundInstance) {
// client.getSoundManager().stop(soundInstance);
// this.activeSounds.remove(soundInstance);
// }

// public Optional<AbstractDynamicSoundInstance>
// getPlayingSoundInstance(SoundEvent soundEvent) {
// for (var activeSound : this.activeSounds) {
// if (activeSound.getId().equals(soundEvent.id())) {
// return Optional.of(activeSound);
// }
// }
// return Optional.empty();
// }

// private static void handleS2CEngineSoundPacket(EngineSoundInstancePacket
// packet,
// ClientPlayNetworking.Context context) {
// ClientWorld world = context.client().world;
// if (world == null)
// return;
// DynamicSoundManager soundManager = DynamicSoundManager.getInstance();
// if (world.getBlockEntity(packet.blockEntityPos()) instanceof
// EngineBlockEntity engineBlockEntity) {
// if (packet.shouldStart()) {
// soundManager.play(new EngineSoundInstance(engineBlockEntity,
// ModSounds.ENGINE_LOOP,
// SoundCategory.BLOCKS, 60, 30, 1.2f, 0.8f, 1.4f, soundManager));
// return;
// }
// }
// if (!packet.shouldStart()) {
// soundManager.getPlayingSoundInstance(ModSounds.ENGINE_LOOP).ifPresent(AbstractDynamicSoundInstance::end);
// }
// }
// }
