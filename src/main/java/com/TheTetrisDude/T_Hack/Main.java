package com.TheTetrisDude.T_Hack;

import com.TheTetrisDude.T_Hack.command.CommandManager;
import com.TheTetrisDude.T_Hack.gui.ClickGui;
import com.TheTetrisDude.T_Hack.gui.Hud;
import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.module.ModuleManager;
import com.TheTetrisDude.T_Hack.proxy.CommonProxy;
import com.TheTetrisDude.T_Hack.config.ConfigManager;
import com.TheTetrisDude.T_Hack.config.SaveLoader;
import com.TheTetrisDude.T_Hack.setting.settings.SettingsManager;
import com.TheTetrisDude.T_Hack.util.Discord;
import com.TheTetrisDude.T_Hack.util.Reference;
import me.zero.alpine.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    public static ModuleManager moduleManager;
    public SettingsManager settingsManager;
    public static EventManager EVENT_BUS = new EventManager();
    public CommandManager commandManager;
    public Hud hud;
    public static ClickGui clickGui;
    public static SaveLoader saveLoader;
    public static ConfigManager configManager;

    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void PreInit(FMLPreInitializationEvent event) { System.out.println("T-Hack loading"); }

    @EventHandler
    public void Init (FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(instance);
        MinecraftForge.EVENT_BUS.register(new Hud());
        settingsManager = new SettingsManager();
        moduleManager = new ModuleManager();
        hud = new Hud();
        MinecraftForge.EVENT_BUS.register(new ClickGui());
        clickGui = new ClickGui();
        commandManager = new CommandManager();
        saveLoader = new SaveLoader();
        configManager = new ConfigManager();
        System.out.println("T-Hack: all systems succesfully started");
    }

    @EventHandler
    public void PostInit (FMLPostInitializationEvent event) {
        configManager.loadConfig();
        System.out.println("T-Hack: Loaded active configuration file");
        if (configManager.rpcEnabled()) {
            Discord.startRPC();
            System.out.println("T-Hack: Discord Rich Presence started");
        }
        Display.setTitle(Reference.NAME + " " + Reference.VERSION);
    }

    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent e) {
        if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) return;
        try {
            if(Keyboard.isCreated()) {
                if(Keyboard.getEventKeyState()) {
                    int keyCode = Keyboard.getEventKey();
                    if(keyCode <= 0) return;
                    for(Module m : moduleManager.modules) {
                        if (m.getKey() == keyCode && keyCode > 0) {m.toggle();}
                    }
                }
            }
        } catch (Exception q) {q.printStackTrace();}
    }

}
