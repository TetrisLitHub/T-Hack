package com.TheTetrisDude.T_Hack.setting.settings;

import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.setting.Setting;

import java.util.ArrayList;

public class SettingsManager {
    public ArrayList<Setting> settings;

    public SettingsManager() {
        settings = new ArrayList<>();
    }

    public ArrayList<Setting> getSettingsInMod(Module mod) {
        ArrayList<Setting> sets = new ArrayList<>();
        for (Setting s : settings) {
            if (s.getMod() == mod) {
                sets.add(s);
            }
        }
        return sets;
    }

    public ArrayList<Setting> getSettings() {
        return settings;
    }

}
