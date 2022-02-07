package com.TheTetrisDude.T_Hack.util;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRichPresence;
import club.minnced.discord.rpc.DiscordRPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;

public class Discord {

    private static String discordID = "";
    private static DiscordRichPresence discordRichPresence = new DiscordRichPresence();
    private static DiscordRPC discordRPC = DiscordRPC.INSTANCE;
    private static Thread thread;

    public static void startRPC() {
        DiscordEventHandlers discordEventHandlers = new DiscordEventHandlers();

        discordRPC.Discord_Initialize(discordID, discordEventHandlers, true, null);

        discordRichPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        discordRichPresence.largeImageKey = "thack";
        discordRichPresence.largeImageText = "T-Hack by TheTetrisDude";

        discordRichPresence.details = "Playing Minecraft + T-Hack " + Reference.VERSION;
        discordRichPresence.state = Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu ?
                "Main menu" : Minecraft.getMinecraft().getCurrentServerData() != null ?
                Minecraft.getMinecraft().getCurrentServerData().serverIP : "RPC error";
        discordRPC.Discord_UpdatePresence(discordRichPresence);

        thread = new Thread(() -> { while (!Thread.currentThread().isInterrupted()) {
            discordRPC.Discord_RunCallbacks();
            discordRichPresence.state = Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu ?
                    "Main menu" : Minecraft.getMinecraft().getCurrentServerData() != null ?
                        "Playing " + Minecraft.getMinecraft().getCurrentServerData().serverIP : "RPC error";

            discordRPC.Discord_UpdatePresence(discordRichPresence);
            try { Thread.sleep(2000L); } catch (InterruptedException interruptedException) {}
        }});

        thread.start();

    }

    public static void stopRPC() {
        if (thread != null && !thread.isInterrupted()) thread.interrupt();
        discordRPC.Discord_Shutdown();
        discordRPC.Discord_ClearPresence();
    }

}
