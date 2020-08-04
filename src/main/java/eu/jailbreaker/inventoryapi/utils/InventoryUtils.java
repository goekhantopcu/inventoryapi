package eu.jailbreaker.inventoryapi.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.Nullable;

@UtilityClass
public class InventoryUtils {

    @Nullable
    public String getTitle(InventoryEvent event) {
        if (event == null) {
            return null;
        }
        return event.getView().getTitle();
    }

    @Nullable
    public String getTitle(Inventory inventory) {
        if (inventory.getViewers().isEmpty()) {
            return null;
        }
        return inventory.getViewers().iterator().next().getOpenInventory().getTitle();
    }
}
