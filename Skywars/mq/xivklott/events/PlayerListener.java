/*    */ package mq.xivklott.events;
/*    */ 
/*    */ import mq.xivklott.game.GameState;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.world.PortalCreateEvent;
/*    */ 
/*    */ public class PlayerListener implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void place(BlockPlaceEvent e)
/*    */   {
/* 18 */     if ((GameState.isState(GameState.LOBBY)) || (GameState.isState(GameState.PREGAME))) {
/* 19 */       e.setCancelled(true);
/*    */     }
/* 21 */     if (e.getBlock().getType() == Material.CHEST) {
/* 22 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void breake(BlockBreakEvent e) {
/* 28 */     if ((GameState.isState(GameState.LOBBY)) || (GameState.isState(GameState.PREGAME))) {
/* 29 */       e.setCancelled(true);
/* 30 */     } else if ((e.getBlock().getType() == Material.GLASS) && 
/* 31 */       (GameState.isState(GameState.GAME))) {
/* 32 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void damage(EntityDamageEvent e)
/*    */   {
/* 39 */     if ((GameState.isState(GameState.LOBBY)) || (GameState.isState(GameState.PREGAME))) {
/* 40 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void portalCreate(PortalCreateEvent e) {
/* 46 */     e.setCancelled(true);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void spawnMob(CreatureSpawnEvent e) {
/* 51 */     e.setCancelled(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\events\PlayerListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */