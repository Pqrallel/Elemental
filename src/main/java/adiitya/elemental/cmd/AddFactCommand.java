package adiitya.elemental.cmd;

import adiitya.elemental.elements.EnumElements;
import adiitya.elemental.elements.Facts;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Permissions;

public class AddFactCommand implements CommandExecutor {

	@Command(aliases = {"!fadd", "!factadd"}, usage = "!factadd <element> <fact>")
	public String execute(String[] args, IUser u, IGuild g) {
		
		if (!u.getPermissionsForGuild(g).contains(Permissions.ADMINISTRATOR))
			return "You dont have permissions for that!";
		
		if (args.length < 2)
			return "Invalid arguments! Usage: ``!fadd <element> <fact>``";
		
		EnumElements e = EnumElements.getElementByName(EnumElements.getElementName(args[0]));
		StringBuilder b = new StringBuilder();
		
		for (int i = 1; i < args.length; i++)
			b.append(args[i] + " ");
		
		return Facts.addFact(e, b.toString().substring(0, b.length()-1)) ? "Fact successfully registered! ``!freload`` to reload facts!" : "Could not register your fact!";
	}
}
