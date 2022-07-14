package de.gamingwave.manhunt.timer;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import de.gamingwave.manhunt.main.Main;

public class Timer {

    public static Timer instance;


    private boolean running; // true or false
    private int time;
    int seconds = 0;
    int seconds2 = 0;
    int minutes = 0;
    int minutes2 = 0;
    int hours = 0;
    int hours2 = 0;


    public Timer() {
        instance = this;


        this.running = false;


        run();
    }


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setTime(int hours, int hours2, int minutes, int minutes2, int seconds, int seconds2) {

        this.minutes = minutes;
        this.hours = hours;
        this.seconds = seconds;
        this.minutes2 = minutes2;
        this.hours2 = hours2;
        this.seconds2 = seconds2;
    }

    public int getSeconds2() {
        return seconds2;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes2() {
        return minutes2;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours2() {
        return hours2;
    }

    public int getHours() {
        return hours;
    }

    public void setSeconds2(int seconds2) {


        this.seconds2 = seconds2;
    }

    public void setSeconds(int seconds) {


        this.seconds = seconds;
    }

    public void setMinutes2(int minutes2) {


        this.minutes2 = minutes2;

    }

    public void setMinutes(int minutes) {


        this.minutes = minutes;

    }

    public void setHours2(int hours2) {


        this.hours2 = hours2;

    }

    public void setHours(int hours) {


        this.hours = hours;

    }

    public int getTime() {
        return seconds2;
    }


    public void sendActionBar() {
        for (Player player : Bukkit.getOnlinePlayers()) {

            if (!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED +
                        "Timer ist pausiert"));
                continue;
            }

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Time: " + ChatColor.GOLD.toString() +
                    ChatColor.BOLD + hours + hours2 + ":" + minutes + minutes2 + ":" + seconds + seconds2));
        }
    }


    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if (!isRunning()) {
                    return;
                }


                setSeconds2(getSeconds2() + 1);


                if (seconds2 == 10) {

                    seconds2 = 0;

                    setSeconds(getSeconds() + 1);
                }

                if (seconds == 6) {
                    seconds = 0;

                    setMinutes2(getMinutes2() + 1);
                }

                if (minutes2 == 10) {
                    minutes2 = 0;

                    setMinutes(getMinutes() + 1);
                }

                if (minutes == 6) {
                    minutes = 0;

                    setHours2(getHours2() + 1);
                }

                if (hours2 == 10) {
                    hours2 = 0;

                    setHours(getHours() + 1);
                }
                return;
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }

    public static Timer getInstance() {
        return instance;
    }
}
