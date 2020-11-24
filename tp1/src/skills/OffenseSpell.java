package skills;

import abstraction.Attackable;
import duel.Fighter;
import exception.IllegalValueException;

public class OffenseSpell implements Attackable{//MS : Doit implémenter Skills aussi.

	public static final int MULTIPLIER = 3;
	public static final int MINIMUM_VALUE = 20;
	public static final int MAXIMUM_VALUE = 100;
	
	private int efficiency;
	
	public OffenseSpell(int efficiency) {
		this.validateValue(efficiency);
		this.efficiency = efficiency;
	}
	
	private void validateValue(int valueToCheck) {
		if(valueToCheck < MINIMUM_VALUE || valueToCheck > MAXIMUM_VALUE) {
			throw new IllegalValueException();
		}
	}
	
	public int getEfficiency() {
		return this.efficiency;
	}
	
	@Override
	public int getValue(Fighter fighter) {
		return (fighter.getIntelligence() * this.efficiency / MAXIMUM_VALUE) * MULTIPLIER;
	}
	@Override
	public String toString() {
		return "OffenseSpell Power: "+ getEfficiency();
	}
}
