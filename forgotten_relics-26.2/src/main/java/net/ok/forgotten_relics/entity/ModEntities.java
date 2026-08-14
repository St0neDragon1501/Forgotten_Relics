package net.ok.forgotten_relics.entity;

import java.util.function.Supplier;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.ok.forgotten_relics.ForgottenRelics;

public class ModEntities {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
	        DeferredRegister.create(
	                BuiltInRegistries.ENTITY_TYPE,
	                ForgottenRelics.MODID
	        );

	public static final ResourceKey<EntityType<?>> BOW_BLAST_KEY =
	        ResourceKey.create(
	                Registries.ENTITY_TYPE,
	                Identifier.parse(ForgottenRelics.MODID + ":bow_blast")
	        );

	public static final Supplier<EntityType<BowBlastProjectileEntity>> BOW_BLAST =
	        ENTITY_TYPES.register("bow_blast", () ->
	                EntityType.Builder.of(
	                        BowBlastProjectileEntity::new,
	                        MobCategory.MISC
	                )
	                .sized(0.5f, 1.15f)
	                .build(BOW_BLAST_KEY)
	        );
	
	
	public static void register(IEventBus eventBus) {
	    ENTITY_TYPES.register(eventBus);
	}
}