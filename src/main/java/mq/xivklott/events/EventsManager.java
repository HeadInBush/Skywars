package mq.xivklott.events;

import mq.xivklott.game.ChatListener;
import mq.xivklott.kit.KitMenu;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.SqlConnection;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager {
    public SkyWars pl;
    private SqlConnection sql;

    public EventsManager(SkyWars skyWars) {
        this.pl = skyWars;
    }

    public EventsManager(SqlConnection sql) {
        this.sql = sql;
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SkyJoin(this.pl), this.pl);
        pm.registerEvents(new PlayerListener(), this.pl);
        pm.registerEvents(new SkyPvP(this.sql), this.pl);
        pm.registerEvents(new KitMenu(), this.pl);
        pm.registerEvents(new ChatListener(), this.pl);
    }
}