package adiitya.elemental.elements.elements;

import java.util.List;

public class Fluorine extends Element {

	public Fluorine() {

		super("Fluorine", "F", 9, 18.9984f, 17);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of fluorine is " + this.getWeight());
		facts.add("The atomic number of fluorine is " + this.getNumber());
		facts.add("The group of fluorine is " + this.getGroup());
		facts.add("The symbol of fluorine is " + this.getSymbol());
		
		this.setFacts(facts);
	}

}
