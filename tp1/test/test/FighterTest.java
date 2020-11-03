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

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	private static final int FIGHTER_HEALTH = 200 - (ANY_ATTRIBUTES.getDexterity() + ANY_ATTRIBUTES.getFocus() + ANY_ATTRIBUTES.getIntelligence() + ANY_ATTRIBUTES.getStrenght());

	
	
	private Fighter aFighter;
	
	@Before
	public void setUpAFighter() {
		this.aFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
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
		assertEquals(FIGHTER_HEALTH, aFighter.getHealthPoints());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_SkillsShouldBeInitialized() {		
		final int EXPECTED_SKILL_AMOUNT = 2;
		
		assertEquals(EXPECTED_SKILL_AMOUNT, aFighter.getSkills().size());
		assertTrue(aFighter.hasTheSkill(ANY_SKILL));
	}
	
	@Test (expected = IllegalAttributeTotal.class)
	public void WHEN_aFighterIsCreated_WITH_IllegalAttributeTotal_THEN_ShouldThrowException() {
		int Strenght = 50;
		
		Attributes illegalAttributes = new Attributes(Strenght, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_FOCUS);
		
		new FighterMock(ANY_NAME, illegalAttributes, ANY_SKILL, ANY_SKILL);
		
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_ShouldBeAlive() {
		assertTrue(aFighter.isAlive());
	}
	
	@Test
	public void WHEN_aFighterDeadIsCreated_THEN_ShouldBeDead() {
		Fighter fighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		fighter.decreaseHealthPoints(FIGHTER_HEALTH);
		
		assertFalse(fighter.isAlive());
	}
	
	@Test
	public void WHEN_aFighterDeadIsCreated_With_NegativeHealth_THEN_ShouldBeDead() {
		int health = 200;
		Fighter fighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		fighter.decreaseHealthPoints(health);
		
		assertFalse(fighter.isAlive());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_With_DamageDone_THEN_ShouldReduceHealth() {
		int healthToRemove = 20;
		
		aFighter.decreaseHealthPoints(healthToRemove);
		
		final int EXPECTED_HEALTH = FIGHTER_HEALTH - healthToRemove;
		assertEquals(EXPECTED_HEALTH, aFighter.getHealthPoints());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_ShouldHaveSkill() {
		assertTrue(aFighter.hasTheSkill(ANY_SKILL));
	}
	
	@Test
	public void WHEN_aFighterIsCreatedAndDoesntHaveTheSkill_THEN_ShouldntHaveSkill() {
		Skills skill = new SkillsMock();
		
		assertFalse(aFighter.hasTheSkill(skill));
	}
	
	@Test
	public void WHEN_aFighterIsCreatedAndHas2DifferentSkills_THEN_ShouldHaveSkill() {
		Skills skill1 = new SkillsMock();
		Skills skill2 = new SkillsMock();
		Skills skill3 = new SkillsMock();
		Fighter newFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, skill1, skill2);
		
		assertTrue(newFighter.hasTheSkill(skill1));
		assertTrue(newFighter.hasTheSkill(skill2));
		assertFalse(newFighter.hasTheSkill(skill3));
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_ShouldBeAbleToAddSkill() {
		this.aFighter.addSkill(ANY_SKILL);
		this.aFighter.addSkill(ANY_SKILL);
		this.aFighter.addSkill(ANY_SKILL);

		
		final int EXPECTED_AMOUNT_SKILL = 5;
		assertEquals(EXPECTED_AMOUNT_SKILL, aFighter.getSkills().size());
	}
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_ShouldBeAbleToRemoveSkill() {
		this.aFighter.removeSkill(ANY_SKILL);
		
		final int EXPECTED_AMOUNT_SKILL = 1;
		assertEquals(EXPECTED_AMOUNT_SKILL, aFighter.getSkills().size());
	}
	
	@Test
	public void WHEN_aFirghterIsCreatedAndGetPowerIsCalled_ShouldReturnPower() {
		Skills sword = new SkillsMock();
		
		int swordPower = aFighter.getPower(sword);
		
		final int EXPECTED_POWER = SkillsMock.ANY_VALUE;
		assertEquals(EXPECTED_POWER, swordPower);
	}
	
	

}
