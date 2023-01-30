package net.robert.oreheim_odyssey.item;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robert.oreheim_odyssey.OreheimOdyssey;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OreheimOdyssey.MOD_ID);

    public static final RegistryObject<Item> RED_BERYL = ITEMS.register("red_beryl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RED_BERYL = ITEMS.register("raw_red_beryl",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}