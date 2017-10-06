/*    */ package mq.xivklott.events.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mq.xivklott.main.SkyWars;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Locations
/*    */ {
/* 14 */   public static ArrayList<Location> cages = new ArrayList();
/*    */   
/*    */   public Locations() {
/* 17 */     World w = Bukkit.getWorld("world");
/* 18 */     cages.add(new Location(w, 256.3D, 86.0D, 215.535D));
/* 19 */     cages.add(new Location(w, 247.408D, 86.0D, 207.56D));
/* 20 */     cages.add(new Location(w, 221.515D, 86.0D, 208.549D));
/* 21 */     cages.add(new Location(w, 214.586D, 86.0D, 217.626D));
/* 22 */     cages.add(new Location(w, 214.53D, 86.0D, 243.401D));
/* 23 */     cages.add(new Location(w, 223.605D, 86.0D, 250.357D));
/* 24 */     cages.add(new Location(w, 249.482D, 86.0D, 250.325D));
/* 25 */     cages.add(new Location(w, 256.437D, 86.0D, 241.6D));
/*    */   }
/*    */   
/*    */   public static void teleportPlayers() {
/* 29 */     for (int i = 0; i < SkyWars.getInstance().playersList.size(); i++)
/*    */     {
/* 31 */       Player player = (Player)SkyWars.getInstance().playersList.get(i);
/* 32 */       Location cage = (Location)cages.get(i);
/* 33 */       player.teleport(cage);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\events\util\Locations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */