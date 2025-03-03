package com.bessson.casualthings.block;

import com.bessson.casualthings.CasualThings;
import com.bessson.casualthings.block.custom.CornCropBlock;
import com.bessson.casualthings.block.custom.PolishingMachine;
import com.bessson.casualthings.block.custom.jumpblock;
import com.bessson.casualthings.block.custom.OnionCropBlock;
import com.bessson.casualthings.sounds.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block CHICKEN_SHIN_BLOCK=registerBlocks("chicken_skin_block", new Block(FabricBlockSettings.copyOf(Blocks.SAND)));
    public static final Block CHICKEN_ORE=registerBlocks("chicken_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(5f), UniformIntProvider.create(2,5)));
    public static final Block CHICKEN_BRICK=registerBlocks("chicken_brick", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block JUMPBLOCK=registerBlocks("jumpblock",
            new jumpblock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(ModSounds.BLOCK_SOUND_GROUP)));

    public static final Block POLISHING_MACHINE=registerBlocks("polishing_machine",
            new PolishingMachine(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)));
    public static final Block ONION_CROP= Registry.register(Registries.BLOCK,new Identifier(CasualThings.MOD_ID,"onion_crop"),
            new OnionCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block CORN_CROP= Registry.register(Registries.BLOCK,new Identifier(CasualThings.MOD_ID,"corn_crop"),
            new CornCropBlock(FabricBlockSettings.copyOf(Blocks.CARROTS)));

    public static final Block CHICKEN_BRICK_STAIR
            =registerBlocks("chicken_brick_stair", new StairsBlock(ModBlocks.CHICKEN_BRICK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block CHICKEN_BRICK_SLAB
            =registerBlocks("chicken_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block CHICKEN_BRICK_BUTTON
            =registerBlocks("chicken_brick_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS),BlockSetType.STONE,20,true));
    public static final Block CHICKEN_BRICK_PRESSURE_PLATE
            =registerBlocks("chicken_brick_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,FabricBlockSettings.copyOf(Blocks.STONE_BRICKS),BlockSetType.STONE));
    public static final Block CHICKEN_BRICK_FENCE
            =registerBlocks("chicken_brick_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block CHICKEN_BRICK_FENCE_GATE
            =registerBlocks("chicken_brick_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS),WoodType.OAK));
    public static final Block CHICKEN_BRICK_WALL
            =registerBlocks("chicken_brick_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block CHICKEN_BRICK_DOOR
            =registerBlocks("chicken_brick_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS),BlockSetType.STONE));
    public static final Block CHICKEN_BRICK_TRAPDOOR
            =registerBlocks("chicken_brick_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS),BlockSetType.STONE));
    private static Block registerBlocks(String name,Block block){
        registerBlockItems(name,block);
        return Registry.register(Registries.BLOCK,new Identifier(CasualThings.MOD_ID,name),block);
    }
    private static Item registerBlockItems(String name, Block block){
        return Registry.register(Registries.ITEM,new Identifier(CasualThings.MOD_ID, name),new BlockItem(block,new FabricItemSettings()));
    }
    public static final void registerModBlocks(){

    }
}
