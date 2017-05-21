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
	public static List<String> sulphur = new ArrayList<String>();
	public static List<String> chlorine = new ArrayList<String>();
	public static List<String> argon = new ArrayList<String>();
	public static List<String> potassium = new ArrayList<String>();
	public static List<String> calcium = new ArrayList<String>();

	public static void init() {

		hydrogen = addDefaultFactsAndRegister(hydrogen, EnumElements.HYDROGEN);
		helium = addDefaultFactsAndRegister(helium, EnumElements.HELIUM);
		lithium = addDefaultFactsAndRegister(lithium, EnumElements.LITHIUM);
		beryllium = addDefaultFactsAndRegister(beryllium, EnumElements.BERYLLIUM);
		boron = addDefaultFactsAndRegister(boron, EnumElements.BORON);
		carbon = addDefaultFactsAndRegister(carbon, EnumElements.CARBON);
		nitrogen = addDefaultFactsAndRegister(nitrogen, EnumElements.NITROGEN);
		fluorine = addDefaultFactsAndRegister(fluorine, EnumElements.FLUORINE);
		neon = addDefaultFactsAndRegister(neon, EnumElements.NEON);
		sodium = addDefaultFactsAndRegister(sodium, EnumElements.SODIUM);
		magnesium = addDefaultFactsAndRegister(magnesium, EnumElements.MAGNESUIM);
		aluminium = addDefaultFactsAndRegister(aluminium, EnumElements.ALUMINIUM);
		silicon = addDefaultFactsAndRegister(silicon, EnumElements.SILICON);
		phosphorus = addDefaultFactsAndRegister(phosphorus, EnumElements.PHOSPHORUS);
		sulphur = addDefaultFactsAndRegister(sulphur, EnumElements.SULPHUR);
		chlorine = addDefaultFactsAndRegister(chlorine, EnumElements.CHLORINE);
		argon = addDefaultFactsAndRegister(argon, EnumElements.ARGON);
		potassium = addDefaultFactsAndRegister(potassium, EnumElements.POTASSIUM);
		calcium = addDefaultFactsAndRegister(calcium, EnumElements.CALCIUM);

/*		facts.put("hydrogen", hydrogen);
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
		facts.put("sulphur", sulphur);
		facts.put("chlorine", chlorine);*/
	}

	private static List<String> addDefaultFactsAndRegister(List<String> l, EnumElements e) {

		l.add("The atomic weight of " + e.name.toLowerCase() + " is " + e.weight);
		l.add("The atomic number of " + e.name.toLowerCase() + " is " + e.number);
		l.add("The group of " + e.name.toLowerCase() + " is " + e.group);
		l.add("The symbol of " + e.name.toLowerCase() + " is " + e.symbol);
		l.add("The period of " + e.name.toLowerCase() + " is " + e.period);

		facts.put(e.name.toLowerCase(), l);

		return l;
	}

	@SuppressWarnings("unused")
	private static List<String> addDefaultFacts(List<String> l, EnumElements e) {

		l.add("The atomic weight of " + e.name.toLowerCase() + " is " + e.weight);
		l.add("The atomic number of " + e.name.toLowerCase() + " is " + e.number);
		l.add("The group of " + e.name.toLowerCase() + " is " + e.group);
		l.add("The symbol of " + e.name.toLowerCase() + " is " + e.symbol);
		l.add("The period of " + e.name.toLowerCase() + " is " + e.period);

		return l;
	}
}
