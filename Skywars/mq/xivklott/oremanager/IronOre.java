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
/*    */ public class IronOre implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e)
/*    */   {
/* 17 */     Block block = e.getBlock();
/* 18 */     org.bukkit.Location bLoc = block.getLocation();
/*    */     
/* 20 */     if (block.getType() == Material.IRON_ORE) {
/* 21 */       e.setCancelled(true);
/* 22 */       block.setType(Material.AIR);
/* 23 */       int r = new Random().nextInt(24);
/*    */       
/* 25 */       switch (r) {
/*    */       case 0: 
/* 27 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_HELMET));
/* 28 */         break;
/*    */       case 1: 
/* 30 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_CHESTPLATE));
/* 31 */         break;
/*    */       case 2: 
/* 33 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_LEGGINGS));
/* 34 */         break;
/*    */       case 3: 
/* 36 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_BOOTS));
/* 37 */         break;
/*    */       case 4: 
/* 39 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_SWORD));
/* 40 */         break;
/*    */       case 5: 
/* 42 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_HELMET));
/* 43 */         break;
/*    */       case 6: 
/* 45 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_CHESTPLATE));
/* 46 */         break;
/*    */       case 7: 
/* 48 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_LEGGINGS));
/* 49 */         break;
/*    */       case 8: 
/* 51 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_BOOTS));
/* 52 */         break;
/*    */       case 9: 
/* 54 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_SWORD));
/* 55 */         break;
/*    */       case 10: 
/* 57 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LEATHER_HELMET));
/* 58 */         break;
/*    */       case 11: 
/* 60 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LEATHER_CHESTPLATE));
/* 61 */         break;
/*    */       case 12: 
/* 63 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LEATHER_LEGGINGS));
/* 64 */         break;
/*    */       case 13: 
/* 66 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LEATHER_BOOTS));
/* 67 */         break;
/*    */       case 14: 
/* 69 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.WOOD_SWORD));
/* 70 */         break;
/*    */       case 15: 
/* 72 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CHAINMAIL_HELMET));
/* 73 */         break;
/*    */       case 16: 
/* 75 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CHAINMAIL_CHESTPLATE));
/* 76 */         break;
/*    */       case 17: 
/* 78 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CHAINMAIL_LEGGINGS));
/* 79 */         break;
/*    */       case 18: 
/* 81 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CHAINMAIL_BOOTS));
/* 82 */         break;
/*    */       case 19: 
/* 84 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.STONE_SWORD));
/* 85 */         break;
/*    */       case 20: 
/* 87 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_INGOT, 12));
/*    */       case 21: 
/* 89 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.COAL, 12));
/*    */       case 22: 
/* 91 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_INGOT, 12));
/*    */       case 23: 
/* 93 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.WOOD, 32));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\oremanager\IronOre.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */