package net.glooshy.vire.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.glooshy.vire.VireMod;
import net.glooshy.vire.entity.custom.SpireEntity;
import net.glooshy.vire.entity.layers.ModModelLayers;
import net.glooshy.vire.entity.variants.SpireVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class SpireRenderer extends MobRenderer<SpireEntity, SpireModel<SpireEntity>> {
    private static final Map<SpireVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SpireVariant.class), map ->  {
                map.put(SpireVariant.DEFAULT,
                        new ResourceLocation(VireMod.MOD_ID,"textures/entity/spire_texture.png" ));
                map.put(SpireVariant.BROWN,
                        new ResourceLocation(VireMod.MOD_ID,"textures/entity/brown_spire_texture.png" ));
            });

    public SpireRenderer(EntityRendererProvider.Context context) {
        super(context, new SpireModel<>(context.bakeLayer(ModModelLayers.SPIRE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SpireEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }

    @Override
    public void render(SpireEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.60f,0.60f,0.60f);
        }

        if (pEntity.getVariant().getId() == 1) {
            pMatrixStack.scale(1.20f,1.20f,1.20f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

