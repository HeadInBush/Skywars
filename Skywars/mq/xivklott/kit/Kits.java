/*    */ package mq.xivklott.kit;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import mq.xivklott.main.SkyWars;
/*    */ import mq.xivklott.main.Title;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum Kits
/*    */ {
/* 16 */   DEFAULT(9, "§cKIT §6DEFAULT", new ItemStack(Material.WOOD_PICKAXE, 1), SkyWars.getInstance().kitContents.getDefaultKit()), 
/* 17 */   GUERRIER(12, "§cKIT §8GUERRIER", new ItemStack(Material.STONE_SWORD, 1), SkyWars.getInstance().kitContents.getGuerrierKit()), 
/* 18 */   SNOWBALL(15, "§cKIT §fSNOWBALL", new ItemStack(Material.SNOW_BALL, 1), SkyWars.getInstance().kitContents.getSnowballKit()), 
/* 19 */   TNT(17, "§cKIT §fT§4N§fT", new ItemStack(Material.TNT, 1), SkyWars.getInstance().kitContents.getTntKit());
/*    */   
/*    */   private ArrayList<ItemStack> items;
/*    */   private int slot;
/*    */   private String kitName;
/*    */   private ItemStack icon;
/*    */   
/*    */   private Kits(int slot, String kitName, ItemStack icon, ArrayList<ItemStack> items) {
/* 27 */     this.slot = slot;
/* 28 */     this.kitName = kitName;
/* 29 */     this.icon = icon;
/* 30 */     this.items = items;
/*    */   }
/*    */   
/*    */   public int getSlot()
/*    */   {
/* 35 */     return this.slot;
/*    */   }
/*    */   
/*    */   public String getKitName() {
/* 39 */     return this.kitName;
/*    */   }
/*    */   
/*    */   public ItemStack getIcon() {
/* 43 */     return this.icon;
/*    */   }
/*    */   
/*    */   public ItemStack getItem() {
/* 47 */     ItemStack i = this.icon;
/* 48 */     ItemMeta iM = i.getItemMeta();
/* 49 */     iM.setDisplayName(this.kitName);
/* 50 */     i.setItemMeta(iM);
/* 51 */     return i;
/*    */   }
/*    */   
/*    */   public void add(Player player)
/*    */   {
/* 56 */     if (SkyWars.getInstance().kits.containsKey(player)) {
/* 57 */       SkyWars.getInstance().kits.remove(player);
/*    */     }
/*    */     
/* 60 */     SkyWars.getInstance().kits.put(player, this);
/* 61 */     Title.sendActionBar(player, "§cKIT : §e" + this.kitName);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ArrayList<ItemStack> getItems()
/*    */   {
/* 68 */     return this.items;
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\kit\Kits.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */