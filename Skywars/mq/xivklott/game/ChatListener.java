/*    */ package mq.xivklott.game;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerChatEvent;
/*    */ 
/*    */ public class ChatListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onChat(PlayerChatEvent e)
/*    */   {
/* 15 */     Player p = e.getPlayer();
/* 16 */     e.setFormat(ChatColor.GOLD + p.getName() + ChatColor.GRAY + " §l» " + ChatColor.YELLOW + e.getMessage());
/* 17 */     p.setPlayerListName("§6 " + p.getName());
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\game\ChatListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */