package adiitya.elemental.cmd;

import adiitya.elemental.Elemental;
import adiitya.elemental.WikiAPI;
import adiitya.elemental.elements.Elements;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import sx.blah.discord.handle.obj.IChannel;

public class ElementCommand implements CommandExecutor {

	@Command(aliases = { "!element", "!el"}, usage = "!element <element>")
	public String execute(String[] args, IChannel c) {

		if (args.length < 1)
			return "You did not specify an element! Usage: ``"
					+ Elemental.handler.getCommands().get(0).getCommandAnnotation().usage() + "``";

		String url = "";
		String id = "";
		int type = Elements.getType(args[0]);
		String element = Elements.getElementName(type, args[0]);

		if (Elements.isElement(element)) {
		
			try {
				id = WikiAPI.requestPageId(element, c);
				url = WikiAPI.requestPageUrl(id);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return url;
		}

		return "You did not enter an element or the element you entered isn't registered!";
	}
}
