/*    */ package mq.xivklott.chest;
/*    */ 
/*    */ import java.util.Random;
/*    */ import org.bukkit.Chunk;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.BlockState;
/*    */ import org.bukkit.block.Chest;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class ChestRefill
/*    */ {
/*    */   public void refillAllChests()
/*    */   {
/*    */     Chunk[] arrayOfChunk;
/* 16 */     int j = (arrayOfChunk = org.bukkit.Bukkit.getWorld("world").getLoadedChunks()).length; for (int i = 0; i < j; i++) { Chunk chunk = arrayOfChunk[i];
/* 17 */       BlockState[] arrayOfBlockState; int m = (arrayOfBlockState = chunk.getTileEntities()).length; for (int k = 0; k < m; k++) { BlockState bs = arrayOfBlockState[k];
/* 18 */         if ((bs instanceof Chest))
/*    */         {
/* 20 */           Chest coffre = (Chest)bs.getBlock().getState();
/* 21 */           Inventory inv = coffre.getInventory();
/* 22 */           inv.clear();
/*    */           
/* 24 */           for (int i = 0; i < 5; i++) {
/* 25 */             ItemStack randomItem = ItemsRandom.getRandomItem();
/* 26 */             Random r = new Random();
/* 27 */             int limit = inv.getSize() - 1;
/* 28 */             int randomSlot = r.nextInt(limit);
/*    */             
/* 30 */             inv.setItem(randomSlot, randomItem);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\chest\ChestRefill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */