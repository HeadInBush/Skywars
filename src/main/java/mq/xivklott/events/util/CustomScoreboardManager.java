package mq.xivklott.events.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import mq.xivklott.events.SkyJoin;
import mq.xivklott.game.GameManager;
import mq.xivklott.main.SkyWars;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class CustomScoreboardManager implements ScoreboardManager {
    public Player player;
    public Scoreboard scoreboard;
    public Objective objective;
    private String name;

    public CustomScoreboardManager(Player p) {
        this.scoreboard = org.bukkit.Bukkit.getScoreboardManager().getNewScoreboard();
        this.player = p;

        if (SkyJoin.sb.containsKey(p))
            return;
        SkyJoin.sb.put(p, this);

        this.name = ("sb." + new Random().nextInt(999999));

        this.objective = this.scoreboard.registerNewObjective(this.name, "dummy");
        this.objective = this.scoreboard.getObjective(this.name);
        this.objective.setDisplayName("§b§lSKYWARS         ");
        this.objective.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);
    }

    public void refresh() {
        for (String ligne : this.scoreboard.getEntries()) {
            if (ligne.contains("§9» §bRefill des Chests")) {
                this.scoreboard.resetScores(ligne);
                String lastligne = ligne.split(":")[0];
                String newligne = lastligne + ":" + " " + GameManager.timer + "s";
                String twoligne = lastligne + ":" + " §cEnd§e/§cGoPvP";

                if (GameManager.timer == 0) {
                    this.objective.getScore(twoligne).setScore(2);
                } else {
                    this.objective.getScore(newligne).setScore(2);
                }
            }
            if (ligne.contains("§4» §cJoueurs :")) {
                this.scoreboard.resetScores(ligne);
                String lastligne = ligne.split(":")[0];
                String newligne = lastligne + ":" + " " + SkyWars.getInstance().playersList.size() + "§e/§c8";

                this.objective.getScore(newligne).setScore(4);
            }
        }
    }

    public void sendLine() {
        this.objective.getScore(ChatColor.WHITE + "-" + ChatColor.GRAY + "§m---------------" + ChatColor.DARK_GRAY + "-").setScore(8);
        this.objective.getScore("§8 ").setScore(7);
        this.objective.getScore("§e» §6Map : " + ChatColor.YELLOW + SkyWars.getInstance().getConfig().getString(SkyWars.getInstance().coloration("map"))).setScore(6);
        this.objective.getScore("§1 ").setScore(5);
        this.objective.getScore("§4» §cJoueurs :").setScore(4);
        this.objective.getScore("§6 ").setScore(3);
        this.objective.getScore("§9» §bRefill des Chests : ").setScore(2);
        this.objective.getScore("§5 ").setScore(1);
        this.objective.getScore(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + "§m---------------" + ChatColor.WHITE + "-").setScore(0);
    }

    public Scoreboard getMainScoreboard() {
        return this.scoreboard;
    }

    public Scoreboard getNewScoreboard() {
        return null;
    }

    public void set() {
        this.player.setScoreboard(getMainScoreboard());
    }
}