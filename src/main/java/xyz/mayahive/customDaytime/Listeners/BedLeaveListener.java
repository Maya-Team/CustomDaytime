package xyz.mayahive.customDaytime.Listeners;

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

        World world = event.getPlayer().getWorld();

        // If not enough players are sleeping, stop night fast forwarding
        Bukkit.getScheduler().runTaskLater(CustomDaytime.getInstance(), () -> {
            if (!TimeUtils.isEnoughPlayersSleeping(world)) {
                TimeUtils.stopNightFastForward(world);
            }
        }, 1L); // delay so sleeping state is updated

        // Reset time since rest (to prevent phantom spawning)
        event.getPlayer().setStatistic(Statistic.TIME_SINCE_REST, 0);
    }
}
