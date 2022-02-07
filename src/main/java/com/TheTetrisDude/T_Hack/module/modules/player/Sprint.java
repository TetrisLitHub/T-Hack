package com.TheTetrisDude.T_Hack.module.modules.player;

import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", "Auto sprints when you move", Category.PLAYER);
        this.setKey(Keyboard.KEY_CAPITAL);
    }

    public void onUpdate()  {
        Minecraft.getMinecraft().player.setSprinting(true);
    }

}

// TODO: Fix this module