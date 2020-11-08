package duel;

import abstraction.Healable;
import exception.NoHealableException;

public class Infirmary {
	private Fighter fighter;
	private Healable healSpell;
	
	public Infirmary(Fighter fighter, Healable healSpell) {
		this.fighter = fighter;
		validateHealSkill(healSpell);
		this.healSpell = healSpell;
	}
	
	private void validateHealSkill(Healable healSpell) {
		if (this.fighter.hasTheSkill(healSpell) == false) throw new NoHealableException();
	}
	
	public void healing () {
		int HPToHeal = this.fighter.getPower(this.healSpell);
		this.fighter.heal(HPToHeal);
		this.fighter.removeSkill(this.healSpell);
	}
}
