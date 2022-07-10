package de.gamingwave.manhunt.Listener;

import de.gamingwave.manhunt.scoreboard.ScoreboardCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import de.gamingwave.manhunt.main.Main;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.security.Permission;
import java.util.Random;

public class Listeners implements Listener{


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        Player player = Bukkit.getOnlinePlayers().stream().skip((int) (Bukkit.getOnlinePlayers().size() * Math.random())).findFirst().orElse(null);



        e.setJoinMessage(Main.prefix + "§6" + p.getDisplayName() + "§e hat §4§lGaming§9§lWave §r§ebetreten");

        e.getPlayer().setScoreboard(ScoreboardCreator.getBaseScoreboard(e.getPlayer()));

        PermissionAttachment attachment = player.addAttachment((Plugin) this);
        attachment.setPermission("hunter", true);

    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskLater(Main.getInstance(), 1);
    }

    @EventHandler

    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        e.setQuitMessage(Main.prefix  + ChatColor.GOLD +  p.getDisplayName() + "§e hat den Server " + ChatColor.RED + "verlassen");
    }

}
