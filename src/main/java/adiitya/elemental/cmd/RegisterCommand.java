package adiitya.elemental.cmd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class RegisterCommand implements CommandExecutor {

	@Command(aliases = {"!reg"}, usage = "!reg <name> <symbol> <weight> <number> <group> <period>")
	public String execute(String[] args) {
		
		if (args.length < 6)
			return "You didn't enter enough data.";
		
		String name = "";
		String symbol = "";
		float weight;
		int number;
		int group;
		int period;
		
		try {
			
			name = args[0];
			symbol = args[1];
			weight = Float.parseFloat(args[2]);
			number = Integer.parseInt(args[3]);
			group = Integer.parseInt(args[4]);
			period = Integer.parseInt(args[5]);
		} catch (NumberFormatException e) {
			
			return "1 or more of the values entered are incorrect.";
		}
		
		StringBuilder b = new StringBuilder(name.toUpperCase() + "(");
		b.append("\"" + name + "\"" + ", ");
		b.append("\"" + symbol + "\"" + ", ");
		b.append(weight + "f" + ", ");
		b.append(number + ", ");
		b.append(group + ", ");
		b.append(period + ")");
		
		String element = b.toString();
		File f = new File("elements.txt");
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(f));
			String temp;
			b = new StringBuilder();
			
			while ((temp = br.readLine()) != null)
				b.append(temp + "\n");
			
			br.close();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(b.toString() + element);
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
			return "The element you entered couldn't be registered!";
		}
		
		return "Element registered as " + element;
	}
}
