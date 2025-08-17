package xyz.mayahive.customDaytime.Listeners;

import org.bukkit.entity.Player;
import xyz.mayahive.customDaytime.CustomDaytime;
import xyz.mayahive.customDaytime.Utils.TimeUtils;
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

        Player player = event.getPlayer();
        World world = player.getWorld();

        // If enough players are sleeping, start night fast forwarding
        Bukkit.getRegionScheduler().runDelayed(
                CustomDaytime.getInstance(),
                player.getLocation(),
                scheduledTask -> {
                    if (TimeUtils.isEnoughPlayersSleeping(world)) {
                        TimeUtils.startNightFastForward(world);
                    }
                },
                1
        ); // delay 1 tick so isSleeping() returns true
    }
}
