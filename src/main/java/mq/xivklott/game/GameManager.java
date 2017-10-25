package mq.xivklott.game;

import mq.xivklott.chest.ChestRefill;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class GameManager {
    int task;
    public static int timer = 180;

    public GameManager() {
        this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable() {

            public void run() {
                GameManager.timer -= 1;

                if (GameManager.timer == 0) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        Title.sendTitle(pl, "§cRefill des Chests", "", 25);
                    }
                    new ChestRefill().refillAllChests();
                    Bukkit.getScheduler().cancelTask(GameManager.this.task);
                    return;
                }

            }

        }, 20L, 20L);
    }
}