package net.ok.forgotten_relics.block;

import net.ok.forgotten_relics.ForgottenRelics;
import net.ok.forgotten_relics.item.ModItems;
import net.ok.forgotten_relics.block.ShieldBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ForgottenRelics.MODID);

    public static final DeferredBlock<Block> SHIELD_BLOCK = registerBlock("shield_block",
                    properties -> new ShieldBlock(properties.strength(0f).requiresCorrectToolForDrops()
                                    .sound(SoundType.AMETHYST)));

    private static <T extends Block> DeferredBlock<T> registerBlock(
            String name,
            Function<BlockBehaviour.Properties, T> function) {

        DeferredBlock<T> block = BLOCKS.registerBlock(
                name,
                function
        );

        registerBlockItem(name, block);

        return block;
    }

    private static <T extends Block> void registerBlockItem(
            String name,
            DeferredBlock<T> block) {

        ModItems.ITEMS.registerItem(
                name,
                properties -> new BlockItem(
                        block.get(),
                        properties.useBlockDescriptionPrefix()
                )
        );
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}