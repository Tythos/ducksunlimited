// package net.tythos.ducksunlimited;

// import net.minecraft.sound.SoundEvent;
// import net.minecraft.sound.SoundCategory;

// public class EngineSoundInstance extends AbstractDynamicSoundInstance {
// public EngineSoundInstance(DynamicSoundSource soundSource, SoundEvent
// soundEvent, SoundCategory soundCategory,
// int startTransitionTicks, int endTransitionTicks, float maxVolume, float
// minPitch, float maxPitch,
// SoundInstanceCallback callback) {
// super(soundSource, soundEvent, soundCategory, startTransitionTicks,
// endTransitionTicks, maxVolume, minPitch,
// maxPitch, callback);
// }

// @Override
// public void tick() {
// if (soundSource instanceof EngineBlockEntity blockEntity &&
// blockEntity.isRemoved()) {
// this.end();
// }
// super.tick();
// this.modulateSoundForTransition();
// this.modulateSoundForStress();
// }
// }
