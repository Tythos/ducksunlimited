// package net.tythos.ducksunlimited;

// import net.minecraft.block.BlockWithEntity;
// import net.minecraft.block.entity.BlockEntity;
// import net.minecraft.block.entity.BlockEntityTicker;
// import net.minecraft.block.entity.BlockEntityType;
// import com.mojang.serialization.MapCodec;
// import net.minecraft.block.BlockState;
// import net.minecraft.block.BlockRenderType;
// import net.minecraft.util.math.BlockPos;
// import org.jetbrains.annotations.Nullable;
// import net.minecraft.text.Text;
// import net.minecraft.util.ActionResult;
// import net.minecraft.util.hit.BlockHitResult;
// import net.minecraft.world.World;
// import net.minecraft.entity.player.PlayerEntity;

// public class CounterBlock extends BlockWithEntity {
// public CounterBlock(Settings settings) {
// super(settings);
// }

// @Override
// protected MapCodec<? extends BlockWithEntity> getCodec() {
// return createCodec(CounterBlock::new);
// }

// @Override
// protected BlockRenderType getRenderType(BlockState state) {
// return BlockRenderType.MODEL;
// }

// @Nullable
// @Override
// public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
// return new CounterBlockEntity(pos, state);
// }

// @Override
// protected ActionResult onUse(BlockState state, World world, BlockPos pos,
// PlayerEntity player, BlockHitResult hit) {
// if (!(world.getBlockEntity(pos) instanceof CounterBlockEntity
// counterBlockEntity)) {
// return super.onUse(state, world, pos, player, hit);
// }
// counterBlockEntity.incrementClicks();
// player.sendMessage(
// Text.literal("You've clicked this block for the " +
// counterBlockEntity.getClicks() + "th time."),
// true);
// return ActionResult.SUCCESS;
// }

// @Nullable
// @Override
// public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world,
// BlockState state,
// BlockEntityType<T> type) {
// return validateTicker(type, ModBlockEntities.COUNTER_BLOCK_ENTITY,
// CounterBlockEntity::tick);
// }
// }
