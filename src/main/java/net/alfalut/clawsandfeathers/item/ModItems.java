package net.alfalut.clawsandfeathers.item;

import net.alfalut.clawsandfeathers.ClawsAndFeathers;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ClawsAndFeathers.MOD_ID);

    public static final DeferredItem<Item> TRICERATOPSHEAD = ITEMS.register("triceratopshead",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRICERATOPS_HORN = ITEMS.register("triceratops_horn",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
ITEMS.register(eventBus);
    }
}
