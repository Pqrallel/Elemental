package adiitya.elemental.elements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Facts {

	private static Map<String, List<String>> facts = new HashMap<String, List<String>>();
	private static JsonObject root;

	public static void load() {

		facts.clear();

		for (EnumElements e : EnumElements.getElementsAsList()) {

			List<String> l = new ArrayList<String>();
			String group = e.group < 0 ? "unknown" : "" + e.group;
			String weight = e.weight < 0f ? "unknown" : "" + e.weight;

			l.add(String.format("The symbol of %s is %s", e.name.toLowerCase(), e.symbol));
			l.add(String.format("The group of %s is %s", e.name.toLowerCase(), group));
			l.add(String.format("The atomic weight of %s is %s", e.name.toLowerCase(), weight));
			l.add(String.format("The atomic number of %s is %s", e.name.toLowerCase(), e.number));
			l.add(String.format("The period of %s is %s", e.name.toLowerCase(), e.period));

			facts.put(e.name, l);
		}

		loadJson();
	}

	private static void loadJson() {

		StringBuilder b = new StringBuilder();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		BufferedReader br = null;
		File f = new File("facts.json");

		try {

			if (!f.exists())
				f.createNewFile();

			br = new BufferedReader(new FileReader(f));

			String temp;
			if ((temp = br.readLine()) == null) {

				br.close();
				return;
			}

			b.append(temp);

			while ((temp = br.readLine()) != null)
				b.append(temp);

			br.close();

			root = gson.fromJson(b.toString(), JsonObject.class);
		} catch (IOException e) {

			e.printStackTrace();
		}

		registerFacts();
	}

	private static void registerFacts() {

		for (EnumElements e : EnumElements.getElementsAsList()) {

			List<String> l = facts.get(e.name);

			if (root.has(e.symbol)) {

				JsonArray o = root.get(e.symbol).getAsJsonArray();

				for (int i = 0; i < o.size(); i++) {

					l.add(o.get(i).getAsString());
				}

				facts.put(e.name, l);
			}
		}
	}

	
	public static boolean addFact(EnumElements element, String fact) {
	
		if (root.has(element.symbol)) {

			JsonArray o = root.get(element.symbol).getAsJsonArray();
			o.add(fact);
			root.add(element.symbol, o);

			writeJsonToFile(root);
			
			return true;
		} else if(!root.has(element.symbol)) {
			
			JsonArray o = new JsonArray();
			o.add(fact);
			root.add(element.symbol, o);
			
			writeJsonToFile(root);
			
			return true;
		}
		
		return false;
	}
	
	public static String removeFact(EnumElements e, String fact) {
		
		if (root.has(e.symbol)) {
			
			JsonArray o = root.get(e.symbol).getAsJsonArray();
			
			for (int i = 0; i < o.size(); i++) {
				
				
				if (o.get(i).getAsString().equalsIgnoreCase(fact)) {
				
					o.remove(i);
					root.add(e.symbol, o);
					writeJsonToFile(root);
					return String.format("Fact \"%s\" removed from %s", fact, e.name.toLowerCase());
				}
			}
			
			return String.format("%s doesn't exist for %s", fact, e.name.toLowerCase());
		} else {
			
			return String.format("Fact \"%s\" for %s does not exist!", fact, e.name.toLowerCase());
		}
	}
	
	public static String getFacts(EnumElements e) {
		
		List<String> f = facts.get(e.name);
		StringBuilder b = new StringBuilder();
		
		for (String s : f) {
			
			b.append(String.format("``%s``\n", s));
		}
		
		return String.format("Facts for %s:\n%s", e.name.toLowerCase(), b.toString());
	}

	public static String getFact() {

		Random rand = new Random();
		int r = rand.nextInt(EnumElements.getElementsAsList().size());

		EnumElements e = EnumElements.getElementsAsList().get(r);

		return getFact(e.name);
	}

	public static String getFact(String name) {

		List<String> f = facts.get(name);
		Random rand = new Random();
		int r = rand.nextInt(f.size());

		return f.get(r);
	}
	
	private static void writeJsonToFile(JsonElement e) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(e);
		File f = new File("facts.json");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(json);
			bw.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	}
}
