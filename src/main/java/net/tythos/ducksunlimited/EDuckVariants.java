package net.tythos.ducksunlimited;

import net.minecraft.util.Identifier;

public enum EDuckVariants {
    BUFFLEHEAD(0, DucksUnlimited.get_resource_location("textures/entity/bufflehead.png")),
    MALLARD(1, DucksUnlimited.get_resource_location("textures/entity/mallard.png")),
    MANDARIN(2, DucksUnlimited.get_resource_location("textures/entity/mandarin.png")),
    PACIFIC_BLACK(3, DucksUnlimited.get_resource_location("textures/entity/pacific_black.png")),
    WOOD(4, DucksUnlimited.get_resource_location("textures/entity/wood.png"));

    public final byte id;
    public final Identifier texture;

    EDuckVariants(int id, Identifier texture) {
        this.texture = texture;
        this.id = (byte) id;
    }
}
