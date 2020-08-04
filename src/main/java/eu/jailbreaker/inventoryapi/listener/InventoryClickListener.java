package eu.jailbreaker.inventoryapi.listener;

import eu.jailbreaker.inventoryapi.inventories.SimpleInventory;
import eu.jailbreaker.inventoryapi.items.types.ClickableItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        final Player player = (Player) event.getWhoClicked();
        if (SimpleInventory.OPEN_INVENTORIES.containsKey(player)) {
            event.setCancelled(true);
            SimpleInventory.OPEN_INVENTORIES.get(player).getItems().stream()
                    .filter(item -> item.getSlot() == event.getSlot())
                    .filter(ClickableItem.class::isInstance)
                    .map(ClickableItem.class::cast)
                    .findFirst()
                    .ifPresent(item -> item.getConsumer().accept(event));
        }
    }
}
