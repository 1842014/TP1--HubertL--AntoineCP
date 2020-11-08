package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstraction.Attackable;
import abstraction.Healable;
import abstraction.Parryable;
import duel.Attributes;
import duel.Fighter;
import duel.Infirmary;
import exception.NoHealableException;
import mock.AttackSkillMock;
import mock.FighterMock;
import mock.HealSkillMock;
import mock.ParrySkillMock;

public class InfirmaryTest {

	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;
	private static final int ANY_VALUE = 50;
	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Attackable ANY_ATTACK_SKILL = new AttackSkillMock(ANY_VALUE);
	private static final Parryable ANY_PARRY_SKILL = new ParrySkillMock(ANY_VALUE);
	private static final Healable ANY_HEAL_SKILL = new HealSkillMock(ANY_VALUE);
	private Fighter anyFighter;
	private Infirmary infermery;
	
	@Before
	public void setUpInfermery() {
		this.anyFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_ATTACK_SKILL, ANY_HEAL_SKILL);
		this.infermery = new Infirmary(anyFighter, ANY_HEAL_SKILL);
	}

	@Test (expected = NoHealableException.class)
	public void WHEN_HeallingSkillIsNotHere_THEN_ExceptionIsReturn() {
		Fighter fighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_ATTACK_SKILL, ANY_PARRY_SKILL);
		new Infirmary(fighter, ANY_HEAL_SKILL);
	}
	@Test
	public void WHEN_InfermeryIsUsed_THEN_HPIsHealed() {
		int expectedHP = this.anyFighter.getHealthPoints() + ANY_VALUE;
		this.infermery.healing();
		
		assertEquals(expectedHP, this.anyFighter.getHealthPoints());
	}
	@Test 
	public void WHEN_InfermeryIsUsedForEachSpell_THEN_HPIsHealed() {
		this.anyFighter.addSkill(ANY_HEAL_SKILL);
		int expectedHP = this.anyFighter.getHealthPoints() + ANY_VALUE +ANY_VALUE;
		this.infermery.healing();
		this.infermery.healing();
		assertEquals(expectedHP, this.anyFighter.getHealthPoints());
	}
}
