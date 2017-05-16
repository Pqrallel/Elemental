package adiitya.elemental.elements;

import java.util.ArrayList;
import java.util.List;

import adiitya.elemental.elements.elements.Beryllium;
import adiitya.elemental.elements.elements.Boron;
import adiitya.elemental.elements.elements.Carbon;
import adiitya.elemental.elements.elements.Element;
import adiitya.elemental.elements.elements.Fluorine;
import adiitya.elemental.elements.elements.Helium;
import adiitya.elemental.elements.elements.Hydrogen;
import adiitya.elemental.elements.elements.Lithium;
import adiitya.elemental.elements.elements.Magnesium;
import adiitya.elemental.elements.elements.Neon;
import adiitya.elemental.elements.elements.Nitrogen;
import adiitya.elemental.elements.elements.Oxygen;
import adiitya.elemental.elements.elements.Sodium;
import lombok.Getter;

public class Elements {

	@Getter
	private static List<Element> elements = new ArrayList<Element>();

	public static final int TYPE_NAME = 0;
	public static final int TYPE_SYMBOL = 1;
	public static final int TYPE_INVALID = 2;

	public static Element hydrogen = new Hydrogen();
	public static Element helium = new Helium();
	public static Element lithium = new Lithium();
	public static Element beryllium = new Beryllium();
	public static Element boron = new Boron();
	public static Element carbon = new Carbon();
	public static Element nitrogen = new Nitrogen();
	public static Element oxygen = new Oxygen();
	public static Element fluorine = new Fluorine();
	public static Element neon = new Neon();
	public static Element sodium = new Sodium();
	public static Element magnesium = new Magnesium();

	public static void init() {

		elements.add(hydrogen);
		elements.add(helium);
		elements.add(lithium);
		elements.add(beryllium);
		elements.add(boron);
		elements.add(carbon);
		elements.add(nitrogen);
		elements.add(oxygen);
		elements.add(fluorine);
		elements.add(neon);
		elements.add(sodium);
		elements.add(magnesium);
	}
	
	public static boolean isElement(String name) {
		
		int type = getType(name);
		
		if (type == TYPE_INVALID)
			return false;
		else if (type == TYPE_SYMBOL)
			return true;
		else if (type == TYPE_NAME)
			return true;
		
		return false;
	}
	
	public static Element getElement(String name) {
		
		Element element = null;
		
		if (isElement(name)) {
			
			String e = getElementName(name);
			
			for (Element el : elements)
				if (el.getName().equalsIgnoreCase(e))
					element = el;
		}
		
		return element;
	}
	
	public static String getElementName(String name) {

		int type = getType(name);
		
		return getElementName(type, name);
	}

	public static String getElementName(int type, String name) {

		if (type == TYPE_SYMBOL)
			for (Element e : elements) {
				
				if (e.getSymbol().equalsIgnoreCase(name))
					return e.getName();
			}
		
		if (type == TYPE_NAME)
			for (Element e : elements) {
				
				if (e.getName().equalsIgnoreCase(name))
					return e.getName();
			}
		
		return null;
	}

	public static int getType(String s) {

		for (Element e : elements) {

			if (e.getName().equalsIgnoreCase(s))
				return TYPE_NAME;

			if (e.getSymbol().equalsIgnoreCase(s))
				return TYPE_SYMBOL;
		}

		return TYPE_INVALID;
	}
}
