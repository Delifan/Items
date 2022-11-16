package cc.items.deus.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import cc.items.deus.setting.ItemManager;


public class EventListener implements Listener {


	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		ItemStack cursorItem = event.getCursor();
		ItemStack currentItem = event.getCurrentItem();
		Player player = (Player) event.getView().getPlayer();
		ItemManager.instance().initItemEvents(event);
		ItemManager.instance().crossingObjects(player, cursorItem, currentItem, event);

	}

	@EventHandler
	public void onEntityDamageEvent(EntityDamageByEntityEvent event) {
		ItemManager.instance().initItemEvents(event);
	}

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event){
		ItemManager.instance().initItemEvents(event);
	}
}
