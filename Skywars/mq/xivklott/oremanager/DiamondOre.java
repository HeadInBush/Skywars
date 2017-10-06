/*    */ package mq.xivklott.oremanager;
/*    */ 
/*    */ import java.util.Random;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class DiamondOre
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e)
/*    */   {
/* 19 */     Block block = e.getBlock();
/* 20 */     Location bLoc = block.getLocation();
/*    */     
/* 22 */     if (block.getType() == Material.DIAMOND_ORE) {
/* 23 */       e.setCancelled(true);
/* 24 */       block.setType(Material.AIR);
/* 25 */       int r = new Random().nextInt(16);
/*    */       
/* 27 */       switch (r) {
/*    */       case 0: 
/* 29 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_HELMET));
/* 30 */         break;
/*    */       case 1: 
/* 32 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_CHESTPLATE));
/* 33 */         break;
/*    */       case 2: 
/* 35 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_LEGGINGS));
/* 36 */         break;
/*    */       case 3: 
/* 38 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_BOOTS));
/* 39 */         break;
/*    */       case 4: 
/* 41 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_SWORD));
/* 42 */         break;
/*    */       case 5: 
/* 44 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_BLOCK, 5));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\oremanager\DiamondOre.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */