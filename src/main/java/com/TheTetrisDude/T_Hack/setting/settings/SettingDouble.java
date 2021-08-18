package com.TheTetrisDude.T_Hack.setting.settings;

import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.setting.Setting;

public class SettingDouble extends Setting {
    public double value;
    public double min;
    public double max;

    public SettingDouble(String name, Module mod, double value, double min, double max) {
        this.name = name;
        this.mod = mod;
        this.value = value;
        this.min = min;
        this.max = max;
        this.type = Type.DOUBLE;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
