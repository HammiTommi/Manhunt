package de.gamingwave.manhunt.main;


import de.gamingwave.manhunt.Listener.EnderDragonDeath;
import de.gamingwave.manhunt.Listener.Listeners;
import de.gamingwave.manhunt.Listener.RunnerDeath;
import de.gamingwave.manhunt.commands.*;
import de.gamingwave.manhunt.scoreboard.ScoreboardCreator;
import de.gamingwave.manhunt.timer.Timer;
import de.gamingwave.manhunt.whentimerisstopped.NoBlocks;
import de.gamingwave.manhunt.whentimerisstopped.NoDamage;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public class Main extends JavaPlugin {



    private static Main main;



    private static Main instance;
    public Timer timer;



    public static String prefix = " §6[§cManhunt] ";

    @Override
    public void onLoad(){
        instance = this;
        saveConfig();


        if (!getConfig().contains("isReset")){
            getConfig().set("isReset", false);
            saveConfig();
            return;
        }
        if (getConfig().getBoolean("isReset")){


            try {
                File world = new File(Bukkit.getWorldContainer(), "world");
                File nether = new File(Bukkit.getWorldContainer(), "world_nether");
                File end = new File(Bukkit.getWorldContainer(), "world_the_end");
            FileUtils.deleteDirectory(world);
            FileUtils.deleteDirectory(nether);
            FileUtils.deleteDirectory(end);

            /////////////////////////////////////////////////////////
            world.mkdirs();
            nether.mkdirs();
            end.mkdirs();

            new File(world,"data").mkdirs();
            new File(world,"datapacks").mkdirs();
            new File(world,"playerdata").mkdirs();
            new File(world,"poi").mkdirs();
            new File(world,"region").mkdirs();

            new File(nether,"data").mkdirs();
            new File(nether,"datapacks").mkdirs();
            new File(nether,"playerdata").mkdirs();
            new File(nether,"poi").mkdirs();
            new File(nether,"region").mkdirs();

            new File(end,"data").mkdirs();
            new File(end,"datapacks").mkdirs();
            new File(end,"playerdata").mkdirs();
            new File(end,"poi").mkdirs();
            new File(end,"region").mkdirs();
            } catch (IOException e) {
                e.printStackTrace();
            }

            getConfig().set("isReset", false);
            saveConfig();
        }

    }

    public void onEnable() {
        main = this;

        Bukkit.getPluginCommand("timer").setExecutor(new TimerCommand());
        Bukkit.getPluginCommand("reset").setExecutor(new ResetCommand());
        Bukkit.getPluginCommand("hunter").setExecutor(new PermissionCommandHunter());
        Bukkit.getPluginCommand("runner").setExecutor(new PermissionCommandRunner());
        Bukkit.getPluginCommand("start").setExecutor(new Start());
        Bukkit.getPluginCommand("pause").setExecutor(new Pause());

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule sendCommandFeedback false");



        Bukkit.getConsoleSender().sendMessage(prefix + "§aManhunt wird geladen...");
        timer = new Timer();


        try {
            register();
        }catch(Exception e1) {
            Bukkit.getConsoleSender().sendMessage(prefix + "§cManhunt hat einen Fehler!");


            return;
        }

        Bukkit.getConsoleSender().sendMessage(prefix + "§2Manhunt wurde erfolgreich geladen!");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§aManhunt wurde gestoppt");
    }
    public void register() {
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        Bukkit.getPluginManager().registerEvents(new ScoreboardCreator(), this);
        Bukkit.getPluginManager().registerEvents(new EnderDragonDeath(), this);
        Bukkit.getPluginManager().registerEvents( new RunnerDeath(), this );
        Bukkit.getPluginManager().registerEvents(new NoDamage(), this);
        Bukkit.getPluginManager().registerEvents(new NoBlocks(), this);


    }

    public static Main getInstance(){
        return instance;
    }

    public static Main getMain() {
        return main;
    }
    public Timer getTimer() {
        return timer;
    }






}

