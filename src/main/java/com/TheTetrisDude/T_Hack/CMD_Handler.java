package com.TheTetrisDude.T_Hack;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CMD_Handler {
    // detects chat that starts with "~", prevents message from sending and interprets as command
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String msg = event.getMessage().getUnformattedText();
        if (msg.startsWith("~")) {
            // EntityPlayer p = Minecraft.getMinecraft().world.getPlayerEntityByName(Minecraft.getMinecraft().player.getName());
            Minecraft.getMinecraft().player.sendChatMessage("CMD INTERPRETED");

        }
    }
}