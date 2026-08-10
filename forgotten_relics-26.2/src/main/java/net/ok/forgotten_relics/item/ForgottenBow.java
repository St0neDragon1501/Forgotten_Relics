package net.ok.forgotten_relics.item;

import com.google.common.math.Stats;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEgg;


public class ForgottenBow extends BowItem {
	

    public ForgottenBow(Properties properties) {
        super(properties);
    }
    
    
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        
        if (level instanceof ServerLevel serverLevel) {
            Projectile.spawnProjectileFromRotation(ThrownEgg::new, serverLevel, itemStack, player, 0.0F, 1.5F, 1.0F);
        }

        return InteractionResult.SUCCESS;
    }
    
}