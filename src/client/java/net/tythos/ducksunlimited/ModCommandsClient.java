package net.tythos.ducksunlimited;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.minecraft.text.Text;

public class ModCommandsClient {
    protected static void initialize() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("clienttater").executes(context -> {
                context.getSource().sendFeedback(Text.literal("Called /clienttater with no arguments."));
                return 1;
            }));
        });
    }
}
