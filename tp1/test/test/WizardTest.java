package test;

import org.junit.Test;

import abstraction.Skills;
import duel.Attributes;
import duel.Wizard;
import exception.IllegalDexterityAttributes;
import exception.IllegalStrenghtAttributes;
import mock.SkillsMock;

public class WizardTest {

	private static final int ANY_STRENGHT = 10;
	private static final int ANY_DEXTERITY = 10;
	private static final int ANY_INTELLIGENCE = 30;
	private static final int ANY_FOCUS = 30;
	private static final String ANY_NAME = "Hubert";
	private static final Skills ANY_SKILL = new SkillsMock();

	
	
	@Test (expected = IllegalStrenghtAttributes.class)
	public void WHEN_fighterIsCreated_WITH_strenghtHigherThanIntelligence_ShouldThrowException() {
		int strenght = ANY_INTELLIGENCE - 14;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE - 1;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalStrenghtAttributes.class)
	public void WHEN_fighterIsCreated_WITH_strenghtHigherThanFocus_ShouldThrowException() {
		int strenght = ANY_FOCUS - 14;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS - 1;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalDexterityAttributes.class)
	public void WHEN_fighterIsCreated_WITH_dexterityHigherThanIntelligence_ShouldThrowException() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_INTELLIGENCE - 14;
		int intelligence = ANY_INTELLIGENCE - 1;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalDexterityAttributes.class)
	public void WHEN_fighterIsCreated_WITH_dexterityHigherThanFocus_ShouldThrowException() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_FOCUS - 14;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS - 1;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test 
	public void WHEN_fighterIsCreated_WITH_legalAttributes_ShouldCreateWizard() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}

}
