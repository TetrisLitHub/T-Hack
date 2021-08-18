package com.TheTetrisDude.T_Hack.setting.settings;

import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.setting.Setting;

public class SettingBoolean extends Setting {
    public boolean value;

    public SettingBoolean(String name, Module mod, boolean value) {
        this.name = name;
        this.mod = mod;
        this.value = value;
        this.type = Type.BOOLEAN;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
