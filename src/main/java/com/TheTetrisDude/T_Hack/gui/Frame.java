package com.TheTetrisDude.T_Hack.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.io.IOException;
import java.util.ArrayList;

public class Frame {

    public String name;
    public int x, y, width, height, dragx, dragy, barHeight, offset;
    public boolean hovered, open, dragging;
    public ArrayList<Button> buttons;

    public Frame(String name, int x, int y, int width, int barHeight) {
        this.name = name; this.x = x; this.y = y; this.width = width; this.height = 200; this.barHeight = barHeight;
        buttons  = new ArrayList<Button>();
    }

    public void update(int mouseX, int mouseY) {
        if (dragging) {
            x = mouseX - dragx;
            y = mouseY - dragy;
        }
        for (Button b : buttons) {
            b.update(mouseX, mouseY);
        }
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (mouseButton == 0) {
            if(bounding(mouseX, mouseY)) {
                dragging = true;
                this.dragx = mouseX - x;
                this.dragy = mouseY - y;
            }
        }
        if (mouseButton == 1) {
            if(bounding(mouseX, mouseY)) {
                open = !open;
            }
        }
        for (Button b : buttons) {
            b.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        dragging = false;
        for (Button b : buttons) {
            b.mouseReleased(mouseX, mouseY, state);
        }
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        for (Button b : buttons) {
            b.keyTyped(typedChar, keyCode);
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Gui.drawRect(x, y, x + width, y + barHeight, 0x70010101);
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(name, x + 2, y + 2, 0x61de2a);
        offset = barHeight;
        for (Button b : buttons) {
            if (open) {
                b.drawScreen(mouseX, mouseY, partialTicks, offset);
                offset += barHeight;
            }
        }
    }

    public boolean bounding(int mouseX, int mouseY) {
        if (mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + barHeight) {
            return true;
        } else {
            return false;
        }
    }

}
