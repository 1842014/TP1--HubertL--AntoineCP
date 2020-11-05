package duel;

import abstraction.Healable;
import exception.NoHealableException;

public class Infermery {
	private Fighter fighter;
	private Healable heal;
	public Infermery(Fighter fighter, Healable heal) {
		this.fighter = fighter;
		validateHealSkill(heal);
		this.heal = heal;
	}
	
	private void validateHealSkill(Healable heal) {
		if (this.fighter.hasTheSkill(heal) == false) throw new NoHealableException();
	}
	
	public void healing () {
		int HPToHeal = this.heal.getValue(this.fighter);
		this.fighter.heal(HPToHeal);
		this.fighter.removeSkill(this.heal);
	}
}
