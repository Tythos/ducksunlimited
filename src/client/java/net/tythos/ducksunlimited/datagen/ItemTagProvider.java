package net.tythos.ducksunlimited.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import java.util.concurrent.CompletableFuture;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.registry.tag.ItemTags;

public class ItemTagProvider extends FabricTagProvider<Item> {
    public static final TagKey<Item> SMELLY_ITEMS = TagKey.of(RegistryKeys.ITEM,
            Identifier.of("ducksunlimited", "smelly_items"));

    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(SMELLY_ITEMS)
                .add(Items.SLIME_BALL)
                .add(Items.ROTTEN_FLESH)
                .addOptionalTag(ItemTags.DIRT)
                .add(Identifier.ofVanilla("oak_planks"))
                .forceAddTag(ItemTags.BANNERS)
                .setReplace(true);
    }
}
