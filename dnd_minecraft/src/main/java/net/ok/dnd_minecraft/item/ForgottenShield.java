package net.ok.forgotten_relics.item;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.ok.forgotten_relics.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;

import org.jspecify.annotations.Nullable;

public class ForgottenShield extends ShieldItem {

    public ForgottenShield(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide()) {

            // Position in front of the player
            BlockPos center = player.blockPosition()
                    .relative(player.getDirection(), 3);

            Direction facing = player.getDirection();

            // Choose what block gets placed
            BlockState block = ModBlocks.SHIELD_BLOCK.get().defaultBlockState();

            // Create a 3 wide x 3 tall wall
            for (int width = -1; width <= 1; width++) {

                for (int height = 0; height < 3; height++) {

                    BlockPos pos;

                    if (facing == Direction.NORTH || facing == Direction.SOUTH) {
                        pos = center.offset(width, height, 0);
                    } else {
                        pos = center.offset(0, height, width);
                    }

                    // Only replace air
                    if (level.getBlockState(pos).isAir()) {
                        level.setBlock(pos, block, 3);
                    }
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
    
}
