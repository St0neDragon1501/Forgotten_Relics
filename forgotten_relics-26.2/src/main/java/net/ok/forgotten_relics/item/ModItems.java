package net.ok.forgotten_relics.item;

import net.ok.forgotten_relics.ForgottenRelics;
import net.ok.forgotten_relics.item.ForgottenWatch;
import net.ok.forgotten_relics.item.ForgottenBow;
import net.ok.forgotten_relics.item.ForgottenShield;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;



public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ForgottenRelics.MODID);

    public static final DeferredItem<Item> HOPE = ITEMS.registerSimpleItem("hope",
            properties -> properties);
    
    public static final DeferredItem<Item> WATCH = ITEMS.registerItem("forgotten_watch",
            properties -> new ForgottenWatch(properties.stacksTo(1)));
    public static final DeferredItem<Item> FORGOTTEN_BOW = ITEMS.registerItem("forgotten_bow",
            properties -> new ForgottenBow(properties.stacksTo(1)));
    public static final DeferredItem<Item> FORGOTTEN_SHIELD = ITEMS.registerItem("forgotten_shield",
            properties -> new ForgottenShield(properties.stacksTo(1)));
    
  

    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
