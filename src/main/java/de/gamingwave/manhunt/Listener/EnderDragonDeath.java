package de.gamingwave.manhunt.Listener;

import de.gamingwave.manhunt.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;


public class EnderDragonDeath implements Listener {

    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent e){
        if(e.getEntity() instanceof EnderDragon){

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a subtitle [\"\",{\"text\":\"Der \"},{\"text\":\"Runner \",\"bold\":true,\"color\":\"red\"},{\"text\":\"hat gewonnen!\"}]");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title [\"\",{\"text\":\"EnderDrache \",\"bold\":true,\"color\":\"blue\"},{\"text\":\"ist gestrben!\",\"color\":\"red\"}]");
            Timer.getInstance().setRunning(false);
        }
    }
}
