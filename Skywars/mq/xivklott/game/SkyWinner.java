/*    */ package mq.xivklott.game;
/*    */ 
/*    */ import mq.xivklott.main.SkyWars;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SkyWinner
/*    */ {
/*    */   mq.xivklott.main.SqlConnection sql;
/*    */   SkyWars main;
/*    */   
/*    */   public SkyWinner(mq.xivklott.main.SqlConnection sql)
/*    */   {
/* 14 */     this.sql = sql;
/*    */   }
/*    */   
/*    */   public SkyWinner(SkyWars main) {
/* 18 */     this.main = main;
/*    */   }
/*    */   
/*    */   public void check()
/*    */   {
/* 23 */     if ((SkyWars.getInstance().playersList.size() == 0) && (GameState.isState(GameState.GAME)))
/*    */     {
/* 25 */       GameState.setState(GameState.FINISH);
/* 26 */       Bukkit.spigot().restart();
/*    */     }
/*    */     
/* 29 */     if (SkyWars.getInstance().playersList.size() == 1)
/*    */     {
/* 31 */       GameState.setState(GameState.FINISH);
/*    */       
/*    */ 
/* 34 */       Player p = ((Player)SkyWars.getInstance().playersList.get(0)).getPlayer();
/* 35 */       Bukkit.broadcastMessage(SkyWars.getInstance().coloration("&b&lGrand gagnant &7: &1&k!&b&k!&1&k!&f&l&f&l " + ((Player)SkyWars.getInstance().playersList.get(0)).getPlayer().getName() + "&1&k !&b&k!&1&k!"));
/*    */       
/* 37 */       Bukkit.broadcastMessage("§aRemise des prix ! Téléportation au Hub dans quelques secondes..");
/*    */       
/* 39 */       for (Player player : Bukkit.getOnlinePlayers())
/*    */       {
/*    */ 
/* 42 */         this.sql.addMoney(player, 25);
/* 43 */         player.sendMessage("§eTu as gagné 25coins en terminant cette partie !");
/*    */         
/* 45 */         this.sql.addMoney(p, 75);
/* 46 */         player.sendMessage("§eTu as gagné 100 coins en remportant cette partie ! Bien joué !");
/*    */         
/* 48 */         Bukkit.broadcastMessage("§7Téléportation au lobby en cours...");
/* 49 */         this.main.Lobbytp(player);
/*    */       }
/*    */       
/*    */ 
/* 53 */       Bukkit.spigot().restart();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\game\SkyWinner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */