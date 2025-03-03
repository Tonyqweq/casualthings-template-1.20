package com.bessson.casualthings.datagen;

import com.bessson.casualthings.block.ModBlocks;
import com.bessson.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{


    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.PROSPECTOR_LIST)
                .add(ModBlocks.CHICKEN_ORE)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.JUMPBLOCK)
                .add(ModBlocks.CHICKEN_BRICK)
                .add(ModBlocks.CHICKEN_ORE);


        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.CHICKEN_SHIN_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.JUMPBLOCK);


        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,new Identifier("fabric","needs_tool_level_0")))
                .add(ModBlocks.CHICKEN_BRICK);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,new Identifier("fabric","needs_tool_level_4")))
                .add(ModBlocks.CHICKEN_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.CHICKEN_BRICK_FENCE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.CHICKEN_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.CHICKEN_BRICK_FENCE_GATE);
        }
}
