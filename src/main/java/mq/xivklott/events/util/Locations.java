package mq.xivklott.events.util;

import java.util.ArrayList;
import mq.xivklott.main.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Locations {
    public static ArrayList<Location> cages = new ArrayList();

    public Locations() {
        World w = Bukkit.getWorld("world");
        cages.add(new Location(w, 256.3D, 86.0D, 215.535D));
        cages.add(new Location(w, 247.408D, 86.0D, 207.56D));
        cages.add(new Location(w, 221.515D, 86.0D, 208.549D));
        cages.add(new Location(w, 214.586D, 86.0D, 217.626D));
        cages.add(new Location(w, 214.53D, 86.0D, 243.401D));
        cages.add(new Location(w, 223.605D, 86.0D, 250.357D));
        cages.add(new Location(w, 249.482D, 86.0D, 250.325D));
        cages.add(new Location(w, 256.437D, 86.0D, 241.6D));
    }

    public static void teleportPlayers() {
        for (int i = 0; i < SkyWars.getInstance().playersList.size(); i++) {
            Player player = (Player) SkyWars.getInstance().playersList.get(i);
            Location cage = (Location) cages.get(i);
            player.teleport(cage);
        }
    }
}