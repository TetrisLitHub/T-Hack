package com.TheTetrisDude.T_Hack.module.modules.player;

import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.setting.settings.SettingDouble;
import net.minecraft.client.Minecraft;

public class Step extends Module {

    SettingDouble height;

    public Step() {
        super("Step", "allows you to step up more than 1 block", Category.PLAYER);
        height = this.register("height", 3, 0.5, 10);
    }

    public void onEnable() {
        Minecraft.getMinecraft().player.stepHeight = (float) height.getValue();
    }

    public void onDisable() {
        Minecraft.getMinecraft().player.stepHeight = 0.5f;
    }
}
