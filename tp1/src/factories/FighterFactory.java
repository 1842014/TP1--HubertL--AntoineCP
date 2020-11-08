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
		ATHLETE,WARRIOR,WIZARD;
	}
	public Fighter CreateFighter(FighterType type, String name, Attributes attributes,Skills firstSkill, Skills secondSkill) {
		
		switch(type){
		case ATHLETE:
			return new Athlete(name, attributes, firstSkill, secondSkill);
		case WARRIOR:
			return new Warrior(name, attributes, firstSkill, secondSkill);
		case WIZARD:
			return new Wizard(name, attributes, firstSkill, secondSkill);
	
			
		}
		throw new NotImplementedTypeException();

	}
}
