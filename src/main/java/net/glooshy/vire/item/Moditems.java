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

    public static final RegistryObject<Item> NTHELAILUM = ITEMS.register("nthelailum",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_NTHELAILUM = ITEMS.register("raw_nthelailum",
            ()-> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
