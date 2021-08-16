package com.TheTetrisDude.T_Hack.module.modules.client;

import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.util.Discord;
import org.lwjgl.input.Keyboard;

public class DiscordRPC extends Module{ // This references Discord.java in util (which is copied from srgantmoomoo)

    public DiscordRPC() { super("DiscordRPC", "Shows T-Hack on your Discord PFP", Category.CLIENT); this.setKey(Keyboard.KEY_DOWN);}

    public void onEnable() { Discord.startRPC(); }
    public void onDisable() { Discord.stopRPC(); }

}