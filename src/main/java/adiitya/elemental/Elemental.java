package adiitya.elemental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import adiitya.elemental.cmd.AddFactCommand;
import adiitya.elemental.cmd.ElementCommand;
import adiitya.elemental.cmd.ElementsCommand;
import adiitya.elemental.cmd.FactCommand;
import adiitya.elemental.cmd.HelpCommand;
import adiitya.elemental.cmd.PropertyCommand;
import adiitya.elemental.cmd.ReloadFactCommand;
import adiitya.elemental.cmd.RemoveFactCommand;
import adiitya.elemental.cmd.RepoCommand;
import adiitya.elemental.cmd.StopCommand;
import adiitya.elemental.cmd.TableCommand;
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
	public static DataCache<String, String> cache = new DataCache<String, String>(1920000, 100);
	public static Logger LOGGER = LoggerFactory.getLogger(Elemental.class);

	public void start(String[] args) {

		Discord4J.disableAudio();
		Configuration.AUTOMATICALLY_ENABLE_MODULES = false;
		Configuration.LOAD_EXTERNAL_MODULES = false;
		
		bot = new ClientBuilder().withToken(token).login();
		handler = new Discord4JHandler(bot);
		
		registerCommands();

		Facts.load();

		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {

				if (bot.isLoggedIn())
					bot.logout();
			}
		});
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

		Elemental app = new Elemental();
		app.start(args);
	}
}
