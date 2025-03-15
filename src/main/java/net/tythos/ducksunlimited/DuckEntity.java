package net.tythos.ducksunlimited;

import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class DuckEntity extends AnimalEntity {
    public DuckEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return ModEntity.createModAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }
}
