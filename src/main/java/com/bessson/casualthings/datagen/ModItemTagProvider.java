package com.bessson.casualthings.datagen;

import com.bessson.casualthings.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CHICKEN_JEWEL,
                        ModItems.CHICKEN_JEWEL_HELMET,
                        ModItems.CHICKEN_JEWEL_CHESTPLATE,
                        ModItems.CHICKEN_JEWEL_LEGGINGS,
                        ModItems.CHICKEN_JEWEL_BOOTS);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.AAA_CD);
    }
}
