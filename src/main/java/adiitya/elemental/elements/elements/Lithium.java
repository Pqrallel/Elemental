package adiitya.elemental.elements.elements;

import java.util.List;

public class Lithium extends Element {

	public Lithium() {

		super("Lithium", "Li", 3, 6.941f, 1);

		List<String> facts = getFacts();
		facts.add("The atomic weight of lithium is " + this.getWeight());
		facts.add("The atomic number of lithium is " + this.getNumber());
		facts.add("The group of lithium is " + this.getGroup());
		facts.add("The symbol of lithium is " + this.getSymbol());

		this.setFacts(facts);
	}
}
