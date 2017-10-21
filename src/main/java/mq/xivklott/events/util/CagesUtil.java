package mq.xivklott.events.util;

import org.bukkit.Location;

public class CagesUtil {
    public static void destroyAllCages() {
        for (Location allCages : Locations.cages) {
            Location glass = allCages.add(0.0D, -1.0D, 0.0D);

            glass.getBlock().setType(org.bukkit.Material.AIR);
        }
    }
}