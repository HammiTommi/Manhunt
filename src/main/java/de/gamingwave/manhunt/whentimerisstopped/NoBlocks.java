package de.gamingwave.manhunt.whentimerisstopped;

import de.gamingwave.manhunt.timer.Timer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class NoBlocks implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Timer timer = Timer.getInstance();

        if (!timer.isRunning()){
            event.setCancelled(true);
        }
    }
}
