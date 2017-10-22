package adiitya.elemental.cmd;

import adiitya.elemental.elements.EnumElements;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class PropertyCommand implements CommandExecutor {

	private final String ATOMIC_NUMBER = "atomic_number";
	private final String ATOMIC_WEIGHT = "atomic_weight";
	private final String PERIOD = "period";

	@Command(aliases = { "!property", "!p" }, usage = "!property <element | all | list> <property>")
	public String execute(String[] args) {

		if (args.length < 1)
			return "Invalid arguments! Usage: ``!property <element | all | list> <property>``";

		String element = args[0];
		String property = args.length > 1 ? args[1] : null;
		StringBuilder b = new StringBuilder();

		if (EnumElements.isElement(element))
			element = EnumElements.getElementName(element);
		else if (!element.equalsIgnoreCase("all") && !element.equalsIgnoreCase("list"))
			return element + " is not an element!";

		if (element.equalsIgnoreCase("all")) {

			if (args.length < 2)
				return "You didn't enter a property, silly!";
			
			if (property.equalsIgnoreCase(ATOMIC_NUMBER))
				for (EnumElements e : EnumElements.getElementsAsList())
					b.append("``").append(e.name).append(" (").append(e.symbol).append("): ").append(e.number).append("``\n");
			else if (property.equalsIgnoreCase(ATOMIC_WEIGHT))
				for (EnumElements e : EnumElements.getElementsAsList())
					b.append("``").append(e.name).append(" (").append(e.symbol).append("): ").append(e.weight).append("``\n");
			else if (property.equalsIgnoreCase(PERIOD))
				for (EnumElements e : EnumElements.getElementsAsList())
					b.append("``").append(e.name).append(" (").append(e.symbol).append("): ").append(e.period).append("``\n");
			else 
				return property + " is not a valid property. Do ``!property list`` to see a list of properties!";
		} else if (element.equalsIgnoreCase("list")) {

			return "```" + ATOMIC_NUMBER + " - The atomic number of the element.\n" + ATOMIC_WEIGHT
					+ " - The atomic weight of the element.\n"
					+ PERIOD + " - The period of the element.```\n";
		} else {

			EnumElements e = EnumElements.getElementByName(element);

			if (args.length < 2)
				return "You didn't enter a property, silly!";
			
			if (property.equalsIgnoreCase(ATOMIC_NUMBER))
					b.append("``" + e.name + " (" + e.symbol + "): " + e.number + "``\n");
			else if (property.equalsIgnoreCase(ATOMIC_WEIGHT))
					b.append("``" + e.name + " (" + e.symbol + "): " + e.weight + "``\n");
			else if (property.equalsIgnoreCase(PERIOD))
					b.append("``" + e.name + " (" + e.symbol + "): " + e.period + "``\n");
			else 
				return property + " is not a valid property. Do ``!property list`` to see a list of properties!";
		}

		return b.toString();
	}
}
