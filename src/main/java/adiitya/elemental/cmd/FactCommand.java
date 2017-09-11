package adiitya.elemental.cmd;

import adiitya.elemental.elements.EnumElements;
import adiitya.elemental.elements.Facts;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class FactCommand implements CommandExecutor {

	@Command(aliases = {"!fact", "!f"}, usage = "!fact [element]")
	public String execute(String[] args) {
		
		if (args.length < 1)
			return Facts.getFact();
		
		if (EnumElements.isElement(args[0])) {

			String element = EnumElements.getElementName(args[0]);
			
			return Facts.getFact(element);
		}
		
		if (args.length > 1)
			if (args[0].equalsIgnoreCase("list"))
				return Facts.getFacts(EnumElements.getElementByName(EnumElements.getElementName(args[1])));
		
		return "The thing you entered isn't an element!";
	}
}
