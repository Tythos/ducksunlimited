package net.tythos.ducksunlimited.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import java.util.concurrent.CompletableFuture;
import net.minecraft.registry.RegistryWrapper;

public class EnglishLangProvider extends FabricLanguageProvider {
    protected EnglishLangProvider(FabricDataOutput dataOutput,
            CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup,
            TranslationBuilder translationBuilder) {
        translationBuilder.add("text.ducksunlimited.greeting", "Hello there!");
    }
}
