import java.util.ArrayList;
import java.util.List;

import abstraction.Attackable;
import abstraction.Healable;
import abstraction.Parryable;
import duel.Attributes;
import duel.Duel;
import duel.Fighter;
import duel.Infirmary;
import exception.NoHealableException;
import factories.FighterFactory;
import factories.FighterFactory.FighterType;
import factories.SkillsFactory;
import factories.SkillsFactory.AttackSkill;
import factories.SkillsFactory.DefenseSkill;
import factories.SkillsFactory.HealSkill;

public class Simulator {

	private static final int ANY_VALUE = 20;

	public static void main(String[] args) {
		new Simulator();
	}
	
	private List<Fighter> listOfFighter = new ArrayList<Fighter>();
	private FighterFactory fighterFactory = new FighterFactory();
	private SkillsFactory skillsFactory = new SkillsFactory();
	private Healable remedy =  skillsFactory.createHealsSkill(HealSkill.REMEDY, ANY_VALUE);
	
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
		duel.giveWinnerBonus(skillsFactory.createHealsSkill(HealSkill.REMEDY, ANY_VALUE));
		
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
		duel.giveWinnerBonus(skillsFactory.createHealsSkill(HealSkill.REMEDY, ANY_VALUE));
		
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
		Attributes warriorAttributes = new Attributes(40, 25,20, 15);
		Attackable sword = skillsFactory.createAttackSkill(AttackSkill.SWORD, ANY_VALUE);
		Parryable shield = skillsFactory.createDefenseSkill(DefenseSkill.SHEILD, ANY_VALUE);
		Attributes athleteAttributes = new Attributes(20, 20, 20, 20);
		Attackable offenseSpell = skillsFactory.createAttackSkill(AttackSkill.OFFENSE_SPELL, ANY_VALUE);
		Parryable defenseSpell = skillsFactory.createDefenseSkill(DefenseSkill.DEFENSE_SPELL, ANY_VALUE);
		Attributes wizardAttributes = new Attributes(10, 10, 40, 40);
		Healable healSpell = skillsFactory.createHealsSkill(HealSkill.HEAL_SPELL, ANY_VALUE);
		
		this.listOfFighter.add(fighterFactory.CreateFighter(FighterType.WARRIOR, "Bob", warriorAttributes, sword, shield));
		this.listOfFighter.add(fighterFactory.CreateFighter(FighterType.WIZARD, "Merlon", wizardAttributes, offenseSpell, healSpell));
		this.listOfFighter.add(fighterFactory.CreateFighter(FighterType.ATHLETE, "Ryu", athleteAttributes, defenseSpell, sword));
	}

}
