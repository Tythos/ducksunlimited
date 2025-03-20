package net.tythos.ducksunlimited;

import software.bernie.geckolib.animatable.GeoEntity;
import net.minecraft.world.level.LevelInfo;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import net.minecraft.entity.EntityType;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.AnimatableManager;
import net.minecraft.world.entity.EntityLookup;

public class DuckEntity extends EntityLookup implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public DuckEntity(EntityType<DuckEntity> entityType, LevelInfo levelInfo) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        event.getController().setAnimation(AnimationConstants.IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", 10, this::predicate));
    }
}
