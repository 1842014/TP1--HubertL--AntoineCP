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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Simulator();
	}
	Attributes warriorAttributes = new Attributes(40, 25,20, 15);
	Skills sword = new Sword(20);
	Skills shield = new Sheild(20);
	Attributes athleteAttributes = new Attributes(20, 20, 20, 20);
	Skills offenseSpell = new OffenseSpell(20);
	Skills defenseSpell = new DefenseSpell(20);
	Attributes wizardAttributes = new Attributes(10, 10, 40, 40);
	Skills healSpell = new HealSpell(20);
	Skills remedy = new Remedy(20);
	
	private List<Fighter> listOfFighter = new ArrayList<Fighter>();
	
	public Simulator() {
		this.seedData();
		this.printData("Voici les combatants");
	}

	private void printData(String title) {
		// TODO Auto-generated method stub
		System.out.println();
        System.out.println(title);
        for (Fighter fighter: listOfFighter) {
        	System.out.println(fighter.toString());
        }
	}

	private void seedData() {
		// TODO Auto-generated method stub
		this.listOfFighter.add(new Warrior("Bob", warriorAttributes, sword, shield));
		this.listOfFighter.add(new Wizard("Merlon", wizardAttributes, offenseSpell, defenseSpell));
		this.listOfFighter.add(new Athlete("Ryu", athleteAttributes, healSpell, remedy));
	}

}
