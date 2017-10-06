/*    */ package mq.xivklott.game;
/*    */ 
/*    */ import mq.xivklott.chest.ChestRefill;
/*    */ import mq.xivklott.main.SkyWars;
/*    */ import mq.xivklott.main.Title;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class GameManager
/*    */ {
/*    */   int task;
/* 13 */   public static int timer = 180;
/*    */   
/*    */   public GameManager()
/*    */   {
/* 17 */     this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable()
/*    */     {
/*    */ 
/*    */       public void run()
/*    */       {
/* 22 */         GameManager.timer -= 1;
/*    */         
/* 24 */         if (GameManager.timer == 0)
/*    */         {
/* 26 */           for (Player pl : Bukkit.getOnlinePlayers()) {
/* 27 */             Title.sendTitle(pl, "§cRefill des Chests", "", 25);
/*    */           }
/* 29 */           new ChestRefill().refillAllChests();
/* 30 */           Bukkit.getScheduler().cancelTask(GameManager.this.task);
/* 31 */           return;
/*    */         }
/*    */         
/*    */       }
/*    */       
/*    */ 
/* 37 */     }, 20L, 20L);
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\game\GameManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */