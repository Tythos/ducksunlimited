package net.tythos.ducksunlimited;

import net.minecraft.block.Block;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.state.StateManager;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.Hand;

public class PrismarineLampBlock extends Block {
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    public PrismarineLampBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(null, pos, ModSounds.BEE_DOOP, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }

        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.PASS;
        } else {
            boolean activated = state.get(ACTIVATED);
            world.setBlockState(pos, state.with(ACTIVATED, !activated));
            world.playSound(player, pos, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        }
    }

    public static int getLuminance(BlockState currentBlockState) {
        boolean activated = currentBlockState.get(PrismarineLampBlock.ACTIVATED);
        return activated ? 15 : 0;
    }
}
