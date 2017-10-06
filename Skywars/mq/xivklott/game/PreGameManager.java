/*    */ package mq.xivklott.game;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import mq.xivklott.chest.ChestRefill;
/*    */ import mq.xivklott.kit.Kits;
/*    */ import mq.xivklott.main.SkyWars;
/*    */ import mq.xivklott.main.Title;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class PreGameManager
/*    */ {
/* 18 */   static int timer = 5;
/*    */   int task;
/*    */   
/*    */   public PreGameManager()
/*    */   {
/* 23 */     this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable()
/*    */     {
/*    */ 
/*    */       public void run()
/*    */       {
/* 28 */         PreGameManager.timer -= 1;
/*    */         
/* 30 */         if ((PreGameManager.timer == 5) || (PreGameManager.timer == 4) || (PreGameManager.timer == 3) || (PreGameManager.timer == 2) || (PreGameManager.timer == 1)) {
/* 31 */           for (Player pl : Bukkit.getOnlinePlayers())
/*    */           {
/* 33 */             Title.sendTitle(pl, "§c" + PreGameManager.timer + "s", "§ePréparez vous", 20);
/*    */           }
/*    */         }
/*    */         
/* 37 */         for (Player p : Bukkit.getOnlinePlayers()) {
/* 38 */           p.setLevel(PreGameManager.timer);
/*    */         }
/*    */         
/* 41 */         if (PreGameManager.timer == 0) {
/* 42 */           GameState.setState(GameState.GAME);
/* 43 */           Iterator localIterator2; for (??? = Bukkit.getOnlinePlayers().iterator(); ???.hasNext(); 
/*    */               
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 50 */               localIterator2.hasNext())
/*    */           {
/* 43 */             Player pl = (Player)???.next();
/* 44 */             Title.sendTitle(pl, "§cLancement du Jeu !", "§eBonne Chance !", 20);
/*    */             
/*    */ 
/* 47 */             Kits playerKit = (Kits)SkyWars.getInstance().kits.get(pl);
/* 48 */             ArrayList<ItemStack> itemsdukit = playerKit.getItems();
/* 49 */             pl.getInventory().clear();
/* 50 */             localIterator2 = itemsdukit.iterator(); continue;ItemStack item = (ItemStack)localIterator2.next();
/* 51 */             pl.getInventory().addItem(new ItemStack[] { item });
/*    */           }
/*    */           
/*    */ 
/*    */ 
/* 56 */           Bukkit.getScheduler().cancelTask(PreGameManager.this.task);
/*    */           
/* 58 */           mq.xivklott.events.util.CagesUtil.destroyAllCages();
/* 59 */           new ChestRefill().refillAllChests();
/* 60 */           new GameManager();
/*    */         }
/*    */         
/*    */       }
/*    */       
/* 65 */     }, 20L, 20L);
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\game\PreGameManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */