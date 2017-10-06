/*    */ package mq.xivklott.events.util;
/*    */ 
/*    */ import org.bukkit.Location;
/*    */ 
/*    */ public class CagesUtil
/*    */ {
/*    */   public static void destroyAllCages()
/*    */   {
/*  9 */     for (Location allCages : Locations.cages) {
/* 10 */       Location glass = allCages.add(0.0D, -1.0D, 0.0D);
/*    */       
/* 12 */       glass.getBlock().setType(org.bukkit.Material.AIR);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\events\util\CagesUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */