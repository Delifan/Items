package cc.items.deus.commands;

import java.util.ArrayList;
import java.util.List;

import cc.items.deus.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class CommandManager implements CommandExecutor {
	private static CommandManager instance;
	private List<Command> commands = new ArrayList();

	public void registerCommands(JavaPlugin javaPlugin) {
		this.commands.add(new CommandItems());
		for (Command command : this.commands) {
			javaPlugin.getCommand(command.getName()).setExecutor(this);
		}
	}

	public static CommandManager instance() {
		return instance;
	}

	static {
		instance = new CommandManager();
	}

	@Override
	public boolean onCommand(CommandSender arg0, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
		for (Command command : this.commands) {
			if (command.getName().equals(arg2)) {
				try {
					command.onExecute((Player) arg0, arg3);
				} catch (Throwable e) {
					e.printStackTrace();
					Main.sendMessage(arg0, command.getErrorMessage(e));
				}
			}
		}
		return true;
	}
}
