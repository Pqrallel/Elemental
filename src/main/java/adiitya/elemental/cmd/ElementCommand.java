package adiitya.elemental.cmd;

import adiitya.elemental.Elemental;
import adiitya.elemental.api.WikiAPI;
import adiitya.elemental.elements.EnumElements;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class ElementCommand implements CommandExecutor {

	@Command(aliases = { "!element", "!el"}, usage = "!element <element>")
	public String execute(String[] args) {

		if (args.length < 1)
			return String.format("You did not specify an element! Usage: ``%s``", Elemental.handler.getCommands().get(0).getCommandAnnotation().usage());
		
		boolean debug = false;
		
		if (args.length >= 2) {
			
			for (int i = 0; i < args.length; i++) {
				
				if (args[i].equalsIgnoreCase("-debug") || args[i].equalsIgnoreCase("--d"))
					debug = true;
			}
		}

		String url = "";
		String id = "";
		String element = EnumElements.getElementName(args[0]);
		long start = System.currentTimeMillis();
		long end = 0;
		
		if (EnumElements.isElement(element)) {
		
			try {
				id = WikiAPI.requestPageId(element);
				url = WikiAPI.requestPageUrl(id);
				end = System.currentTimeMillis();
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return debug ? "**The API request took " + (end - start) + " milliseconds (" + (double) (end - start) / 1000d + " seconds)**\n" + url : url;
		}

		return "You did not enter an element!";
	}
}
