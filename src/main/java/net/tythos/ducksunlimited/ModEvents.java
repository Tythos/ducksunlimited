package net.tythos.ducksunlimited;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModEvents {
    private static final Identifier COAL_ORE_LOOT_TABLE_ID = Identifier.of("minecraft", "blocks/coal_ore");

    public static void initialize() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            BlockState state = world.getBlockState(pos);
            if (!player.isSpectator() && player.getMainHandStack().isEmpty() && state.isToolRequired()
                    && world instanceof ServerWorld serverWorld) {
                player.damage(serverWorld, world.getDamageSources().generic(), 1.0F);
            }
            return ActionResult.PASS;
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && COAL_ORE_LOOT_TABLE_ID.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(Items.EGG));
                tableBuilder.pool(poolBuilder);
            }
        });

        SheepShearCallback.EVENT.register((player, sheep) -> {
            sheep.setSheared(true);
            ItemStack stack = new ItemStack(Items.DIAMOND);
            ItemEntity itemEntity = new ItemEntity(player.getWorld(), sheep.getX(), sheep.getY(), sheep.getZ(), stack);
            player.getWorld().spawnEntity(itemEntity);
            return ActionResult.FAIL;
        });
    }
}
