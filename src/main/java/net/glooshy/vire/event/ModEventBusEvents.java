package net.glooshy.vire.event;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.entity.ModEntities;
import net.glooshy.vire.entity.client.SpireModel;
import net.glooshy.vire.entity.custom.SpireEntity;
import net.glooshy.vire.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VireMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SPIRE_LAYER, SpireModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SPIRE.get(), SpireEntity.createAttributes().build());
    }

}
