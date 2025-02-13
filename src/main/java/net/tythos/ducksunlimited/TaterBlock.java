package net.tythos.ducksunlimited;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.entity.Entity;

public class TaterBlock extends Block {
    public static final RegistryKey<DamageType> TATER_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            Identifier.of("ducksunlimited", "tater"));

    public TaterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity && world instanceof ServerWorld serverWorld) {
            DamageSource damageSource = new DamageSource(world.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE)
                    .getEntry(TATER_DAMAGE.getValue()).get());
            entity.damage(serverWorld, damageSource, 5.0f);
        }
    }
}
