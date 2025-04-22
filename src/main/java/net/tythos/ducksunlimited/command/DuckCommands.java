package net.tythos.ducksunlimited.command;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.command.CommandManager;
import net.tythos.ducksunlimited.DucksUnlimited;
import net.tythos.ducksunlimited.duck.DuckEntity;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.SpawnReason;

public class DuckCommands {
    public static void register(
            CommandDispatcher<ServerCommandSource> dispatcher,
            CommandRegistryAccess registryAccess,
            CommandManager.RegistrationEnvironment environment) {
        dispatcher.register(CommandManager.literal("ducksunlimited")
                .then(CommandManager.literal("spawnduck")
                        .executes(context -> {
                            context.getSource().sendFeedback(() -> Text.literal("Spawning duck..."), false);

                            ServerCommandSource source = context.getSource();
                            ServerWorld world = source.getWorld();
                            BlockPos pos = BlockPos.ofFloored(source.getPosition());
                            DuckEntity duck = DucksUnlimited.DUCK.create(world, null, pos, SpawnReason.COMMAND, true,
                                    false);

                            if (duck != null) {
                                duck.refreshPositionAndAngles(pos, 0, 0);
                                world.spawnEntity(duck);
                                source.sendFeedback(() -> Text.literal("Duck spawned!"), false);
                                return 1;
                            }

                            source.sendFeedback(() -> Text.literal("Failed to spawn duck."), false);
                            return 0;
                        })));
    }
}
