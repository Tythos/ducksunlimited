package net.tythos.ducksunlimited;

import software.bernie.geckolib.animatable.GeoEntity;
import net.minecraft.world.level.LevelInfo;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;

import org.jetbrains.annotations.Nullable;

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
        super(entityType, level);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
    }

    public static boolean canDuckSpawn(EntityType<DuckEntity> entity, LevelAccessor level, ModSpawnType type,
            BlockPos pos, RandomSource random) {
        if (type == ModSpawnType.SPAWNER)
            return true;
        return (level.isEmptyBlock(pos.above()) || level.isEmptyBlock(pos))
                && level.getFluidState(pos.below()).is(Fluids.WATER);
    }

    public static AttributeSupplier.Builder createDuckAttributes() {
        return Mod.createModAttributes().add(Attributes.MOVEMENT_SPEED, 0.25).add(Attributes.MAX_HEALTH, 4);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, (byte) 1);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4F));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D, BREEDING_INGREDIENT, false));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(6, new new LookAdPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookArroundGoal(this));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance,
            MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData) {
        var group = super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData);
        this.getEntityData().set(VARIANT,
                serverLevelAccessor.getRandom().nextBoolean() ? EDuckVariant.MALLARD.id : EDuckVariant.BUFFLEHEAD.id);
        return group;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.QUACK.get();
    }

    @Nullable
    @Override
    protected SouondEvent getDeathSound() {
        return ModSounds.DUCK_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource source) {
        return ModSounds.DUCK_DEATH.get();
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.getEntityData().set(VARIANT, EDuckVariant.getVariant(nbt.getString("Variant")).id);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putString("Variant", getVariant().name());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        Vec3 vec3d = this.getDeltaMovement();
        if (!this.onGround() && vec3d.y < 0.0D) {
            this.setDeltaMovement(vec3d.multiply(1.0D, 0.8D, 1.0D));
        }
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, @NotNull DamageSource damageSource) {
        return false;
    }

    public EDuckVariant getVariant() {
        return EDuckVariant.getVariant(this.entityData.get(VARIANT));
    }

    public EDuckVariant getTexture() {
        return getVariant();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.level().getFluidState(blockPosition().below()).is(FluidTags.WATER)) {
            event.getController().setAnimation(AnimationConstants.WALKING);
        } else if (!this.onGround()) {
            event.getController().setAnimation(AnimationConstants.FALLING);
        } else if (event.isMoving()) {
            event.getController().setAnimation(AnimationConstants.WALKING);
        } else {
            event.getController().setAnimation(AnimationConstants.IDLE);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
