package net.tythos.ducksunlimited.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.tythos.ducksunlimited.ModBlocks;
import net.minecraft.client.data.TexturedModel;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSingleton(ModBlocks.PIPE_BLOCK, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        // .stairs(ModBlocks.RUBY_STAIRS)
        // .slab(ModBlocks.RUBY_SLAB)
        // .fence(ModBlocks.RUBY_FENCE);
        // blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        // blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);
        // CustomBlockStateModelGenerator.registerVerticalSlab(blockStateModelGenerator,
        // ModBlocks.VERTICAL_OAK_LOG_SLAB,
        // Blocks.OAK_LOG,
        // CustomBlockStateModelGenerator.blockAndTopForEnds(Blocks.OAK_LOG));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }

    @Override
    public String getName() {
        return "DucksUnlimited Model Provider";
    }
}
