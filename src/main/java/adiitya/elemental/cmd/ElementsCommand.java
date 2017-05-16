package adiitya.elemental.cmd;

import adiitya.elemental.elements.Elements;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class ElementsCommand implements CommandExecutor {

	@Command(aliases = {"!elements", "!els"})
	public String execute() {
		
		String elements = "";
		
		for (int i = 0; i < Elements.getElements().size(); i++) {
			
			elements += "``" + Elements.getElements().get(i).getName() + "``\n";
		}
		
		return "All registered elements:\n" + elements;
	}
}
