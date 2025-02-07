package net.tythos.ducksunlimited;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class ModComponents {
    public static final ComponentType<Integer> CLICK_COUNT_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of("ducksunlimited", "click_count"),
            ComponentType.<Integer>builder().codec(Codec.INT).build());

    public static final Codec<MyCustomComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.FLOAT.fieldOf("temperature").forGetter(MyCustomComponent::temperature),
                Codec.BOOL.optionalFieldOf("burnt", false).forGetter(MyCustomComponent::burnt))
                .apply(builder, MyCustomComponent::new);
    });

    public static final ComponentType<MyCustomComponent> MY_CUSTOM_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of("ducksunlimited", "custom"),
            ComponentType.<MyCustomComponent>builder().codec(CODEC).build());

    protected static void initialize() {
        ducksunlimited.LOGGER.info("Registering {} components", "ducksunlimited");
    }
}
