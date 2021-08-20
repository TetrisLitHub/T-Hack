package com.TheTetrisDude.T_Hack.module.modules.render;

import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import net.minecraft.client.Minecraft;

public class FullBright extends Module {

    public FullBright() {
        super("FullBright", "Brightens everything to max", Category.RENDER);
    }

    public void onEnable() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
    }

    public void onDisable() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 1;
    }
}
