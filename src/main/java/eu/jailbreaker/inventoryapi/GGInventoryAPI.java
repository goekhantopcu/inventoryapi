package eu.jailbreaker.inventoryapi;

import eu.jailbreaker.inventoryapi.listener.InventoryClickListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GGInventoryAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        this.register();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void register() {
        final PluginManager manager = this.getServer().getPluginManager();
        manager.registerEvents(new InventoryClickListener(), this);
    }
}
