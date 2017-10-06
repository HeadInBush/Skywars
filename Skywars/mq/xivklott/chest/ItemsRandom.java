/*    */ package mq.xivklott.chest;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemsRandom
/*    */ {
/* 14 */   public static ArrayList<ItemStack> itemList = new ArrayList();
/*    */   
/*    */   public ItemsRandom() {
/* 17 */     itemList.add(getItem(null, Material.STONE_SWORD, 1, 0, Enchantment.DAMAGE_ALL, 2));
/* 18 */     itemList.add(getItem(null, Material.GOLDEN_APPLE, 1, 1, null, 0));
/* 19 */     itemList.add(getItem(null, Material.GOLD_CHESTPLATE, 1, 0, null, 0));
/* 20 */     itemList.add(getItem(null, Material.STONE, 32, 0, null, 0));
/* 21 */     itemList.add(getItem(null, Material.CHAINMAIL_HELMET, 1, 0, null, 0));
/* 22 */     itemList.add(getItem(null, Material.CHAINMAIL_CHESTPLATE, 1, 0, null, 0));
/* 23 */     itemList.add(getItem(null, Material.TNT, 5, 0, null, 0));
/* 24 */     itemList.add(getItem(null, Material.COOKED_BEEF, 16, 0, null, 0));
/* 25 */     itemList.add(getItem(null, Material.LOG, 24, 0, null, 0));
/* 26 */     itemList.add(getItem(null, Material.LEATHER_LEGGINGS, 1, 0, Enchantment.PROTECTION_EXPLOSIONS, 2));
/* 27 */     itemList.add(getItem(null, Material.LEATHER_HELMET, 1, 0, null, 0));
/* 28 */     itemList.add(getItem(null, Material.DIRT, 32, 0, null, 0));
/* 29 */     itemList.add(getItem(null, Material.IRON_HELMET, 1, 0, null, 0));
/* 30 */     itemList.add(getItem(null, Material.LEATHER_BOOTS, 1, 0, null, 0));
/* 31 */     itemList.add(getItem(null, Material.STONE_SWORD, 1, 0, Enchantment.DAMAGE_ALL, 1));
/* 32 */     itemList.add(getItem(null, Material.IRON_SWORD, 1, 0, null, 0));
/* 33 */     itemList.add(getItem(null, Material.GOLDEN_APPLE, 1, 0, null, 0));
/* 34 */     itemList.add(getItem(null, Material.WATER_BUCKET, 1, 0, null, 0));
/* 35 */     itemList.add(getItem(null, Material.FISHING_ROD, 1, 0, null, 0));
/* 36 */     itemList.add(getItem(null, Material.DIAMOND_SWORD, 1, 0, null, 0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static ItemStack getRandomItem()
/*    */   {
/* 43 */     int listlimit = itemList.size() - 1;
/* 44 */     Random r = new Random();
/* 45 */     int alea = r.nextInt(listlimit);
/*    */     
/* 47 */     return (ItemStack)itemList.get(alea);
/*    */   }
/*    */   
/*    */ 
/*    */   private ItemStack getItem(String displayName, Material mat, int amount, int data, Enchantment ench, int enchLevel)
/*    */   {
/* 53 */     ItemStack i = new ItemStack(mat, amount, (byte)data);
/* 54 */     ItemMeta iM = i.getItemMeta();
/* 55 */     iM.setDisplayName(displayName);
/*    */     
/* 57 */     if ((ench != null) && (enchLevel != 0)) {
/* 58 */       iM.addEnchant(ench, enchLevel, true);
/*    */     }
/* 60 */     i.setItemMeta(iM);
/* 61 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\chest\ItemsRandom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */