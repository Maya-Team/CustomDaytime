package xyz.mayahive.customDaytime.Listeners;

import org.bukkit.entity.Player;
import xyz.mayahive.customDaytime.CustomDaytime;
import xyz.mayahive.customDaytime.Utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedLeaveListener implements Listener {

    // Listen to player bed leave event
    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event) {

        Player player = event.getPlayer();
        World world = player.getWorld();

        // If not enough players are sleeping, stop night fast forwarding
        Bukkit.getRegionScheduler().runDelayed(
                CustomDaytime.getInstance(),
                player.getLocation(),
                scheduledTask -> {
                    if (!TimeUtils.isEnoughPlayersSleeping(world)) {
                        TimeUtils.stopNightFastForward(world);
                    }
                },
                1
        ); // delay so sleeping state is updated

        // Reset time since rest (to prevent phantom spawning)
        event.getPlayer().setStatistic(Statistic.TIME_SINCE_REST, 0);
    }
}
