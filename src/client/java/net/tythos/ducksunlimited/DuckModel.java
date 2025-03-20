package net.tythos.ducksunlimited;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class DuckModel extends GeoModel<DuckEntity> {
    @Override
    public Identifier getModelResource(DuckEntity entity, GeoRenderer<DuckEntity> duck_renderer) {
        return DucksUnlimited.get_resource_location("geo/duck.geo.json");
    }

    @Override
    public Identifier getTextureResource(DuckEntity entity, GeoRenderer<DuckEntity> duck_renderer) {
        return DucksUnlimited.get_resource_location("textures/entity/mallard.png");
    }

    @Override
    public Identifier getAnimationResource(DuckEntity entity) {
        return DucksUnlimited.get_resource_location("animations/duck.animation.json");
    }
}
