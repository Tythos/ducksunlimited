package net.tythos.ducksunlimited;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.server.command.CommandManager.*;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "ducksunlimited";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing DucksUnlimited");
        
        // Register our test command
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("modtest")
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    ServerWorld world = player.getServerWorld();
                    
                    // Send message to player
                    player.sendMessage(Text.literal("§a[DucksUnlimited] Mod is working!§r"));
                    
                    // Create particle effect at player location
                    world.spawnParticles(
                        ParticleTypes.END_ROD,
                        player.getX(),
                        player.getY() + 2,
                        player.getZ(),
                        50,  // particle count
                        0.5, // spread X
                        0.5, // spread Y
                        0.5, // spread Z
                        0.1  // speed
                    );
                    
                    LOGGER.info("Test command executed by " + player.getName().getString());
                    return 1;
                }));
        });
    }
}