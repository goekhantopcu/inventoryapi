package eu.jailbreaker.inventoryapi.inventories;

import com.google.common.collect.Maps;
import eu.jailbreaker.inventoryapi.items.types.SimpleItem;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.Map;

@Getter
public abstract class SimpleInventory {

    public static final Map<Player, SimpleInventory> OPEN_INVENTORIES = Maps.newHashMap();
    private final List<SimpleItem> items;
    private int size;
    private String title;

    public SimpleInventory(int size, String title) {
        this.size = size;
        this.title = title;
        this.items = this.loadItems();
    }

    public SimpleInventory(InventoryType type) {
        this(type.getDefaultSize(), type.getDefaultTitle());
    }

    public static void unregister(Player player) {
        OPEN_INVENTORIES.remove(player);
    }

    public void open(Player player) {
        Inventory inventory = Bukkit.createInventory(player, this.size, this.title);
        this.items.forEach(item -> inventory.setItem(item.getSlot(), item.getCover()));
        player.openInventory(inventory);
        OPEN_INVENTORIES.put(player, this);
    }

    public void close(Player player) {
        if (player.getOpenInventory().getTitle().equals(this.title)) {
            player.closeInventory();
        }
        OPEN_INVENTORIES.remove(player);
    }

    public void add(SimpleItem item) {
        this.items.removeIf(simpleItem -> simpleItem.getSlot() == item.getSlot());
        this.items.add(item);
    }

    public abstract List<SimpleItem> loadItems();
}