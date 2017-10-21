package mq.xivklott.events;

import java.util.ArrayList;
import java.util.HashMap;
import mq.xivklott.events.util.CustomScoreboardManager;
import mq.xivklott.events.util.ScoreboardsRunnable;
import mq.xivklott.game.GameState;
import mq.xivklott.game.SkyWinner;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.SqlConnection;
import mq.xivklott.main.Title;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;

public class SkyJoin implements Listener {
    int timer = 15;
    
    int task;

    public static HashMap<Player, CustomScoreboardManager> sb = new HashMap();
    private SkyWars main;
    private SqlConnection sql;

    public SkyJoin(SkyWars main) {
        this.main = main;
    }

    public SkyJoin(SqlConnection sql) {
        this.sql = sql;
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setMaxHealth(40.0D);
        p.setHealth(40.0D);
        p.setFoodLevel(20);
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
        p.getInventory().clear();
        p.teleport(((World) Bukkit.getWorlds().get(0)).getSpawnLocation());

        if (!GameState.isState(GameState.LOBBY)) {
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage("Vous êtes spectateur.");
            return;
        }

        if (!SkyWars.getInstance().playersList.contains(p)) {
            p.setGameMode(GameMode.SURVIVAL);
            SkyWars.getInstance().playersList.add(p);
            e.setJoinMessage(
                    "§7" + p.getName() + " §ea rejoint la partie ! §7[" + this.main.playersList.size() + "/8]");

            Title.sendTitle(p, "§eSkyWars", "§cBienvenue", 40);

            new ScoreboardsRunnable().runTaskTimer(SkyWars.getInstance(), 0L, 20L);
            CustomScoreboardManager scoreboard = new CustomScoreboardManager(p);
            scoreboard.sendLine();
            scoreboard.set();

            if (SkyWars.getInstance().playersList.size() == 6) {
                this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable() {

                    public void run() {
                        SkyJoin.this.timer -= 1;

                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setLevel(SkyJoin.this.timer);
                        }

                        if ((SkyJoin.this.timer == 15) || (SkyJoin.this.timer == 10) || (SkyJoin.this.timer == 5)
                                || (SkyJoin.this.timer == 4) || (SkyJoin.this.timer == 3) || (SkyJoin.this.timer == 2)
                                || (SkyJoin.this.timer == 1)) {
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                Title.sendTitle(pl, "§c" + SkyJoin.this.timer + "s", "§ePréparez vous", 20);
                            }
                        }

                        if (SkyJoin.this.timer == 0) {
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                Title.sendTitle(pl, "§cTéléportation... !", " ", 20);
                            }
                            Bukkit.getScheduler().cancelTask(SkyJoin.this.task);
                            GameState.setState(GameState.PREGAME);
                            mq.xivklott.events.util.Locations.teleportPlayers();
                            new mq.xivklott.game.PreGameManager();
                        }

                    }

                }, 20L, 20L);
            }
        }
    }

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        if (SkyWars.getInstance().playersList.contains(p)) {
            SkyWars.getInstance().playersList.remove(p);
        }

        new SkyWinner(this.sql).check();
    }
}
