package net.tythos.ducksunlimited;

import net.minecraft.util.math.Vec3d;

public interface DynamicSoundSource {
    int getTick();

    Vec3d getPosition();

    float getNormalizedStress();
}
