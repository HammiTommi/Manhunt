package de.gamingwave.manhunt.commands;

import de.gamingwave.manhunt.main.Main;
import de.gamingwave.manhunt.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pause implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Timer timer = Timer.getInstance();


        if (!timer.isRunning()) {
            sender.sendMessage(Main.prefix + ChatColor.RED + "Der Timer läuft nicht.");

            ;
        }

        timer.setRunning(false);

        sender.sendMessage(Main.prefix + ChatColor.GREEN + "Der Timer wurde pausiert.");



        for (Player player : Bukkit.getOnlinePlayers()) {
            int volume = 10;
            int pitch = 1;
            Bukkit.getWorld("world").playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, volume, pitch);

            return false;
        }




        return false;
    }
}
