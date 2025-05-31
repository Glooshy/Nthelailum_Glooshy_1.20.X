package net.glooshy.vire.item;


import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VireMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VIRE_TAB = CREATIVE_MODE_TABS.register("vire_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.NTHALIUM_BLOCK.get()))
                    .title(Component.translatable("creativetab.vire_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.NTHALIUM.get());
                        output.accept(Moditems.RAW_NTHALIUM.get());
                        output.accept(Moditems.NTHAGLOOM.get());

                        output.accept(ModBlocks.NTHALIUM_BLOCK.get());
                        output.accept(ModBlocks.RAW_NTHALIUM_BLOCK.get());
                        output.accept(ModBlocks.NTHALIUM_GEODE.get());

                        output.accept(Moditems.CHARED_INGOT.get());

                    } ).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
