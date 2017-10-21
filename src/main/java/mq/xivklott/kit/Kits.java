package mq.xivklott.kit;

import java.util.ArrayList;
import java.util.HashMap;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.Title;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Kits {
    DEFAULT(9, "§cKIT §6DEFAULT", new ItemStack(Material.WOOD_PICKAXE, 1), SkyWars.getInstance().kitContents.getDefaultKit()), 
    GUERRIER(12, "§cKIT §8GUERRIER", new ItemStack(Material.STONE_SWORD, 1), SkyWars.getInstance().kitContents.getGuerrierKit()), 
    SNOWBALL(15, "§cKIT §fSNOWBALL", new ItemStack(Material.SNOW_BALL, 1), SkyWars.getInstance().kitContents.getSnowballKit()), 
    TNT(17, "§cKIT §fT§4N§fT", new ItemStack(Material.TNT, 1), SkyWars.getInstance().kitContents.getTntKit());

    private ArrayList<ItemStack> items;
    private int slot;
    private String kitName;
    private ItemStack icon;

    private Kits(int slot, String kitName, ItemStack icon, ArrayList<ItemStack> items) {
        this.slot = slot;
        this.kitName = kitName;
        this.icon = icon;
        this.items = items;
    }

    public int getSlot() {
        return this.slot;
    }

    public String getKitName() {
        return this.kitName;
    }

    public ItemStack getIcon() {
        return this.icon;
    }

    public ItemStack getItem() {
        ItemStack i = this.icon;
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(this.kitName);
        i.setItemMeta(iM);
        return i;
    }

    public void add(Player player) {
        if (SkyWars.getInstance().kits.containsKey(player)) {
            SkyWars.getInstance().kits.remove(player);
        }

        SkyWars.getInstance().kits.put(player, this);
        Title.sendActionBar(player, "§cKIT : §e" + this.kitName);
    }

    public ArrayList<ItemStack> getItems() {
        return this.items;
    }
}