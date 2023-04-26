package net.benmoore.projectmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.benmoore.projectmod.ProjectMod;
import net.benmoore.projectmod.entity.custom.CrypticEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrypticRenderer extends GeoEntityRenderer<CrypticEntity> {
    public CrypticRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrypticModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CrypticEntity animatable) {
        return new ResourceLocation(ProjectMod.MOD_ID, "textures/entity/cryptic.png");
    }

    @Override
    public void render(CrypticEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}