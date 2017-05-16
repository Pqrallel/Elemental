package adiitya.elemental.cmd;

import java.util.Random;

import adiitya.elemental.Elemental;
import adiitya.elemental.elements.Elements;
import adiitya.elemental.elements.elements.Element;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class FactCommand implements CommandExecutor {

	@Command(aliases = {"!fact", "!f"}, usage = "!fact <element>")
	public String execute(String[] args) {
		
		if (args.length < 1)
			return "You didn't enter an element! Usage: ``" + Elemental.handler.getCommands().get(4).getCommandAnnotation().usage() + "``";
		
		if (Elements.isElement(args[0])) {
			
			Random rand = new Random();
			Element e = Elements.getElement(args[0]);
			
			int r = rand.nextInt(e.getFacts().size());
			
			return "Fact about " + e.getName().toLowerCase() + ": " + e.getFacts().get(r);
		}
		
		return "The thing you entered isn't an element!";
	}
}
