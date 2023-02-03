package net.robert.oreheim_odyssey.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robert.oreheim_odyssey.OreheimOdyssey;
import net.robert.oreheim_odyssey.block.custom.GemCleanerBlock;
import net.robert.oreheim_odyssey.item.ModCreativeModeTab;
import net.robert.oreheim_odyssey.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OreheimOdyssey.MOD_ID);

    public static final RegistryObject<Block> RED_BERYL_BLOCK = registerBlock("red_beryl_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.OREHEIM_ODYSSEY);

    public static final RegistryObject<Block> RED_BERYL_ORE = registerBlock("red_beryl_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.OREHEIM_ODYSSEY);
    public static final RegistryObject<Block> DEEPSLATE_RED_BERYL_ORE = registerBlock("deepslate_red_beryl_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.OREHEIM_ODYSSEY);
    public static final RegistryObject<Block> TRASH = registerBlock("trash",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(0.75f)), ModCreativeModeTab.OREHEIM_ODYSSEY);

    public static final RegistryObject<Block> GEM_CLEANER = registerBlock("gem_cleaner",
            () -> new GemCleanerBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.OREHEIM_ODYSSEY);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}