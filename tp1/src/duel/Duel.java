package duel;

import abstraction.Attackable;
import abstraction.Parryable;
import abstraction.Skills;

public class Duel {

	//Attributs
	private Fighter fighterInitiator;
	private Attackable skill;
	private Fighter provokedFighter;
	private Fighter winner;
	private boolean hasSurrendered = false;

	
	//Constructeur
	public Duel(Fighter fighterInitiator, Attackable skill, Fighter provokedFighter) {
		this.fighterInitiator = fighterInitiator;
		this.skill = skill;
		this.provokedFighter = provokedFighter;
	}
	
	
	//Méthodes privées
	private void isWinner(Skills skill) {
		if(this.fighterInitiator.getPower(this.skill) >= this.provokedFighter.getPower(skill)) {
			this.winner = this.fighterInitiator;
		}
		else {
			this.winner = this.provokedFighter;
		}
	}
	
	private int healthToRemove() {
		return this.fighterInitiator.getPower(this.skill) - this.provokedFighter.getPower(skill);
	}
	
	
	
	//Méthodes publiques
	public void retaliate(Attackable skill) {
		this.isWinner(skill);
	}
	
	public void retaliate(Parryable skill) {
		this.isWinner(skill);
	}
	
	public void surrender() {
		this.hasSurrendered = true;
		this.winner = this.fighterInitiator;
	}
	
	public void giveWinnerBonus(Skills chosenSkill) {
		if(this.winner.equals(this.fighterInitiator)) {
			this.fighterInitiator.addSkill(chosenSkill);
			this.fighterInitiator.giveBonusAttributes();
			
			if(this.hasSurrendered) {
				this.provokedFighter.givePenalityAttributes();
			}
			else {
				this.provokedFighter.givePenalityAttributes();
				this.provokedFighter.decreaseHealthPoints(healthToRemove());
			}
		}
		else {
			this.provokedFighter.addSkill(chosenSkill);
			this.provokedFighter.giveBonusAttributes();
			this.fighterInitiator.givePenalityAttributes();
			this.fighterInitiator.decreaseHealthPoints(-healthToRemove());
		}
	}
	
}
