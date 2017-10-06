/*     */ package mq.xivklott.events;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import mq.xivklott.events.util.CustomScoreboardManager;
/*     */ import mq.xivklott.events.util.ScoreboardsRunnable;
/*     */ import mq.xivklott.game.GameState;
/*     */ import mq.xivklott.game.SkyWinner;
/*     */ import mq.xivklott.main.SkyWars;
/*     */ import mq.xivklott.main.SqlConnection;
/*     */ import mq.xivklott.main.Title;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class SkyJoin implements Listener
/*     */ {
/*  25 */   int timer = 15;
/*     */   int task;
/*  27 */   public static HashMap<Player, CustomScoreboardManager> sb = new HashMap();
/*     */   private SkyWars main;
/*     */   private SqlConnection sql;
/*     */   
/*     */   public SkyJoin(SkyWars main) {
/*  32 */     this.main = main;
/*     */   }
/*     */   
/*     */   public SkyJoin(SqlConnection sql) {
/*  36 */     this.sql = sql;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void join(PlayerJoinEvent e)
/*     */   {
/*  42 */     Player p = e.getPlayer();
/*  43 */     p.setMaxHealth(40.0D);
/*  44 */     p.setHealth(40.0D);
/*  45 */     p.setFoodLevel(20);
/*  46 */     p.getInventory().setHelmet(null);
/*  47 */     p.getInventory().setChestplate(null);
/*  48 */     p.getInventory().setLeggings(null);
/*  49 */     p.getInventory().setBoots(null);
/*  50 */     p.getInventory().clear();
/*  51 */     p.teleport(((World)Bukkit.getWorlds().get(0)).getSpawnLocation());
/*  52 */     if (!GameState.isState(GameState.LOBBY)) {
/*  53 */       p.setGameMode(GameMode.SPECTATOR);
/*  54 */       p.sendMessage("Vous êtes spectateur.");
/*  55 */       return;
/*     */     }
/*     */     
/*  58 */     if (!SkyWars.getInstance().playersList.contains(p)) {
/*  59 */       p.setGameMode(GameMode.SURVIVAL);
/*  60 */       SkyWars.getInstance().playersList.add(p);
/*  61 */       e.setJoinMessage("§7" + p.getName() + " §ea rejoint la partie ! §7[" + this.main.playersList.size() + "/8]");
/*     */       
/*  63 */       Title.sendTitle(p, "§eSkyWars", "§cBienvenue", 40);
/*     */       
/*  65 */       new ScoreboardsRunnable().runTaskTimer(SkyWars.getInstance(), 0L, 20L);
/*  66 */       CustomScoreboardManager scoreboard = new CustomScoreboardManager(p);
/*  67 */       scoreboard.sendLine();
/*  68 */       scoreboard.set();
/*     */       
/*  70 */       if (SkyWars.getInstance().playersList.size() == 6)
/*     */       {
/*  72 */         this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable()
/*     */         {
/*     */ 
/*     */           public void run()
/*     */           {
/*  77 */             SkyJoin.this.timer -= 1;
/*     */             
/*  79 */             for (Player pl : Bukkit.getOnlinePlayers()) {
/*  80 */               pl.setLevel(SkyJoin.this.timer);
/*     */             }
/*     */             
/*  83 */             if ((SkyJoin.this.timer == 15) || (SkyJoin.this.timer == 10) || (SkyJoin.this.timer == 5) || (SkyJoin.this.timer == 4) || (SkyJoin.this.timer == 3) || (SkyJoin.this.timer == 2) || (SkyJoin.this.timer == 1)) {
/*  84 */               for (Player pl : Bukkit.getOnlinePlayers()) {
/*  85 */                 Title.sendTitle(pl, "§c" + SkyJoin.this.timer + "s", "§ePréparez vous", 20);
/*     */               }
/*     */             }
/*     */             
/*  89 */             if (SkyJoin.this.timer == 0) {
/*  90 */               for (Player pl : Bukkit.getOnlinePlayers()) {
/*  91 */                 Title.sendTitle(pl, "§cTéléportation... !", " ", 20);
/*     */               }
/*  93 */               Bukkit.getScheduler().cancelTask(SkyJoin.this.task);
/*  94 */               GameState.setState(GameState.PREGAME);
/*  95 */               mq.xivklott.events.util.Locations.teleportPlayers();
/*  96 */               new mq.xivklott.game.PreGameManager();
/*     */             }
/*     */             
/*     */           }
/*     */           
/* 101 */         }, 20L, 20L);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void quit(PlayerQuitEvent e)
/*     */   {
/* 111 */     Player p = e.getPlayer();
/* 112 */     e.setQuitMessage(null);
/* 113 */     if (SkyWars.getInstance().playersList.contains(p)) {
/* 114 */       SkyWars.getInstance().playersList.remove(p);
/*     */     }
/*     */     
/* 117 */     new SkyWinner(this.sql).check();
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\events\SkyJoin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */