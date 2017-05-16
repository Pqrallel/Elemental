package adiitya.elemental.elements.elements;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Element {

	private String name;
	private String symbol;
	private int number;
	private float weight;
	private int group;
	private List<String> facts = new ArrayList<String>();
	
	public Element(String name, String symbol, int number, float weight, int group) {
		
		this.name = name;
		this.symbol = symbol;
		this.number = number;
		this.weight = weight;
		this.group = group;
	}
}
