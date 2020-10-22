package mock;

import abstraction.Skills;
import duel.Attributes;
import duel.Fighter;

public class FighterMock extends Fighter {

	public FighterMock(String name, Attributes attributes, Skills firstSkill, Skills secondSkill, int healthPoints) {
		super(name, attributes, firstSkill, secondSkill, healthPoints);
	}

}
