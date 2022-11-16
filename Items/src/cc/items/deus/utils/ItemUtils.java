package cc.items.deus.utils;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemUtils {

    public static boolean isLore(ItemStack itemStack){
        return itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore();
    }
}
