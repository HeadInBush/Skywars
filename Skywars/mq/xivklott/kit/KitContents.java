/*    */ package mq.xivklott.kit;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class KitContents
/*    */ {
/*    */   public ArrayList<ItemStack> getDefaultKit()
/*    */   {
/* 13 */     ArrayList<ItemStack> i = new ArrayList();
/* 14 */     i.add(get(Material.WOOD_PICKAXE, 1, (byte)0, "§aPioche", null, 0));
/* 15 */     i.add(get(Material.WOOD_AXE, 1, (byte)0, "§aHache", null, 0));
/* 16 */     i.add(get(Material.WOOD_SPADE, 1, (byte)0, "§aPelle", null, 0));
/*    */     
/* 18 */     return i;
/*    */   }
/*    */   
/*    */   public ArrayList<ItemStack> getGuerrierKit() {
/* 22 */     ArrayList<ItemStack> i = new ArrayList();
/* 23 */     i.add(get(Material.WOOD_SWORD, 1, (byte)0, "§aÉpée en Fer §7(Kits)", Enchantment.KNOCKBACK, 1));
/* 24 */     i.add(get(Material.CHAINMAIL_BOOTS, 1, (byte)0, "§aPaire de Botte §7(Kits)", null, 0));
/* 25 */     i.add(get(Material.LEATHER_CHESTPLATE, 1, (byte)0, "§aPlastron  §7(Kits)", null, 0));
/*    */     
/* 27 */     return i;
/*    */   }
/*    */   
/*    */   public ArrayList<ItemStack> getSnowballKit() {
/* 31 */     ArrayList<ItemStack> i = new ArrayList();
/* 32 */     i.add(get(Material.SNOW_BALL, 32, (byte)0, "§aBoule de Neige §7(Kits)", Enchantment.ARROW_KNOCKBACK, 1));
/* 33 */     i.add(get(Material.SNOW_BLOCK, 12, (byte)0, "§aBloc de Neige §7(Kits)", null, 0));
/* 34 */     i.add(get(Material.PUMPKIN, 1, (byte)0, "§aCitrouille §7(Kits)", null, 0));
/* 35 */     i.add(get(Material.STONE_SPADE, 1, (byte)0, "§aPelle de Neige §7(Kits)", Enchantment.LUCK, 1));
/*    */     
/* 37 */     return i;
/*    */   }
/*    */   
/*    */   public ArrayList<ItemStack> getTntKit()
/*    */   {
/* 42 */     ArrayList<ItemStack> i = new ArrayList();
/* 43 */     i.add(get(Material.TNT, 16, (byte)0, "§aT.n.T §7(Kits)", null, 0));
/* 44 */     i.add(get(Material.FLINT_AND_STEEL, 1, (byte)0, "§aBriquet §7(Kits)", Enchantment.ARROW_KNOCKBACK, 1));
/* 45 */     i.add(get(Material.IRON_LEGGINGS, 1, (byte)0, "§aJambières §7(Kits)", Enchantment.PROTECTION_EXPLOSIONS, 2));
/* 46 */     i.add(get(Material.LEATHER_HELMET, 1, (byte)0, "§aChapeau §7(Kits)", Enchantment.PROTECTION_PROJECTILE, 1));
/*    */     
/* 48 */     return i;
/*    */   }
/*    */   
/*    */   private ItemStack get(Material mat, int amount, byte data, String displayName, Enchantment ench, int enchLevel) {
/* 52 */     ItemStack i = new ItemStack(mat, amount, data);
/* 53 */     ItemMeta iM = i.getItemMeta();
/* 54 */     iM.setDisplayName(displayName);
/* 55 */     if (ench != null) {
/* 56 */       iM.addEnchant(ench, enchLevel, true);
/*    */     }
/* 58 */     i.setItemMeta(iM);
/* 59 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\kit\KitContents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */