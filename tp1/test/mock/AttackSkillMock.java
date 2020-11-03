package mock;

import abstraction.Attackable;
import duel.Fighter;

public class AttackSkillMock implements Attackable {

	private int value;

	public AttackSkillMock(int value) {
		this.value = value;
	}
	
	@Override
	public int getValue(Fighter fighter) {
		return this.value;
	}

}
