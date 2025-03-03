package com.bessson.util;

import com.bessson.casualthings.item.ModItems;
import com.bessson.casualthings.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModTrades {
    public static void modTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                factories -> {
            factories.add((entity,random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD_BLOCK, 1),
                    new ItemStack(ModItems.PHOENIX_FEATHER, 1),
                    5, 5, 0.05F
                    /*
                    * maxUses 可交易次数
                    * merchantExperience 交易后获得经验
                    * priceMultiplier 价格倍率
                    * */
            ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN,1,
                factories -> {
            factories.add((entity,random) -> new TradeOffer(
                    new ItemStack(ModItems.CHICKEN_JEWEL,5),
                    EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SHARPNESS,3)),
                    3,5,0.05f
            ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CHICKEN_JEWEL_MASTER,1,
                factories -> {
                    factories.add((entity,random) -> new TradeOffer(
                            new ItemStack(ModItems.CHICKEN_JEWEL,5),
                            EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SHARPNESS,3)),
                            3,5,0.05f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CHICKEN_JEWEL_MASTER,1,
                factories -> {
                    factories.add((entity,random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD_BLOCK, 1),
                            new ItemStack(ModItems.PHOENIX_FEATHER, 1),
                            5, 5, 0.05F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CHICKEN_JEWEL_MASTER,2,
                factories -> {
                    factories.add((entity,random) -> new TradeOffer(
                            new ItemStack(ModItems.PHOENIX_FEATHER, 1),
                            new ItemStack(Items.QUARTZ_BLOCK, 1),
                            5, 5, 0.05F
                    ));
                });
    }
}
