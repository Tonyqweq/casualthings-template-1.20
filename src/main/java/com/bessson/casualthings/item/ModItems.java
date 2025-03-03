package com.bessson.casualthings.item;

import com.bessson.casualthings.CasualThings;
import com.bessson.casualthings.block.ModBlocks;

import com.bessson.casualthings.item.custom.ModArmorItem;
import com.bessson.casualthings.item.custom.PhoenixFeather;
import com.bessson.casualthings.item.custom.Prospector;
import com.bessson.casualthings.sounds.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CHICKEN_SKIN=registerItems("chicken_skin",new Item(new FabricItemSettings()));
    public static final Item CHOPPED_CHICKEN_SKIN=registerItems("chopped_chicken_skin",new Item(new FabricItemSettings()));
    public static final Item COOKED_CHOPPED_CHICKEN_SKIN=registerItems("cooked_chopped_chicken_skin",
            new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_CHOPPED_CHICKEN_SKIN).maxCount(64)));
    public static final Item ONION=registerItems("onion",
            new Item(new FabricItemSettings().food(ModFoodComponents.ONION).maxCount(64)));
    public static final Item ONION_SEED=registerItems("onion_seed",
            new AliasedBlockItem(ModBlocks.ONION_CROP,new FabricItemSettings().food(ModFoodComponents.ONION).maxCount(64)));

    public static final Item CORN=registerItems("corn",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN).maxCount(64)));

    public static final Item CORN_SEED=registerItems("corn_seed",
            new AliasedBlockItem(ModBlocks.CORN_CROP,new FabricItemSettings().food(ModFoodComponents.CORN).maxCount(64)));

    public static final Item GRILLED_CORN=registerItems("grilled_corn",
            new Item((new FabricItemSettings().food(ModFoodComponents.GRILLED_CORN).maxCount(64))));


    public static final Item CHICKEN_JEWEL=registerItems("chicken_jewel",new Item(new FabricItemSettings().maxCount(64)));

    public static final Item PHOENIX_FEATHER=registerItems("phoenix_feather",new PhoenixFeather(new FabricItemSettings().maxCount(1)));

    //Tools
    public static final Item CHICKEN_JEWEL_PICKAXE=registerItems("chicken_jewel_pickaxe"
            ,new PickaxeItem(ModToolMaterial.CHICKEN_JEWEL,1, -2.8F,new FabricItemSettings()));
    public static final Item CHICKEN_JEWEL_SWORD=registerItems("chicken_jewel_sword"
            ,new SwordItem(ModToolMaterial.CHICKEN_JEWEL,3, -2.4F,new FabricItemSettings()));
    public static final Item CHICKEN_JEWEL_AXE=registerItems("chicken_jewel_axe",
            new AxeItem(ModToolMaterial.CHICKEN_JEWEL,5.0F, -3.0F,new FabricItemSettings()));
    public static final Item CHICKEN_JEWEL_SHOVEL=registerItems("chicken_jewel_shovel"
            ,new ShovelItem(ModToolMaterial.CHICKEN_JEWEL,1.5F, -3.0F,new FabricItemSettings()));
    public static final Item CHICKEN_JEWEL_HOE=registerItems("chicken_jewel_hoe"
            ,new HoeItem(ModToolMaterial.CHICKEN_JEWEL,-3, 0.0F,new FabricItemSettings()));

    //Armor

    public static final Item CHICKEN_JEWEL_HELMET=registerItems("chicken_jewel_helmet",
            new ModArmorItem(ModArmorMaterial.CHICKEN_JEWEL, ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item CHICKEN_JEWEL_CHESTPLATE=registerItems("chicken_jewel_chestplate",
            new ModArmorItem(ModArmorMaterial.CHICKEN_JEWEL, ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item CHICKEN_JEWEL_LEGGINGS=registerItems("chicken_jewel_leggings",
            new ModArmorItem(ModArmorMaterial.CHICKEN_JEWEL, ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item CHICKEN_JEWEL_BOOTS=registerItems("chicken_jewel_boots",
            new ModArmorItem(ModArmorMaterial.CHICKEN_JEWEL, ArmorItem.Type.BOOTS,new FabricItemSettings()));

    public static final Item AAA_CD=registerItems("aaa_cd",new MusicDiscItem(7, ModSounds.AAA_CD_CALL,new FabricItemSettings().maxCount(1),223));




    public static final Item PROSPECTOR=registerItems("prospector",new Prospector(new FabricItemSettings().maxDamage(128)));
    /*private static void addItemToIG_1(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(CHICKEN_SKIN);
    }
    private static void addItemToIG_2(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(CHICKEN_SKIN);
    }*/
    //物品注册
    private static Item registerItems(String name,Item item){
        return Registry.register(Registries.ITEM,new Identifier(CasualThings.MOD_ID,name),item);
    }
    public static void registerModItems(){

    }


}
