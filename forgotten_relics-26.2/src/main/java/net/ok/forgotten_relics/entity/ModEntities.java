package net.ok.forgotten_relics.entity;

import java.util.function.Supplier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ok.forgotten_relics.ForgottenRelics;

public class ModEntities {

    public static final DeferredRegister.Entities ENTITY_TYPES =
            DeferredRegister.createEntities(ForgottenRelics.MODID);

    public static final Supplier<EntityType<BowBlast>> BOW_BLAST = ENTITY_TYPES.registerEntityType(
                    "bow_blast",BowBlast::new, MobCategory.MISC,builder -> builder
                            .sized(1.0f, 1.0f).clientTrackingRange(8).updateInterval(3));
    
    
}