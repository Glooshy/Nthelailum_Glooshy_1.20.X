package net.glooshy.vire.entity;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.entity.custom.SpireEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VireMod.MOD_ID);

    public static  final RegistryObject<EntityType<SpireEntity>> SPIRE =
            ENTITY_TYPES.register("spire",() -> EntityType.Builder.of(SpireEntity::new, MobCategory.CREATURE)
                    .sized(0.6f,1.75f).build("spire"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
