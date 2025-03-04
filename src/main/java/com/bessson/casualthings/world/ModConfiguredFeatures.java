package com.bessson.casualthings.world;

import com.bessson.casualthings.CasualThings;
import com.bessson.casualthings.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> CHICKEN_ORE_KEY = registerKey("chicken_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> NETHER_CHICKEN_ORE_KEY = registerKey("nether_chicken_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_CHICKEN_ORE_KEY = registerKey("end_chicken_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> DIAMOND_BLOCK_KEY = registerKey("diamond_block");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stonePlace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslatePlace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        RuleTest netherPlace = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endPlace = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overWorld =
                List.of(OreFeatureConfig.createTarget(stonePlace, ModBlocks.CHICKEN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslatePlace,ModBlocks.CHICKEN_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> nether =
                List.of(OreFeatureConfig.createTarget(netherPlace, ModBlocks.CHICKEN_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> end =
                List.of(OreFeatureConfig.createTarget(endPlace, ModBlocks.CHICKEN_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overWorld1 =
                List.of(OreFeatureConfig.createTarget(stonePlace, Blocks.DIAMOND_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslatePlace, Blocks.DIAMOND_BLOCK.getDefaultState()));

        register(context,CHICKEN_ORE_KEY, Feature.ORE,new OreFeatureConfig(overWorld,10));
        register(context,NETHER_CHICKEN_ORE_KEY,Feature.ORE,new OreFeatureConfig(nether,10));
        register(context,END_CHICKEN_ORE_KEY,Feature.ORE,new OreFeatureConfig(end,10));
        register(context,DIAMOND_BLOCK_KEY,Feature.ORE,new OreFeatureConfig(overWorld1,10));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CasualThings.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
