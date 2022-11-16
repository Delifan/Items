package cc.items.deus.commands;

import org.bukkit.entity.Player;

public abstract class Command {
	public abstract void onExecute(Player player, String[] args) throws Throwable;

	public abstract String getName();

	public abstract String getRequiredPermission();

	public abstract String getErrorMessage(Throwable throwable);
}
