package xyz.mayahive.customDaytime.Tasks;

import xyz.mayahive.customDaytime.Utils.TimeUtils;
import org.bukkit.World;

public class TimeTickTask implements Runnable {

    private static final long TICKS_PER_DAY = 24000;
    private static final long TICKS_PER_HALF_DAY = 12000;

    @Override
    public void run() {

        // Get default worl
        World world = TimeUtils.getDefaultWorld();
        if (world == null) return; // If world isn't loaded, return

        // Get current time
        long currentTime = world.getFullTime();

        // Check if night fast forwarding is on
        if (TimeUtils.isNightFastForward(world)) {

            // Get incremented time
            long newTime = (long) ( currentTime + TimeUtils.getFastForwardIncrementPerTick()) % TICKS_PER_DAY;

            // Apply incremented time
            world.setFullTime(newTime);

            // Check if it day
            if (newTime < TICKS_PER_HALF_DAY) {
                // Stop night fast forwarding
                TimeUtils.stopNightFastForward(world);
            }
        } else {
            // Check if it day
            if (currentTime < TICKS_PER_HALF_DAY) {
                // Apply day increment per tick
                world.setFullTime((long) (currentTime + TimeUtils.getDayIncrementPerTick()) % TICKS_PER_DAY);
            } else {
                // Apply night increment per tick
                world.setFullTime((long) (currentTime + TimeUtils.getNightIncrementPerTick()) % TICKS_PER_DAY);
            }
        }
    }

}
