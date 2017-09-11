package adiitya.elemental.cmd;

import adiitya.elemental.elements.Facts;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class ReloadFactCommand implements CommandExecutor {

	@Command(aliases = {"!freload"})
	public String execute() {
		
		Facts.load();
		
		return "Facts have been reloaded!";
	}
}
