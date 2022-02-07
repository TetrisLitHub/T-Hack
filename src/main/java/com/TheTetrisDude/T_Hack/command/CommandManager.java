package com.TheTetrisDude.T_Hack.command;

import com.TheTetrisDude.T_Hack.Main;
import com.TheTetrisDude.T_Hack.util.Reference;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommandManager {
    public static String prefix = "~";

    public CommandManager() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void addchatmessage(String msg) {
        msg = ChatFormatting.GRAY + "[" + ChatFormatting.GREEN + Reference.NAME + ChatFormatting.GRAY + "] " + ChatFormatting.WHITE + msg;
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(msg));
    }

    @SubscribeEvent
    public void listener(ClientChatEvent event) { if (event.getMessage().startsWith(prefix)) {
        String[] args = event.getMessage().split(" ");
        event.setCanceled(true);

        switch (args[0].substring(1)) { default: addchatmessage(ChatFormatting.RED + "Not a valid command!"); break;

            case "enable":
                if (args.length < 2) { addchatmessage(ChatFormatting.RED + "Not enough arguments!"); break; }
                if (Main.moduleManager.getModuleList().contains(Main.moduleManager.getModule(args[1]))) {
                    Main.moduleManager.getModule(args[1]).setToggled(true);
                    addchatmessage(Main.moduleManager.getModule(args[1]).getName() + " enabled");
                } else addchatmessage(ChatFormatting.RED + "Could not find " + args[1]);
                break;

            case "disable":
                if (args.length < 2) { addchatmessage(ChatFormatting.RED + "Not enough arguments!"); break; }
                if (Main.moduleManager.getModuleList().contains(Main.moduleManager.getModule(args[1]))) {
                    Main.moduleManager.getModule(args[1]).setToggled(false);
                    addchatmessage(Main.moduleManager.getModule(args[1]).getName() + " disabled");
                } else addchatmessage(ChatFormatting.RED + "Could not find " + args[1]);
                break;

            case "help":
                if (args.length < 2) { addchatmessage(ChatFormatting.RED + "Not enough arguments!"); break; }
                if (Main.moduleManager.getModuleList().contains(Main.moduleManager.getModule(args[1]))) {
                    addchatmessage(Main.moduleManager.getModule(args[1]).getName() +": "+ Main.moduleManager.getModule(args[1]).getDescription());
                } else addchatmessage(ChatFormatting.RED + "Could not find " + args[1]);
                break;

            case "save":
                if (args.length < 2) Main.configManager.active_config = "config";
                else Main.configManager.active_config = args[1];
                Main.configManager.saveConfig();
                addchatmessage("Saved T-Hack config as: " + args[1] + ".thcf");
                break;

            case "load":
                if (args.length < 2) Main.configManager.active_config = "config";
                else Main.configManager.active_config = args[1];
                Main.configManager.loadConfig();
                addchatmessage("Loaded T-Hack config: " + args[1] + ".thcf");
                break;

            case "mask":
                addchatmessage("?????????\n(Secure the bag, know what I mean? Banrisk on the beat)\n" +
                        "(We The Sus Music)\n" +
                        "(Ayo, Perish, this is hot, boy)\n" +
                        "\n" +
                        "I suck his dick with a smile for hours at a time\n" +
                        "Stare at his nutsack while I hold back my cum tonight\n" +
                        "And when he ask me what position\n" +
                        "I say, \"Doggystyle\"\n" +
                        "(And when they ask me what position\n" +
                        "I say, \"Doggystyle\")\n" +
                        "But the fact is\n" +
                        "I can never get off of his fat dick\n" +
                        "And all that they can ask is (Ask is, ask is)\n" +
                        "\"I just wanna smack it\" (I just wanna smack it)\n" +
                        "\n" +
                        "Here's what the fact is\n" +
                        "He can put my asshole in a casket (Yuh, yuh, yuh)\n" +
                        "Asshole in a casket\n" +
                        "\n" +
                        "So you can see I'm cummin'\n" +
                        "But you won't see me nut\n" +
                        "And I'll just keep on suckin', I'm good (Yeah, I'm good)\n" +
                        "And if he sucks my glizzy\n" +
                        "I will become dizzy\n" +
                        "But it keeps us busy, I'm good (Yeah, I'm good)\n" +
                        "I've been twerking for boys for so long\n" +
                        "I've been flirting with boys for so long\n" +
                        "My jaw's been hurting for so, so long it's real\n" +
                        "So long, it's real, so long, it's real\n" +
                        "\n" +
                        "Always bein' judged by a bunch of sexy faces\n" +
                        "Stickin' up the guys, haven't seen a girl in ages\n" +
                        "But I've been places\n" +
                        "Kissin' guy's faces, kissin' guy's faces\n" +
                        "Kissin' guy's faces\n" +
                        "But the fact is\n" +
                        "Kissin' guys is all that I have practiced\n" +
                        "Suckin' glizzies while I'm on my mattress\n" +
                        "I just really wish that I could smack it (I just wanna smack it)\n" +
                        "\n" +
                        "Here's what the fact is\n" +
                        "He can put my asshole in a casket (Yuh, yuh, yuh)\n" +
                        "Asshole in a casket\n" +
                        "\n" +
                        "So you can see I'm cummin'\n" +
                        "But you won't see me nut\n" +
                        "And I'll just keep on suckin', I'm good (Yeah, I'm good)\n" +
                        "And if he sucks my glizzy\n" +
                        "I will become dizzy\n" +
                        "But it keeps us busy, I'm good (Yeah, I'm good)\n" +
                        "I've been twerking for boys for so long\n" +
                        "I've been flirting with boys for so long\n" +
                        "My jaw's been hurting for so, so long it's real\n" +
                        "So long, it's real, so long, it's real\n" +
                        "\n" +
                        "So long, it's real\n" +
                        "So long, it's real\n" +
                        "So long, it's real\n" +
                        "(We The Sus Music)");
                break;
        }
    }}

}
