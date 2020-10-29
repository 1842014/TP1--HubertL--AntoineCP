package skillTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstraction.Skills;
import duel.Attributes;
import duel.Fighter;
import exception.IllegalValueException;
import mock.FighterMock;
import mock.SkillsMock;
import skills.Sword;

public class SwordTest {

	private static final int LOWER_IMPACT = Sword.MINIMUM_VALUE - 1;
	private static final int HIGHER_IMPACT = Sword.MAXIMUM_VALUE + 1;
	private static final int ANY_VALUE = 50;
	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	
	
	private Fighter aFighter;
	private Sword sword;
	
	@Before
	public void setUpAFighter() {
		this.aFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		sword = new Sword(ANY_VALUE);
	}
	
	@Test
	public void WHEN_swordIsCreated_THEN_ShouldHaveImpact() {
		assertEquals(ANY_VALUE, sword.getImpact());
	}
	
	@Test (expected = IllegalValueException.class)
	public void WHEN_swordIsCreated_WITH_ImpactLowerThanMinimum_ShouldThrowException() {
		new Sword(LOWER_IMPACT);
	}
	@Test (expected = IllegalValueException.class)
	public void WHEN_swordIsCreated_WITH_ImpactHigherThanMaximum_ShouldThrowException() {
		new Sword(HIGHER_IMPACT);
	}
	
	@Test
	public void WHEN_swordIsCreated_THEN_getValueIsCorrect() {
		
		int value = sword.getValue(aFighter);
		
		final int EXPECTED_VALUE = aFighter.getStrenght() * sword.getImpact() / Sword.MAXIMUM_VALUE;
		assertEquals(EXPECTED_VALUE, value);
	}
	

}
