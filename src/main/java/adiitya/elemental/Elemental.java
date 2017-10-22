package adiitya.elemental;

import adiitya.elemental.cmd.*;
import adiitya.elemental.elements.Facts;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.Discord4JHandler;
import sx.blah.discord.Discord4J;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.modules.Configuration;

public class Elemental {

	private static String token;
	public static IDiscordClient bot;
	public static CommandHandler handler;
	public static DataCache<String> cache = new DataCache<>(1920000, 128);

	private void start() {

		Discord4J.disableAudio();
		Configuration.AUTOMATICALLY_ENABLE_MODULES = false;
		Configuration.LOAD_EXTERNAL_MODULES = false;

		bot = new ClientBuilder().withToken(token).login();
		handler = new Discord4JHandler(bot);

		registerCommands();

		Facts.load();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {

			if (bot.isLoggedIn())
				bot.logout();
		}));
	}

	private void registerCommands() {

		handler.registerCommand(new ElementCommand());
		handler.registerCommand(new TableCommand());
		handler.registerCommand(new ElementsCommand());
		handler.registerCommand(new FactCommand());
		handler.registerCommand(new HelpCommand());
		handler.registerCommand(new PropertyCommand());
		handler.registerCommand(new RepoCommand());
		handler.registerCommand(new StopCommand());
		handler.registerCommand(new AddFactCommand());
		handler.registerCommand(new ReloadFactCommand());
		handler.registerCommand(new RemoveFactCommand());
	}

	public static void main(String[] args) {

		if (args.length > 0)
			token = args[0];
		else {

			System.err.println("INVALID BOT TOKEN");
			System.exit(-1);
		}

		new Elemental().start();
	}
}
