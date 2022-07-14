package de.gamingwave.manhunt.commands;

import de.gamingwave.manhunt.main.Main;
import de.gamingwave.manhunt.timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.gamingwave.manhunt.Listener.Listeners;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(Main.prefix + "§cDu musst " + ChatColor.BLUE + "yes/no " + "§ceingeben");
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "yes": {



                if (player.hasPermission("manhunt.fly")) {
                    player.setAllowFlight(true);
                    player.sendMessage(Main.prefix + "§aDu kannst nun fliegen!");
                }
                break;
            }

                case "no": {

                    if (player.hasPermission("manhunt.fly")) {
                        player.setAllowFlight(false);
                        player.sendMessage(Main.prefix + "§aDu kannst nun §cnicht mehr §afliegen!");
                    }

                    break;
                }

    }
    return false;
}}
