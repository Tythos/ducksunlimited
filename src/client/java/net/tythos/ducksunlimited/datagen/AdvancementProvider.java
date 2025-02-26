package net.tythos.ducksunlimited.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import java.util.concurrent.CompletableFuture;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.registry.RegistryWrapper;
import java.util.function.Consumer;
import net.minecraft.advancement.Advancement;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKeys;
import java.util.Optional;

public class AdvancementProvider extends FabricAdvancementProvider {
    protected AdvancementProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry getDirt = Advancement.Builder.create()
                .display(Items.DIRT, Text.literal("Your First Dirt Block"), Text.literal("Now make a house from it"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK, true, true, false)
                .criterion("got_dirt", InventoryChangedCriterion.Conditions.items(Items.DIRT))
                .build(consumer, "ducksunlimited:get_dirt");
        final RegistryWrapper.Impl<Item> itemLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);
        AdvancementEntry appleAndBeef = Advancement.Builder.create().parent(getDirt)
                .display(Items.APPLE, Text.literal("Apple and Beef"), Text.literal("Ate an apple and beef"), null,
                        AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("ate_apple",
                        ConsumeItemCriterion.Conditions.item(wrapperLookup.getOrThrow(RegistryKeys.ITEM), Items.APPLE))
                .criterion("ate_cooked_beef", ConsumeItemCriterion.Conditions.item(itemLookup, Items.COOKED_BEEF))
                .build(consumer, "ducksunlimited:apple_and_beef");
        AdvancementEntry breaksBlockWithTool = Advancement.Builder.create().parent(getDirt)
                .display(Items.DIAMOND_SHOVEL, Text.literal("Not a Shovel"),
                        Text.literal("That's not a shovel (probably)"), null, AdvancementFrame.GOAL, true, true, false)
                .criterion("break_block_with_tool_five_times",
                        ModCriteria.USE_TOOL.create(new UseToolCriterion.Conditions(Optional.empty(), 5)))
                .build(consumer, "ducksunlimited:break_block_with_tool_five_times");
        // AdvancementEntry breaksBlockWithTool =
        // Advancement.Builder.create().parent(getDirt)
        // .display(Items.DIAMOND_SHOVEL, Text.literal("Not a Shovel"),
        // Text.literal("That's not a shovel (probably)"), null, AdvancementFrame.GOAL,
        // true, true, false)
        // .criterion("break_block_with_tool",
        // ModCriteria.USE_TOOL.create(new
        // UseToolCriterion.Conditions(Optional.empty())))
        // .build(consumer, "ducksunlimited:break_block_with_tool");
    }
}
