package mq.xivklott.main;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.util.ArrayList;
import java.util.HashMap;
import mq.xivklott.chest.ItemsRandom;
import mq.xivklott.events.EventsManager;
import mq.xivklott.events.util.Locations;
import mq.xivklott.game.GameState;
import mq.xivklott.kit.KitContents;
import mq.xivklott.kit.KitMenu;
import mq.xivklott.kit.Kits;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;

public class SkyWars extends JavaPlugin {
    public KitContents kitContents = new KitContents();
    public HashMap<Player, Kits> kits = new HashMap();
    public SqlConnection sql;
    public ArrayList<Player> playersList = new ArrayList();
    ByteArrayDataOutput out = ByteStreams.newDataOutput();
    public static SkyWars instance;

    public static SkyWars getInstance() {
        return instance;
    }

    public void onEnable() {
        super.onEnable();
        instance = this;
        GameState.setState(GameState.LOBBY);
        new EventsManager(this).registerEvents();
        new Locations();
        new KitMenu();
        new ItemsRandom();
        this.sql = new SqlConnection("jdbc:mysql://", "127.0.0.1 <- Adresse PhpMyAdmin", "BaseDeDonnée", "Identifiant", "MotDePasse");
        this.sql.connection();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().dispatchCommand(getServer().getConsoleSender(), "save-off");
    }

    public void onDisable() {
        getServer().dispatchCommand(getServer().getConsoleSender(), "save-off");
        this.sql.disconnect();
    }

    public void Lobbytp(Player player) {
        this.out.writeUTF("Connect");
        this.out.writeUTF("lobby");
        player.sendPluginMessage(this, "BungeeCord", this.out.toByteArray());
    }

    public String coloration(String msg) {
        String coloredMsg = "";
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '&') {
                coloredMsg = coloredMsg + '§';
            } else
                coloredMsg = coloredMsg + msg.charAt(i);
        }
        return coloredMsg;
    }
}