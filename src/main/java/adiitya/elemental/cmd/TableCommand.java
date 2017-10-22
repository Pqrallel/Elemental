package adiitya.elemental.cmd;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import sx.blah.discord.handle.obj.IChannel;

public class TableCommand implements CommandExecutor {

	@Command(aliases = {"!pt"}, description = "Sends a photo of the periodic table", usage = "!pt")
	public void execute(String[] args, IChannel c) {

		c.sendFile("", false, this.getClass().getResourceAsStream("/table.png"), "table.png");
	}
}
