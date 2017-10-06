/*    */ package mq.xivklott.events.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Random;
/*    */ import mq.xivklott.events.SkyJoin;
/*    */ import mq.xivklott.game.GameManager;
/*    */ import mq.xivklott.main.SkyWars;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scoreboard.Objective;
/*    */ import org.bukkit.scoreboard.Score;
/*    */ import org.bukkit.scoreboard.Scoreboard;
/*    */ import org.bukkit.scoreboard.ScoreboardManager;
/*    */ 
/*    */ public class CustomScoreboardManager implements ScoreboardManager
/*    */ {
/*    */   public Player player;
/*    */   public Scoreboard scoreboard;
/*    */   public Objective objective;
/*    */   private String name;
/*    */   
/*    */   public CustomScoreboardManager(Player p)
/*    */   {
/* 26 */     this.scoreboard = org.bukkit.Bukkit.getScoreboardManager().getNewScoreboard();
/* 27 */     this.player = p;
/*    */     
/* 29 */     if (SkyJoin.sb.containsKey(p)) return;
/* 30 */     SkyJoin.sb.put(p, this);
/*    */     
/* 32 */     this.name = ("sb." + new Random().nextInt(999999));
/*    */     
/* 34 */     this.objective = this.scoreboard.registerNewObjective(this.name, "dummy");
/* 35 */     this.objective = this.scoreboard.getObjective(this.name);
/* 36 */     this.objective.setDisplayName("§b§lSKYWARS         ");
/* 37 */     this.objective.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);
/*    */   }
/*    */   
/*    */   public void refresh()
/*    */   {
/* 42 */     for (String ligne : this.scoreboard.getEntries()) {
/* 43 */       if (ligne.contains("§9» §bRefill des Chests"))
/*    */       {
/* 45 */         this.scoreboard.resetScores(ligne);
/* 46 */         String lastligne = ligne.split(":")[0];
/* 47 */         String newligne = lastligne + ":" + " " + GameManager.timer + "s";
/* 48 */         String twoligne = lastligne + ":" + " §cEnd§e/§cGoPvP";
/*    */         
/* 50 */         if (GameManager.timer == 0) {
/* 51 */           this.objective.getScore(twoligne).setScore(2);
/*    */         } else {
/* 53 */           this.objective.getScore(newligne).setScore(2);
/*    */         }
/*    */       }
/* 56 */       if (ligne.contains("§4» §cJoueurs :"))
/*    */       {
/* 58 */         this.scoreboard.resetScores(ligne);
/* 59 */         String lastligne = ligne.split(":")[0];
/* 60 */         String newligne = lastligne + ":" + " " + SkyWars.getInstance().playersList.size() + "§e/§c8";
/*    */         
/* 62 */         this.objective.getScore(newligne).setScore(4);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void sendLine() {
/* 68 */     this.objective.getScore(ChatColor.WHITE + "-" + ChatColor.GRAY + "§m---------------" + ChatColor.DARK_GRAY + "-").setScore(8);
/* 69 */     this.objective.getScore("§8 ").setScore(7);
/* 70 */     this.objective.getScore("§e» §6Map : " + ChatColor.YELLOW + SkyWars.getInstance().getConfig().getString(SkyWars.getInstance().coloration("map"))).setScore(6);
/* 71 */     this.objective.getScore("§1 ").setScore(5);
/* 72 */     this.objective.getScore("§4» §cJoueurs :").setScore(4);
/* 73 */     this.objective.getScore("§6 ").setScore(3);
/* 74 */     this.objective.getScore("§9» §bRefill des Chests : ").setScore(2);
/* 75 */     this.objective.getScore("§5 ").setScore(1);
/* 76 */     this.objective.getScore(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + "§m---------------" + ChatColor.WHITE + "-").setScore(0);
/*    */   }
/*    */   
/*    */   public Scoreboard getMainScoreboard()
/*    */   {
/* 81 */     return this.scoreboard;
/*    */   }
/*    */   
/*    */   public Scoreboard getNewScoreboard()
/*    */   {
/* 86 */     return null;
/*    */   }
/*    */   
/* 89 */   public void set() { this.player.setScoreboard(getMainScoreboard()); }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\events\util\CustomScoreboardManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */