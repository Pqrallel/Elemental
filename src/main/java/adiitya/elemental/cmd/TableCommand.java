package adiitya.elemental.cmd;

import adiitya.elemental.Elemental;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.MessageBuilder;

public class TableCommand implements CommandExecutor {

	@Command(aliases = {"!pt"}, description = "Sends a photo of the periodic table", usage = "!pt")
	public IMessage execute(String[] args, IChannel c) {
		
		return new MessageBuilder(Elemental.bot).withFile(this.getClass().getResourceAsStream("/table.png"), "png").withChannel(c).build();
	}
}
