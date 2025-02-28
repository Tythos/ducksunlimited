// package net.tythos.ducksunlimited.datagen;

// import
// net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
// import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
// import java.util.concurrent.CompletableFuture;
// import net.minecraft.registry.RegistryWrapper;
// import net.tythos.ducksunlimited.ModBlocks;
// import net.minecraft.loot.LootTable;
// import net.minecraft.item.Items;
// import net.minecraft.loot.LootPool;
// import net.minecraft.loot.provider.number.UniformLootNumberProvider;
// import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
// import net.minecraft.loot.entry.ItemEntry;

// public class BlockLootTableProvider extends FabricBlockLootTableProvider {
// protected BlockLootTableProvider(FabricDataOutput dataOutput,
// CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
// super(dataOutput, registryLookup);
// }

// @Override
// public void generate() {
// addDrop(ModBlocks.CONDENSED_DIRT);
// addDropWithSilkTouch(ModBlocks.PRISMARINE_LAMP);
// addDrop(ModBlocks.CONDENSED_OAK_LOG,
// LootTable.builder().pool(addSurvivesExplosionCondition(Items.OAK_LOG,
// LootPool.builder()
// .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(7),
// new ConstantLootNumberProvider(9))))
// .with(ItemEntry.builder(Items.OAK_LOG))));
// }
// }
