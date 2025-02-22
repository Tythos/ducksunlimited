package net.tythos.ducksunlimited;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRendering {
    public static final SimpleParticleType SPARKLE_PARTICLE = FabricParticleTypes.simple();

    public static void initialize() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of("ducksunlimited", "sparkle_particle"),
                SPARKLE_PARTICLE);
    }
}
