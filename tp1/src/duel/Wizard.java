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
			checkException();
		}
		else if ( super.getFocus() < max(super.getStrenght(), super.getDexterity()) + AMOUNT_TO_ADD) {
			checkException();
		}
	}

	private void checkException() {
		if(super.getStrenght() >= super.getDexterity()) {
			throw new IllegalStrenghtAttributes();
		}
		else {
			throw new IllegalDexterityAttributes();
		}
	}

	private int max(int firstAttribute, int secondAttribute) {//MS : DRY : Utiliser Math.max
		if(firstAttribute >= secondAttribute) {
			return firstAttribute;
		}
		else {
			return secondAttribute;
		}
	}

}
