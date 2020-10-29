package factories;

import abstraction.Skills;
import duel.Athlete;
import duel.Attributes;
import duel.Fighter;
import duel.Warrior;
import duel.Wizard;
import exception.NotImplementedTypeException;

public class FighterFactory {
	public enum FighterType{
		ATHLETE,WARRIOR,WIZARD,UNKNOWN;
	}
	public Fighter CreateFighter(FighterType type, String name, Attributes attributes,Skills firstSkill, Skills secondSkill) {
		
		switch(type){
		case ATHLETE:
			return new Athlete(name, attributes, secondSkill, secondSkill);
		case WARRIOR:
			return new Warrior(name, attributes, secondSkill, secondSkill);
		case WIZARD:
			return new Wizard(name, attributes, secondSkill, secondSkill);
	
			
		}
		throw new NotImplementedTypeException();

	}
}
