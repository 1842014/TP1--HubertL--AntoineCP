package duel;

import abstraction.Skills;
import exception.IllegalWarriorAttributes;

public class Warrior extends Fighter{
	
	

	public Warrior(String name, Attributes attributes, Skills firstSkill, Skills secondSkill) {
		super(name, attributes, firstSkill, secondSkill);
		this.validateAttributes(attributes);
	}
	
	private void validateAttributes(Attributes attributes) {
		if(attributes.getStrenght() >= attributes.getDexterity() + 10 && attributes.getDexterity() + 10 >= attributes.getIntelligence() + 10 && attributes.getIntelligence() + 10 >= attributes.getFocus()) {
			throw new IllegalWarriorAttributes();
		}
	}
	
}
