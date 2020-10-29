package factories;

import abstraction.Skills;

public class SkillsFactory {

	public enum SkillType{
		ATTACK, PARY, HEAL;
	}

	
	public Skills createdSkill(SkillType type) {
		
		switch(type) {
		case ATTACK : return new
		}
	}
}
