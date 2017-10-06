/*     */ package mq.xivklott.oremanager;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ public class LapisLazuliOre
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void onBlockBreak(BlockBreakEvent e)
/*     */   {
/*  23 */     Block block = e.getBlock();
/*  24 */     Location bLoc = block.getLocation();
/*     */     
/*  26 */     if (block.getType() == Material.LAPIS_ORE) {
/*  27 */       e.setCancelled(true);
/*  28 */       block.setType(Material.AIR);
/*  29 */       int r = new Random().nextInt(6);
/*     */       
/*  31 */       switch (r) {
/*     */       case 0: 
/*  33 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.EXP_BOTTLE, 32));
/*  34 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LAPIS_BLOCK, 4));
/*  35 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_PICKAXE));
/*  36 */         break;
/*     */       case 1: 
/*  38 */         block.getWorld().dropItemNaturally(bLoc, EnchantedBook1());
/*  39 */         break;
/*     */       case 2: 
/*  41 */         block.getWorld().dropItemNaturally(bLoc, EnchantedBook2());
/*  42 */         break;
/*     */       case 3: 
/*  44 */         block.getWorld().dropItemNaturally(bLoc, EnchantedBook3());
/*  45 */         break;
/*     */       case 4: 
/*  47 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CAULDRON_ITEM));
/*  48 */         break;
/*     */       case 5: 
/*  50 */         block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CACTUS, 5));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private ItemStack EnchantedBook1()
/*     */   {
/*  57 */     ItemStack isbook1 = new ItemStack(Material.BOOK, 1);
/*  58 */     ItemMeta metabook1 = isbook1.getItemMeta();
/*  59 */     metabook1.setDisplayName("§c§lLivre Enflammé");
/*  60 */     metabook1.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
/*  61 */     ArrayList<String> book1 = new ArrayList();
/*  62 */     book1.add("§f§l<->§f§l§m---§f§l<X>§f§l§m---§f§l<->");
/*  63 */     book1.add("§eEnchantement :");
/*  64 */     book1.add("  §cAura de Feu I");
/*  65 */     metabook1.setLore(book1);
/*  66 */     isbook1.setItemMeta(metabook1);
/*  67 */     return isbook1;
/*     */   }
/*     */   
/*     */   private ItemStack EnchantedBook2() {
/*  71 */     ItemStack isbook2 = new ItemStack(Material.BOOK, 1);
/*  72 */     ItemMeta metabook2 = isbook2.getItemMeta();
/*  73 */     metabook2.setDisplayName("§9§lLivre de Repoussement");
/*  74 */     metabook2.addEnchant(Enchantment.KNOCKBACK, 1, true);
/*  75 */     ArrayList<String> book2 = new ArrayList();
/*  76 */     book2.add("§f§l<->§f§l§m---§f§l<X>§f§l§m---§f§l<->");
/*  77 */     book2.add("§eEnchantement :");
/*  78 */     book2.add("  §9Knockback I");
/*  79 */     book2.add("");
/*  80 */     book2.add("");
/*  81 */     metabook2.setLore(book2);
/*  82 */     isbook2.setItemMeta(metabook2);
/*  83 */     return isbook2;
/*     */   }
/*     */   
/*     */   private ItemStack EnchantedBook3() {
/*  87 */     ItemStack isbook3 = new ItemStack(Material.BOOK, 2);
/*  88 */     ItemMeta metabook3 = isbook3.getItemMeta();
/*  89 */     metabook3.setDisplayName("§4§lLivre de Protection anti flamèche");
/*  90 */     metabook3.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);
/*  91 */     ArrayList<String> book3 = new ArrayList();
/*  92 */     book3.add("§f§l<->§f§l§m---§f§l<X>§f§l§m---§f§l<->");
/*  93 */     book3.add("§eEnchantement :");
/*  94 */     book3.add("  §4Protection contre le Feu I");
/*  95 */     book3.add("");
/*  96 */     book3.add("");
/*  97 */     book3.add("");
/*  98 */     metabook3.setLore(book3);
/*  99 */     isbook3.setItemMeta(metabook3);
/* 100 */     return isbook3;
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\oremanager\LapisLazuliOre.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */