package net.glooshy.vire.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.glooshy.vire.VireMod;
import net.glooshy.vire.entity.custom.SpireEntity;
import net.glooshy.vire.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpireRenderer extends MobRenderer<SpireEntity, SpireModel<SpireEntity>> {
    private static final ResourceLocation SPIRE_TEXTURE =
            new ResourceLocation(VireMod.MOD_ID, "textures/entity/spire_texture.png");

    public SpireRenderer(EntityRendererProvider.Context context) {
        super(context, new SpireModel<>(context.bakeLayer(ModModelLayers.SPIRE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SpireEntity entity) {
        return SPIRE_TEXTURE;
    }

    @Override
    public void render(SpireEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.60f,0.60f,0.60f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

