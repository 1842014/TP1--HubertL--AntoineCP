package skills;

import abstraction.Attackable;
import duel.Fighter;
import exception.IllegalValueException;

public class Sword implements Attackable{//MS : Doit implémenter Skills aussi.

	public static final int MINIMUM_VALUE = 20;
	public static final int MAXIMUM_VALUE = 100;
	private int impact;
	
	public Sword(int impact) {
		this.validateValue(impact);
		this.impact = impact;
	}
	
	private void validateValue(int valueToCheck) {
		if(valueToCheck < MINIMUM_VALUE || valueToCheck > MAXIMUM_VALUE) {
			throw new IllegalValueException();
		}
	}
	
	public int getImpact() {
		return this.impact;
	}
	
	@Override
	public int getValue(Fighter fighter) {
		return fighter.getStrenght() * this.impact / MAXIMUM_VALUE;//MS : Attention ici, le 100 dans le calcul ne correspond pas à la valeur Max... Si la valeur Max change, on aura un problème.
	}
	@Override
	public String toString() {
		return "Sword Power: "+ getImpact();
	}
}
