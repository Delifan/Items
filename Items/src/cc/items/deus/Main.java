package cc.items.deus;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import cc.items.deus.commands.CommandManager;
import cc.items.deus.listener.EventListener;
import cc.items.deus.setting.ItemManager;

public class Main extends JavaPlugin {

	public static JavaPlugin plugin;

	public void onEnable() {
		plugin = this;
		Bukkit.getServer().getPluginManager().registerEvents(new EventListener(), this);
		CommandManager.instance().registerCommands(this);
		ItemManager.instance().registerItems();
	}

	public void onDisable() {

	}

	public static void debug(Object... objects) {
		for (Object o : objects) {
			if (o instanceof String) {
				System.out.println(o);
			}
		}
	}

	public static void sendMessage(CommandSender commandSender, String message) {
		commandSender.sendMessage(message);
	}

}
