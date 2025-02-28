// package net.tythos.ducksunlimited.datagen;

// import
// net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
// import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
// import java.util.concurrent.CompletableFuture;
// import net.minecraft.registry.RegistryWrapper;
// import net.tythos.ducksunlimited.ModLootTables;
// import net.minecraft.registry.RegistryKey;
// import net.minecraft.loot.context.LootContextTypes;
// import net.minecraft.loot.LootTable;
// import net.minecraft.loot.LootPool;
// import java.util.function.BiConsumer;
// import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
// import net.minecraft.item.Items;
// import net.minecraft.loot.entry.ItemEntry;
// import net.minecraft.loot.function.SetCountLootFunction;

// public class ChestLootTableProvider extends SimpleFabricLootTableProvider {
// public ChestLootTableProvider(FabricDataOutput output,
// CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
// super(output, registryLookup, LootContextTypes.CHEST);
// }

// @Override
// public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder>
// lootTableBiConsumer) {
// lootTableBiConsumer.accept(ModLootTables.TEST_CHEST_LOOT,
// LootTable.builder()
// .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0f))
// .with(ItemEntry.builder(Items.DIAMOND)
// .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f))))
// .with(ItemEntry.builder(Items.DIAMOND_SWORD))));
// }
// }
