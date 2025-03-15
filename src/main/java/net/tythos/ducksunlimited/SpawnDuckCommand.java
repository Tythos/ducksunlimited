package net.tythos.ducksunlimited;

import net.minecraft.text.Text;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class SpawnDuckCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("spawnduck")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> spawnDuck(context.getSource())));
    }

    private static int spawnDuck(ServerCommandSource source) throws CommandSyntaxException {
        ServerWorld world = source.getWorld();
        ServerPlayerEntity player = source.getPlayer();
        BlockPos pos = player.getBlockPos();
        DuckEntity duck = new DuckEntity(DucksUnlimited.DUCK, world);
        duck.refreshPositionAndAngles(pos, 0, 0);
        world.spawnEntity(duck);
        source.sendFeedback(Text.literal("Duck spawned!"), false);
        return 1;
    }
}
