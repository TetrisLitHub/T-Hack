package com.TheTetrisDude.T_Hack.util;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRichPresence;
import club.minnced.discord.rpc.DiscordRPC;
import net.minecraft.client.Minecraft;

public class Discord {
    // basically copied from srgantmoomoo
    private static String discordID = "876649543935082497";
    private static DiscordRichPresence discordRichPresence = new DiscordRichPresence();
    private static DiscordRPC discordRPC = DiscordRPC.INSTANCE;

    public static void startRPC() {
        DiscordEventHandlers discordEventHandlers = new DiscordEventHandlers();

        discordRPC.Discord_Initialize(discordID, discordEventHandlers, true, null);

        discordRichPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        discordRichPresence.details = "Playing Minecraft with T-Hack";
        discordRichPresence.largeImageKey = "thack"; discordRichPresence.largeImageText = "T-Hack by TheTetrisDude";
        discordRichPresence.state = null;
        discordRPC.Discord_UpdatePresence(discordRichPresence);
    }

    public static void stopRPC() {
        discordRPC.Discord_Shutdown();
        discordRPC.Discord_ClearPresence();
    }

}
