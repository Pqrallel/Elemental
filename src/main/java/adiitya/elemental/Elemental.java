package adiitya.elemental;

import adiitya.elemental.api.DataCache;
import adiitya.elemental.cmd.ElementCommand;
import adiitya.elemental.cmd.ElementTestCommand;
import adiitya.elemental.cmd.ElementsCommand;
import adiitya.elemental.cmd.FactCommand;
import adiitya.elemental.cmd.HelpCommand;
import adiitya.elemental.cmd.PropertyCommand;
import adiitya.elemental.cmd.RegisterCommand;
import adiitya.elemental.cmd.RepoCommand;
import adiitya.elemental.cmd.TableCommand;
import adiitya.elemental.elements.Facts;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.Discord4JHandler;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class Elemental {

	private static String token;
	public static IDiscordClient bot;
	public static CommandHandler handler;
	public static DataCache<String, String> cache = new DataCache<String, String>(1920000, 100);

	public void start(String[] args) {
		
		bot = new ClientBuilder().withToken(token).login();
		handler = new Discord4JHandler(bot);
		
		handler.registerCommand(new ElementCommand());
		handler.registerCommand(new TableCommand());
		handler.registerCommand(new ElementTestCommand());
		handler.registerCommand(new ElementsCommand());
		handler.registerCommand(new FactCommand());
		handler.registerCommand(new HelpCommand());
		handler.registerCommand(new PropertyCommand());
		handler.registerCommand(new RepoCommand());
		handler.registerCommand(new RegisterCommand());
		
		Facts.init();
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
