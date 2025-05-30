package net.glooshy.vire.item;

import net.glooshy.vire.VireMod;
import net.minecraft.world.item.Item;
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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
