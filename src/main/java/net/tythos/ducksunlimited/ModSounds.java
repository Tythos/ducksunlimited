package net.tythos.ducksunlimited;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;

public class ModSounds {
    public static final RegistryKey<SoundEvent> BEE_DOOP_ID = RegistryKey.of(RegistryKeys.SOUND_EVENT,
            Identifier.of("ducksunlimited", "bee_doop"));
    public static final SoundEvent BEE_DOOP = SoundEvent.of(Identifier.of("ducksunlimited", "bee_doop"));

    public static void initialize() {
        Registry.register(Registries.SOUND_EVENT, BEE_DOOP_ID, BEE_DOOP);
    }
}
