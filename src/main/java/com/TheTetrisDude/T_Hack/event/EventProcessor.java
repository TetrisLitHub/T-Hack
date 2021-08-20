package com.TheTetrisDude.T_Hack.event;

import com.TheTetrisDude.T_Hack.Main;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventProcessor {

    public EventProcessor() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        Main.EVENT_BUS.post(event);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        Main.EVENT_BUS.post(event);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent event) {
        Main.EVENT_BUS.post(event);
    }

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent event) {
        Main.EVENT_BUS.post(event);
    }
}
