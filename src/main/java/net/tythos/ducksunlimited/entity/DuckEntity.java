package net.tythos.ducksunlimited.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.entity.damage.DamageSource;

public class DuckEntity extends ChickenEntity {

    public DuckEntity(EntityType<? extends ChickenEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createDuckAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 4.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public SoundEvent getAmbientSound() {
        // Will be replaced with duck sound when available
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        // Will be replaced with duck sound when available
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        // Will be replaced with duck sound when available
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }
}