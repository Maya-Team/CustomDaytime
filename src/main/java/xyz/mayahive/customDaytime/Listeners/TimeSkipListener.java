package xyz.mayahive.customDaytime.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.TimeSkipEvent;

public class TimeSkipListener implements Listener {

    // Listen to time skip event
    @EventHandler
    public void onTimeSkip(TimeSkipEvent event){
        // Cancel vanilla night skip event
        if (event.getSkipReason() == TimeSkipEvent.SkipReason.NIGHT_SKIP) event.setCancelled(true);
    }

}
