package eu.jailbreaker.inventoryapi.items.types;

import eu.jailbreaker.inventoryapi.inventories.SlotPos;
import lombok.Getter;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class ClickableItem extends SimpleItem {

    @Getter
    private final Consumer<InventoryClickEvent> consumer;

    public ClickableItem(int slot, ItemStack cover, Consumer<InventoryClickEvent> consumer) {
        super(slot, cover);
        this.consumer = consumer;
    }

    public ClickableItem(SlotPos slotPos, ItemStack cover, Consumer<InventoryClickEvent> consumer) {
        super(slotPos.toSlot(), cover);
        this.consumer = consumer;
    }
}
