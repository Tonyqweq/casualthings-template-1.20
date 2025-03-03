package com.bessson.casualthings.block.entity;


import com.bessson.casualthings.CasualThings;
import com.bessson.casualthings.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PolishingMachineBlockEntity> POLISHING_MACHINE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(CasualThings.MOD_ID,"polishing_machine_block_entity"),
                    FabricBlockEntityTypeBuilder.create(PolishingMachineBlockEntity::new,
                            ModBlocks.POLISHING_MACHINE).build());
    public static void registerBlockEntities(){

    }
}
