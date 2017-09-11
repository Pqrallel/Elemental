package adiitya.elemental.cmd;

import adiitya.elemental.Elemental;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Permissions;
import sx.blah.discord.util.MessageBuilder;

public class StopCommand implements CommandExecutor {

	@Command(aliases = {"!stop"})
	public String execute(String[] args, IUser u, IGuild g, IChannel c) {
		
		if (u.getPermissionsForGuild(g).contains(Permissions.ADMINISTRATOR)) {
			
			new MessageBuilder(Elemental.bot).appendContent("Stopping and logging out!").withChannel(c).build();
			System.exit(0);
		}
		
		return "You don't have permissions for that!";
	}
}
