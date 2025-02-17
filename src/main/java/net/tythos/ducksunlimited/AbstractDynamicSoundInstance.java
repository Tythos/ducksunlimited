// package net.tythos.ducksunlimited;

// import net.minecraft.util.math.MathHelper;
// import net.minecraft.client.sound.MovingSoundInstance;
// import net.minecraft.sound.SoundEvent;
// import net.minecraft.sound.SoundCategory;
// import net.minecraft.client.sound.SoundInstance;

// public abstract class AbstractDynamicSoundInstance extends
// MovingSoundInstance {
// protected final DynamicSoundSource soundSource;
// protected TransitionState transitionState;
// protected final int startTransitionTicks, endTransitionTicks;
// protected final float maxVolume;
// protected final float minPitch, maxPitch;
// protected int currentTick = 0, transitionTick = 0;
// protected final SoundInstanceCallback callback;

// protected AbstractDynamicSoundInstance(DynamicSoundSource soundSource,
// SoundEvent soundEvent,
// SoundCategory soundCategory, int startTransitionTicks, int
// endTransitionTicks, float maxVolume,
// float minPitch, float maxPitch, SoundInstanceCallback callback) {
// super(soundEvent, soundCategory, SoundInstance.createRandom());
// this.soundSource = soundSource;
// this.callback = callback;
// this.maxVolume = maxVolume;
// this.minPitch = minPitch;
// this.maxPitch = maxPitch;
// this.startTransitionTicks = startTransitionTicks;
// this.endTransitionTicks = endTransitionTicks;
// this.volume = 0.0f;
// this.pitch = minPitch;
// this.repeat = true;
// this.transitionState = TransitionState.STARTING;
// this.setPositionToEntity();
// }

// @Override
// public boolean shouldAlwaysPlay() {
// return true;
// }

// @Override
// public void tick() {
// if (this.soundSource == null) {
// this.callback.onFinished(this);
// }
// this.currentTick++;
// this.setPositionToEntity();
// switch (this.transitionState) {
// case STARTING -> {
// this.transitionTick++;
// if (this.transitionTick > this.startTransitionTicks) {
// this.transitionTick = 0;
// this.transitionState = TransitionState.RUNNING;
// }
// }
// case ENDING -> {
// this.transitionTick++;
// if (this.transitionTick > this.endTransitionTicks) {
// this.callback.onFinished(this);
// }
// }
// case RUNNING -> {
// }
// }
// }

// protected void modulateSoundForTransition() {
// float normalizedTick = switch (transitionState) {
// case STARTING -> (float) this.transitionTick / this.startTransitionTicks;
// case ENDING -> 1.0f - ((float) this.transitionTick /
// this.endTransitionTicks);
// default -> 1.0f;
// };
// this.volume = MathHelper.lerp(normalizedTick, 0.0f, this.maxVolume);
// }

// protected void modulateSoundForStress() {
// this.pitch = MathHelper.lerp(this.soundSource.getNormalizedStress(),
// this.minPitch, this.maxPitch);
// }

// protected void setPositionToEntity() {
// this.x = soundSource.getPosition().getX();
// this.y = soundSource.getPosition().getY();
// this.z = soundSource.getPosition().getZ();
// }

// public void end() {
// this.transitionState = TransitionState.ENDING;
// }
// }
