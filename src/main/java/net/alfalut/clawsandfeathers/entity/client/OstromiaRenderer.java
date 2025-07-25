package net.alfalut.clawsandfeathers.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.alfalut.clawsandfeathers.ClawsAndFeathers;
import net.alfalut.clawsandfeathers.entity.custom.OstromiaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OstromiaRenderer extends MobRenderer<OstromiaEntity, OstromiaModel<OstromiaEntity>> {
    public OstromiaRenderer(EntityRendererProvider.Context context) {
        super(context, new OstromiaModel<>(context.bakeLayer(OstromiaModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(OstromiaEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(ClawsAndFeathers.MOD_ID, "textures/entity/ostromia_texture.png");
    }

    @Override
    public void render(OstromiaEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}



