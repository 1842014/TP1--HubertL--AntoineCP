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
import skills.Sheild;

public class SheildTest {

	private static final int LOWER_PROTECTION = Sheild.MINIMUM_VALUE - 1;
	private static final int HIGHER_PROTECTION = Sheild.MAXIMUM_VALUE + 1;
	private static final int ANY_VALUE = 50;
	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	
	
	private Fighter aFighter;
	private Sheild sheild;
	
	@Before
	public void setUpAFighter() {
		this.aFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		sheild = new Sheild(ANY_VALUE);
	}
	
	@Test
	public void WHEN_sheildIsCreated_THEN_ShouldHaveProtection() {
		assertEquals(ANY_VALUE, sheild.getProtection());
	}
	
	@Test (expected = IllegalValueException.class)
	public void WHEN_sheildIsCreated_WITH_ProtectionLowerThanMinimum_ShouldThrowException() {
		new Sheild(LOWER_PROTECTION);
	}
	@Test (expected = IllegalValueException.class)
	public void WHEN_sheildIsCreated_WITH_ProtectionHigherThanMaximum_ShouldThrowException() {
		new Sheild(HIGHER_PROTECTION);
	}
	
	@Test
	public void WHEN_sheildIsCreated_THEN_getValueIsCorrect() {
		
		int value = sheild.getValue(aFighter);
		
		final int EXPECTED_VALUE = aFighter.getStrenght() * sheild.getProtection() / Sheild.MAXIMUM_VALUE;
		assertEquals(EXPECTED_VALUE, value);
	}

}
