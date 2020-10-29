package skills;

import abstraction.Healable;
import duel.Fighter;
import exception.IllegalValueException;

public class Remedy implements Healable {

	public static final int MAXIMUM_VALUE = 100;
	public static final int MINIMUM_VALUE = 20;
	private int strenght;

	public Remedy(int strenght) {
		this.validateValue(strenght);
		this.strenght = strenght;
	}
	
	private void validateValue(int valueToCheck) {
		if(valueToCheck < MINIMUM_VALUE || valueToCheck > MAXIMUM_VALUE) {
			throw new IllegalValueException();
		}
	}
	
	public int getStrenght() {
		return this.strenght;
	}

	@Override
	public int getValue(Fighter fighter) {
		return fighter.getDexterity() * this.strenght / MAXIMUM_VALUE;
	}

}
