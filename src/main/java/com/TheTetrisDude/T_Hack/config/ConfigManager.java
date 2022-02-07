package com.TheTetrisDude.T_Hack.config;

import com.TheTetrisDude.T_Hack.Main;
import java.util.ArrayList;

public class ConfigManager {
    public String active_config;

    public void saveConfig() {
        // TODO finish this function
        ArrayList<String> settingsList = new ArrayList<>();
        settingsList.add("test"); // placeholder
        Main.saveLoader.save(settingsList, active_config);
    }

    public void loadConfig() {
        // TODO finish this function
    }

    // TODO: read value from ShowModList from config.thcf and set variable to it
    public boolean showModList() {
        return true; // TODO placeholder. will return true or false depending on what it says in config.thcf
    }

    public boolean rpcEnabled() {
        return true; // TODO placeholder. will return true or false depending on what it says in config.thcf
    }

}