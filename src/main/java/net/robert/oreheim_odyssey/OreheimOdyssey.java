package net.robert.oreheim_odyssey;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.robert.oreheim_odyssey.block.ModBlocks;
import net.robert.oreheim_odyssey.item.ModCreativeModeTab;
import net.robert.oreheim_odyssey.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OreheimOdyssey.MOD_ID)
public class OreheimOdyssey
{
    public static final String MOD_ID = "oreheim_odyssey";
    private static final Logger LOGGER = LogUtils.getLogger();
    public OreheimOdyssey() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTab.OREHEIM_ODYSSEY) {
            event.accept(ModItems.RED_BERYL);
            event.accept(ModItems.RAW_RED_BERYL);

            event.accept(ModBlocks.RED_BERYL_BLOCK);
            event.accept(ModBlocks.RED_BERYL_ORE);
            event.accept(ModBlocks.DEEPSLATE_RED_BERYL_ORE);
            event.accept(ModBlocks.GEM_CLEANER);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
