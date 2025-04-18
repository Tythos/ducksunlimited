package net.tythos.ducksunlimited.client.render;

import java.util.Map;
import org.jetbrains.annotations.Nullable;
import net.minecraft.client.render.entity.state.EntityRenderState;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import java.util.HashMap;

public class DuckEntityRenderState extends EntityRenderState implements GeoRenderState {
    private final Map<DataTicket<?>, Object> dataMap = new HashMap<>();

    public <D> void addGeckolibData(DataTicket<D> dataTicket, @Nullable D data) {
        dataMap.put(dataTicket, data);
    }

    public Map<DataTicket<?>, Object> getDataMap() {
        return dataMap;
    }

    @SuppressWarnings("unchecked")
    public <D> D getGeckolibData(DataTicket<D> dataTicket) {
        return (D) dataMap.get(dataTicket);
    }

    public boolean hasGeckolibData(DataTicket<?> dataTicket) {
        return dataMap.containsKey(dataTicket);
    }
}
