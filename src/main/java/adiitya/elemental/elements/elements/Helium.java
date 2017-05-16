package adiitya.elemental.elements.elements;

import java.util.List;

public class Helium extends Element {

	public Helium() {

		super("Helium", "He", 2, 4.0026f, 18);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of helium is " + this.getWeight());
		facts.add("The atomic number of helium is " + this.getNumber());
		facts.add("The group of helium is " + this.getGroup());
		facts.add("The symbol of helium is " + this.getSymbol());
		
		this.setFacts(facts);
	}
}
