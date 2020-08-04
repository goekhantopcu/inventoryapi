package eu.jailbreaker.inventoryapi.items.types;

import eu.jailbreaker.inventoryapi.inventories.SimpleInventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryOpenerItem extends ClickableItem {

    public InventoryOpenerItem(int slot, ItemStack cover, Inventory inventory) {
        super(slot, cover, event -> event.getWhoClicked().openInventory(inventory));
    }

    public InventoryOpenerItem(int slot, ItemStack cover, SimpleInventory inventory) {
        super(slot, cover, event -> inventory.open((Player) event.getWhoClicked()));
    }
}
