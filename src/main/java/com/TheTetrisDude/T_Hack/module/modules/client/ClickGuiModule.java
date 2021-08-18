package com.TheTetrisDude.T_Hack.module.modules.client;

import com.TheTetrisDude.T_Hack.Main;
import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGuiModule extends Module {
    public ClickGuiModule() {
        super("ClickGui", "Opens the GUI interface of the client", Category.CLIENT);
        this.setKey(Keyboard.KEY_RSHIFT);
    }

    public void onEnable() {
        // Minecraft.getMinecraft().displayGuiScreen(Main.instance.clickGui);
        toggle();
    }

}
