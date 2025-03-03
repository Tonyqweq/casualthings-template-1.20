package com.bessson.casualthings.screen;


import com.bessson.casualthings.CasualThings;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PolishingMachineScreen extends HandledScreen<PolishingMachineScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CasualThings.MOD_ID,"textures/gui/polishing_machine_gui.png");
    public PolishingMachineScreen(PolishingMachineScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 1000;
        playerInventoryTitleY = 1000;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        // 设置着色器为位置纹理程序
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        // 设置着色器颜色为白色
        RenderSystem.setShaderColor(1f,1f,1f,1f);
        // 设置着色器纹理为TEXTURE
        RenderSystem.setShaderTexture(0,TEXTURE);
        // 计算背景的x坐标
        int x = (width - backgroundWidth) / 2;
        // 计算背景的y坐标
        int y = (height - backgroundHeight) / 2;

        // 绘制背景纹理
        context.drawTexture(TEXTURE,x,y,0,0,backgroundWidth,backgroundHeight);

        // 绘制进度箭头
        renderProgressArrow(context, x, y);
    }

// 渲染进度箭头
    private void renderProgressArrow(DrawContext context, int x, int y) {
        // 如果正在制作
        if (handler.isCrafting()){
            // 绘制纹理
            context.drawTexture(TEXTURE,x + 85, y + 30, 176,0,8,handler.getScaledProgress());
        }
    }

    @Override
    // 重写render方法
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 渲染背景
        renderBackground(context);
        // 调用父类的render方法
        super.render(context, mouseX, mouseY, delta);
        // 绘制鼠标悬停提示
        drawMouseoverTooltip(context,mouseX,mouseY);
    }
}
