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
import skills.OffenseSpell;

public class OffenseSpellTest {

	private static final int LOWER_EFFICIENCY = OffenseSpell.MINIMUM_VALUE - 1;
	private static final int HIGHER_EFFICIENCY = OffenseSpell.MAXIMUM_VALUE + 1;
	private static final int ANY_VALUE = 50;
	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	
	
	private Fighter aFighter;
	private OffenseSpell spell;
	
	@Before
	public void setUpAFighter() {
		aFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		spell = new OffenseSpell(ANY_VALUE);
	}
	
	@Test
	public void WHEN_offenseSpellIsCreated_THEN_ShouldHaveEfficiency() {
		assertEquals(ANY_VALUE, spell.getEfficiency());
	}
	
	@Test (expected = IllegalValueException.class)
	public void WHEN_offenseSpellIsCreated_WITH_EfficiencyLowerThanMinimum_ShouldThrowException() {
		new OffenseSpell(LOWER_EFFICIENCY);
	}
	@Test (expected = IllegalValueException.class)
	public void WHEN_offenseSpellIsCreated_WITH_EfficiencyHigherThanMaximum_ShouldThrowException() {
		new OffenseSpell(HIGHER_EFFICIENCY);
	}
	
	@Test
	public void WHEN_offenseSpellIsCreated_THEN_getValueIsCorrect() {
		
		int value = spell.getValue(aFighter);
		
		final int EXPECTED_VALUE = (aFighter.getStrenght() * spell.getEfficiency() / OffenseSpell.MAXIMUM_VALUE) * OffenseSpell.MULTIPLIER;
		assertEquals(EXPECTED_VALUE, value);
	}

}
