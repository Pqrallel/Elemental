package adiitya.elemental.cmd;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class RepoCommand implements CommandExecutor {

	@Command(aliases = {"!source", "!code", "!repo"}, usage = "!repo")
	public String execute() {
		
		return "https://github.com/AdityaSF/Elemental";
	}
}
