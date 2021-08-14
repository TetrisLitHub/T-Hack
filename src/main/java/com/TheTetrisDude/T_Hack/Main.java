package com.TheTetrisDude.T_Hack;

import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.module.ModuleManager;
import com.TheTetrisDude.T_Hack.proxy.CommonProxy;
import com.TheTetrisDude.T_Hack.ui.Hud;
import com.TheTetrisDude.T_Hack.util.Reference;
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

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    public static ModuleManager moduleManager;
    public static Hud hud;

    @Instance
    public Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
        System.out.println("T-HACK ACTIVE!");
    }

    @EventHandler
    public void Init (FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(instance);
        MinecraftForge.EVENT_BUS.register(new Hud());
        moduleManager = new ModuleManager();
        hud = new Hud();
    }

    @EventHandler
    public void PostInit (FMLPostInitializationEvent event) {

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
