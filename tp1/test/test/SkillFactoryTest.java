package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstraction.Attackable;
import abstraction.Healable;
import abstraction.Parryable;
import abstraction.Skills;
import factories.SkillsFactory;
import factories.SkillsFactory.AttackSkill;
import factories.SkillsFactory.DefenseSkill;
import factories.SkillsFactory.HealSkill;
import skills.DefenseSpell;
import skills.HealSpell;
import skills.OffenseSpell;
import skills.Remedy;
import skills.Sheild;
import skills.Sword;

public class SkillFactoryTest {

	private static final int ANY_VALUE = 50;
	private SkillsFactory factory;

	@Before
	public void setUpFactory() {
		factory = new SkillsFactory();
	}
	
	@Test
	public void WHEN_SkillIsSword_THEN_ASwordIsCreated() {
		Skills sword = factory.createAttackSkill(AttackSkill.SWORD, ANY_VALUE);
		
		assertTrue(sword instanceof Attackable);
		assertTrue(sword instanceof Sword);
	}
	
	@Test
	public void WHEN_SkillIsOffenseSpell_THEN_AnOffenseSpellIsCreated() {
		Skills offenseSpell = factory.createAttackSkill(AttackSkill.OFFENSE_SPELL, ANY_VALUE);
		
		assertTrue(offenseSpell instanceof Attackable);
		assertTrue(offenseSpell instanceof OffenseSpell);
	}
	
	@Test
	public void WHEN_SkillIsSheild_THEN_ASheildIsCreated() {
		Skills sheild = factory.createDefenseSkill(DefenseSkill.SHEILD, ANY_VALUE);
		
		assertTrue(sheild instanceof Parryable);
		assertTrue(sheild instanceof Sheild);
	}
	
	@Test
	public void WHEN_SkillIsDefenseSpell_THEN_AnDefenseSpellIsCreated() {
		Skills defenseSpell = factory.createDefenseSkill(DefenseSkill.DEFENSE_SPELL, ANY_VALUE);
		
		assertTrue(defenseSpell instanceof Parryable);
		assertTrue(defenseSpell instanceof DefenseSpell);
	}
	
	@Test
	public void WHEN_SkillIsHealSpell_THEN_AnHealSpellIsCreated() {
		Skills healSpell = factory.createHealsSkill(HealSkill.HEAL_SPELL, ANY_VALUE);
		
		assertTrue(healSpell instanceof Healable);
		assertTrue(healSpell instanceof HealSpell);
	}
	
	@Test
	public void WHEN_SkillIsRemedy_THEN_ARemedyIsCreated() {
		Skills remedy = factory.createHealsSkill(HealSkill.REMEDY, ANY_VALUE);
		
		assertTrue(remedy instanceof Healable);
		assertTrue(remedy instanceof Remedy);
	}

}
