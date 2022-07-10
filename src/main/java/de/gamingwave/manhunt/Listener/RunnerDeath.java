package de.gamingwave.manhunt.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import de.gamingwave.manhunt.main.Main;
import de.gamingwave.manhunt.timer.Timer;
import org.spigotmc.SpigotCommand;

public class RunnerDeath implements Listener {

    @EventHandler
    public void OnRunnerDeath(PlayerDeathEvent event) {
        if (event.getEntity().hasPermission("runner")) {


            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title [\"\",{\"text\":\"Runner \",\"bold\":true,\"color\":\"blue\"},{\"text\":\"ist gestorben!\",\"color\":\"red\"}]");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a subtitle [\"\",{\"text\":\"Die \"},{\"text\":\"Hunter \",\"bold\":true,\"color\":\"red\"},{\"text\":\"haben gewonnen!\"}]");
            Timer.getInstance().setRunning(false);
        }


    }
}
