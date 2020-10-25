package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstraction.Skills;
import duel.Attributes;
import duel.Fighter;
import duel.Warrior;
import exception.IllegalWarriorAttributes;
import mock.FighterMock;
import mock.SkillsMock;

public class WarriorTest {

	
	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	private static final int FIGHTER_HEALTH = 200 - (ANY_ATTRIBUTES.getDexterity() + ANY_ATTRIBUTES.getFocus() + ANY_ATTRIBUTES.getIntelligence() + ANY_ATTRIBUTES.getStrenght());

	
	
	@Test (expected = IllegalWarriorAttributes.class)
	public void test() {
	 new Warrior (ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
	}

}
