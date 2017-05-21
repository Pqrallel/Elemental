package adiitya.elemental.elements;

import java.util.Arrays;
import java.util.List;

public enum EnumElements {

	HYDROGEN("Hydrogen", "H", 1.0079f, 1, 1, 1), 
	HELIUM("Helium", "He", 4.0026f, 2, 18, 1), 
	LITHIUM("Lithium", "Li", 6.941f, 3, 1, 2), 
	BERYLLIUM("Beryllium", "Be", 9.0122f, 4, 2, 2), 
	BORON("Boron", "B", 10.811f, 5, 13, 2), 
	CARBON("Carbon", "C", 12.0107f, 6, 14, 2), 
	NITROGEN("Nitrogen", "N", 14.0067f, 7, 15, 2), 
	OXYGEN("Oxygen", "O", 15.9994f, 8, 16, 2), 
	FLUORINE("Fluorine", "F", 18.9984f, 9, 17, 2), 
	NEON("Neon", "Ne", 20.1797f, 10, 18, 2), 
	SODIUM("Sodium", "Na", 22.9897f, 11, 1, 3), 
	MAGNESUIM("Magnesium", "Mg", 25.305f, 12, 2, 3), 
	ALUMINIUM("Aluminium", "Al", 26.9815f, 13, 13, 3), 
	SILICON("Silicon", "Si", 20.0855f, 14, 14, 3), 
	PHOSPHORUS("Phosphorus", "P", 30.9738f, 15, 15, 3),
	SULPHUR("Sulphur", "S", 32.065f, 16, 16, 3),
	CHLORINE("Chlorine", "Cl", 35.453f, 17, 17, 3),
	ARGON("Argon", "Ar", 39.948f, 18, 18, 3),
	POTASSIUM("Potassium", "K", 39.098f, 19, 1, 4),
	CALCIUM("Calcium", "Ca", 40.078f, 20, 2, 4);

	public String name;
	public String symbol;
	public float weight;
	public int number;
	public int group;
	public int period;

	public static final int TYPE_NAME = 0;
	public static final int TYPE_SYMBOL = 1;
	public static final int TYPE_INVALID = 2;

	EnumElements(String name, String symbol, float weight, int number, int group, int period) {

		this.name = name;
		this.symbol = symbol;
		this.weight = weight;
		this.number = number;
		this.group = group;
		this.period = period;
	}

	public static EnumElements getElementByName(String name) {

		for (EnumElements e : getElementsAsList())
			if (e.name.equalsIgnoreCase(name))
				return e;

		return (EnumElements) null;
	}

	public static EnumElements getElementBySymbol(String name) {

		for (EnumElements e : getElementsAsList())
			if (e.symbol.equalsIgnoreCase(name))
				return e;

		return (EnumElements) null;
	}

	public static List<EnumElements> getElementsAsList() {

		return Arrays.asList(EnumElements.values());
	}

	// idk what i would use this for but ill keep it
	public String toString() {

		return this.name() + " [name = " + name + "; symbol = " + symbol + "; weight = " + weight + "; number = "
				+ number + "; group = " + group + "; period = " + period + "]";
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

	/**
	 * Convenience method. Calls {@link #getType(String)}, then
	 * {@link #getElementName(int, String)}
	 * 
	 * @param name
	 *            Name of the element. This can be a symbol or a name.
	 * @return The name of the element.
	 */
	public static String getElementName(String name) {

		int type = getType(name);

		return getElementName(type, name);
	}

	public static String getElementName(int type, String name) {

		if (type == TYPE_SYMBOL)
			for (EnumElements e : values()) {

				if (e.symbol.equalsIgnoreCase(name))
					return e.name;
			}
		else if (type == TYPE_NAME)
			for (EnumElements e : values()) {

				if (e.name.equalsIgnoreCase(name))
					return e.name;
			}

		return null;
	}

	public static int getType(String s) {

		for (EnumElements e : values()) {

			if (e.name.equalsIgnoreCase(s))
				return TYPE_NAME;

			if (e.symbol.equalsIgnoreCase(s))
				return TYPE_SYMBOL;
		}

		return TYPE_INVALID;
	}
}
