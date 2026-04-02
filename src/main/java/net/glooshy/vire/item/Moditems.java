package net.glooshy.vire.item;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.entity.ModEntities;
import net.glooshy.vire.item.custom.FuelItem;
import net.glooshy.vire.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VireMod.MOD_ID);

    public static final RegistryObject<Item> NTHALIUM = ITEMS.register("nthalium",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_NTHALIUM = ITEMS.register("raw_nthalium",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NTHAGLOOM = ITEMS.register("nthagloom",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.NTHAGLOOM)));

    public static final RegistryObject<Item> CHARED_INGOT = ITEMS.register("chared_ingot",
            ()-> new FuelItem(new Item.Properties(), 32000));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(512)));
    public static final RegistryObject<Item> SPIRE_SPAWN_EGG = ITEMS.register("spire_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPIRE, 0x7e960, 0xc5d1c5,
                    new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
