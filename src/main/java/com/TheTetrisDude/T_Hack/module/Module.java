package com.TheTetrisDude.T_Hack.module;

import com.TheTetrisDude.T_Hack.Main;
import com.TheTetrisDude.T_Hack.setting.settings.SettingBoolean;
import com.TheTetrisDude.T_Hack.setting.settings.SettingDouble;
import com.TheTetrisDude.T_Hack.setting.settings.SettingInteger;
import com.TheTetrisDude.T_Hack.setting.settings.SettingMode;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;

public class Module {

    public String name, description;
    private int key;
    private Category category;
    public boolean toggled;

    public Module(String name, String description, Category category) {
        super();
        this.name = name;
        this.description = description;
        this.key = 0;
        this.category = category;
        this.toggled = false;
    }

    // Just getters and setters
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public int getKey() { return key; }
    public void setKey(int key) {this.key = key;}
    public String getName() {return this.name;}
    public Category getCategory() {return this.category;}
    public boolean isToggled() {return toggled;}
    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        if (this.toggled) {this.onEnable();}
        else {this.onDisable();}}
    public void toggle() {
        this.toggled = !this.toggled;
        if(this.toggled) {this.onEnable();}
        else {this.onDisable();}
    }

    public void onEnable() {MinecraftForge.EVENT_BUS.register(this);}
    public void onDisable() {MinecraftForge.EVENT_BUS.unregister(this);}
    public void onUpdate() {} public void onRender() {}

    // Register Settings

    public SettingBoolean register(String name, boolean value) {
        SettingBoolean set = new SettingBoolean(name, this, value);
        Main.instance.settingsManager.settings.add(set);
        return set;
    }

    public SettingMode register(String name, ArrayList<String> values, String value) {
        SettingMode set = new SettingMode(name, this, value, values);
        Main.instance.settingsManager.settings.add(set);
        return set;
    }

    public SettingInteger register(String name, int value, int min, int max) {
        SettingInteger set = new SettingInteger(name, this, value, min, max);
        Main.instance.settingsManager.settings.add(set);
        return set;
    }

    public SettingDouble register(String name, double value, double min, double max) {
        SettingDouble set = new SettingDouble(name, this, value, min, max);
        Main.instance.settingsManager.settings.add(set);
        return set;
    }

}
