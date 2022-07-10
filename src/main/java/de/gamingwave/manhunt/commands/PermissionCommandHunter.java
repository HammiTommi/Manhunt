package de.gamingwave.manhunt.commands;

import de.gamingwave.manhunt.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;

public class PermissionCommandHunter implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try{
        sender.sendMessage(Main.prefix + "§aDir wurde erfolgreich die Rolle 'Hunter' gegeben.\nBitte §crejoine§a den Server einmal");


            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() +" permission unset runner");

        } catch (Exception e){
            sender.sendMessage(Main.prefix + "§c§lDas hat nicht geklappt. Wennde dich an den Plugin-Owner!");
        }

        return false;
    }
}
