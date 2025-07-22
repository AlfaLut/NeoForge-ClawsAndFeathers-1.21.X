package net.alfalut.clawsandfeathers.block;

import net.alfalut.clawsandfeathers.ClawsAndFeathers;
import net.alfalut.clawsandfeathers.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ClawsAndFeathers.MOD_ID);

public static final DeferredBlock<Block> MOSSY_PODZOL = registerBlock(  "mossy_podzol",
        () -> new Block(BlockBehaviour.Properties.of()
                .strength(1f).sound(SoundType.GRASS)));
public static final DeferredBlock<Block> LOAM = registerBlock(  "loam",
        () -> new Block(BlockBehaviour.Properties.of()
                .strength(1f).sound(SoundType.ROOTED_DIRT)));
    public static final DeferredBlock<Block> GINKGO_LOG  = registerBlock(  "ginkgo_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LIMESTONE = registerBlock(  "limestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.STONE)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
    ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
}

public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
}

}
