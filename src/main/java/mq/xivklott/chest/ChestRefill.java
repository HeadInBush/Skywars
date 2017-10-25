package mq.xivklott.chest;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChestRefill {
    public void refillAllChests() {

        Chunk[] arrayOfChunk;
        int j = (arrayOfChunk = org.bukkit.Bukkit.getWorld("world").getLoadedChunks()).length;

        for (int i = 0; i < j; i++) {
            Chunk chunk = arrayOfChunk[i];
            BlockState[] arrayOfBlockState;
            int m = (arrayOfBlockState = chunk.getTileEntities()).length;

            for (int k = 0; k < m; k++) {
                BlockState bs = arrayOfBlockState[k];
                
                if ((bs instanceof Chest)) {
                    Chest coffre = (Chest) bs.getBlock().getState();
                    Inventory inv = coffre.getInventory();
                    inv.clear();

                    for (int i = 0; i < 5; i++) {
                        ItemStack randomItem = ItemsRandom.getRandomItem();
                        Random r = new Random();
                        int limit = inv.getSize() - 1;
                        int randomSlot = r.nextInt(limit);

                        inv.setItem(randomSlot, randomItem);
                    }
                }
            }
        }
    }
}