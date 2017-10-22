package adiitya.elemental.cmd;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Permissions;

public class StopCommand implements CommandExecutor {

	@Command(aliases = {"!stop"})
	public String execute(IUser u, IGuild g, IChannel c) {

		if (u.getPermissionsForGuild(g).contains(Permissions.ADMINISTRATOR)) {

			c.sendMessage("Stopping and logging out!");
			System.exit(0);
		}

		return "You don't have permissions for that!";
	}
}
