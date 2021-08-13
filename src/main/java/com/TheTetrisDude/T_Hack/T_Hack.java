package com.TheTetrisDude.T_Hack;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = T_Hack.MODID, name = T_Hack.NAME, version = T_Hack.VERSION)
public class T_Hack
{
    public static final String MODID = "thack";
    public static final String NAME = "T-Hack";
    public static final String VERSION = "1.0";

    /*private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }*/

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("T-HACK ACTIVE!");
    }

}
