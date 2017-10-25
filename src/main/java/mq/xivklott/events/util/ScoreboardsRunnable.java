package mq.xivklott.events.util;

import java.util.HashMap;
import java.util.Map.Entry;
import mq.xivklott.events.SkyJoin;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardsRunnable extends BukkitRunnable {
    public void run() {
        for (Map.Entry<Player, CustomScoreboardManager> scoreboard : SkyJoin.sb.entrySet()) {
            CustomScoreboardManager board = (CustomScoreboardManager) scoreboard.getValue();
            board.refresh();
        }
    }
}