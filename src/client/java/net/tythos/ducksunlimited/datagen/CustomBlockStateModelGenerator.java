package net.tythos.ducksunlimited.datagen;

import net.minecraft.block.Block;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.BlockStateSupplier;
import net.minecraft.client.data.BlockStateVariant;
import net.minecraft.client.data.BlockStateVariantMap;
import net.minecraft.client.data.ModelIds;
import net.minecraft.client.data.TextureKey;
import net.minecraft.client.data.TextureMap;
import net.minecraft.client.data.VariantSetting;
import net.minecraft.client.data.VariantSettings;
import net.minecraft.client.data.VariantsBlockStateSupplier;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.tythos.ducksunlimited.VerticalSlab;

public class CustomBlockStateModelGenerator {

    public static TextureMap blockAndTopForEnds(Block block) {
        return new TextureMap()
                .put(TextureKey.TOP, ModelIds.getBlockSubModelId(block, "_top"))
                .put(TextureKey.BOTTOM, ModelIds.getBlockSubModelId(block, "_top"))
                .put(TextureKey.SIDE, ModelIds.getBlockModelId(block));
    }

    protected static BlockStateSupplier createVerticalSlabBlockStates(Block vertSlabBlock, Identifier vertSlabId,
            Identifier fullBlockId) {
        VariantSetting<Boolean> uvlock = VariantSettings.UVLOCK;
        VariantSetting<VariantSettings.Rotation> yRot = VariantSettings.Y;
        return VariantsBlockStateSupplier.create(vertSlabBlock)
                .coordinate(BlockStateVariantMap.create(VerticalSlab.FACING, VerticalSlab.SINGLE)
                        .register(Direction.NORTH, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, vertSlabId).put(uvlock, true))
                        .register(Direction.EAST, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, vertSlabId).put(uvlock, true)
                                        .put(yRot, VariantSettings.Rotation.R90))
                        .register(Direction.SOUTH, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, vertSlabId).put(uvlock, true)
                                        .put(yRot, VariantSettings.Rotation.R180))
                        .register(Direction.WEST, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, vertSlabId).put(uvlock, true)
                                        .put(yRot, VariantSettings.Rotation.R270))
                        .register(Direction.NORTH, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, fullBlockId).put(uvlock, true))
                        .register(Direction.EAST, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, fullBlockId).put(uvlock, true))
                        .register(Direction.SOUTH, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, fullBlockId).put(uvlock, true))
                        .register(Direction.WEST, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, fullBlockId).put(uvlock, true)));
    }

    public static void registerVerticalSlab(BlockStateModelGenerator generator, Block vertSlabBlock, Block fullBlock,
            TextureMap textures) {
        // Identifier slabModel = VerticalSlab.upload(vertSlabBlock, textures,
        // generator.modelCollector);
        Identifier fullBlockModel = ModelIds.getBlockModelId(fullBlock);
        // generator.blockStateCollector.accept(createVerticalSlabBlockStates(vertSlabBlock,
        // slabModel, fullBlockModel));
        // generator.registerParentedItemModel(vertSlabBlock, slabModel);
    }
}
