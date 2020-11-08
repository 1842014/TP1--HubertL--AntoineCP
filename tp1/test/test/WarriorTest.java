package test;

import org.junit.Test;

import abstraction.Skills;
import duel.Attributes;
import duel.Warrior;
import exception.IllegalDexterityAttributes;
import exception.IllegalFocusAttributes;
import exception.IllegalIntelligenceAttributes;
import mock.SkillsMock;

public class WarriorTest {

	
	private static final int ANY_INTELLIGENCE = 0;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_STRENGHT = 30;
	private static final String ANY_NAME = "Hubert";
	private static final Skills ANY_SKILL = new SkillsMock();
	private static final int ANY_FOCUS = 0;

	
	
	@Test (expected = IllegalDexterityAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalDexterity_ShouldThrowException() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_STRENGHT - 10 + 1;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Warrior (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalIntelligenceAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalIntelligence_ShouldThrowException() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_DEXTERITY + 1;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Warrior (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalFocusAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalFocus_ShouldThrowException() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_INTELLIGENCE + 11;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Warrior (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test 
	public void WHEN_fighterIsCreated_WITH_legalAttributes_ShouldCreateWarrior() {
		int strenght = ANY_STRENGHT;
		int dexterity = ANY_DEXTERITY;
		int intelligence = ANY_INTELLIGENCE;
		int focus = ANY_FOCUS;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Warrior (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}

}
