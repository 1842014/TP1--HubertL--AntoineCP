package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstraction.Skills;
import duel.Athlete;
import duel.Attributes;
import duel.Fighter;
import duel.Warrior;
import duel.Wizard;
import exception.NotImplementedTypeException;
import frabrics.FighterFabric;
import frabrics.FighterFabric.FighterType;
import mock.SkillsMock;

public class FighterFactoryTest {
	private static final String ANY_NAME = "Hubert";



	private static final Skills ANY_SKILL = new SkillsMock();
	private FighterFabric fabric;
	
	@Before
	public void setUpFactory() {
		fabric = new FighterFabric();
	}
	@Test
	public void WHEN_TypeIsAthlete_THEN_AnFighterOfAthleteTypeIsCreated() {
		int strenght = 20;
		int dexterity = 20;
		int intelligence = 20;
		int focus = 20;
		Attributes ANY_ATTRIBUTES = new Attributes(strenght, dexterity, intelligence, focus);
		Fighter fighter = fabric.CreateFighter(FighterType.ATHLETE, ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		
		assertTrue((fighter instanceof Athlete));
		assertFalse((fighter instanceof Warrior));
		assertFalse((fighter instanceof Wizard));
	}
	@Test
	public void WHEN_TypeIsWarrior_THEN_AnFighterOfWarriorTypeIsCreated() {
		int strenght = 40;
		int dexterity = 25;
		int intelligence = 20;
		int focus = 15;
		Attributes ANY_ATTRIBUTES = new Attributes(strenght, dexterity, intelligence, focus);
		Fighter fighter = fabric.CreateFighter(FighterType.WARRIOR, ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		
		assertTrue((fighter instanceof Warrior));
		assertFalse((fighter instanceof Wizard));
		assertFalse((fighter instanceof Athlete));
	}
	@Test
	public void WHEN_TypeIsWizzard_THEN_AnFighterOfWizzardTypeIsCreated() {
		int strenght = 10;
		int dexterity = 10;
		int intelligence = 40;
		int focus = 40;
		Attributes ANY_ATTRIBUTES = new Attributes(strenght, dexterity, intelligence, focus);
		Fighter fighter = fabric.CreateFighter(FighterType.WIZARD, ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		
		assertTrue((fighter instanceof Wizard));
		assertFalse((fighter instanceof Warrior));
		assertFalse((fighter instanceof Athlete));
	}
	@Test (expected = NotImplementedTypeException.class)
	public void WHEN_TypeIsNotExistent_THEN_AnErrorIsSent() {
		int strenght = 10;
		int dexterity = 10;
		int intelligence = 40;
		int focus = 40;
		Attributes ANY_ATTRIBUTES = new Attributes(strenght, dexterity, intelligence, focus);
		fabric.CreateFighter(FighterType.UNKNOWN, ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
	}
}
