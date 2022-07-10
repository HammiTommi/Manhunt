package de.gamingwave.manhunt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;

public class PermissionCommandRunner implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try{
        sender.sendMessage("§aDir wurde erfolgreich die Rolle 'Runner' gegeben.\nBitte §crejoine§a den Server einmal");


            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " permission set runner true");
        } catch (Exception e){
            sender.sendMessage("§c§lDas hat nicht geklappt. Wennde dich an den Plugin-Owner!");
        }

        return false;
    }
}
