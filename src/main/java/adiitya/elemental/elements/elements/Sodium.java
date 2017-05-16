package adiitya.elemental.elements.elements;

import java.util.List;

public class Sodium extends Element {

	public Sodium() {

		super("Sodium", "Na", 11, 22.9897f, 1);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of sodium is " + this.getWeight());
		facts.add("The atomic number of sodium is " + this.getNumber());
		facts.add("The group of sodium is " + this.getGroup());
		facts.add("The symbol of sodium is " + this.getSymbol());
		
		this.setFacts(facts);
	}

}
