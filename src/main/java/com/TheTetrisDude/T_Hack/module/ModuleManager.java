package com.TheTetrisDude.T_Hack.module;


import com.TheTetrisDude.T_Hack.Main;
import com.TheTetrisDude.T_Hack.module.modules.client.DiscordRPC;
import com.TheTetrisDude.T_Hack.module.modules.player.RickAura;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public ArrayList<Module> modules;

    public ModuleManager() {
        (modules = new ArrayList<>()).clear();
        // client
        this.modules.add(new DiscordRPC());
        // exploits

        // player
        this.modules.add(new RickAura());
        // pvp

        // render

    }

    public Module getModule (String name) {
        for (Module m : this.modules) {
            if(m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModuleList() { return  this.modules; }

    public static List<Module> getModuleByCategory(Category c) {
        List<Module> modules = new ArrayList<Module>();
        for (Module m : Main.moduleManager.modules) {
            if(m.getCategory() == c) {
                modules.add(m);
            }
        }
        return modules;
    }

}