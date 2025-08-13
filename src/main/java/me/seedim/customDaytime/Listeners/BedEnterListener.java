package me.seedim.customDaytime.Listeners;

import me.seedim.customDaytime.CustomDaytime;
import me.seedim.customDaytime.Utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class BedEnterListener implements Listener {

    // Listen to player bed enter event
    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {

        // If player didn't successfully enter the bed, return
        if (event.getBedEnterResult() != PlayerBedEnterEvent.BedEnterResult.OK) return;

        World world = event.getPlayer().getWorld();

        // If enough players are sleeping, start night fast forwarding
        Bukkit.getScheduler().runTaskLater(CustomDaytime.getInstance(), () -> {
            if (TimeUtils.isEnoughPlayersSleeping(world)) {
                TimeUtils.startNightFastForward(world);
            }
        }, 1L); // delay 1 tick so isSleeping() returns true
    }

}
