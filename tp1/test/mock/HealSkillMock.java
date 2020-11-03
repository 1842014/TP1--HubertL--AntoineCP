package mock;

import abstraction.Healable;
import duel.Fighter;

public class HealSkillMock implements Healable{

	private int value;

	public HealSkillMock(int value) {
		this.value = value;
	}
	
	@Override
	public int getValue(Fighter fighter) {
		return this.value;
	}

}
