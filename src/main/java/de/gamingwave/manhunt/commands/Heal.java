package de.gamingwave.manhunt.commands;

import de.gamingwave.manhunt.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("manhunt.heal")){
            player.sendMessage(Main.prefix + "§cDir fehlt die Berechtigung dazu!");
        }else {
            player.setHealth(20);
            player.setFoodLevel(20);
            player.sendMessage(Main.prefix + "§aDu wurdest geheilt!");
        }
        return false;
    }
}
