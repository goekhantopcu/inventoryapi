package eu.jailbreaker.inventoryapi.items;

import lombok.Builder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.List;
import java.util.Map;

@Builder
public final class ItemBuilder {

    private int amount;
    private Color color;
    private String skinData;
    private List<String> lore;
    private Material material;
    private String displayname;
    private boolean glow, unbreakable;
    private Map<Enchantment, Integer> enchantments;

    public ItemStack toItemStack() {
        ItemStack itemStack = new ItemStack(this.material == null ? Material.STONE : this.material);
        itemStack.setAmount(this.amount == 0 ? 1 : this.amount);

        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta instanceof LeatherArmorMeta) {
            if (this.color != null) {
                ((LeatherArmorMeta) itemMeta).setColor(this.color);
            }
        }

        itemMeta.setDisplayName(this.displayname);

        if (this.lore != null && !this.lore.isEmpty()) {
            itemMeta.setLore(this.lore);
        }

        itemMeta.setUnbreakable(this.unbreakable);

        if (this.enchantments != null && !this.enchantments.isEmpty()) {
            this.enchantments.forEach((enchantment, integer) -> {
                try {
                    itemMeta.addEnchant(enchantment, integer, true);
                } catch (IllegalArgumentException e) {
                    itemStack.addUnsafeEnchantment(enchantment, integer);
                }
            });
        }

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}