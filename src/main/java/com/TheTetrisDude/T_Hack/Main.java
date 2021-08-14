package com.TheTetrisDude.T_Hack;

import com.TheTetrisDude.T_Hack.module.ModuleManager;
import com.TheTetrisDude.T_Hack.proxy.CommonProxy;
import com.TheTetrisDude.T_Hack.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    public static ModuleManager moduleManager;

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
        moduleManager = new ModuleManager();
    }

    @EventHandler
    public void PostInit (FMLPostInitializationEvent event) {

    }

}
