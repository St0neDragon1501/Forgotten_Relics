package net.ok.forgotten_relics.item;

import java.util.Set;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;


public class ForgottenWatch extends Item {
	
	private static PositionMoveRotation oldPos = null;
	

    public ForgottenWatch(Properties properties) {
        super(properties);
    }
    

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() ) {
        	if (oldPos == null) {
            	oldPos = new PositionMoveRotation(player.position(), player.getDeltaMovement(), player.getYRot(), player.getXRot());
            	
        	} else {
        		player.teleportTo(
                        (ServerLevel) level,
                        oldPos.position().x,
                        oldPos.position().y,
                        oldPos.position().z,
                        Set.of(),
                        oldPos.yRot(),
                        oldPos.xRot(),
                        true);
            	
        		oldPos = null;
        		
        	}
        }
        	
        return InteractionResult.SUCCESS;
    }
}