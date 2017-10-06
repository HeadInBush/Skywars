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
/*    */ public class EmeraldOre
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e)
/*    */   {
/* 19 */     Block block = e.getBlock();
/* 20 */     Location bLoc = block.getLocation();
/*    */     
/* 22 */     if (block.getType() == Material.EMERALD_ORE) {
/* 23 */       e.setCancelled(true);
/* 24 */       block.setType(Material.AIR);
/* 25 */       int r = new Random().nextInt(4);
/*    */       
/* 27 */       switch (r) {
/*    */       case 0: 
/* 29 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.ENDER_PEARL, 4));
/* 30 */         break;
/*    */       case 1: 
/* 32 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.POTION, 3));
/* 33 */         break;
/*    */       case 2: 
/* 35 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.TNT, 6));
/* 36 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.FLINT_AND_STEEL));
/* 37 */         break;
/*    */       case 3: 
/* 39 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLDEN_APPLE));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\oremanager\EmeraldOre.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */