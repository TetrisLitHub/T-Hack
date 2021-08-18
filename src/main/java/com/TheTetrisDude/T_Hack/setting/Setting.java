package com.TheTetrisDude.T_Hack.setting;

import com.TheTetrisDude.T_Hack.module.Module;

public class Setting<T> {
    public String name;
    public Module mod;
    public Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Module getMod() {
        return mod;
    }

    public void setMod(Module mod) {
        this.mod = mod;
    }

    public enum Type {
        BOOLEAN,
        DOUBLE,
        INTEGER,
        MODE
    }
}
