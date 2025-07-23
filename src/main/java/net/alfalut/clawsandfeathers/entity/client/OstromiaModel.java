package net.alfalut.clawsandfeathers.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.alfalut.clawsandfeathers.ClawsAndFeathers;
import net.alfalut.clawsandfeathers.entity.custom.OstromiaEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class OstromiaModel<T extends OstromiaEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ClawsAndFeathers.MOD_ID, "ostromia"), "main");
    private final ModelPart Body;
    private final ModelPart Right_wing;
    private final ModelPart Left_wing;
    private final ModelPart Head;
    private final ModelPart Right_leg;
    private final ModelPart Left_leg;
    private final ModelPart Tail;
    private final ModelPart bb_main;

    public OstromiaModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Right_wing = root.getChild("Right_wing");
        this.Left_wing = root.getChild("Left_wing");
        this.Head = root.getChild("Head");
        this.Right_leg = root.getChild("Right_leg");
        this.Left_leg = root.getChild("Left_leg");
        this.Tail = root.getChild("Tail");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -10.0F, -5.0F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Right_wing = partdefinition.addOrReplaceChild("Right_wing", CubeListBuilder.create().texOffs(32, 0).addBox(-5.5F, -5.0F, -5.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 43).addBox(-2.5F, -6.0F, -5.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 21.0F, 0.5F));

        PartDefinition Left_wing = partdefinition.addOrReplaceChild("Left_wing", CubeListBuilder.create().texOffs(32, 4).addBox(-3.5F, -5.0F, -5.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(14, 43).addBox(-2.5F, -6.0F, -5.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 21.0F, 0.5F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 8).addBox(-1.5F, -14.4118F, -12.9583F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(28, 31).addBox(-2.5F, -14.9118F, -9.9583F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.7248F, -0.0523F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 42).addBox(7.5F, -15.8F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.2752F, 3.0523F, 0.1134F, 0.2443F, 0.0F));

        PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 8).addBox(-9.5F, -15.8F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.2752F, 3.0523F, 0.1134F, -0.2443F, 0.0F));

        PartDefinition Right_leg = partdefinition.addOrReplaceChild("Right_leg", CubeListBuilder.create().texOffs(0, 47).addBox(-3.0F, -11.0F, 0.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(20, 47).addBox(-3.0F, -7.0F, 1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 27.0F, 1.0F));

        PartDefinition Left_leg = partdefinition.addOrReplaceChild("Left_leg", CubeListBuilder.create().texOffs(10, 47).addBox(1.0F, -12.0F, 0.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(44, 48).addBox(1.0F, -8.0F, 1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, 1.0F));

        PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -10.0F, -7.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(30, 16).addBox(-1.5F, -10.0F, 5.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-2.5F, -9.0F, 11.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 12.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Neck_r1 = bb_main.addOrReplaceChild("Neck_r1", CubeListBuilder.create().texOffs(28, 42).addBox(-2.0F, -15.5F, -8.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, -3.5F, -0.3665F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(OstromiaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(OstromiaAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, OstromiaAnimations.IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45f);

        this.Head.yRot = headYaw * ((float) Math.PI / 180f);
        this.Head.xRot = headPitch * ((float) Math.PI / 180f);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return this.Body;
    }
}

