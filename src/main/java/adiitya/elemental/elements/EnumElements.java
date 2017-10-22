package adiitya.elemental.elements;

import java.util.Arrays;
import java.util.List;

public enum EnumElements {

	NEUTRONIUM("Neutronium", "Nu", 1.008f, 0, 18, 0),
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
	CALCIUM("Calcium", "Ca", 40.078f, 20, 2, 4),
	SCANDIUM("Scandium", "Sc", 44.956f, 21, 3, 4),
	TITANIUM("Titanium", "Ti", 47.867f, 22, 4, 4),
	VANADIUM("Vanadium", "V", 50.942f, 23, 5, 4),
	CHROMIUM("Chromium", "Cr", 51.996f, 24, 6, 4),
	MANGANESE("Manganese", "Mn", 54.938f, 25, 7, 4),
	IRON("Iron", "Fe", 55.845f, 26, 8, 4),
	COBALT("Cobalt", "Co", 58.933f, 27, 9, 4),
	NICKEL("Nickel", "Ni", 58.693f, 28, 10, 4),
	COPPER("Copper", "Cu", 63.546f, 29, 11, 4),
	ZINC("Zinc", "Zn", 65.38f, 30, 12, 4),
	GALLIUM("Gallium", "Ga", 69.723f, 31, 13, 4),
	GERMANIUM("Germanium", "Ge", 72.631f, 32, 14, 4),
	ARSENIC("Arsenic", "As", 74.922f, 33, 15, 4),
	SELENIUM("Selenium", "Se", 78.972f, 34, 16, 4),
	BROMINE("Bromine", "Br", 79.904f, 35, 17, 4),
	KRYPTON("Krypton", "Kr", 84.798f, 36, 18, 4),
	RUBIDIUM("Rubidium", "Rb", 85.468f, 37, 1, 5),
	STRONTIUM("Strontium", "Sr", 87.62f, 38, 2, 5),
	YTTRIUM("Yttrium", "Y", 88.906f, 39, 3, 5),
	ZIRCONIUM("Zirconium", "Zr", 91.224f, 40, 4, 5),
	NIOBIUM("Niobium", "Nb", 92.906f, 41, 5, 5),
	MOLYBDENUM("Molybdenum", "Mo", 95.95f, 42, 6, 5),
	TECHNETIUM("Technetium", "Tc", 98.907f, 43, 7, 5),
	RUTHENIUM("Ruthenium", "Ru", 101.07f, 44, 8, 5),
	RHODIUM("Rhodium", "Rh", 102.906f, 45, 9, 5),
	PALLADIUM("Palladium", "Pd", 106.42f, 46, 10, 5),
	SILVER("Silver", "Ag", 107.868f, 47, 11, 5),
	CADMIUM("Cadmium", "Cd", 112.411f, 48, 12, 5),
	INDIUM("Indium", "In", 114.818f, 49, 13, 5),
	TIN("Tin", "Sn", 118.711f, 50, 14, 5),
	ANTIMONY("Antimony", "Sb", 121.76f, 51, 15, 5),
	TELLURIUM("Tellurium", "Te", 127.6f, 52, 16, 5),
	IODINE("Iodine", "I", 126.904f, 53, 17, 5),
	XENON("Xenon", "Xe", 131.294f, 54, 18, 5),
	CAESIUM("Caesium", "Cs", 132.905f, 55, 1, 6),
	BARIUM("Barium", "Ba", 137.328f, 56, 2, 6),
	LANTHANUM("Lanthanum", "La", 138.905f, 57, 3, 6),
	CERIUM("Cerium", "Ce", 140.116f, 58, -1, 6),
	PRASEODYMIUM("Praseodymium", "Pr", 140.908f, 59, -1, 6),
	NEODYMIUM("Neodymium", "Nd", 144.242f, 60, -1, 6),
	PROMETHIUM("Promethium", "Pm", 144.913f, 61, -1, 6),
	SAMARIUM("Samarium", "Sm", 150.36f, 62, -1, 6),
	EUROPIUM("Europium", "Eu", 151.964f, 63, -1, 6),
	GADOLINIUM("Gadolinium", "Gd", 157.25f, 64, -1, 6),
	TERBIUM("Terbium", "Tb", 158.925f, 65, -1, 6),
	DYSPROSIUM("Dysprosium", "Dy", 162.5f, 66, -1, 6),
	HOLMIUM("Holmium", "Ho", 164.93f, 67, -1, 6),
	ERBIUM("Erbium", "Er", 167.259f, 68, -1, 6),
	THULIUM("Thulium", "Tm", 168.934f, 69, -1, 6),
	YTTERBIUM("Ytterbium", "Yb", 173.055f, 70, -1, 6),
	LUTETIUM("Lutetium", "Lu", 174.967f, 71, -1, 6),
	HAFNIUM("Hafnium", "Hf", 178.49f, 72, 4, 6),
	TANTALUM("Tantalum", "Ta", 180.948f, 73, 5, 6),
	TUNGSTEN("Tungsten", "W", 183.84f, 74, 6, 6),
	RHENIUM("Rhenium", "Re", 186.207f, 75, 7, 6),
	OSMIUM("Osmium", "Os", 190.23f, 76, 8, 6),
	IRIDIUM("Iridium", "Ir", 192.217f, 77, 9, 6),
	PLATINUM("Platinum", "Pt", 195.085f, 78, 10, 6),
	GOLD("Gold", "Au", 196.967f, 79, 11, 6),
	MERCURY("Mercury", "Hg", 200.592f, 80, 12, 6),
	THALLIUM("Thallium", "Tl", 204.383f, 81, 13, 6),
	LEAD("Lead", "Pb", 207.2f, 82, 14, 6),
	BISMUTH("Bismuth", "Bi", 208.98f, 83, 15, 6),
	POLONIUM("Polonium", "Po", 208.982f, 84, 16, 6), // estimated
	ASTATINE("Astatine", "At", 209.987f, 85, 17, 6),
	RADON("Radon", "Rn", 222.018f, 86, 18, 6),
	FRANCIUM("Francium", "Fr", 223.02f, 87, 1, 7),
	RADIUM("Radium", "Ra", 226.025f, 88, 2, 7),
	ACTINIUM("Actinium", "Ac", 227.028f, 89, 3, 7),
	THORIUM("Thorium", "Th", 232.038f, 90, -1, 7),
	PROTACTINIUM("Protactinium", "Pa", 231.036f, 91, -1, 7),
	URANIUM("Uranium", "U", 238.029f, 92, -1, 7),
	NEPTUNIUM("Neptunium", "Np", 237.048f, 93, -1, 7),
	PLUTONIUM("Plutonium", "Pu", 244.064f, 94, -1, 7),
	AMERICIUM("Americium", "Am", 243.061f, 95, -1, 7),
	CURIUM("Curium", "Cm", 247.07f, 96, -1, 7),
	BERKELIUM("Berkelium", "Bk", 247.07f, 97, -1, 7),
	CALIFORNIUM("Californium", "Cf", 251.08f, 98, -1, 7),
	EINSTEINIUM("Einsteinium", "Es", 254.0f, 99, -1, 7),
	FERMIUM("Fermium", "Fm", 257.095f, 100, -1, 7),
	MENDELEVIUM("Mendelevium", "Md", 258.1f, 101, -1, 7),
	NOBELIUM("Nobelium", "No", 259.101f, 102, -1, 7),
	LAWRENCIUM("Lawrencium", "Lr", 262.0f, 103, -1, 7), //estimated
	RUTHERFORDIUM("Rutherfordium", "Rf", 261.0f, 104, 4, 7), //estimated
	DUBNIUM("Dubnium", "Db", 262.0f, 105, 5, 7), //estimated
	SEABORGIUM("Seaborgium", "Sg", 266.0f, 106, 6, 7), //estimated
	BOHRIUM("Bohrium", "Bh", 264.0f, 107, 7, 7), //estimated
	HASSIUM("Hassium", "Hs", 269.0f, 108, 8, 7), //estimated
	MEITNERIUM("Meitnerium", "Mt", 268.0f, 109, 9, 7), //estimated
	DARMSTADTIUM("Darmstadtium", "Ds", 269.0f, 110, 10, 7), //estimated
	ROENTGENIUM("Roentgenium", "Rg", 272.0f, 111, 11, 7), //estimated
	COPERNICIUM("Copernicium", "Cn", 277.0f, 112, 12, 7), //estimated
	NIHONIUM("Nihonium", "Nh", -1.0f, 113, 13, 7), //estimated
	FLEROVIUM("Flerovium", "Fl", 289.0f, 114, 14, 7), //estimated
	MOSCOVIUM("Moscovium", "Mc", -1.0f, 115, 15, 7), //estimated
	LIVERMORIUM("Livermorium", "Lv", 298.0f, 116, 16, 7), //estimated
	TENNESSINE("Tennessine", "Ts", -1.0f, 117, 17, 7), //estimated
	OGANESSON("Oganesson", "Og", -1.0f, 118, 18, 7), //estimated
	UNUNENNIUM("Ununennium", "Uue", -1.0f, 119, 1, 8), //estimated
	UNBINILIUM("Unbinilium", "Ubn", -1.0f, 120, 2, 8), //estimated
	UNBIUNIUM("Unbiunium", "Ubu", -1.0f, 121, 3, 8); //estimated

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

		return null;
	}

	public static EnumElements getElementBySymbol(String name) {

		for (EnumElements e : getElementsAsList())
			if (e.symbol.equalsIgnoreCase(name))
				return e;

		return null;
	}

	public static List<EnumElements> getElementsAsList() {

		return Arrays.asList(EnumElements.values());
	}

	public static boolean isElement(String name) {

		int type = getType(name);

		return type != TYPE_INVALID && (type == TYPE_SYMBOL || type == TYPE_NAME);

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
