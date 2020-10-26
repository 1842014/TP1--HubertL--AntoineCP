package duel;

import abstraction.Skills;
import exception.IllegalDexterityAttributes;
import exception.IllegalFocusAttributes;
import exception.IllegalIntelligenceAttributes;

public class Warrior extends Fighter{
	
	private final int LEGAL_DEXTERITY = super.getDexterity() + 10;
	private final int LEGAL_INTELLIGENCE = super.getIntelligence() + 10;

	public Warrior(String name, Attributes attributes, Skills firstSkill, Skills secondSkill) {
		super(name, attributes, firstSkill, secondSkill);
		this.validateAttributes();
	}
	
	private void validateAttributes() {
		if(super.getStrenght() < LEGAL_DEXTERITY) { 
			throw new IllegalDexterityAttributes();
		}
		else if( LEGAL_DEXTERITY < LEGAL_INTELLIGENCE) {
			throw new IllegalIntelligenceAttributes();
		}
		else if (LEGAL_INTELLIGENCE < super.getFocus()) {
			throw new IllegalFocusAttributes();
		}
	}
	
}
