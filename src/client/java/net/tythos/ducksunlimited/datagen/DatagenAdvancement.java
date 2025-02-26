package net.tythos.ducksunlimited.datagen;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import java.util.HashMap;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class DatagenAdvancement implements ModInitializer {
    @Override
    public void onInitialize() {
        HashMap<Item, Integer> tools = new HashMap<>();
        PlayerBlockBreakEvents.AFTER.register(((world, player, blockPos, blockState, blockEntity) -> {
            if (player instanceof ServerPlayerEntity serverPlayer) {
                Item item = player.getMainHandStack().getItem();
                Integer usedCount = tools.getOrDefault(item, 0);
                usedCount++;
                tools.put(item, usedCount);
                serverPlayer.sendMessage(Text.of("You've used \"" + item + "\" as a tool " + usedCount + " times!"));
            }
        }));
    }
}
