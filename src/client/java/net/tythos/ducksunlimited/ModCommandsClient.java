package net.tythos.ducksunlimited;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.minecraft.text.Text;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandRegistryAccess;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.MinecraftClient;

public class ModCommandsClient {
    public static int clientTaterCommand(CommandContext<FabricClientCommandSource> context) {
        context.getSource().sendFeedback(Text.literal("Called /clienttater with no arguments."));
        return 1;
    }

    // public static int
    // customScreenCommand(CommandContext<FabricClientCommandSource> context) {
    // MinecraftClient current = MinecraftClient.getInstance();
    // Screen currentScreen = current.currentScreen;
    // context.getSource().sendFeedback(Text.literal("Called /customscreen with no
    // arguments."));
    // current.setScreen(new CustomScreen(Text.empty(), currentScreen));
    // return 1;
    // }

    public static void dispatchClientTater(CommandDispatcher<FabricClientCommandSource> dispatcher,
            CommandRegistryAccess registeryAccess) {
        dispatcher
                .register(ClientCommandManager.literal("clienttater").executes(ModCommandsClient::clientTaterCommand));
    }

    protected static void initialize() {
        // ClientCommandRegistrationCallback.EVENT.register(ModCommandsClient::dispatchClientTater);
        // ClientCommandRegistrationCallback.EVENT.register(ModCommandsClient::dispatchCustomScreen);

        // ClientCommandRegistrationCallback.EVENT.register((dispatcher, registyAccess)
        // -> {
        // dispatcher.register(
        // ClientCommandManager.literal("customscreen").executes(ModCommandsClient::customScreenCommand);
        // );
        // });

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(
                    ClientCommandManager.literal("myscreen")
                            .executes(context -> {
                                context.getSource()
                                        .sendFeedback(Text.literal("Command executed!"));

                                // Get the client instance
                                MinecraftClient client = MinecraftClient.getInstance();
                                // Create the screen
                                CustomScreen screen = new CustomScreen(Text.literal("Test"));
                                // Schedule the screen change for the next tick to avoid threading issues
                                client.execute(() -> {
                                    context.getSource()
                                            .sendFeedback(Text.literal("Actually setting screen now..."));
                                    client.setScreen(screen);
                                });

                                return 1;
                            }));
        });
    }
}
