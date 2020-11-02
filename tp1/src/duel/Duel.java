package duel;

import abstraction.Attackable;
import abstraction.Parryable;
import abstraction.Skills;
import exception.NoLoserException;
import exception.NoWinnerException;

public class Duel {

	
	
	//Attributs
	private Fighter fighterInitiator;
	private Attackable initiatorSkill;
	private Skills provokatorSkill;
	private Fighter provokedFighter;
	private Fighter winner;
	private Fighter loser;
	private boolean hasSurrendered = false;

	
	//Constructeur
	public Duel(Fighter fighterInitiator, Attackable skill, Fighter provokedFighter) {
		this.fighterInitiator = fighterInitiator;
		this.initiatorSkill = skill;
		this.provokedFighter = provokedFighter;
	}
	
	
	//Méthodes privées
	
	private int getInitiatorPower() {
		return this.fighterInitiator.getPower(this.initiatorSkill);
	}
	
	private int getProvokatorPower() {
		return this.provokedFighter.getPower(this.provokatorSkill);
	}
	
	private void isWinner() {
		if(getInitiatorPower() >= getProvokatorPower()) {
			this.winner = this.fighterInitiator;
			this.loser = this.provokedFighter;
		}
		else {
			this.winner = this.provokedFighter;
			this.loser = this.fighterInitiator;
		}
	}
	
	private int healthToRemove() {
		int healthToRemove;
		if(this.getInitiatorPower() >= this.getProvokatorPower()) {
			healthToRemove = this.getInitiatorPower() - this.getProvokatorPower();
		}
		else {
			healthToRemove = this.getProvokatorPower() - this.getInitiatorPower();
		}
		return healthToRemove;
	}
	
	private void setProvokatorSkill(Skills skill) {
		this.provokatorSkill = skill;
	}
	
	
	
	//Méthodes publiques
	public void retaliate(Attackable skill) {
		this.setProvokatorSkill(skill);
		this.isWinner();
	}


	public void retaliate(Parryable skill) {
		this.setProvokatorSkill(skill);
		this.isWinner();
	}
	
	public void surrender() {
		this.hasSurrendered = true;
		this.winner = this.fighterInitiator;
		this.loser = this.provokedFighter;
	}
	
	public Fighter getWinner() {
		if(this.winner == null) {
			throw new NoWinnerException();
		}
		return this.winner;
	}
	
	public Fighter getLoser() {
		if(this.loser == null) {
			throw new NoLoserException();
		}
		return this.loser;
	}
	
	public void giveWinnerBonus(Skills chosenSkill) {
		
		this.winner.addSkill(chosenSkill);
		this.winner.giveBonusAttributes();
		
		if(this.hasSurrendered) {
			this.loser.givePenalityAttributes();
		}
		else {
			this.loser.givePenalityAttributes();
			this.loser.decreaseHealthPoints(healthToRemove());
		}
	}
	
}
