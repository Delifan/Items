package cc.items.deus.setting;

import java.util.ArrayList;
import java.util.List;

import cc.items.deus.item.Zatochka;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
	private static final ItemManager instance = new ItemManager();
	private final List<Item> item = new ArrayList<>();

	public void registerItems() {
		item.add(new Zatochka());
	}

	public static ItemManager instance() {
		return ItemManager.instance;
	}

	public void initItemEvents(Event event){
		for(Item item : item){
			item.onEvent(event);
		}
	}

	public void crossingObjects(Player player, ItemStack itemStack, ItemStack itemStack2, Event event){
		if(itemStack.hasItemMeta()) {
			if (itemStack.getItemMeta().hasLore()) {
				ItemMeta meta = itemStack.getItemMeta();
				List<String> lore = meta.getLore();
				for (Item item : item) {
					if (item.getEnumUseType() == EnumUseType.CROSSING && item.isCrossingItem(itemStack2) && lore.contains(item.getLore())) {
						itemStack.setAmount(itemStack.getAmount() - 1);
						itemStack.setAmount(itemStack.getAmount());
						return;
					}
				}
			}
		}
	}

	public void handleUseItem(Player player, ItemStack itemStack) {
		ItemMeta meta = itemStack.getItemMeta();
		if (meta.hasLore()) {
			List<String> lore = meta.getLore();
			for (String str : lore) {
				for (Item item : this.item) {
					if (item.getEnumUseType() == EnumUseType.CONSUME && str.equals(item.getLore())) {
						item.onPlayer(player);
						return;
					}
				}
			}
		}
	}

	public void handlePlayerWearItem(Player player) {
		ItemStack[] stacks = new ItemStack[] { player.getInventory().getItemInOffHand(),
				player.getInventory().getItemInMainHand() };
		for (ItemStack itemStack : stacks) {
			ItemMeta meta = itemStack.getItemMeta();
			if (meta != null && meta.hasLore()) {
				List<String> lore = meta.getLore();
				for (String str : lore) {
					for (Item item : this.item) {
						if (item.getEnumUseType() == EnumUseType.HAND && str.equals(item.getLore())) {
							item.onPlayer(player);
							return;
						}
					}
				}
			}
		}
	}

	public void createItemStack(Player player, String cmd, int count) {
		for (Item item : this.item) {
			if (item.getCommand().equals(cmd)) {
				ItemStack stack = new ItemStack(item.getMaterial(), count);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName(item.getName());
				List<String> newLore = new ArrayList<>();
				newLore.add(item.getLore());
				meta.setLore(newLore);
				stack.setItemMeta(meta);
				player.getInventory().addItem(stack);
			}
		}
	}

	public void convertListColor(List<String> in, List<String> out) {
		in.forEach(element -> out.add(ChatColor.translateAlternateColorCodes('&', element)));
	}
}
