package net.ok.forgotten_relics.item;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.minecraft.core.particles.ParticleTypes; 


public class ForgottenWatchItem extends Item {
	

    public ForgottenWatchItem(Properties properties) {
        super(properties);
    }
    

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel(); 
        
        if(!level.isClientSide() ) {
        ((ServerLevel) level).sendParticles(ParticleTypes.PORTAL,
                context.getClickedPos().getX() + 0.5, context.getClickedPos().getY() + 0.5,
                context.getClickedPos().getZ() + 0.5, 5, 0, 0, 0, 3);
        }
        return InteractionResult.SUCCESS;
    }
}