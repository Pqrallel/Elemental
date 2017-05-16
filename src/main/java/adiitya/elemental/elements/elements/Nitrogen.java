package adiitya.elemental.elements.elements;

import java.util.List;

public class Nitrogen extends Element {

	public Nitrogen() {

		super("Nitrogen", "n", 7, 14.0067f, 15);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of nitrogen is " + this.getWeight());
		facts.add("The atomic number of nitrogen is " + this.getNumber());
		facts.add("The group of nitrogen is " + this.getGroup());
		facts.add("The symbol of nitrogen is " + this.getSymbol());
		
		this.setFacts(facts);
	}
}
