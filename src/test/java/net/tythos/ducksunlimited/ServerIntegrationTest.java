package net.tythos.ducksunlimited;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ServerIntegrationTest {
    private static final Path SERVER_DIR = Path.of("run/server");
    private static final int STARTUP_WAIT_SECONDS = 30;
    
    @Test
    @EnabledIfSystemProperty(named = "runServerTests", matches = "true")
    void testServerStartupWithMod() throws Exception {
        // Verify server directory exists
        assertTrue(Files.exists(SERVER_DIR), "Server directory should exist");
        
        // Verify mod is deployed
        Path modsDir = SERVER_DIR.resolve("mods");
        assertTrue(Files.exists(modsDir), "Mods directory should exist");
        assertTrue(Files.list(modsDir)
            .anyMatch(p -> p.getFileName().toString().contains("ducksunlimited")),
            "Mod should be present in mods directory");
            
        // Start server process
        ProcessBuilder pb = new ProcessBuilder(
            "java", 
            "-Xmx2G",
            "-jar",
            "server.jar",
            "nogui"
        );
        pb.directory(SERVER_DIR.toFile());
        
        Process server = pb.start();
        
        // Monitor server logs for successful startup
        boolean startupSuccess = false;
        long startTime = System.currentTimeMillis();
        
        while (System.currentTimeMillis() - startTime < TimeUnit.SECONDS.toMillis(STARTUP_WAIT_SECONDS)) {
            String logs = FileUtils.readFileToString(
                new File(SERVER_DIR.toString(), "logs/latest.log"), 
                StandardCharsets.UTF_8
            );
            
            if (logs.contains("Done") && logs.contains(DucksUnlimited.MOD_ID)) {
                startupSuccess = true;
                break;
            }
            
            Thread.sleep(1000);
        }
        
        // Clean up
        server.destroy();
        
        assertTrue(startupSuccess, "Server should start successfully with mod loaded");
    }
}