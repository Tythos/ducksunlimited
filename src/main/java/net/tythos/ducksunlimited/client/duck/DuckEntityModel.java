package net.tythos.ducksunlimited.client.duck;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.tythos.ducksunlimited.DucksUnlimited;

public class DuckEntityModel extends EntityModel<DuckEntityRenderState> {
    public static final EntityModelLayer DUCK = new EntityModelLayer(DucksUnlimited.DUCK_ID, "main");

    private final ModelPart body;

    public DuckEntityModel(ModelPart modelPart) {
        super(modelPart);
        this.body = modelPart.getChild(EntityModelPartNames.BODY);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(
                EntityModelPartNames.BODY,
                ModelPartBuilder.create().uv(0, 0).cuboid(-6F, 12F, -6F, 12F, 12F, 12F),
                ModelTransform.of(0F, 0F, 0F, 0F, 0F, 0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setAngles(DuckEntityRenderState renderState) {
    }
}
