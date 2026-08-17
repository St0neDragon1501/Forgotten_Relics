package net.ok.forgotten_relics.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jspecify.annotations.Nullable;

public class ShieldBlock extends HalfTransparentBlock {

    public static final MapCodec<ShieldBlock> CODEC =simpleCodec(ShieldBlock::new);
    public static final int MAX_AGE = 2;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final int NEIGHBORS_TO_AGE = 3;
    private static final int NEIGHBORS_TO_MELT = 1;

    public ShieldBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(
        		this.stateDefinition.any().setValue(AGE, 0)
        );
    }
    
    

    public static BlockState meltsInto() {
        return Blocks.AIR.defaultBlockState();
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
        if (!EnchantmentHelper.hasTag(destroyedWith, EnchantmentTags.PREVENTS_ICE_MELTING)) {
            if (level.environmentAttributes().getValue(EnvironmentAttributes.WATER_EVAPORATES, pos)) {
                level.removeBlock(pos, false);
                return;
            }

            BlockState belowState = level.getBlockState(pos.below());
            if (belowState.blocksMotion() || belowState.liquid()) {
                level.setBlockAndUpdate(pos, meltsInto());
            }
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getBrightness(LightLayer.BLOCK, pos) > 11 - state.getLightDampening()) {
            this.melt(state, level, pos);
        }
    }

    protected void melt(BlockState state, Level level, BlockPos pos) {
        if (level.environmentAttributes().getValue(EnvironmentAttributes.WATER_EVAPORATES, pos)) {
            level.removeBlock(pos, false);
        } else {
            level.setBlockAndUpdate(pos, meltsInto());
            level.neighborChanged(pos, meltsInto().getBlock(), null);
        }
    }

    @Override
    public MapCodec<ShieldBlock> codec() {
        return CODEC;
    }

    @Override
    public void onPlace(
            BlockState state,
            Level level,
            BlockPos pos,
            BlockState oldState,
            boolean movedByPiston
    ) {
        level.scheduleTick(
                pos,
                this,
                Mth.nextInt(level.getRandom(), 60, 120)
        );
    }

    @Override
    protected void tick( BlockState state,ServerLevel level, BlockPos pos,RandomSource random) {
        if (random.nextInt(3) == 0
                || this.fewerNeigboursThan(level, pos, 4)) {

            int brightness =level.dimension() == Level.END
                            ? level.getBrightness(LightLayer.BLOCK, pos)
                            : level.getMaxLocalRawBrightness(pos);

            if (brightness > 1
                    - state.getValue(AGE)
                    - state.getLightDampening()
                    && this.slightlyMelt(state, level, pos)) {

                BlockPos.MutableBlockPos neighborPos =
                        new BlockPos.MutableBlockPos();

                for (Direction direction : Direction.values()) {

                    neighborPos.setWithOffset(pos, direction);

                    BlockState neighbour =
                            level.getBlockState(neighborPos);

                    if (neighbour.is(this)
                            && !this.slightlyMelt(neighbour,level,neighborPos)) {

                        level.scheduleTick(neighborPos,this,Mth.nextInt(random, 20, 40));
                    }
                }

                return;
            }
        }

        level.scheduleTick(
                pos,
                this,
                Mth.nextInt(random, 20, 40)
        );
    }

    private boolean slightlyMelt(BlockState state,Level level,BlockPos pos) {
        int age = state.getValue(AGE);

        if (age < 3) {

            level.setBlock(
                    pos,state.setValue(AGE, age + 1),2
            );

            return false;

        } else {

            this.melt(state, level, pos);

            return true;
        }
    }

    
    
    
    @Override
    protected void neighborChanged( BlockState state,Level level,BlockPos pos, Block block,
    		@Nullable Orientation orientation,
            boolean movedByPiston
    ) {if (block.defaultBlockState().is(this)
                && this.fewerNeigboursThan(level,pos,2)) {
    	this.melt(state, level, pos);
        }

        super.neighborChanged(state,level,pos,block,orientation,movedByPiston);
        }

    private boolean fewerNeigboursThan(BlockGetter level,BlockPos pos,int limit) {
        int result = 0;

        BlockPos.MutableBlockPos neighborPos =new BlockPos.MutableBlockPos();

        for (Direction direction : Direction.values()) {

            neighborPos.setWithOffset(pos, direction);

            if (level.getBlockState(neighborPos).is(this)) {

                if (++result >= limit) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(AGE);
    }

    @Override
    protected ItemStack getCloneItemStack(
            LevelReader level,
            BlockPos pos,
            BlockState state,
            boolean includeData
    ) {
        return ItemStack.EMPTY;
    }
}