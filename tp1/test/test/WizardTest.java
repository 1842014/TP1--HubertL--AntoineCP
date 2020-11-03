package test;

import org.junit.Test;

import abstraction.Skills;
import duel.Attributes;
import duel.Wizard;
import exception.IllegalDexterityAttributes;
import exception.IllegalStrenghtAttributes;
import mock.SkillsMock;

public class WizardTest {

	private static final String ANY_NAME = "Hubert";
	private static final Skills ANY_SKILL = new SkillsMock();

	
	
	@Test (expected = IllegalStrenghtAttributes.class)
	public void WHEN_fighterIsCreated_WITH_strenghtHigherThanIntelligence_ShouldThrowException() {
		int strenght = 20;
		int dexterity = 0;
		int intelligence = 34;
		int focus = 40;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalStrenghtAttributes.class)
	public void WHEN_fighterIsCreated_WITH_strenghtHigherThanFocus_ShouldThrowException() {
		int strenght = 20;
		int dexterity = 0;
		int intelligence = 40;
		int focus = 34;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalDexterityAttributes.class)
	public void WHEN_fighterIsCreated_WITH_dexterityHigherThanIntelligence_ShouldThrowException() {
		int strenght = 0;
		int dexterity = 20;
		int intelligence = 34;
		int focus = 40;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalDexterityAttributes.class)
	public void WHEN_fighterIsCreated_WITH_dexterityHigherThanFocus_ShouldThrowException() {
		int strenght = 0;
		int dexterity = 20;
		int intelligence = 40;
		int focus = 34;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test 
	public void WHEN_fighterIsCreated_WITH_legalAttributes_ShouldCreateWizard() {
		int strenght = 10;
		int dexterity = 10;
		int intelligence = 40;
		int focus = 40;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Wizard (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}

}
