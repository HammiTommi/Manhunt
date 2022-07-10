package de.gamingwave.manhunt.commands;

import de.gamingwave.manhunt.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("§7--------------------\n\n§7>> §cServerreset §7<< \n\n§rWorldreset durch §4§l" + sender.getName() +"§r\nDer Server starten nun §6mit einer neuen Map §cneu§r!\n\n§7--------------------"));
        Main.getInstance().getConfig().set("isReset", true);
        Main.getInstance().saveConfig();
        Bukkit.spigot().restart();

        return false;
    }
}
