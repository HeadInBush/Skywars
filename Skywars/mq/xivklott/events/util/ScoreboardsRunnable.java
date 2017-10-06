/*    */ package mq.xivklott.events.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mq.xivklott.events.SkyJoin;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class ScoreboardsRunnable
/*    */   extends BukkitRunnable
/*    */ {
/*    */   public void run()
/*    */   {
/* 14 */     for (Map.Entry<Player, CustomScoreboardManager> scoreboard : SkyJoin.sb.entrySet()) {
/* 15 */       CustomScoreboardManager board = (CustomScoreboardManager)scoreboard.getValue();
/* 16 */       board.refresh();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\events\util\ScoreboardsRunnable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */