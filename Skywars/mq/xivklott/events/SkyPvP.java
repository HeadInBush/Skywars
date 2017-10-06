/*    */ package mq.xivklott.events;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mq.xivklott.game.SkyWinner;
/*    */ import mq.xivklott.main.SkyWars;
/*    */ import mq.xivklott.main.SqlConnection;
/*    */ import mq.xivklott.main.Title;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
/*    */ import net.minecraft.server.v1_8_R3.PlayerConnection;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class SkyPvP implements org.bukkit.event.Listener
/*    */ {
/*    */   private SqlConnection sql;
/*    */   
/*    */   public SkyPvP(SqlConnection sql)
/*    */   {
/* 22 */     this.sql = sql;
/*    */   }
/*    */   
/*    */   @org.bukkit.event.EventHandler
/*    */   public void death(PlayerDeathEvent e) {
/* 27 */     final Player p = e.getEntity();
/* 28 */     e.setDeathMessage("§7" + p.getName() + "§e est mort !");
/* 29 */     p.setGameMode(GameMode.SPECTATOR);
/* 30 */     SkyWars.getInstance().playersList.remove(p);
/* 31 */     new SkyWinner(this.sql).check();
/* 32 */     org.bukkit.Bukkit.getScheduler().runTaskLater(SkyWars.getInstance(), new Runnable()
/*    */     {
/*    */ 
/*    */       public void run()
/*    */       {
/* 37 */         PacketPlayInClientCommand cmd = new PacketPlayInClientCommand(net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);
/* 38 */         ((CraftPlayer)p).getHandle().playerConnection.a(cmd);
/* 39 */         Title.sendTitle(p, "§cGameOver :o", "", 25);
/*    */       }
/*    */       
/* 42 */     }, 5L);
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\events\SkyPvP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */