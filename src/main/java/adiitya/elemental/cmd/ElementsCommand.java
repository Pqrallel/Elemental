package adiitya.elemental.cmd;

import java.util.ArrayList;
import java.util.List;

import adiitya.elemental.Elemental;
import adiitya.elemental.elements.EnumElements;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.MessageBuilder;

public class ElementsCommand implements CommandExecutor {

	@Command(aliases = { "!elements", "!els" }, usage = "!elements <page>")
	public String execute(IUser u) {
		
		List<EnumElements> elements = EnumElements.getElementsAsList();
		List<String> lines = new ArrayList<>();
		StringBuilder b = new StringBuilder();
				
		for (EnumElements e : elements)
			lines.add(String.format("``%s (%s)``\n", e.name, e.symbol));
		
		for (int i = 0; i < lines.size(); i++) {
			
			if (i == lines.size() / 2) {
				
				new MessageBuilder(Elemental.bot).appendContent(b.toString()).withChannel(u.getOrCreatePMChannel()).build();
				b = new StringBuilder();
			}
			
			b.append(lines.get(i));
		}
		
		new MessageBuilder(Elemental.bot).appendContent(b.toString()).withChannel(u.getOrCreatePMChannel()).build();
		
		return "The list of elements has been sent to your DMs!";
	}
}
