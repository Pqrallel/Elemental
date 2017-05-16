package adiitya.elemental.elements.elements;

import java.util.List;

public class Carbon extends Element {

	public Carbon() {

		super("Carbon", "C", 6, 12.0107f, 14);
		
		List<String> facts = getFacts();
		facts.add("The atomic weight of carbon is " + this.getWeight());
		facts.add("The atomic number of carbon is " + this.getNumber());
		facts.add("The group of carbon is " + this.getGroup());
		facts.add("The symbol of carbon is " + this.getSymbol());
		
		this.setFacts(facts);
	}
}
