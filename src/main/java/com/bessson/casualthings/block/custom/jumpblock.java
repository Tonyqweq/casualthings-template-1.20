package com.bessson.casualthings.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class jumpblock extends Block {
    public jumpblock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        entity.setPos(entity.getX(),entity.getY()+60,entity.getZ());
        entity.setSwimming(true);
        super.onEntityLand(world, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.literal("他可以让你\"跳\"高"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
