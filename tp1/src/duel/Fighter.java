package duel;

import java.util.ArrayList;
import java.util.List;

import abstraction.Skills;
import exception.IllegalAttributeTotal;

public abstract class Fighter {

	private static final int BONUS_ATTRIBUTES = 1;
	private static final int DEATH_POINT = 0;
	private static final int MAX_TOTAL_ATTRIBUTES = 100;
	private static final int BASE_HEALTH_POINTS = 200;
	private static final int PENALITY_ATTRIBUTES = 1;
	
	//Attributs
	private String name;
	private Attributes attributes;
	private int healthPoints;
	private List<Skills> skills = new ArrayList<Skills>();

	

	
	//Constructeur
	public Fighter(String name, Attributes attributes, Skills firstSkill, Skills secondSkill) {
		this.name = name;
		this.validateAttributes(attributes);
		this.attributes = attributes;
		this.healthPoints = this.setHealthPoints();
		this.addSkill(firstSkill);
		this.addSkill(secondSkill);

	}	


	//Méthodes privées
	private void validateAttributes(Attributes attributes) {
		int attributesTotal = getTotalAttributes(attributes);
		if(attributesTotal > MAX_TOTAL_ATTRIBUTES) {
			throw new IllegalAttributeTotal();
		}
	}
	
	private int getTotalAttributes() {
		return attributes.getStrenght() + attributes.getDexterity() + attributes.getIntelligence() + attributes.getFocus();
	}
	private int getTotalAttributes(Attributes attributes) {
		return attributes.getStrenght() + attributes.getDexterity() + attributes.getIntelligence() + attributes.getFocus();
	}


	//Méthodes Publiques
	public String getName() {
		return this.name;
	}
	
	public int getStrenght() {
		return this.attributes.getStrenght();
	}
	
	public int getDexterity() {
		return this.attributes.getDexterity();
	}
	
	public int getIntelligence() {
		return this.attributes.getIntelligence();
	}
	
	public int getFocus() {
		return this.attributes.getFocus();
	}
	
	public int getHealthPoints() {
		return this.healthPoints;
	}
	
	public int setHealthPoints() {
		return BASE_HEALTH_POINTS - this.getTotalAttributes();
	}
	
	public void decreaseHealthPoints(int healthToRemove) {
		this.healthPoints -= healthToRemove;
	}
	
	public boolean isAlive() {
		if(this.healthPoints > DEATH_POINT) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean hasTheSkill(Skills skillToCheck) {
		for(Skills skill : this.skills) {
			if(skill.equals(skillToCheck)) {
				return true;
			}
		}
		return false;
	}
	
	public void addSkill(Skills skill) {
		this.skills.add(skill);
	}
	
	public void removeSkill(Skills skill) {
		this.skills.remove(skill);
	}
	
	public int getPower(Skills skill) {
		return skill.getValue(this);
	}
	
	public List<Skills> getSkills(){
		return this.skills;
	}

	public void giveBonusAttributes() {
		this.attributes.setDexterity(getDexterity() + BONUS_ATTRIBUTES);
		this.attributes.setFocus(getFocus() + BONUS_ATTRIBUTES);
		this.attributes.setIntelligence(getIntelligence() + BONUS_ATTRIBUTES);
		this.attributes.setStrenght(getStrenght() + BONUS_ATTRIBUTES);
	}


	public void givePenalityAttributes() {
		this.attributes.setDexterity(getDexterity() - PENALITY_ATTRIBUTES);
		this.attributes.setFocus(getFocus() - PENALITY_ATTRIBUTES);
		this.attributes.setIntelligence(getIntelligence() - PENALITY_ATTRIBUTES);
		this.attributes.setStrenght(getStrenght() - PENALITY_ATTRIBUTES);
	}


	public void setAttributes(int newStrenght, int newDexterity, int newIntelligence, int newFocus) {
		this.attributes.setStrenght(newStrenght);
		this.attributes.setDexterity(newDexterity);
		this.attributes.setIntelligence(newIntelligence);
		this.attributes.setFocus(newFocus);
	}
}
