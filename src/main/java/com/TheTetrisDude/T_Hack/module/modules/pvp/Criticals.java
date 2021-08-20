package com.TheTetrisDude.T_Hack.module.modules.pvp;

import com.TheTetrisDude.T_Hack.event.events.NetworkPacketEvent;
import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import org.lwjgl.input.Keyboard;

public class Criticals extends Module {

    public Criticals() {
        super("Crits", "Converts hits to critical hits", Category.PVP);
        this.setKey(Keyboard.KEY_Z);
    }
    // Credits to Srgantmoomoo bc i partially copied this from him
    @EventHandler
    private Listener<NetworkPacketEvent> PacketEvent = new Listener<>(event -> {
        if (event.getPacket() instanceof CPacketUseEntity) {
            CPacketUseEntity packet = (CPacketUseEntity)event.getPacket();
            if (packet.getAction() == CPacketUseEntity.Action.ATTACK) {
                if (packet.getEntityFromWorld(Minecraft.getMinecraft().world) instanceof EntityLivingBase && Minecraft.getMinecraft().player.onGround && !Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
                    Minecraft.getMinecraft().player.connection.sendPacket(new CPacketPlayer.Position(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY + 0.1f, Minecraft.getMinecraft().player.posZ, false));
                    Minecraft.getMinecraft().player.connection.sendPacket(new CPacketPlayer.Position(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ, false));
                }
            }
        }
    });

}
