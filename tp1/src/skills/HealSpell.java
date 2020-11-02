package skills;

import abstraction.Healable;
import duel.Fighter;
import exception.IllegalValueException;

public class HealSpell implements Healable {

	public static final int MINIMUM_VALUE = 20;
	public static final int MAXIMUM_VALUE = 100;
	private int energy;

	public HealSpell(int energy) {
		this.validateValue(energy);
		this.energy = energy;
	}
	
	private void validateValue(int valueToCheck) {
		if(valueToCheck < MINIMUM_VALUE || valueToCheck > MAXIMUM_VALUE) {
			throw new IllegalValueException();
		}
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	@Override
	public int getValue(Fighter fighter) {
		return fighter.getIntelligence() * this.energy / MAXIMUM_VALUE;
	}
	@Override
	public String toString() {
		return "HealSpell Power: " + getEnergy();
	}
}
