package de.gamingwave.manhunt.scoreboard;



import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardCreator implements Listener {

    public static Scoreboard getBaseScoreboard(Player player) {

        Scoreboard s =  Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("main", "main","§aManhunt");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("§c§oGaming§9§oWave §6§oServernetzwerk").setScore(0);
        objective.getScore("§d").setScore(1);
        objective.getScore("§dDeine Rolle:").setScore(5);
        objective.getScore(player.hasPermission("runner") ? "§9§lRunner" : "§4§lHunter").setScore(4);
        objective.getScore("§c").setScore(6);





        //Manhunt                           6
        //-                                 5
        //Deine Rolle (Hunter/Runner)       4
        //-                                 3
        //Time:                             2
        //-                                 1
        //GamingWave Servernetzwerk         0
        return s;




    }



}
