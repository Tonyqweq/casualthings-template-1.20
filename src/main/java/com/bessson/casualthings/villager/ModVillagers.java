package com.bessson.casualthings.villager;

import com.bessson.casualthings.CasualThings;
import com.bessson.casualthings.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;



public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> CHICKEN_JEWEL_POI_KEY =point("chicken_jewel_poi");
    public static final PointOfInterestType CHICKEN_JEWEL_POI = registerPointOfInterest("chicken_jewel_poi", ModBlocks.CHICKEN_SHIN_BLOCK);
    public static final VillagerProfession CHICKEN_JEWEL_MASTER = registerProfession("chicken_jewel_master",CHICKEN_JEWEL_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION,new Identifier(CasualThings.MOD_ID,name),
                new VillagerProfession(name,entry ->entry.matchesKey(type),entry -> entry.matchesKey(type),
                        ImmutableSet.of(),ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_DEATH));
    }
    private static PointOfInterestType registerPointOfInterest(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(CasualThings.MOD_ID,name),1,1,block);
        /*
        * tickerCount 可供村民使用的方块的人数
        * blockDistance 村民可以使用的方块的最大距离
        * */
    }
    private static RegistryKey<PointOfInterestType> point(String name){
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE,new Identifier(CasualThings.MOD_ID,name));
    }
    public static void registerVillagers() {

    }
}
