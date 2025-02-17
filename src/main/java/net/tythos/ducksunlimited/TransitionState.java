package net.tythos.ducksunlimited;

import net.minecraft.util.Identifier;

public enum TransitionState {
    STARTING("starting_phase"),
    RUNNING("idle_phase"),
    ENDING("ending_phase");

    private final Identifier identifier;

    TransitionState(String name) {
        this.identifier = Identifier.of("ducksunlimited", name);
    }

    public Identifier getIdentifier() {
        return identifier;
    }
}
