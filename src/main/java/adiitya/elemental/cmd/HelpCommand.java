package adiitya.elemental.cmd;

import adiitya.elemental.Elemental;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import de.btobastian.sdcf4j.CommandHandler.SimpleCommand;

public class HelpCommand implements CommandExecutor {

	@Command(aliases = {"~help", "~h"}, usage = "~help")
	public String execute() {
		
		StringBuilder sb = new StringBuilder();
		String s;
		
		for (SimpleCommand c : Elemental.handler.getCommands()) {
			
			sb.append(c.getCommandAnnotation().aliases()[0] + " - Usage: " + c.getCommandAnnotation().usage() + "\n");
		}
		
		s = sb.toString();
		
		return "```Markdown\n" + s + "```";
	}
}
