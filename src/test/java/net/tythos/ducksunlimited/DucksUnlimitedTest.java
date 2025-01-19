package net.tythos.ducksunlimited;

import net.fabricmc.loader.api.FabricLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class DucksUnlimitedTest {
    private DucksUnlimited mod;
    
    @BeforeEach
    void setup() {
        mod = new DucksUnlimited();
    }

    @Test
    void testModInitialization() {
        // Basic initialization test
        assertDoesNotThrow(() -> mod.onInitialize());
    }

    @Test
    void testModId() {
        assertEquals("ducksunlimited", DucksUnlimited.MOD_ID);
    }
    
    @Test
    void testModPresenceInFabric() {
        // Verify mod is properly registered
        assertTrue(FabricLoader.getInstance()
            .getAllMods()
            .stream()
            .anyMatch(container -> 
                container.getMetadata()
                    .getId()
                    .equals(DucksUnlimited.MOD_ID)
            )
        );
    }
}