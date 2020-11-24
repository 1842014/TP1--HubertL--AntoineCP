package skills;

import abstraction.Parryable;
import duel.Fighter;
import exception.IllegalValueException;

public class Shield implements Parryable{//MS : Doit implémenter Skills aussi.

public static final int MINIMUM_VALUE = 20;
public static final int MAXIMUM_VALUE = 100;
private int protection;
	
	public Shield(int protection) {
		this.validateValue(protection);
		this.protection = protection;
	}
	
	private void validateValue(int valueToCheck) {
		if(valueToCheck < MINIMUM_VALUE || valueToCheck > MAXIMUM_VALUE) {
			throw new IllegalValueException();
		}
	}
	
	public int getProtection() {
		return this.protection;
	}
	
	@Override
	public int getValue(Fighter fighter) {
		return fighter.getStrenght() * this.protection / MAXIMUM_VALUE;
	}
	@Override
	public String toString() {
		return "Shield Power: "+ getProtection();
	}
}
