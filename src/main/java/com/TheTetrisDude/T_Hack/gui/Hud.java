package com.TheTetrisDude.T_Hack.gui;

import com.TheTetrisDude.T_Hack.Main;
import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class Hud extends Gui {

    private Minecraft mc = Minecraft.getMinecraft();

    public static class ModuleComparator implements Comparator<Module> {

        @Override
        public int compare(Module arg0, Module arg1) {
            if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) { return -1; }
            if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) { return 1; }
            return 0;
        }
    }

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {

        Collections.sort(Main.moduleManager.modules, new ModuleComparator());
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) { fr.drawStringWithShadow("T-Hack" + " " + Reference.VERSION, 2, 1, 0x61de2a); } // watermark

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) { // modlist
            int y = 2;
            final int[] counter = {1};
            for(Module mod : Main.moduleManager.getModuleList()) {
                if(!mod.getName().equalsIgnoreCase("DiscordRPC") && mod.isToggled() && Main.configManager.showModList()) {
                    fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0] * 300));
                    y += fr.FONT_HEIGHT;
                    counter[0]++;
                }
            }
        }
    }

    public static int rainbow(int delay) {
        double rainbowState = Math.ceil(System.currentTimeMillis() + delay) / 10.0;
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.75f, 1f).getRGB();
    }

}