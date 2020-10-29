package skills;

import abstraction.Parryable;
import duel.Fighter;
import exception.IllegalValueException;

public class DefenseSpell implements Parryable {

	public static final int MULTIPLIER = 3;
	public static final int MINIMUM_VALUE = 20;
	public static final int MAXIMUM_VALUE = 100;
	
	private int intensity;

	public DefenseSpell(int intensity) {
		this.validateValue(intensity);
		this.intensity = intensity;
	}
	
	private void validateValue(int valueToCheck) {
		if(valueToCheck < MINIMUM_VALUE || valueToCheck > MAXIMUM_VALUE) {
			throw new IllegalValueException();
		}
	}
	
	public int getIntensity() {
		return this.intensity;
	}
	
	@Override
	public int getValue(Fighter fighter) {
		return (fighter.getIntelligence() * this.intensity / MAXIMUM_VALUE) * MULTIPLIER;
	}

}
