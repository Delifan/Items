package cc.items.deus.item;

import cc.items.deus.setting.EnumUseType;
import cc.items.deus.setting.Item;
import cc.items.deus.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Zatochka extends Item {

    public Zatochka() {
        super("Zatochka", "Zatochka", Material.GOLD_NUGGET, EnumUseType.CROSSING, "Test");
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof InventoryClickEvent){
            ItemStack cursorItem = ((InventoryClickEvent) event).getCursor();
            ItemStack currentItem = ((InventoryClickEvent) event).getCurrentItem();
            if(ItemUtils.isLore(cursorItem)){
                if(cursorItem.getItemMeta().getLore().contains(getLore()) && currentItem.getType() == Material.DIAMOND_SWORD){
                    int damage = currentItem.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                    currentItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, damage + 1);
                }
            }
        }
    }

    @Override
    public boolean isCrossingItem(ItemStack itemStack) {
        return itemStack.getType() == Material.DIAMOND_SWORD;
    }
}
