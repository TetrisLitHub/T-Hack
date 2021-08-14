package com.TheTetrisDude.T_Hack.module;

public enum Category {
    PVP("PvP"), EXPLOITS("Exploits"), RENDER("Render"), PLAYER("Player"), CLIENT("Client");

    public String name;
    public int moduleIndex;

    Category(String name) {
        this.name = name;
    }

}
