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
import skills.HealSpell;

public class HealSpellTest {

	private static final int LOWER_ENERGY = HealSpell.MINIMUM_VALUE - 1;
	private static final int HIGHER_ENERGY = HealSpell.MAXIMUM_VALUE + 1;
	private static final int ANY_VALUE = 50;
	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;

	private static final Attributes ANY_ATTRIBUTES = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Skills ANY_SKILL = new SkillsMock();
	
	
	private Fighter aFighter;
	private HealSpell spell;
	

	@Before
	public void setUpAFighter() {
		aFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES, ANY_SKILL, ANY_SKILL);
		spell = new HealSpell(ANY_VALUE);
	}
	
	@Test
	public void WHEN_healSpellIsCreated_THEN_ShouldHaveEnergy() {
		assertEquals(ANY_VALUE, spell.getEnergy());
	}
	
	@Test (expected = IllegalValueException.class)
	public void WHEN_healSpellIsCreated_WITH_EnergyLowerThanMinimum_ShouldThrowException() {
		new HealSpell(LOWER_ENERGY);
	}
	@Test (expected = IllegalValueException.class)
	public void WHEN_healSpellIsCreated_WITH_EnergyHigherThanMaximum_ShouldThrowException() {
		new HealSpell(HIGHER_ENERGY);
	}
	
	@Test
	public void WHEN_HealSpellIsCreated_THEN_getValueIsCorrect() {
		
		int value = spell.getValue(aFighter);
		
		final int EXPECTED_VALUE = aFighter.getStrenght() * spell.getEnergy() / HealSpell.MAXIMUM_VALUE;
		assertEquals(EXPECTED_VALUE, value);
	}

}
