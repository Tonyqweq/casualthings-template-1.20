package com.bessson.casualthings.item.custom;

import com.bessson.casualthings.item.ModArmorMaterial;
import com.google.common.collect.ImmutableBiMap;
import jdk.jshell.Snippet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem{
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> ARMOR_EFFECTS =
            (new ImmutableBiMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterial.CHICKEN_JEWEL, Arrays.asList(
                            new StatusEffectInstance(StatusEffects.JUMP_BOOST,1000,3,false,false,true),
                            new StatusEffectInstance(StatusEffects.SPEED,1000,3,false,false,true),
                            new StatusEffectInstance(StatusEffects.SLOW_FALLING,1000,3,false,false,true)
                            ))
                    .build();
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }


    //游戏中实时观察物品栏

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (!world.isClient) {
            if(entity instanceof PlayerEntity player && hasFullStitOfArmor(player)) {
                evaluateArmorsEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorsEffects(PlayerEntity player) {
        for (Map .Entry<ArmorMaterial, List<StatusEffectInstance>> entry : ARMOR_EFFECTS.entrySet()) {
            ArmorMaterial armorMaterial = entry.getKey();
            List<StatusEffectInstance> statusEffectInstances = entry.getValue();
            if (hasCorrectArmorOn(armorMaterial, player)) {
                for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
                    addStatusEffectForMaterial(player, armorMaterial, statusEffectInstance);
                }
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial armorMaterial, StatusEffectInstance statusEffectInstance) {
        boolean hasEffect = player.hasStatusEffect(statusEffectInstance.getEffectType());

        if(hasCorrectArmorOn(armorMaterial,player) && !hasEffect) {
            player.addStatusEffect(new StatusEffectInstance(statusEffectInstance));

        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial armorMaterial, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem breastplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();

        return boots.getMaterial() == material && leggings.getMaterial() == material && breastplate.getMaterial() == material && helmet.getMaterial() == material;


    }

    private boolean hasFullStitOfArmor(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }


}
