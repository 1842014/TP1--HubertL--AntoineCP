package mock;

import abstraction.Attackable;
import abstraction.Skills;
import duel.Fighter;

public class SkillsMock implements Skills, Attackable {

	
	
	public static final int ANY_VALUE = 5;

	@Override
	public int getValue(Fighter fighter) {
		return ANY_VALUE;
	}

}
