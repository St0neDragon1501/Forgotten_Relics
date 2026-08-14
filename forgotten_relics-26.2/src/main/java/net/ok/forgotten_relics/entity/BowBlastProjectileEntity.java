package net.ok.forgotten_relics.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.level.Level;

public class BowBlastProjectileEntity extends Arrow {

    public BowBlastProjectileEntity(
            EntityType<? extends BowBlastProjectileEntity> type,
            Level level) {
        super(type, level);
    }
}