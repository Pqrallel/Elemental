package adiitya.elemental.elements.elements;

import java.util.List;

public class Beryllium extends Element {

	public Beryllium() {

		super("Beryllium", "Be", 4, 9.0122f, 2);

		List<String> facts = getFacts();
		facts.add("The atomic weight of beryllium is " + this.getWeight());
		facts.add("The atomic number of beryllium is " + this.getNumber());
		facts.add("The group of beryllium is " + this.getGroup());
		facts.add("The symbol of beryllium is " + this.getSymbol());

		this.setFacts(facts);
	}
}
