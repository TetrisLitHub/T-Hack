package com.TheTetrisDude.T_Hack.module.modules.player;

import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import org.lwjgl.input.Keyboard;

import java.io.IOException;
import java.net.URISyntaxException;

public class RickAura extends Module {
    java.net.URI uri = null;
    public RickAura() {
        super("RickAura", "This module will never give you up. Binding: up arrow", Category.PLAYER);
        this.setKey(Keyboard.KEY_UP);
    }
    public void onEnable() {
        try { uri = new java.net.URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"); } catch (URISyntaxException e) { e.printStackTrace(); }
        try { java.awt.Desktop.getDesktop().browse(uri); } catch (IOException e) { e.printStackTrace(); }
    }
}
