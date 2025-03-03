package com.bessson.casualthings.item;

import com.bessson.casualthings.CasualThings;
import com.bessson.casualthings.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CASUAL_GROUP= Registry.register(Registries.ITEM_GROUP,
            new Identifier(CasualThings.MOD_ID,"casual_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.casual_group"))
                    .icon(()->new ItemStack(ModItems.CHICKEN_SKIN)).entries((displayContext, entries) -> {
                        entries.add(ModItems.CHICKEN_SKIN);
                        entries.add(ModItems.CHOPPED_CHICKEN_SKIN);
                        entries.add(ModItems.COOKED_CHOPPED_CHICKEN_SKIN);
                        entries.add(ModItems.ONION);
                        entries.add(ModItems.ONION_SEED);
                        entries.add(ModItems.CORN);
                        entries.add(ModItems.GRILLED_CORN);
                        entries.add(ModItems.CORN_SEED);
                        entries.add(ModItems.CHICKEN_JEWEL);
                        entries.add(ModItems.PROSPECTOR);
                        entries.add(ModItems.PHOENIX_FEATHER);


                        entries.add(ModBlocks.CHICKEN_ORE);
                        entries.add(ModBlocks.CHICKEN_SHIN_BLOCK);
                        entries.add(ModBlocks.JUMPBLOCK);
                        entries.add(ModBlocks.CHICKEN_BRICK);

                        entries.add((ModBlocks.CHICKEN_BRICK_FENCE_GATE));
                        entries.add((ModBlocks.CHICKEN_BRICK_BUTTON));
                        entries.add((ModBlocks.CHICKEN_BRICK_FENCE));
                        entries.add((ModBlocks.CHICKEN_BRICK_SLAB));
                        entries.add((ModBlocks.CHICKEN_BRICK_DOOR));
                        entries.add((ModBlocks.CHICKEN_BRICK_STAIR));
                        entries.add((ModBlocks.CHICKEN_BRICK_PRESSURE_PLATE));
                        entries.add((ModBlocks.CHICKEN_BRICK_WALL));
                        entries.add((ModBlocks.CHICKEN_BRICK_TRAPDOOR));

                        entries.add(ModItems.CHICKEN_JEWEL_SWORD);
                        entries.add(ModItems.CHICKEN_JEWEL_PICKAXE);
                        entries.add(ModItems.CHICKEN_JEWEL_AXE);
                        entries.add(ModItems.CHICKEN_JEWEL_SHOVEL);
                        entries.add(ModItems.CHICKEN_JEWEL_HOE);

                        entries.add(ModItems.CHICKEN_JEWEL_HELMET);
                        entries.add(ModItems.CHICKEN_JEWEL_CHESTPLATE);
                        entries.add(ModItems.CHICKEN_JEWEL_LEGGINGS);
                        entries.add(ModItems.CHICKEN_JEWEL_BOOTS);

                        entries.add(ModItems.AAA_CD);
                        entries.add(ModBlocks.POLISHING_MACHINE);


                    }).build());
    public static void registerModItemGroup(){

    }
}
