package net.ok.forgotten_relics.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BowBlast extends AbstractArrow {

    // Constructor used by ModEntities
    public BowBlast(
            EntityType<? extends BowBlast> type,
            Level level
    ) {
        super(type, level);
    }

    // Constructor used when the bow shoots the projectile
    public BowBlast(
            ServerLevel level,
            LivingEntity owner,
            ItemStack itemStack
    ) {
        this(
                ModEntities.BOW_BLAST.get(),
                level
        );

        this.setOwner(owner);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return ItemStack.EMPTY;
    }
}