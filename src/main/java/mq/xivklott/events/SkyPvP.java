package mq.xivklott.events;

import java.util.ArrayList;
import mq.xivklott.game.SkyWinner;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.SqlConnection;
import mq.xivklott.main.Title;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class SkyPvP implements org.bukkit.event.Listener {
    
    private SqlConnection sql;

    public SkyPvP(SqlConnection sql) {
        this.sql = sql;
    }

    @org.bukkit.event.EventHandler
    public void death(PlayerDeathEvent e) {
        final Player p = e.getEntity();
        e.setDeathMessage("§7" + p.getName() + "§e est mort !");
        p.setGameMode(GameMode.SPECTATOR);
        SkyWars.getInstance().playersList.remove(p);
        new SkyWinner(this.sql).check();
        org.bukkit.Bukkit.getScheduler().runTaskLater(SkyWars.getInstance(), new Runnable() {

            public void run() {
                PacketPlayInClientCommand cmd = new PacketPlayInClientCommand(
                        net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);
                ((CraftPlayer) p).getHandle().playerConnection.a(cmd);
                Title.sendTitle(p, "§cGameOver :o", "", 25);
            }

        }, 5L);
    }
}