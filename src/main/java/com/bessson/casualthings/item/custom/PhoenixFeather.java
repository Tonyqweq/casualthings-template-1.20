package com.bessson.casualthings.item.custom;

import com.bessson.casualthings.item.ModArmorMaterial;
import com.bessson.casualthings.sounds.ModSounds;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PhoenixFeather extends Item {
    private static  boolean flag = false;

    private static final Map<ArmorMaterial, List<StatusEffectInstance>> ARMOR_EFFECTS =
            (new ImmutableBiMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterial.CHICKEN_JEWEL, Arrays.asList(
                            new StatusEffectInstance(StatusEffects.STRENGTH,1000,2,false,false,true),
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,1000,1,false,false,true)
                    ))
                    .build();

    public PhoenixFeather(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        BlockPos pos = user.getBlockPos();
        if (user != null && !world.isClient) {
            // 设置冷却时间为 100 tick (5 秒)
            user.getItemCooldownManager().set(this, 10000);
            flag = true;
        }
        if(flag) {
            outputMessage(user);
            evaluateArmorsEffects(user);

            flag = false;
        }

        return super.use(world, user, hand);
    }

    private void evaluateArmorsEffects(PlayerEntity player) {

        for (Map .Entry<ArmorMaterial, List<StatusEffectInstance>> entry : ARMOR_EFFECTS.entrySet()) {
            ArmorMaterial armorMaterial = entry.getKey();
            List<StatusEffectInstance> statusEffectInstances = entry.getValue();
            for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
                addStatusEffectForMaterial(player, armorMaterial, statusEffectInstance);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial armorMaterial, StatusEffectInstance statusEffectInstance) {
        boolean hasEffect = player.hasStatusEffect(statusEffectInstance.getEffectType());

        if(!hasEffect) {
            player.addStatusEffect(new StatusEffectInstance(statusEffectInstance));

        }
    }

    private void outputMessage(PlayerEntity player) {
        // 将文本添加到物品描述
        player.sendMessage(Text.literal("你感受到了火焰的力量"),false);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        Text text=Text.translatable("item.casualthings.phoenix_feather.tooltip").styled(style -> style.withBold(true).withItalic(true).withColor(0x00FF00));
        tooltip.add(text);
        super.appendTooltip(stack, world, tooltip, context);
    }
}
