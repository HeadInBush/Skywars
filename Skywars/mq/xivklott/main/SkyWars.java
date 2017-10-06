/*    */ package mq.xivklott.main;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataOutput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import mq.xivklott.chest.ItemsRandom;
/*    */ import mq.xivklott.events.EventsManager;
/*    */ import mq.xivklott.events.util.Locations;
/*    */ import mq.xivklott.game.GameState;
/*    */ import mq.xivklott.kit.KitContents;
/*    */ import mq.xivklott.kit.KitMenu;
/*    */ import mq.xivklott.kit.Kits;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.FileConfigurationOptions;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ import org.bukkit.plugin.messaging.Messenger;
/*    */ 
/*    */ public class SkyWars extends JavaPlugin
/*    */ {
/* 23 */   public KitContents kitContents = new KitContents();
/* 24 */   public HashMap<Player, Kits> kits = new HashMap();
/*    */   public SqlConnection sql;
/* 26 */   public ArrayList<Player> playersList = new ArrayList();
/* 27 */   ByteArrayDataOutput out = ByteStreams.newDataOutput();
/*    */   public static SkyWars instance;
/*    */   
/*    */   public static SkyWars getInstance() {
/* 31 */     return instance;
/*    */   }
/*    */   
/*    */   public void onEnable()
/*    */   {
/* 36 */     super.onEnable();
/* 37 */     instance = this;
/* 38 */     GameState.setState(GameState.LOBBY);
/* 39 */     new EventsManager(this).registerEvents();
/* 40 */     new Locations();
/* 41 */     new KitMenu();
/* 42 */     new ItemsRandom();
/* 43 */     this.sql = new SqlConnection("jdbc:mysql://", "127.0.0.1 <- Adresse PhpMyAdmin", "BaseDeDonnée", "Identifiant", "MotDePasse");
/* 44 */     this.sql.connection();
/* 45 */     getConfig().options().copyDefaults(true);
/* 46 */     saveDefaultConfig();
/* 47 */     getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
/* 48 */     getServer().dispatchCommand(getServer().getConsoleSender(), "save-off");
/*    */   }
/*    */   
/*    */   public void onDisable()
/*    */   {
/* 53 */     getServer().dispatchCommand(getServer().getConsoleSender(), "save-off");
/* 54 */     this.sql.disconnect();
/*    */   }
/*    */   
/*    */ 
/*    */   public void Lobbytp(Player player)
/*    */   {
/* 60 */     this.out.writeUTF("Connect");
/* 61 */     this.out.writeUTF("lobby");
/* 62 */     player.sendPluginMessage(this, "BungeeCord", this.out.toByteArray());
/*    */   }
/*    */   
/*    */ 
/*    */   public String coloration(String msg)
/*    */   {
/* 68 */     String coloredMsg = "";
/* 69 */     for (int i = 0; i < msg.length(); i++) {
/* 70 */       if (msg.charAt(i) == '&') {
/* 71 */         coloredMsg = coloredMsg + '§';
/*    */       } else
/* 73 */         coloredMsg = coloredMsg + msg.charAt(i);
/*    */     }
/* 75 */     return coloredMsg;
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\main\SkyWars.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */