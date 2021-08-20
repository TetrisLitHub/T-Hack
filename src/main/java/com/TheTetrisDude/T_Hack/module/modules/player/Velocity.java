package com.TheTetrisDude.T_Hack.module.modules.player;

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
        super("Velocity", "Reduces knockback", Category.PLAYER);
        this.setKey(Keyboard.KEY_V);
    }

    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener = new Listener<>(event -> {
        if (event.getPacket() instanceof SPacketEntityVelocity){
            if (((SPacketEntityVelocity) event.getPacket()).getEntityID() == Minecraft.getMinecraft().player.getEntityId()) {
                event.cancel();
            }
        }
        if (event.getPacket() instanceof SPacketExplosion){
            event.cancel();
        }
    });

}
