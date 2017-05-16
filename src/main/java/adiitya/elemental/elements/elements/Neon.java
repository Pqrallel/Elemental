package adiitya.elemental.elements.elements;

import java.util.List;

public class Neon extends Element {

	public Neon() {

		super("Neon", "Ne", 10, 20.1797f, 18);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of neon is " + this.getWeight());
		facts.add("The atomic number of neon is " + this.getNumber());
		facts.add("The group of neon is " + this.getGroup());
		facts.add("The symbol of neon is " + this.getSymbol());
		
		this.setFacts(facts);
	}

}
