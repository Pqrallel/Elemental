package adiitya.elemental;

import adiitya.elemental.cmd.ElementCommand;
import adiitya.elemental.cmd.ElementTestCommand;
import adiitya.elemental.cmd.ElementsCommand;
import adiitya.elemental.cmd.FactCommand;
import adiitya.elemental.cmd.TableCommand;
import adiitya.elemental.elements.Elements;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.Discord4JHandler;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class Elemental {

	private static String token;
	public static IDiscordClient bot;
	public static CommandHandler handler;

	public void start(String[] args) {
		
		// create bot and login
		bot = new ClientBuilder().withToken(token).login();
		handler = new Discord4JHandler(bot);
		
		// register all commands
		handler.registerCommand(new ElementCommand());
		handler.registerCommand(new TableCommand());
		handler.registerCommand(new ElementTestCommand());
		handler.registerCommand(new ElementsCommand());
		handler.registerCommand(new FactCommand());
		
		// initialize elements
		Elements.init();
	}
	
	public static void main(String[] args) {
		
		// check if bot token exists
		if (args.length > 0)
			token = args[0];
		else { 
			
			System.err.println("INVALID BOT TOKEN");
			System.exit(-1);
		}
		
		// start bot
		Elemental app = new Elemental();
		app.start(args);
	}
}
