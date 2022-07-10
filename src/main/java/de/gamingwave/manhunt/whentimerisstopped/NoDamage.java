package de.gamingwave.manhunt.whentimerisstopped;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import de.gamingwave.manhunt.timer.Timer;

public class NoDamage implements Listener {






    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        Timer timer = Timer.getInstance();
        if (!timer.isRunning()) {
            event.setCancelled(true);

        }

    }

}
