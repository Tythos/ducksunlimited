package net.tythos.ducksunlimited;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

public record EngineSoundInstancePacket(BlockPos blockEntityPos, boolean shouldStart) {
    public static void encode(EngineSoundInstancePacket packet, PacketByteBuf buf) {
        buf.writeBlockPos(packet.blockEntityPos);
        buf.writeBoolean(packet.shouldStart);
    }

    public static EngineSoundInstancePacket decode(PacketByteBuf buf) {
        return new EngineSoundInstancePacket(
                buf.readBlockPos(),
                buf.readBoolean());
    }
}
