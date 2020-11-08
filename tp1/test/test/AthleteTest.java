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

	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;
	private static final String ANY_NAME = "Hubert";
	private static final Skills ANY_SKILL = new SkillsMock();

	
	
	@Test (expected = IllegalDexterityAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalDexterity_ShouldThrowException() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_DEXTERITY -1;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalIntelligenceAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalIntelligence_ShouldThrowException() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE - 1;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalFocusAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalFocus_ShouldThrowException() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS - 1;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalStrenghtAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalStrenght_ShouldThrowException() {
		int strenght = ANY_STRENGHT - 1;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test 
	public void WHEN_fighterIsCreated_WITH_legalAttributes_ShouldCreateAthlete() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Athlete (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}

}
