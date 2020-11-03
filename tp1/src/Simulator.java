import java.util.ArrayList;
import java.util.List;

import abstraction.Skills;
import duel.Athlete;
import duel.Attributes;
import duel.Fighter;
import duel.Warrior;
import duel.Wizard;
import skills.DefenseSpell;
import skills.HealSpell;
import skills.OffenseSpell;
import skills.Remedy;
import skills.Sheild;
import skills.Sword;

public class Simulator {

	private static final int ANY_VALUE = 20;

	public static void main(String[] args) {
		new Simulator();
	}
	Attributes warriorAttributes = new Attributes(40, 25,20, 15);
	Skills sword = new Sword(ANY_VALUE);
	Skills shield = new Sheild(ANY_VALUE);
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
		this.listOfFighter.add(new Wizard("Merlon", wizardAttributes, offenseSpell, defenseSpell));
		this.listOfFighter.add(new Athlete("Ryu", athleteAttributes, healSpell, remedy));
	}

}
