package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstraction.Attackable;
import abstraction.Parryable;
import abstraction.Skills;
import duel.Attributes;
import duel.Duel;
import duel.Fighter;
import mock.FighterMock;
import mock.SkillsMock;
import skills.DefenseSpell;
import skills.Sword;

public class DuelTest {

	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;
	private static final int ANY_VALUE = 50;

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Attackable ANY_ATTACK_SKILL = new Sword(ANY_VALUE);
	private static final Parryable ANY_PARRY_SKILL = new DefenseSpell(ANY_VALUE);
	
	private Fighter initFighter;
	private Fighter provokedFighter;
	private Attackable attackSkill;
	private Duel duel;

	@Before
	public void setUpDuel() {
		this.initFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_ATTACK_SKILL, ANY_PARRY_SKILL);
		this.provokedFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_ATTACK_SKILL, ANY_PARRY_SKILL);
		this.attackSkill = ANY_ATTACK_SKILL;
		this.duel = new Duel(initFighter, attackSkill, provokedFighter);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
