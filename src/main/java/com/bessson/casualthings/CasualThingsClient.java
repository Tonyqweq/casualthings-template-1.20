package com.bessson.casualthings;

import com.bessson.casualthings.block.ModBlocks;
import com.bessson.casualthings.entity.ModEntities;
import com.bessson.casualthings.entity.client.ModModelLayers;
import com.bessson.casualthings.entity.client.TigerModel;
import com.bessson.casualthings.entity.client.TigerRenderer;
import com.bessson.casualthings.item.ModItems;
import com.bessson.casualthings.screen.ModScreenHandlers;
import com.bessson.casualthings.screen.PolishingMachineScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class CasualThingsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHICKEN_BRICK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHICKEN_BRICK_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ONION_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.POLISHING_MACHINE_SCREEN_HANDLER, PolishingMachineScreen::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TIGER, TigerModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
    }
}
