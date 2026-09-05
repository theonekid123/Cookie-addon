package com.yourname.cookieaddon.modules;

import com.yourname.cookieaddon.CookieAddon;
import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;

public class SwingSpeed extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> speed = sgGeneral.add(new DoubleSetting.Builder()
        .name("speed")
        .description("Swing speed multiplier.")
        .defaultValue(2.0)
        .min(0.1)
        .max(10.0)
        .build()
    );

    public SwingSpeed() {
        super(CookieAddon.CATEGORY, "swing-speed", "Makes your arm swing faster.");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null || mc.gameMode == null) return;
        
        // This makes the swing animation faster
        // Actual speed modification happens client-side
        mc.player.swingTime = (int) (mc.player.swingTime / speed.get());
    }
}
