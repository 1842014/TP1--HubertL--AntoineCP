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
import skills.DefenseSpell;

public class DefenseSpellTest {

	private static final int LOWER_INTENSITY = DefenseSpell.MINIMUM_VALUE - 1;
	private static final int HIGHER_INTENSITY = DefenseSpell.MAXIMUM_VALUE + 1;
	private static final int ANY_VALUE = 50;
	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	
	
	private Fighter aFighter;
	private DefenseSpell spell;
	

	@Before
	public void setUpAFighter() {
		aFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		spell = new DefenseSpell(ANY_VALUE);
	}
	
	@Test
	public void WHEN_defenseSpellIsCreated_THEN_ShouldHaveIntensity() {
		assertEquals(ANY_VALUE, spell.getIntensity());
	}
	
	@Test (expected = IllegalValueException.class)
	public void WHEN_defenseSpellIsCreated_WITH_IntensityLowerThanMinimum_ShouldThrowException() {
		new DefenseSpell(LOWER_INTENSITY);
	}
	@Test (expected = IllegalValueException.class)
	public void WHEN_defenseSpellIsCreated_WITH_IntensityHigherThanMaximum_ShouldThrowException() {
		new DefenseSpell(HIGHER_INTENSITY);
	}
	
	@Test
	public void WHEN_defenseSpellIsCreated_THEN_getValueIsCorrect() {
		
		int value = spell.getValue(aFighter);
		
		final int EXPECTED_VALUE = (aFighter.getStrenght() * spell.getIntensity() / DefenseSpell.MAXIMUM_VALUE) * DefenseSpell.MULTIPLIER;
		assertEquals(EXPECTED_VALUE, value);
	}

}
