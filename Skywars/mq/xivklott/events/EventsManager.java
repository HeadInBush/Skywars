/*    */ package mq.xivklott.events;
/*    */ 
/*    */ import mq.xivklott.game.ChatListener;
/*    */ import mq.xivklott.kit.KitMenu;
/*    */ import mq.xivklott.main.SkyWars;
/*    */ import mq.xivklott.main.SqlConnection;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ 
/*    */ 
/*    */ public class EventsManager
/*    */ {
/*    */   public SkyWars pl;
/*    */   private SqlConnection sql;
/*    */   
/*    */   public EventsManager(SkyWars skyWars)
/*    */   {
/* 18 */     this.pl = skyWars;
/*    */   }
/*    */   
/*    */ 
/*    */   public EventsManager(SqlConnection sql)
/*    */   {
/* 24 */     this.sql = sql;
/*    */   }
/*    */   
/*    */   public void registerEvents()
/*    */   {
/* 29 */     PluginManager pm = Bukkit.getPluginManager();
/* 30 */     pm.registerEvents(new SkyJoin(this.pl), this.pl);
/* 31 */     pm.registerEvents(new PlayerListener(), this.pl);
/* 32 */     pm.registerEvents(new SkyPvP(this.sql), this.pl);
/* 33 */     pm.registerEvents(new KitMenu(), this.pl);
/* 34 */     pm.registerEvents(new ChatListener(), this.pl);
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\events\EventsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */