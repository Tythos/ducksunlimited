# Ducks Unlimited

Server-side mod for adding support for various ducks and their behavior to a Minecraft world.


To verify the mod is working:

1. In-game verification:
   - Install the mod on both server and client
   - Join the server
   - Type `/modtest` in chat
   - You should see:
     - A green message saying "[ModName] Mod is working!"
     - Particle effects around your player
     - A log entry on the server

2. To package and publish the mod:

```bash
# Build the release package
./gradlew releaseJar

# Publish to Maven repository
./gradlew publish
```

The mod artifacts will be in:
- `build/libs/modname-<version>.jar` - Main mod file
- `build/libs/modname-<version>-sources.jar` - Source code
- `build/libs/modname-<version>-javadoc.jar` - Documentation
- `build/libs/modname-<version>-release.zip` - Complete release package

To install on a server:
1. Take the main JAR file (`modname-<version>.jar`)
2. Place it in the server's `mods` folder
3. Restart the server
4. Check logs for successful initialization message
5. Try the `/modtest` command in-game

The publishing configuration supports:
1. Maven repository publishing
2. Source and JavaDoc artifacts
3. Complete release packages
4. Version-based repository selection (snapshots vs releases)
5. Secure credential management

Would you like me to:
1. Add more in-game verification features?
2. Create a GitHub Actions workflow for automated publishing?
3. Add server-side configuration options?
4. Create a mod update checker?
