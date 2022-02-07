package com.TheTetrisDude.T_Hack.module;


import com.TheTetrisDude.T_Hack.Main;
import com.TheTetrisDude.T_Hack.module.modules.client.*;
import com.TheTetrisDude.T_Hack.module.modules.exploits.*;
import com.TheTetrisDude.T_Hack.module.modules.player.*;
import com.TheTetrisDude.T_Hack.module.modules.pvp.Criticals;
import com.TheTetrisDude.T_Hack.module.modules.pvp.Velocity;
import com.TheTetrisDude.T_Hack.module.modules.render.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static ArrayList<Module> modules;

    public ModuleManager() {
        (modules = new ArrayList<>()).clear();
        // client
        this.modules.add(new DiscordRPC());
        this.modules.add(new ClickGuiModule());
        // exploits
        this.modules.add(new RickAura());
        // player
        this.modules.add(new Sprint());
        this.modules.add(new Step());
        this.modules.add(new Velocity());
        this.modules.add(new Speed());
        // pvp
        this.modules.add(new Criticals());
        // render
        this.modules.add(new FullBright());
    }

    public static void onUpdate() { modules.stream().filter(Module::isToggled).forEach(Module::onUpdate); }
    public static void onRender() {
        modules.stream().filter(Module::isToggled).forEach(Module::onRender);
        // Main.clickGui.render();
    }

    public Module getModule (String name) {
        for (Module m : this.modules) {
            if(m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModuleList() { return this.modules; }

    public List<Module> getModuleByCategory(Category c) {
        List<Module> modules = new ArrayList<Module>();
        for (Module m : Main.moduleManager.modules) {
            if(m.getCategory() == c) {
                modules.add(m);
            }
        }
        return modules;
    }

}
