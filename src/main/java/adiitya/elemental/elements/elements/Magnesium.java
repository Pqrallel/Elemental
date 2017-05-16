package adiitya.elemental.elements.elements;

import java.util.List;

public class Magnesium extends Element {

	public Magnesium() {

		super("Magnesium", "Mg", 12, 24.305f, 2);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of magnesium is " + this.getWeight());
		facts.add("The atomic number of magnesium is " + this.getNumber());
		facts.add("The group of magnesium is " + this.getGroup());
		facts.add("The symbol of magnesium is " + this.getSymbol());
		
		this.setFacts(facts);
	}

}
