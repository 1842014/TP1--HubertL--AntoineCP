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
import skills.Remedy;

public class RemedyTest {

	private static final int LOWER_STRENGHT = Remedy.MINIMUM_VALUE - 1;
	private static final int HIGHER_STRENGHT = Remedy.MAXIMUM_VALUE + 1;
	private static final int ANY_VALUE = 50;
	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	
	
	private Fighter aFighter;
	private Remedy remedy;
	

	@Before
	public void setUpAFighter() {
		aFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		remedy = new Remedy(ANY_VALUE);
	}
	
	@Test
	public void WHEN_RemedyIsCreated_THEN_ShouldHaveStrenght() {
		assertEquals(ANY_VALUE, remedy.getStrenght());
	}
	
	@Test (expected = IllegalValueException.class)
	public void WHEN_RemedyIsCreated_WITH_StrenghtLowerThanMinimum_ShouldThrowException() {
		new Remedy(LOWER_STRENGHT);
	}
	@Test (expected = IllegalValueException.class)
	public void WHEN_RemedyIsCreated_WITH_StrenghtHigherThanMaximum_ShouldThrowException() {
		new Remedy(HIGHER_STRENGHT);
	}
	
	@Test
	public void WHEN_RemedyIsCreated_THEN_getValueIsCorrect() {
		
		int value = remedy.getValue(aFighter);
		
		final int EXPECTED_VALUE = aFighter.getStrenght() * remedy.getStrenght() / Remedy.MAXIMUM_VALUE;
		assertEquals(EXPECTED_VALUE, value);
	}

}
