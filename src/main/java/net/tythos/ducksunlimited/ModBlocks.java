package net.tythos.ducksunlimited;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.PillarBlock;

public class ModBlocks {
        public static Block register(Block block, RegistryKey<Block> blockKey, boolean shouldRegisterItem) {
                if (shouldRegisterItem) {
                        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
                        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
                        Registry.register(Registries.ITEM, itemKey, blockItem);
                }
                return Registry.register(Registries.BLOCK, blockKey, block);
        }

        // public static final RegistryKey<Block> CONDENSED_DIRT_KEY =
        // RegistryKey.of(RegistryKeys.BLOCK,
        // Identifier.of("ducksunlimited", "condensed_dirt"));

        // public static final Block CONDENSED_DIRT = register(
        // new Block(AbstractBlock.Settings.create().registryKey(CONDENSED_DIRT_KEY)
        // .sounds(BlockSoundGroup.GRASS)),
        // CONDENSED_DIRT_KEY, true);

        public static final RegistryKey<Block> CONDENSED_OAK_LOG_KEY = RegistryKey.of(RegistryKeys.BLOCK,
                        Identifier.of("ducksunlimited", "condensed_oak_log"));

        public static final Block CONDENSED_OAK_LOG = register(
                        new PillarBlock(
                                        AbstractBlock.Settings.create().registryKey(CONDENSED_OAK_LOG_KEY)
                                                        .sounds(BlockSoundGroup.WOOD)),
                        CONDENSED_OAK_LOG_KEY, true);

        // public static final RegistryKey<Block> PRISMARINE_LAMP_KEY =
        // RegistryKey.of(RegistryKeys.BLOCK,
        // Identifier.of("ducksunlimited", "prismarine_lamp"));

        // public static final Block PRISMARINE_LAMP = register(
        // new PrismarineLampBlock(AbstractBlock.Settings.create()
        // .registryKey(PRISMARINE_LAMP_KEY)
        // .sounds(BlockSoundGroup.LANTERN)
        // .luminance(PrismarineLampBlock::getLuminance)),
        // PRISMARINE_LAMP_KEY, true);

        // public static final RegistryKey<Block> COUNTER_BLOCK_KEY =
        // RegistryKey.of(RegistryKeys.BLOCK,
        // Identifier.of("ducksunlimited", "counter_block"));

        // public static final Block COUNTER_BLOCK = register(
        // new CounterBlock(AbstractBlock.Settings.create()
        // .registryKey(COUNTER_BLOCK_KEY)),
        // COUNTER_BLOCK_KEY, true);

        public static final RegistryKey<Block> STEEL_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK,
                        Identifier.of("ducksunlimited", "steel_block"));

        public static final Block STEEL_BLOCK = register(
                        new Block(AbstractBlock.Settings.create().registryKey(STEEL_BLOCK_KEY)), STEEL_BLOCK_KEY, true);

        public static final RegistryKey<Block> PIPE_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK,
                        Identifier.of("ducksunlimited", "pipe_block"));

        public static final Block PIPE_BLOCK = register(
                        new Block(AbstractBlock.Settings.create().registryKey(
                                        PIPE_BLOCK_KEY)),
                        PIPE_BLOCK_KEY, true);

        public static final RegistryKey<Block> RUBY_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK,
                        Identifier.of("ducksunlimited", "ruby_block"));

        public static final Block RUBY_BLOCK = register(
                        new Block(AbstractBlock.Settings.create()
                                        .registryKey(RUBY_BLOCK_KEY)),
                        RUBY_BLOCK_KEY, true);

        public static final RegistryKey<Block> RUBY_STAIRS_KEY = RegistryKey.of(RegistryKeys.BLOCK,
                        Identifier.of("ducksunlimited", "ruby_stairs"));

        public static final Block RUBY_STAIRS = register(
                        new Block(AbstractBlock.Settings.create()
                                        .registryKey(RUBY_STAIRS_KEY)),
                        RUBY_STAIRS_KEY, true);

        public static final RegistryKey<Block> RUBY_SLAB_KEY = RegistryKey.of(RegistryKeys.BLOCK,
                        Identifier.of("ducksunlimited", "ruby_slab"));

        public static final Block RUBY_SLAB = register(
                        new SlabBlock(AbstractBlock.Settings.create()
                                        .registryKey(RUBY_SLAB_KEY)),
                        RUBY_SLAB_KEY, true);

        public static final RegistryKey<Block> RUBY_FENCE_KEY = RegistryKey.of(RegistryKeys.BLOCK,
                        Identifier.of("ducksunlimited", "ruby_fence"));

        public static final Block RUBY_FENCE = register(
                        new FenceBlock(AbstractBlock.Settings.create()
                                        .registryKey(RUBY_FENCE_KEY)),
                        RUBY_FENCE_KEY, true);

        public static void initialize() {
        }
}
