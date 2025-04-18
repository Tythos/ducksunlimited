package net.tythos.ducksunlimited.client.cube;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import net.tythos.ducksunlimited.cube.CubeEntity;
import net.tythos.ducksunlimited.DucksUnlimited;

public class CubeEntityModel extends EntityModel<CubeEntityRenderState> {
    public static final EntityModelLayer CUBE = new EntityModelLayer(DucksUnlimited.CUBE_ID, "main");

    private final ModelPart base;

    public CubeEntityModel(ModelPart modelPart) {
        super(modelPart);
        this.base = modelPart.getChild(EntityModelPartNames.CUBE);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.CUBE,
                ModelPartBuilder.create().uv(0, 0).cuboid(-6F, 12F, -6F, 12F, 12F, 12F),
                ModelTransform.of(0F, 0F, 0F, 0F, 0F, 0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setAngles(CubeEntityRenderState renderState) {
    }
}
