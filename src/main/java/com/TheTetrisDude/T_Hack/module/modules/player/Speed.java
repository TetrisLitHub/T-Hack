package com.TheTetrisDude.T_Hack.module.modules.player;

import com.TheTetrisDude.T_Hack.module.Category;
import com.TheTetrisDude.T_Hack.module.Module;
import com.TheTetrisDude.T_Hack.setting.settings.SettingDouble;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;

public class Speed extends Module {
    SettingDouble multiplier;
    Entity entity;
    MovementInput movementInput = new MovementInput();
    double forward;
    double strafe;
    double yaw;

    public Speed() {
        super("Speed", "I am speed.", Category.PLAYER);
        /*multiplier = this.register("multiplier", 2f, 1f, 10f);
        forward = movementInput.moveForward;
        strafe = movementInput.moveStrafe;
        yaw = entity.rotationYaw;*/
    }

    public void onUpdate() {
        /*entity.motionX = forward * multiplier.getValue() * Math.cos(Math.toRadians(yaw + 90.0f)) + strafe * multiplier.getValue() * Math.sin(Math.toRadians(yaw + 90.0f));
        entity.motionZ = forward * multiplier.getValue() * Math.sin(Math.toRadians(yaw + 90.0f)) - strafe * multiplier.getValue() * Math.cos(Math.toRadians(yaw + 90.0f));*/
    }

    public void onDisable() {
        /*entity.motionX = forward;
        entity.motionZ = forward;*/
    }

}

// TODO: Fix this module, unskid placeholder code