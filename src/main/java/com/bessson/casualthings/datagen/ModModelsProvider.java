package com.bessson.casualthings.datagen;

import com.bessson.casualthings.block.ModBlocks;
import com.bessson.casualthings.block.custom.CornCropBlock;
import com.bessson.casualthings.item.ModItems;
import com.bessson.casualthings.block.custom.OnionCropBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.CocoaBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }



    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        BlockStateModelGenerator.BlockTexturePool chickenbrickPool=blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHICKEN_BRICK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHICKEN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHICKEN_SHIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JUMPBLOCK);


        chickenbrickPool.stairs(ModBlocks.CHICKEN_BRICK_STAIR);
        chickenbrickPool.slab(ModBlocks.CHICKEN_BRICK_SLAB);
        chickenbrickPool.button(ModBlocks.CHICKEN_BRICK_BUTTON);
        chickenbrickPool.pressurePlate(ModBlocks.CHICKEN_BRICK_PRESSURE_PLATE);
        chickenbrickPool.fence(ModBlocks.CHICKEN_BRICK_FENCE);
        chickenbrickPool.wall(ModBlocks.CHICKEN_BRICK_WALL);
        chickenbrickPool.fenceGate(ModBlocks.CHICKEN_BRICK_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.CHICKEN_BRICK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CHICKEN_BRICK_TRAPDOOR);

        //crop
        blockStateModelGenerator.registerCrop(ModBlocks.ONION_CROP, OnionCropBlock.AGE,0,1,2,3,4,5);
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE,0,1,2,3,4,5,6,7,8);

        blockStateModelGenerator.registerSimpleState(ModBlocks.POLISHING_MACHINE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //普通物品
        itemModelGenerator.register(ModItems.CHICKEN_SKIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_JEWEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_CHOPPED_CHICKEN_SKIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOPPED_CHICKEN_SKIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRILLED_CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.AAA_CD, Models.GENERATED);

        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHOENIX_FEATHER, Models.GENERATED);
        //工具材质
        itemModelGenerator.register(ModItems.CHICKEN_JEWEL_SWORD,Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHICKEN_JEWEL_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHICKEN_JEWEL_AXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHICKEN_JEWEL_SHOVEL,Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHICKEN_JEWEL_HOE,Models.HANDHELD);

        //盔甲
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CHICKEN_JEWEL_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CHICKEN_JEWEL_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CHICKEN_JEWEL_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CHICKEN_JEWEL_BOOTS);


    }
}
