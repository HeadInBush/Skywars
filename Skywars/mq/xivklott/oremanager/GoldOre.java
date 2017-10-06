/*    */ package mq.xivklott.oremanager;
/*    */ 
/*    */ import java.util.Random;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class GoldOre implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e)
/*    */   {
/* 17 */     Block block = e.getBlock();
/* 18 */     org.bukkit.Location bLoc = block.getLocation();
/*    */     
/* 20 */     if (block.getType() == Material.GOLD_ORE) {
/* 21 */       e.setCancelled(true);
/* 22 */       block.setType(Material.AIR);
/* 23 */       int r = new Random().nextInt(4);
/*    */       
/* 25 */       switch (r) {
/*    */       case 0: 
/* 27 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.ARROW));
/* 28 */         break;
/*    */       case 1: 
/* 30 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.APPLE));
/* 31 */         break;
/*    */       case 2: 
/* 33 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_SWORD));
/* 34 */         break;
/*    */       case 3: 
/* 36 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.BOW));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\oremanager\GoldOre.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */