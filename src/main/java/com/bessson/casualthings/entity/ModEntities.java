package com.bessson.casualthings.entity;

import com.bessson.casualthings.CasualThings;
import com.bessson.casualthings.entity.custom.TigerEntity;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<TigerEntity> TIGER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CasualThings.MOD_ID,"tiger"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,TigerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());

}
