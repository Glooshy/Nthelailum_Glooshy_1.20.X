package net.glooshy.vire.entity.client;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.glooshy.vire.entity.animations.ModAnimationDefinition;
import net.glooshy.vire.entity.custom.SpireEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SpireModel<T extends SpireEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "spiremodel"), "main");
	private final ModelPart spire;
	private final ModelPart Body;
	private final ModelPart Torso;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_Leg;
	private final ModelPart right_Leg;
    private final ModelPart head;

	public SpireModel(ModelPart root) {
		this.spire = root.getChild("spire");
		this.Body = this.spire.getChild("Body");
		this.Torso = this.Body.getChild("Torso");
		this.left_arm = this.Torso.getChild("left_arm");
		this.right_arm = this.Torso.getChild("right_arm");
		this.left_Leg = this.Body.getChild("left_Leg");
		this.right_Leg = this.Body.getChild("right_Leg");
        this.head = this.Torso;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spire = partdefinition.addOrReplaceChild("spire", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = spire.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 24).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(-5.0F, -21.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Main_r1 = Torso.addOrReplaceChild("Main_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition left_arm = Torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 13).addBox(-8.0F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -2.0F, 0.0F));

		PartDefinition right_arm = Torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 38).addBox(-2.0F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.0F, 0.0F));

		PartDefinition left_Leg = Body.addOrReplaceChild("left_Leg", CubeListBuilder.create().texOffs(28, 38).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition right_Leg = Body.addOrReplaceChild("right_Leg", CubeListBuilder.create().texOffs(40, 21).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(SpireEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(entity, netHeadYaw, headPitch,ageInTicks);


        this.animateWalk(ModAnimationDefinition.WALK, limbSwing, limbSwingAmount, 2f, 100f);
        this.animate(entity.idleAnimationState, ModAnimationDefinition.IDLE, ageInTicks, 1f);
        this.animate(entity.attackAnimationState, ModAnimationDefinition.ATTACK, ageInTicks, 1f);
	}

    private void applyHeadRotation(SpireEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		spire.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return spire;
    }
}