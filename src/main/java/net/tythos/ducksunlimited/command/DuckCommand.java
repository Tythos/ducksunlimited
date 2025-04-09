package net.tythos.ducksunlimited.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.literal;

public class DuckCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("ducksunlimited").executes(context -> {
            context.getSource().sendFeedback(() -> Text.literal("DucksUnlimited is successfully loaded. Quack!"), false);
            return 1;
        }));
    }
}

