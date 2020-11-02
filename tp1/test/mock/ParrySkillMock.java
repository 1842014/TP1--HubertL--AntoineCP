package mock;

import abstraction.Parryable;
import duel.Fighter;

public class ParrySkillMock implements Parryable {

	
	private int value;

	public ParrySkillMock(int value) {
		this.value = value;
	}
	
	@Override
	public int getValue(Fighter fighter) {
		return this.value;
	}

}
