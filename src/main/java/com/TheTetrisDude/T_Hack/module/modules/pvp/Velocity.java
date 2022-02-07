package com.TheTetrisDude.T_Hack.module.modules.pvp;

import com.TheTetrisDude.T_Hack.Main;
import com.TheTetrisDude.T_Hack.event.events.PacketEvent;
import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.EventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import org.lwjgl.input.Keyboard;

public class Velocity extends Module {

    public Velocity() {
        super("Velocity", "Reduces knockback", Category.PVP);
        this.setKey(Keyboard.KEY_V);
        Main.EVENT_BUS.subscribe(this);
    }

    private Minecraft mc = Minecraft.getMinecraft();

    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener = new Listener<>(event -> {
        if (event.getPacket() instanceof SPacketEntityVelocity) {
            if (((SPacketEntityVelocity) event.getPacket()).getEntityID() == mc.player.getEntityId()) {
                event.cancel();
            }
        }
        if (event.getPacket() instanceof SPacketExplosion){
            event.cancel();
        }
    });

    public void onEnable() {
        Main.EVENT_BUS.subscribe(this);
    }
    public void onDisable() {
        Main.EVENT_BUS.unsubscribe(this);
    }
}