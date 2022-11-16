package cc.items.deus.setting;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class Item {

    public String name;
    public Material material;
    public EnumUseType enumUseType;
    public String command;
    public String lore;


    public Item(String name, String lore, Material material, EnumUseType enumUseType, String command){
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.enumUseType = enumUseType;
        this.command = command;
    }

    public boolean isCrossingItem(ItemStack itemStack) {
        return false;
    }

    public void onEvent(Event event){
    }

    public void onPlayer(Player player){
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public EnumUseType getEnumUseType() {
        return enumUseType;
    }

    public String getCommand() {
        return command;
    }

    public String getLore() {
        return lore;
    }
}
