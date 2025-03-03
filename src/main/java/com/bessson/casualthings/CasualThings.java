package com.bessson.casualthings;

import com.bessson.casualthings.block.ModBlocks;
import com.bessson.casualthings.block.entity.ModBlockEntities;
import com.bessson.casualthings.entity.ModEntities;
import com.bessson.casualthings.entity.custom.TigerEntity;
import com.bessson.casualthings.item.ModItemGroup;
import com.bessson.casualthings.item.ModItems;
import com.bessson.casualthings.recipe.ModRecipes;
import com.bessson.casualthings.screen.ModScreenHandlers;
import com.bessson.casualthings.villager.ModVillagers;
import com.bessson.util.ModLootTableModifiers;
import com.bessson.util.ModTrades;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CasualThings implements ModInitializer {

	public static final String MOD_ID= "casualthings";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModItemGroup.registerModItemGroup();
		ModBlocks.registerModBlocks();

		//战利品
		ModLootTableModifiers.ModLootTables();
		//村民交易
		ModTrades.modTrades();
		//自定义村民职业
		ModVillagers.registerVillagers();

		FuelRegistry.INSTANCE.add(ModItems.CHICKEN_SKIN,2000);

		ModRecipes.registerRecipes();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.createTigerAttributes());



	}
}
