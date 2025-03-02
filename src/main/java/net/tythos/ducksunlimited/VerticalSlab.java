package net.tythos.ducksunlimited;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.math.Direction;
import net.minecraft.state.StateManager;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.ShapeContext;
// import net.minecraft.state.property.DirectionProperty;
import net.minecraft.world.BlockView;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.item.ItemPlacementContext;

public class VerticalSlab extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty SINGLE = BooleanProperty.of("single");
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0);
    // public static final Model VERTICAL_SLAB = block("vertical_slab",
    // TextureKey.BOTTOM, TextureKey.TOP,
    // TextureKey.SIDE);

    @Override
    protected VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        boolean type = state.get(SINGLE);
        Direction direction = state.get(FACING);
        VoxelShape voxelShape;

        if (type) {
            switch (direction) {
                case WEST -> voxelShape = SHAPE_WEST.asCuboid();
                case EAST -> voxelShape = SHAPE_EAST.asCuboid();
                case SOUTH -> voxelShape = SHAPE_SOUTH.asCuboid();
                case NORTH -> voxelShape = SHAPE_NORTH.asCuboid();
                default -> throw new MatchException(null, null);
            }
            return voxelShape;
        } else {
            return VoxelShapes.fullCube();
        }
    }

    public VerticalSlab(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING,
                Direction.NORTH).with(SINGLE, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SINGLE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.getSidesShape(state, world, pos);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.getSidesShape(state, world, pos);
    }

    @Override
    protected boolean canReplace(BlockState state, ItemPlacementContext context) {
        Direction direction = state.get(FACING);
        if (context.getStack().isOf(this.asItem()) && state.get(SINGLE)) {
            if (context.canReplaceExisting()) {
                return context.getSide().getOpposite() == direction;
            }
        }
        return false;
    }
}
