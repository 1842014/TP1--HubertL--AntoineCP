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
import factories.FighterFactory;
import factories.FighterFactory.FighterType;
import mock.SkillsMock;

public class FighterFactoryTest {
	private static final String ANY_NAME = "Hubert";



	private static final Skills ANY_SKILL = new SkillsMock();
	private FighterFactory fabric;
	
	@Before
	public void setUpFactory() {
		fabric = new FighterFactory();
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
	}
}
