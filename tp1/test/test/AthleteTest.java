package test;

import org.junit.Test;

import abstraction.Skills;
import duel.Athlete;
import duel.Attributes;
import exception.IllegalDexterityAttributes;
import exception.IllegalFocusAttributes;
import exception.IllegalIntelligenceAttributes;
import exception.IllegalStrenghtAttributes;
import mock.SkillsMock;

public class AthleteTest {

	private static final String ANY_NAME = "Hubert";
	private static final Skills ANY_SKILL = new SkillsMock();

	
	
	@Test (expected = IllegalDexterityAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalDexterity_ShouldThrowException() {
		int strenght = 20;
		int dexterity = 19;
		int intelligence = 20;
		int focus = 20;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalIntelligenceAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalIntelligence_ShouldThrowException() {
		int strenght = 20;
		int dexterity = 20;
		int intelligence = 19;
		int focus = 20;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalFocusAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalFocus_ShouldThrowException() {
		int strenght = 20;
		int dexterity = 20;
		int intelligence = 20;
		int focus = 19;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalStrenghtAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalStrenght_ShouldThrowException() {
		int strenght = 19;
		int dexterity = 20;
		int intelligence = 20;
		int focus = 20;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test 
	public void WHEN_fighterIsCreated_WITH_legalAttributes_ShouldCreateAthlete() {
		int strenght = 20;
		int dexterity = 20;
		int intelligence = 20;
		int focus = 20;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}

}
