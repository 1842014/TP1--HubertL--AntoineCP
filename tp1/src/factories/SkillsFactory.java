package factories;

import abstraction.Attackable;
import abstraction.Healable;
import abstraction.Parryable;
import exception.NotImplementedTypeException;
import skills.DefenseSpell;
import skills.HealSpell;
import skills.OffenseSpell;
import skills.Remedy;
import skills.Sheild;
import skills.Sword;

public class SkillsFactory {

	public enum AttackSkill{
		SWORD, OFFENSE_SPELL;
	}
	
	public enum DefenseSkill{
		SHEILD, DEFENSE_SPELL;
	}

	public enum HealSkill{
		REMEDY, HEAL_SPELL;
	}
	
	public Attackable createAttackSkill(AttackSkill skill, int value) {
		
		switch(skill) {
		case SWORD : return new Sword(value);
		
		case OFFENSE_SPELL : return new OffenseSpell(value);
		}
		throw new NotImplementedTypeException();
	}

	
	public Parryable createDefenseSkill(DefenseSkill skill, int value) {
		
		switch(skill) {
		case SHEILD : return new Sheild(value);
		
		case DEFENSE_SPELL : return new DefenseSpell(value);
		}
		throw new NotImplementedTypeException();
	}

	
	public Healable createHealsSkill(HealSkill skill, int value) {
		
		switch(skill) {
		case REMEDY : return new Remedy(value);
		
		case HEAL_SPELL : return new HealSpell(value);
		}
		throw new NotImplementedTypeException();
	}
}
