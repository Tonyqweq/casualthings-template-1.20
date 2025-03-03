package com.bessson.util;

import com.bessson.casualthings.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.loader.impl.lib.sat4j.minisat.core.PrimeImplicantStrategy;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft","chests/jungle_temple");
    //可疑的沙子
    private static final Identifier SUS_SAND_ID =
            new Identifier("minecraft","archaeology/desert_pyramid");

    public static void ModLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))//生成几率
                        .with(ItemEntry.builder(ModItems.CHICKEN_JEWEL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)));//数量的最大最小值

                tableBuilder.pool(poolBuilder.build());
            }
            if (JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.PHOENIX_FEATHER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }

        });


        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (SUS_SAND_ID.equals(id)) {
                LootPool.Builder pool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.CHICKEN_SKIN))
                        .with(ItemEntry.builder(ModItems.CHICKEN_JEWEL_AXE));
                return LootTable.builder().pool(pool).build();
            }
            return null;
        });
    }
}
