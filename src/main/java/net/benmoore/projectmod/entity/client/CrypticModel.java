package net.benmoore.projectmod.entity.client;

import net.benmoore.projectmod.ProjectMod;
import net.benmoore.projectmod.entity.custom.CrypticEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CrypticModel extends GeoModel<CrypticEntity> {
    @Override
    public ResourceLocation getModelResource(CrypticEntity animatable) {
        return new ResourceLocation(ProjectMod.MOD_ID, "geo/cryptic.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrypticEntity animatable) {
        return new ResourceLocation(ProjectMod.MOD_ID, "textures/entity/cryptic.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrypticEntity animatable) {
        return new ResourceLocation(ProjectMod.MOD_ID, "animations/cryptic.animation.json");
    }

    @Override
    public void setCustomAnimations(CrypticEntity animatable, long instanceId, AnimationState<CrypticEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}