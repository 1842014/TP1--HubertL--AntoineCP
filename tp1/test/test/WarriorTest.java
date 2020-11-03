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

	
	private static final String ANY_NAME = "Hubert";
	private static final Skills ANY_SKILL = new SkillsMock();

	
	
	@Test (expected = IllegalDexterityAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalDexterity_ShouldThrowException() {
		int strenght = 30;
		int dexterity = 21;
		int intelligence = 10;
		int focus = 0;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Warrior (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalIntelligenceAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalIntelligence_ShouldThrowException() {
		int strenght = 30;
		int dexterity = 20;
		int intelligence = 21;
		int focus = 0;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Warrior (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test (expected = IllegalFocusAttributes.class)
	public void WHEN_fighterIsCreated_WITH_illegalFocus_ShouldThrowException() {
		int strenght = 30;
		int dexterity = 20;
		int intelligence = 0;
		int focus = 11;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Warrior (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}
	
	@Test 
	public void WHEN_fighterIsCreated_WITH_legalAttributes_ShouldCreateWarrior() {
		int strenght = 40;
		int dexterity = 25;
		int intelligence = 20;
		int focus = 15;
		Attributes attributes = new Attributes(strenght, dexterity, intelligence, focus);
		
		
		new Warrior (ANY_NAME, attributes, ANY_SKILL, ANY_SKILL);
	}

}
