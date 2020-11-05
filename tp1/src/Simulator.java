import java.util.ArrayList;
import java.util.List;

import abstraction.Attackable;
import abstraction.Healable;
import abstraction.Skills;
import duel.Athlete;
import duel.Attributes;
import duel.Duel;
import duel.Fighter;
import duel.Infirmary;
import duel.Warrior;
import duel.Wizard;
import exception.NoHealableException;
import skills.DefenseSpell;
import skills.HealSpell;
import skills.OffenseSpell;
import skills.Remedy;
import skills.Shield;
import skills.Sword;

public class Simulator {

	private static final int ANY_VALUE = 20;

	public static void main(String[] args) {
		new Simulator();
	}
	Attributes warriorAttributes = new Attributes(40, 25,20, 15);
	Skills sword = new Sword(ANY_VALUE);
	Skills shield = new Shield(ANY_VALUE);
	Attributes athleteAttributes = new Attributes(20, 20, 20, 20);
	Skills offenseSpell = new OffenseSpell(ANY_VALUE);
	Skills defenseSpell = new DefenseSpell(ANY_VALUE);
	Attributes wizardAttributes = new Attributes(10, 10, 40, 40);
	Skills healSpell = new HealSpell(ANY_VALUE);
	Skills remedy = new Remedy(ANY_VALUE);
	
	private List<Fighter> listOfFighter = new ArrayList<Fighter>();
	
	public Simulator() {
		this.seedData();
		this.printData("Voici les combatants");
		this.decreaseHealth();
		this.printData("Combatants àpres réducation de la vie");
		this.printData("Combatants avant le combats");
		this.fight(listOfFighter.get(0), listOfFighter.get(1));
		this.printData("Combatants après le combats");
		this.surrender(listOfFighter.get(2), listOfFighter.get(0));
		this.printData("Combatants après le combats");
		this.healStation(listOfFighter.get(1), (Healable) listOfFighter.get(1).getSkills().get(1));
		this.printData("Combatants");
		this.healStation(this.listOfFighter.get(0), (Healable) remedy);

	}

	private void healStation(Fighter fighterToHeal, Healable healSkill) {
		System.out.println();
		System.out.println("Le Combatant " + fighterToHeal.getName() + " va à l'infirmerie.");
		try {
			Infirmary infermery = new Infirmary(fighterToHeal, healSkill);
			
			infermery.healing();
		}
		catch(NoHealableException ex) {
			System.out.println();
			System.out.println("Oh non! Le combatants n'a pas la capacité requise.");
		}
		
		System.out.println();
		System.out.println("Le Combatant a maintenant " + fighterToHeal.getHealthPoints() + " points de vie");
	}

	private void surrender(Fighter initiator, Fighter provoked) {
		System.out.println();
		System.out.println("Le combats entre " + initiator.getName() + " et " + provoked.getName() + " commence!!!");
		Duel duel = new Duel(initiator, (Attackable) initiator.getSkills().get(1), provoked);
		
		duel.surrender();
		System.out.println();
		System.out.println(provoked.getName() + " capitule!");
		duel.giveWinnerBonus(healSpell);
		
		System.out.println();
		System.out.println("Victoire pour " + duel.getWinner().getName() + "!!!");		
	}

	private void fight(Fighter initiator, Fighter provoked) {
		System.out.println();
		System.out.println("Le combats entre " + initiator.getName() + " et " + provoked.getName() + " commence!!!");
		Duel duel = new Duel(initiator, (Attackable) initiator.getSkills().get(0), provoked);
		
		duel.retaliate((Attackable) provoked.getSkills().get(0));
		System.out.println();
		System.out.println(provoked.getName() + " riposte!");
		duel.giveWinnerBonus(healSpell);
		
		System.out.println();
		System.out.println("Victoire pour " + duel.getWinner().getName() + "!!!");
	}

	private void decreaseHealth() {
		for (Fighter fighter : listOfFighter) {
			fighter.decreaseHealthPoints(ANY_VALUE);
		}
	}

	private void printData(String title) {
		System.out.println();
        System.out.println(title);
        for (Fighter fighter: listOfFighter) {
        	System.out.println(fighter.toString());
        }
	}

	private void seedData() {
		this.listOfFighter.add(new Warrior("Bob", warriorAttributes, sword, shield));
		this.listOfFighter.add(new Wizard("Merlon", wizardAttributes, offenseSpell, healSpell));
		this.listOfFighter.add(new Athlete("Ryu", athleteAttributes, defenseSpell, sword));
	}

}
