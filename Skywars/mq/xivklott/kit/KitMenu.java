/*    */ package mq.xivklott.kit;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class KitMenu implements org.bukkit.event.Listener
/*    */ {
/*    */   private Inventory inv;
/*    */   
/*    */   public KitMenu()
/*    */   {
/* 20 */     this.inv = org.bukkit.Bukkit.createInventory(null, 18, "§5§lKITS");
/* 21 */     this.inv.setItem(Kits.GUERRIER.getSlot(), Kits.GUERRIER.getItem());
/* 22 */     this.inv.setItem(Kits.SNOWBALL.getSlot(), Kits.SNOWBALL.getItem());
/* 23 */     this.inv.setItem(Kits.TNT.getSlot(), Kits.TNT.getItem());
/* 24 */     this.inv.setItem(Kits.DEFAULT.getSlot(), Kits.DEFAULT.getItem());
/*    */   }
/*    */   
/*    */   public ItemStack Chest()
/*    */   {
/* 29 */     ItemStack is = new ItemStack(Material.CHEST, 1);
/* 30 */     ItemMeta metachest = is.getItemMeta();
/* 31 */     metachest.setDisplayName("§bMenu des Kits §7§m|§e Clique droit pour ouvrir");
/* 32 */     is.setItemMeta(metachest);
/* 33 */     return is;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void join(PlayerJoinEvent e) {
/* 38 */     Player p = e.getPlayer();
/* 39 */     p.getInventory().clear();
/* 40 */     p.getInventory().setItem(0, new ItemStack(Chest()));
/* 41 */     p.updateInventory();
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void interact(PlayerInteractEvent e)
/*    */   {
/* 47 */     Player p = e.getPlayer();
/* 48 */     ItemStack i = e.getItem();
/*    */     
/* 50 */     if ((i != null) && (i.getType() != null) && (i.getType() == Material.CHEST)) {
/* 51 */       p.openInventory(this.inv);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void clickInventory(InventoryClickEvent e)
/*    */   {
/* 58 */     Player p = (Player)e.getWhoClicked();
/* 59 */     Inventory inv = e.getInventory();
/* 60 */     ItemStack current = e.getCurrentItem();
/*    */     
/* 62 */     if (inv.getName().equalsIgnoreCase("§5§lKITS")) {
/* 63 */       if (current == null) return;
/* 64 */       e.setCancelled(true);
/* 65 */       p.closeInventory();
/* 66 */       if (current.getType() == Kits.GUERRIER.getIcon().getType()) {
/* 67 */         Kits.GUERRIER.add(p);
/*    */       }
/* 69 */       else if (current.getType() == Kits.SNOWBALL.getIcon().getType()) {
/* 70 */         Kits.SNOWBALL.add(p);
/*    */       }
/* 72 */       else if (current.getType() == Kits.TNT.getIcon().getType()) {
/* 73 */         Kits.TNT.add(p);
/*    */       }
/* 75 */       else if (current.getType() == Kits.DEFAULT.getIcon().getType()) {
/* 76 */         Kits.DEFAULT.add(p);
/*    */       }
/*    */       else {
/* 79 */         Kits.DEFAULT.add(p);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\kit\KitMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */