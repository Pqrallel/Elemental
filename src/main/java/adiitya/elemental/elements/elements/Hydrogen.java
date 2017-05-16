package adiitya.elemental.elements.elements;

import java.util.List;

public class Hydrogen extends Element {

	public Hydrogen() {

		super("Hydrogen", "H", 1, 1.0079f, 1);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of hydrogen is " + this.getWeight());
		facts.add("The atomic number of hydrogen is " + this.getNumber());
		facts.add("The group of hydrogen is " + this.getGroup());
		facts.add("The symbol of hydrogen is " + this.getSymbol());
		
		this.setFacts(facts);
	}
}
