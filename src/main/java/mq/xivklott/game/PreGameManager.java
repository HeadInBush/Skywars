package mq.xivklott.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mq.xivklott.chest.ChestRefill;
import mq.xivklott.kit.Kits;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;

public class PreGameManager {
    static int timer = 5;
    int task;

  public PreGameManager()
  {
    this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable()
    {

      public void run()
      {
        PreGameManager.timer -= 1;
        
        if ((PreGameManager.timer == 5) || (PreGameManager.timer == 4) || (PreGameManager.timer == 3) || (PreGameManager.timer == 2) || (PreGameManager.timer == 1)) {
          for (Player pl : Bukkit.getOnlinePlayers())
          {
            Title.sendTitle(pl, "§c" + PreGameManager.timer + "s", "§ePréparez vous", 20);
          }
        }
        
        for (Player p : Bukkit.getOnlinePlayers()) {
          p.setLevel(PreGameManager.timer);
        }
        
        if (PreGameManager.timer == 0) {
          GameState.setState(GameState.GAME);
          Iterator localIterator2; 
          
          for (Player player : Bukkit.getOnlinePlayers())
          {
            Title.sendTitle(pl, "§cLancement du Jeu !", "§eBonne Chance !", 20);
            

            Kits playerKit = (Kits)SkyWars.getInstance().kits.get(pl);
            ArrayList<ItemStack> itemsdukit = playerKit.getItems();
            pl.getInventory().clear();
            localIterator2 = itemsdukit.iterator();
            ItemStack item = (ItemStack)localIterator2.next();
            pl.getInventory().addItem(new ItemStack[] { item });
          }
          
          Bukkit.getScheduler().cancelTask(PreGameManager.this.task);
          
          mq.xivklott.events.util.CagesUtil.destroyAllCages();
          new ChestRefill().refillAllChests();
          new GameManager();
        }
        
      }
      
    }, 20L, 20L);
  }
}