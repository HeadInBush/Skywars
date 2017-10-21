package mq.xivklott.game;

import mq.xivklott.main.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SkyWinner {
    mq.xivklott.main.SqlConnection sql;
    SkyWars main;

    public SkyWinner(mq.xivklott.main.SqlConnection sql) {
        this.sql = sql;
    }

    public SkyWinner(SkyWars main) {
        this.main = main;
    }

    public void check() {
        if ((SkyWars.getInstance().playersList.size() == 0) && (GameState.isState(GameState.GAME))) {
            GameState.setState(GameState.FINISH);
            Bukkit.spigot().restart();
        }

        if (SkyWars.getInstance().playersList.size() == 1) {
            GameState.setState(GameState.FINISH);

            Player p = ((Player) SkyWars.getInstance().playersList.get(0)).getPlayer();
            Bukkit.broadcastMessage(SkyWars.getInstance().coloration("&b&lGrand gagnant &7: &1&k!&b&k!&1&k!&f&l&f&l "
                    + ((Player) SkyWars.getInstance().playersList.get(0)).getPlayer().getName() + "&1&k !&b&k!&1&k!"));

            Bukkit.broadcastMessage("§aRemise des prix ! Téléportation au Hub dans quelques secondes..");

            for (Player player : Bukkit.getOnlinePlayers()) {

                this.sql.addMoney(player, 25);
                player.sendMessage("§eTu as gagné 25coins en terminant cette partie !");

                this.sql.addMoney(p, 75);
                player.sendMessage("§eTu as gagné 100 coins en remportant cette partie ! Bien joué !");

                Bukkit.broadcastMessage("§7Téléportation au lobby en cours...");
                this.main.Lobbytp(player);
            }

            Bukkit.spigot().restart();
        }
    }
}