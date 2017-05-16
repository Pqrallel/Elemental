package adiitya.elemental.elements.elements;

import java.util.List;

public class Oxygen extends Element {

	public Oxygen() {

		super("Oxygen", "O", 8, 15.9994f, 16);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of oxygen is " + this.getWeight());
		facts.add("The atomic number of oxygen is " + this.getNumber());
		facts.add("The group of oxygen is " + this.getGroup());
		facts.add("The symbol of oxygen is " + this.getSymbol());
		
		this.setFacts(facts);
	}
}
