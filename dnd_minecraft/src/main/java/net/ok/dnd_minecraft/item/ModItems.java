package net.ok.forgotten_relics.item;

import net.ok.forgotten_relics.ForgottenRelics;
import net.ok.forgotten_relics.item.ForgottenWatch;
import net.ok.forgotten_relics.item.ForgottenBow;
import net.ok.forgotten_relics.item.ForgottenShield;

import net.minecraft.world.item.component.BlocksAttacks;
import java.util.List;
import java.util.Optional;	
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;


public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ForgottenRelics.MODID);

    public static final DeferredItem<Item> HOPE = ITEMS.registerSimpleItem("hope",
            properties -> properties);
    
    public static final DeferredItem<Item> WATCH = ITEMS.registerItem("forgotten_watch",
            properties -> new ForgottenWatch(properties.stacksTo(1)));
    public static final DeferredItem<Item> FORGOTTEN_BOW = ITEMS.registerItem("forgotten_bow",
            properties -> new ForgottenBow(properties.stacksTo(1)));
   
    public static final DeferredItem<Item> FORGOTTEN_SHIELD =ITEMS.registerItem("forgotten_shield",
            properties -> new ForgottenShield(properties.stacksTo(1)
                       .durability(336).delayedComponent(DataComponents.BLOCKS_ATTACKS,
                       context -> new BlocksAttacks(0.25F,1.0F,List.of(new BlocksAttacks.DamageReduction(
                       90.0F,Optional.empty(),0.0F,1.0F)),new BlocksAttacks.ItemDamageFunction(3.0F,1.0F,1.0F),
                       Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)),
                       Optional.of(SoundEvents.SHIELD_BLOCK),Optional.of(SoundEvents.SHIELD_BREAK)))));
    
    
    
  
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
