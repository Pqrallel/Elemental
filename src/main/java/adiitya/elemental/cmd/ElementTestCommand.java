package adiitya.elemental.cmd;

import adiitya.elemental.elements.EnumElements;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class ElementTestCommand implements CommandExecutor {

	@Command(aliases = {"!test"}, usage = "!test <element>")
	public String execute(String[] args) {
		
		if (args.length < 1)
			return "Please specify an element!";
		
		int type = EnumElements.getType(args[0]);
		
		if (type == EnumElements.TYPE_NAME)
			return "You entered an element name!";
		else if (type == EnumElements.TYPE_SYMBOL)
			return "You entered an element symbol!";
		
		return type == EnumElements.TYPE_INVALID ? "You entered an element that isn't registered yet or you didn't enter an element!" : "**An error occurred and your element couldn't be checked!**";
	}
}
