// package net.tythos.ducksunlimited;

// import net.minecraft.block.Block;
// import net.minecraft.world.World;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.entity.Entity;
// import net.minecraft.block.BlockState;
// import net.minecraft.entity.LivingEntity;
// import net.minecraft.server.world.ServerWorld;
// import net.minecraft.entity.damage.DamageSource;
// import net.minecraft.registry.RegistryKeys;

// public class TaterBlock extends Block {
// public TaterBlock(Settings settings) {
// super(settings);
// }

// @Override
// public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity
// entity) {
// if (entity instanceof LivingEntity && world instanceof ServerWorld
// serverWorld) {
// DamageSource damageSource = new DamageSource(
// world.getRegistryManager()
// .getOrThrow(RegistryKeys.DAMAGE_TYPE)
// .getEntry(DucksUnlimitedDamageTypes.TATER_DAMAGE.getValue()).get());
// entity.damage(serverWorld, damageSource, 5.0f);
// }
// }
// }
