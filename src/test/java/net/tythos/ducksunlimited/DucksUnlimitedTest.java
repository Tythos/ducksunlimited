package net.tythos.ducksunlimited;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DucksUnlimitedTest {
    @Test
    void testCommandRegistration() {
        DucksUnlimited mod = new DucksUnlimited();
        
        // Create a command dispatcher for testing
        CommandDispatcher<ServerCommandSource> dispatcher = new CommandDispatcher<>();
        
        // Initialize the mod
        mod.onInitialize();
        
        // Trigger command registration
        CommandRegistrationCallback.EVENT.invoker().register(
            dispatcher,
            null,
            null
        );
        
        // Verify command exists
        assertTrue(dispatcher.getRoot().getChild("modtest") != null,
            "modtest command should be registered");
    }
}