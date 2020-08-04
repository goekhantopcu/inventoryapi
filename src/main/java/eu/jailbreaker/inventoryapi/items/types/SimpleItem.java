package eu.jailbreaker.inventoryapi.items.types;

import eu.jailbreaker.inventoryapi.inventories.SlotPos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
@AllArgsConstructor
public class SimpleItem {

    private final int slot;
    private ItemStack cover;

    public SimpleItem(SlotPos slotPos, ItemStack cover) {
        this(slotPos.toSlot(), cover);
    }

    public void add(Inventory inventory) {
        inventory.setItem(this.slot, this.cover);
    }
}