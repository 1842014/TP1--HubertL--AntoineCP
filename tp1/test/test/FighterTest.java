package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstraction.Skills;
import duel.Attributes;
import duel.Fighter;
import exception.IllegalAttributeTotal;
import mock.FighterMock;
import mock.SkillsMock;

public class FighterTest {

	
	
	
	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;

	private static final int ANY_HEALTH = 200;
	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	
	
	private Fighter aFighter;
	
	@Before
	public void setUpAFighter() {
		this.aFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL, ANY_HEALTH);
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_NameShouldBeInitialized() {
		assertEquals(ANY_NAME, aFighter.getName());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_StrenghtShouldBeInitialized() {
		assertEquals(ANY_STRENGHT, aFighter.getStrenght());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_DexterityShouldBeInitialized() {
		assertEquals(ANY_DEXTERITY, aFighter.getDexterity());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_IntelligenceShouldBeInitialized() {
		assertEquals(ANY_INTELLIGENCE, aFighter.getIntelligence());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_FocusShouldBeInitialized() {
		assertEquals(ANY_FOCUS, aFighter.getFocus());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_HealthPointsShouldBeInitialized() {
		assertEquals(ANY_HEALTH, aFighter.getHealthPoints());
	}
	
	@Test (expected = IllegalAttributeTotal.class)
	public void WHEN_aFighterIsCreated_WITH_IllegalAttributeTotal_THEN_ShouldThrowException() {
		int Strenght = 50;
		
		Attributes illegalAttributes = new Attributes(Strenght, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_FOCUS);
		
		new FighterMock(ANY_NAME, illegalAttributes, ANY_SKILL, ANY_SKILL, ANY_HEALTH);
		
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_ShouldBeAlive() {
		assertTrue(aFighter.isAlive());
	}
	
	@Test
	public void WHEN_aFighterDeadIsCreated_THEN_ShouldBeDead() {
		int health = 0;
		Fighter fighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL, health);
		
		assertFalse(fighter.isAlive());
	}
	
	@Test
	public void WHEN_aFighterDeadIsCreated_With_NegativeHealth_THEN_ShouldBeDead() {
		int health = -100;
		Fighter fighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL, health);
		
		assertFalse(fighter.isAlive());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_With_DamageDone_THEN_ShouldReduceHealth() {
		int healthToRemove = 20;
		
		aFighter.decreaseHealthPoints(healthToRemove);
		
		final int EXPECTED_HEALTH = ANY_HEALTH - healthToRemove;
		assertEquals(EXPECTED_HEALTH, aFighter.getHealthPoints());
	}

}
