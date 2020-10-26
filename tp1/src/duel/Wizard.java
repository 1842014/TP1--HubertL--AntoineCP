package duel;

import abstraction.Skills;
import exception.IllegalDexterityAttributes;
import exception.IllegalStrenghtAttributes;

public class Wizard extends Fighter{

	private static final int AMOUNT_TO_ADD = 15;
	
	public Wizard(String name, Attributes attributes, Skills firstSkill, Skills secondSkill) {
		super(name, attributes, firstSkill, secondSkill);
		this.validateAttributes();
	}

	private void validateAttributes() {
		if(super.getIntelligence() < max(super.getStrenght(), super.getDexterity()) + AMOUNT_TO_ADD) {
			if(super.getStrenght() >= super.getDexterity()) {
				throw new IllegalStrenghtAttributes();
			}
			else {
				throw new IllegalDexterityAttributes();
			}
		}
		else if ( super.getFocus() < max(super.getStrenght(), super.getDexterity()) + AMOUNT_TO_ADD) {
			if(super.getStrenght() >= super.getDexterity()) {
				throw new IllegalStrenghtAttributes();
			}
			else {
				throw new IllegalDexterityAttributes();
			}
		}
	}

	private int max(int firstAttribute, int secondAttribute) {
		if(firstAttribute >= secondAttribute) {
			return firstAttribute;
		}
		else {
			return secondAttribute;
		}
	}

}
