package cc.items.deus.commands;

import cc.items.deus.setting.ItemManager;
import org.bukkit.entity.Player;

public class CommandItems extends Command {

	@Override
	public void onExecute(Player player, String[] args) throws Throwable {
		ItemManager.instance().createItemStack(player, args[0], Integer.parseInt(args[1]));
	}

	@Override
	public String getName() {
		return "items";
	}

	@Override
	public String getRequiredPermission() {
		return null;
	}

	@Override
	public String getErrorMessage(Throwable throwable) {
		return "error";
	}

}
