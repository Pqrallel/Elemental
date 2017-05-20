package adiitya.elemental.cmd;

import java.util.List;

import adiitya.elemental.elements.EnumElements;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class ElementsCommand implements CommandExecutor {

	@Command(aliases = { "!elements", "!els" }, usage = "!elements")
	public String execute() {

		List<EnumElements> elements = EnumElements.getElementsAsList();
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < elements.size(); i++) {

			b.append("``").append(elements.get(i).name).append(" (").append(elements.get(i).symbol).append(")``\n");
		}

		return "All registered elements:\n" + b.toString();
	}
}
