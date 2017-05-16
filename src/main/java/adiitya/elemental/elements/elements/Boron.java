package adiitya.elemental.elements.elements;

import java.util.List;

public class Boron extends Element {

	public Boron() {

		super("Boron", "B", 5, 10.811f, 13);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of boron is " + this.getWeight());
		facts.add("The atomic number of boron is " + this.getNumber());
		facts.add("The group of boron is " + this.getGroup());
		facts.add("The symbol of boron is " + this.getSymbol());
		
		this.setFacts(facts);
	}

}
