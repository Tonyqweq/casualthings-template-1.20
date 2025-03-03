package com.bessson.casualthings.datagen;

import com.bessson.casualthings.block.ModBlocks;
import com.bessson.casualthings.block.custom.CornCropBlock;
import com.bessson.casualthings.item.ModItems;
import com.bessson.casualthings.block.custom.OnionCropBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHICKEN_SHIN_BLOCK);
        addDrop(ModBlocks.CHICKEN_BRICK);
        addDrop(ModBlocks.JUMPBLOCK);

        addDrop(ModBlocks.CHICKEN_BRICK_BUTTON);
        addDrop(ModBlocks.CHICKEN_BRICK_FENCE);
        addDrop(ModBlocks.CHICKEN_BRICK_FENCE_GATE);
        addDrop(ModBlocks.CHICKEN_BRICK_STAIR);
        addDrop(ModBlocks.CHICKEN_BRICK_TRAPDOOR);
        addDrop(ModBlocks.CHICKEN_BRICK_WALL);
        addDrop(ModBlocks.CHICKEN_BRICK_PRESSURE_PLATE);

        addDrop(ModBlocks.CHICKEN_BRICK_DOOR,doorDrops(ModBlocks.CHICKEN_BRICK_DOOR));
        addDrop(ModBlocks.CHICKEN_BRICK_SLAB,slabDrops(ModBlocks.CHICKEN_BRICK_SLAB));


        addDrop(ModBlocks.CHICKEN_ORE,copperOreLikeDrops(ModBlocks.CHICKEN_ORE, ModItems.CHICKEN_JEWEL,2.0f,5.0f));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.ONION_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(OnionCropBlock.AGE, 5));
        addDrop(ModBlocks.ONION_CROP,cropDrops(ModBlocks.ONION_CROP,ModItems.ONION,ModItems.ONION_SEED,builder));

        BlockStatePropertyLootCondition.Builder builder1 = BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CornCropBlock.AGE, 8));
        addDrop(ModBlocks.CORN_CROP,cropDrops(ModBlocks.CORN_CROP,ModItems.CORN,ModItems.CORN_SEED,builder1));

//        //当作物处于7和8阶段都可以收获
//        AnyOfLootCondition.Builder builder2 =
//                BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
//                        .exactMatch(CornCropBlock.AGE, 7))
//                        .or(BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
//                                .exactMatch(CornCropBlock.AGE, 8)));
    }

    public LootTable.Builder copperOreLikeDrops(Block drop, Item item,float expMin,float expmax) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(expMin, expmax)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }


}
