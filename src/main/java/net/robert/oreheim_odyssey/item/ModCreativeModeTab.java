package net.robert.oreheim_odyssey.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.robert.oreheim_odyssey.OreheimOdyssey;

@Mod.EventBusSubscriber(modid = OreheimOdyssey.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab OREHEIM_ODYSSEY;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        OREHEIM_ODYSSEY = event.registerCreativeModeTab(new ResourceLocation(OreheimOdyssey.MOD_ID, "oreheim_odyssey"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RED_BERYL.get())).title(Component.literal("Oreheim Odyssey Tab")).build());
    }
}