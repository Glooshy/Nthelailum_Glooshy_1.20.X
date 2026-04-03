package net.glooshy.vire.item;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.entity.ModEntities;
import net.glooshy.vire.item.custom.FuelItem;
import net.glooshy.vire.item.custom.MetalDetectorItem;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> NTHALIUM_SWORD = ITEMS.register("nthalium_sword",
            ()-> new SwordItem(ModToolTiers.NTHALIUM, 4, -2f, new Item.Properties().durability(4096)));
    public static final RegistryObject<Item> NTHALIUM_PICKAXE = ITEMS.register("nthalium_pickaxe",
            ()-> new PickaxeItem(ModToolTiers.NTHALIUM, 1, -1f, new Item.Properties().durability(4096)));
    public static final RegistryObject<Item> NTHALIUM_AXE = ITEMS.register("nthalium_axe",
            ()-> new AxeItem(ModToolTiers.NTHALIUM, 6, -2.5f, new Item.Properties().durability(4096)));
    public static final RegistryObject<Item> NTHALIUM_SHOVEL = ITEMS.register("nthalium_shovel",
            ()-> new ShovelItem(ModToolTiers.NTHALIUM, 1, -2f, new Item.Properties().durability(4096)));
    public static final RegistryObject<Item> NTHALIUM_HOE = ITEMS.register("nthalium_hoe",
            ()-> new HoeItem(ModToolTiers.NTHALIUM, 1, -2f, new Item.Properties().durability(4097)));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(512)));

    public static final RegistryObject<Item> SPIRE_SPAWN_EGG = ITEMS.register("spire_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPIRE, 0x808080, 0x404040,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
