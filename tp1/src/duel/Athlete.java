package duel;

import abstraction.Skills;
import exception.IllegalDexterityAttributes;
import exception.IllegalFocusAttributes;
import exception.IllegalIntelligenceAttributes;
import exception.IllegalStrenghtAttributes;

public class Athlete extends Fighter{

	private static final int MINIMUM_VALUE_ATTRIBUTE = 20;

	public Athlete(String name, Attributes attributes, Skills firstSkill, Skills secondSkill) {
		super(name, attributes, firstSkill, secondSkill);
		this.validateAttributes();
	}

	private void validateAttributes() {
		if(super.getStrenght() < MINIMUM_VALUE_ATTRIBUTE) {
			throw new IllegalStrenghtAttributes();
		}
		else if (super.getDexterity() < MINIMUM_VALUE_ATTRIBUTE) {
			throw new IllegalDexterityAttributes();
		}
		else if (super.getIntelligence() < MINIMUM_VALUE_ATTRIBUTE) {
			throw new IllegalIntelligenceAttributes();
		}
		else if (super.getFocus() < MINIMUM_VALUE_ATTRIBUTE) {
			throw new IllegalFocusAttributes();
		}
	}

}
