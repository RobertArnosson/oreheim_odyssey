package net.robert.oreheim_odyssey.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robert.oreheim_odyssey.OreheimOdyssey;
import net.robert.oreheim_odyssey.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, OreheimOdyssey.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemCleanerBlockEntity>> GEM_CLEANER =
            BLOCK_ENTITIES.register("gem_cleaner", () ->
                    BlockEntityType.Builder.of(GemCleanerBlockEntity::new,
                            ModBlocks.GEM_CLEANER.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
