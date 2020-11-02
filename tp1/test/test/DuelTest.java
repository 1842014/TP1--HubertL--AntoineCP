package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import abstraction.Attackable;
import abstraction.Healable;
import abstraction.Parryable;
import duel.Attributes;
import duel.Duel;
import duel.Fighter;
import exception.NoLoserException;
import exception.NoWinnerException;
import mock.AttackSkillMock;
import mock.FighterMock;
import mock.HealSkillMock;
import mock.ParrySkillMock;

public class DuelTest {

	private static final String ANY_NAME = "Hubert";
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_INTELLIGENCE = 20;
	private static final int ANY_FOCUS = 20;
	private static final int ANY_VALUE = 50;

	private static final Attributes ANY_ATTRIBUTES_FIGHTER_INIT = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Attributes ANY_ATTRIBUTES_FIGHTER_PROVOKED = new Attributes(ANY_STRENGHT,ANY_DEXTERITY,ANY_INTELLIGENCE,ANY_FOCUS);
	private static final Attackable ANY_ATTACK_SKILL = new AttackSkillMock(ANY_VALUE);
	private static final Parryable ANY_PARRY_SKILL = new ParrySkillMock(ANY_VALUE);
	private static final Healable ANY_HEAL_SKILL = new HealSkillMock(ANY_VALUE);

	
	private Fighter initFighter;
	private Fighter provokedFighter;
	private Duel duel;

	@Before
	public void setUpDuel() {
		this.initFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES_FIGHTER_INIT, ANY_ATTACK_SKILL, ANY_HEAL_SKILL);
		this.provokedFighter = new FighterMock(ANY_NAME, ANY_ATTRIBUTES_FIGHTER_PROVOKED, ANY_ATTACK_SKILL, ANY_PARRY_SKILL);
		this.duel = new Duel(initFighter, ANY_ATTACK_SKILL, provokedFighter);
		this.initFighter.setAttributes(ANY_STRENGHT, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_FOCUS);
		this.provokedFighter.setAttributes(ANY_STRENGHT, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_FOCUS);
		this.initFighter.setHealthPoints();
		this.provokedFighter.setHealthPoints();
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterSurrendering_THEN_InitFighterIsWinnerAndProvokedFighterIsLoser() {
		this.duel.surrender();
		
		assertTrue(this.initFighter.equals(this.duel.getWinner()));
		assertTrue(this.provokedFighter.equals(this.duel.getLoser()));
	}
	
	@Test (expected = NoWinnerException.class)
	public void WHEN_duelIsCreated_WITH_noWinner_THEN_ThrowException() {
		this.duel.getWinner();
	}

	@Test (expected = NoLoserException.class)
	public void WHEN_duelIsCreated_WITH_noLoser_THEN_ThrowException() {
		this.duel.getLoser();
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterRetaliatingWithSameAttackSkill_THEN_initFighterIsWinner() {
		Attackable attackSkill = (Attackable) this.provokedFighter.getSkills().get(0);
		
		this.duel.retaliate(attackSkill);
		
		assertTrue(this.initFighter.equals(this.duel.getWinner()));
		assertTrue(this.provokedFighter.equals(this.duel.getLoser()));
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterRetaliatingWithLowerAttackSkill_THEN_initFighterIsWinner() {		
		Attackable attackSkill = new AttackSkillMock(ANY_VALUE - 5);
		
		this.duel.retaliate(attackSkill);
		
		assertTrue(this.initFighter.equals(this.duel.getWinner()));
		assertTrue(this.provokedFighter.equals(this.duel.getLoser()));
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterRetaliatingWithHigherAttackSkill_THEN_ProvokedFighterIsWinner() {
		//La capacit� d'attaque doit �tre sup�rieur � 5 de la valeur initial, car le calcul est en int et pas en float.
		//Si il avait �t� en float on aurait �t� capable d'ajouter que 1 � la valeur initial
		Attackable attackSkill = new AttackSkillMock(ANY_VALUE + 5);
		
		this.duel.retaliate(attackSkill);
		
		assertTrue(this.provokedFighter.equals(this.duel.getWinner()));
		assertTrue(this.initFighter.equals(this.duel.getLoser()));
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterRetaliatingWithParryableSkillWithSameValue_THEN_initFighterIsWinner() {
		Parryable parrySkill = (Parryable) this.provokedFighter.getSkills().get(1);
		
		this.duel.retaliate(parrySkill);
		
		assertTrue(this.initFighter.equals(this.duel.getWinner()));
		assertTrue(this.provokedFighter.equals(this.duel.getLoser()));
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterRetaliatingWithParryableSkillWithLowerValue_THEN_initFighterIsWinner() {
		Parryable attackSkill = new ParrySkillMock(ANY_VALUE - 5);
		
		this.duel.retaliate(attackSkill);
		
		assertTrue(this.initFighter.equals(this.duel.getWinner()));
		assertTrue(this.provokedFighter.equals(this.duel.getLoser()));
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterRetaliatingWithParryableSkillWithHigherValue_THEN_ProvokedFighterIsWinner() {
		Parryable attackSkill = new ParrySkillMock(ANY_VALUE + 5);
		
		this.duel.retaliate(attackSkill);
		
		assertTrue(this.provokedFighter.equals(this.duel.getWinner()));
		assertTrue(this.initFighter.equals(this.duel.getLoser()));
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterSurrendering_THEN_InitFighterGetsBonusAndProvokedFighterGetPenalities() {
		this.duel.surrender();
		this.duel.giveWinnerBonus(ANY_HEAL_SKILL);
		
		
		//Bonus initfighter
		assertEquals(ANY_STRENGHT + 1, this.duel.getWinner().getStrenght());
		assertEquals(ANY_DEXTERITY + 1, this.duel.getWinner().getDexterity());
		assertEquals(ANY_INTELLIGENCE + 1, this.duel.getWinner().getIntelligence());
		assertEquals(ANY_FOCUS + 1, this.duel.getWinner().getFocus());
		
		//Penalities provokedFighter
		assertEquals(ANY_STRENGHT - 1, this.duel.getLoser().getStrenght());
		assertEquals(ANY_DEXTERITY - 1, this.duel.getLoser().getDexterity());
		assertEquals(ANY_INTELLIGENCE - 1, this.duel.getLoser().getIntelligence());
		assertEquals(ANY_FOCUS - 1, this.duel.getLoser().getFocus());
	}
	
	@Test
	public void WHEN_duelIsCreated_WITH_provokedFighterRetaliating_THEN_LoserHealthIsDecreased() {
		Parryable parrySkill = new ParrySkillMock(20);
		this.duel.retaliate(parrySkill);
		this.duel.giveWinnerBonus(ANY_HEAL_SKILL);
		
		final int EXPECTED_HEALTH_TO_REMOVE = ANY_ATTACK_SKILL.getValue(null) - parrySkill.getValue(null);
		final int EXPECTED_LOSER_HEALTH = this.duel.getLoser().getHealthPoints() - EXPECTED_HEALTH_TO_REMOVE;
		
		assertEquals(EXPECTED_LOSER_HEALTH, this.duel.getLoser().decreaseHealthPoints(EXPECTED_HEALTH_TO_REMOVE));
	}
	
	
	
	
	
	

}
