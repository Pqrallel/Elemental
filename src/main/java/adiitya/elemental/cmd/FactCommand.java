package adiitya.elemental.cmd;

import java.util.List;
import java.util.Random;

import adiitya.elemental.elements.EnumElements;
import adiitya.elemental.elements.Facts;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class FactCommand implements CommandExecutor {

	@Command(aliases = {"!fact", "!f"}, usage = "!fact <element>")
	public String execute(String[] args) {
		
		if (args.length < 1) {
			
			Random rand = new Random();
			String element = EnumElements.getElementName(EnumElements.values()[rand.nextInt(EnumElements.values().length)].name).toLowerCase();
			List<String> facts = Facts.facts.get(element);
			
			int r = rand.nextInt(facts.size());
			
			return facts.get(r);
		}
		
		if (EnumElements.isElement(args[0])) {
			
			Random rand = new Random();
			String element = EnumElements.getElementName(args[0]).toLowerCase();
			List<String> facts = Facts.facts.get(element);
			
			int r = rand.nextInt(facts.size());
			
			return facts.get(r);
		}
		
		return "The thing you entered isn't an element!";
	}
}
