package adiitya.elemental.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facts {

	public static Map<String, List<String>> facts = new HashMap<String, List<String>>();
	
	public static List<String> hydrogen = new ArrayList<String>();
	public static List<String> helium = new ArrayList<String>();
	public static List<String> lithium = new ArrayList<String>();
	public static List<String> beryllium = new ArrayList<String>();
	public static List<String> boron = new ArrayList<String>();
	public static List<String> carbon = new ArrayList<String>();
	public static List<String> nitrogen = new ArrayList<String>();
	public static List<String> fluorine = new ArrayList<String>();
	public static List<String> neon = new ArrayList<String>();
	public static List<String> sodium = new ArrayList<String>();
	public static List<String> magnesium = new ArrayList<String>();
	public static List<String> aluminium = new ArrayList<String>();
	public static List<String> silicon = new ArrayList<String>();
	public static List<String> phosphorus = new ArrayList<String>();

	public static void init() {

		hydrogen = addDefaultFacts(hydrogen, EnumElements.HYDROGEN);
		helium = addDefaultFacts(helium, EnumElements.HELIUM);
		lithium = addDefaultFacts(lithium, EnumElements.LITHIUM);
		beryllium = addDefaultFacts(beryllium, EnumElements.BERYLLIUM);
		boron = addDefaultFacts(boron, EnumElements.BORON);
		carbon = addDefaultFacts(carbon, EnumElements.CARBON);
		nitrogen = addDefaultFacts(nitrogen, EnumElements.NITROGEN);
		fluorine = addDefaultFacts(fluorine, EnumElements.FLUORINE);
		neon = addDefaultFacts(neon, EnumElements.NEON);
		sodium = addDefaultFacts(sodium, EnumElements.SODIUM);
		magnesium = addDefaultFacts(magnesium, EnumElements.MAGNESUIM);
		aluminium = addDefaultFacts(aluminium, EnumElements.ALUMINIUM);
		silicon = addDefaultFacts(silicon, EnumElements.SILICON);
		phosphorus = addDefaultFacts(phosphorus, EnumElements.PHOSPHORUS);
		
		facts.put("hydrogen", hydrogen);
		facts.put("helium", helium);
		facts.put("lithium", lithium);
		facts.put("beryllium", beryllium);
		facts.put("boron", boron);
		facts.put("carbon", carbon);
		facts.put("nitrogen", nitrogen);
		facts.put("fluorine", fluorine);
		facts.put("neon", neon);
		facts.put("sodium", sodium);
		facts.put("magnesium", magnesium);
		facts.put("aluminium", aluminium);
		facts.put("silicon", silicon);
		facts.put("phosphorus", phosphorus);
	}
	
	private static List<String> addDefaultFacts(List<String> l, EnumElements e) {
		
		l.add("The atomic weight of " + e.name.toLowerCase() + " is " + e.weight);
		l.add("The atomic number of " + e.name.toLowerCase() + " is " + e.number);
		l.add("The group of " + e.name.toLowerCase() + " is " + e.group);
		l.add("The symbol of " + e.name.toLowerCase() + " is " + e.symbol);
		l.add("The period of " + e.name.toLowerCase() + " is " + e.period);
		
		return l;
	}
}
