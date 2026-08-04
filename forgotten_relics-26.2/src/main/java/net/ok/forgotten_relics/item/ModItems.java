package net.ok.forgotten_relics.item;

import net.ok.forgotten_relics.ForgottenRelics;
import net.ok.forgotten_relics.item.ForgottenWatchItem;


import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;



public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ForgottenRelics.MODID);

    public static final DeferredItem<Item> HOPE = ITEMS.registerSimpleItem("hope",
            properties -> properties);
    
    public static final DeferredItem<Item> WATCH = ITEMS.registerItem("watch",
            properties -> new ForgottenWatchItem(properties));
    
    


    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
