package adiitya.elemental.cmd;

import adiitya.elemental.elements.EnumElements;
import adiitya.elemental.elements.Facts;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Permissions;

public class RemoveFactCommand implements CommandExecutor {

	@Command(aliases = {"!fremove"}, usage = "!fremove <element> <fact>")
	public String execute(String[] args, IUser u, IGuild g) {
		
		if (!u.getPermissionsForGuild(g).contains(Permissions.ADMINISTRATOR))
			return "You don't have permissions for that!";
		
		if (args.length < 2)
			return "Invalid arguments! Usage: ``!fremove <element> <fact>``";
		
		EnumElements e = EnumElements.getElementByName(EnumElements.getElementName(args[0]));
		StringBuilder b = new StringBuilder();

		if (e == null)
			return args[0] + " is not a valid element";
		
		for (int i = 1; i < args.length; i++)
			b.append(args[i]).append(" ");
		
		return Facts.removeFact(e, b.toString().substring(0, b.toString().length() - 1));
	}
}
