package duel;

import java.util.ArrayList;
import java.util.List;

import abstraction.Skills;
import exception.IllegalAttributeTotal;

public abstract class Fighter {

	private static final int DEATH_POINT = 0;
	private static final int MAX_TOTAL_ATTRIBUTES = 100;
	private static final int BASE_HEALTH_POINTS = 200;
	
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
		this.addSkills(firstSkill);
		this.addSkills(secondSkill);

	}	


	//Méthodes privées
	private void validateAttributes(Attributes attributes) {
		int attributesTotal = getTotalAttributes(attributes);
		if(attributesTotal > MAX_TOTAL_ATTRIBUTES) {
			throw new IllegalAttributeTotal();
		}
	}

	private void addSkills(Skills skill) {
		this.skills.add(skill);
	}
	
	private int getTotalAttributes() {
		return attributes.getStrenght() + attributes.getDexterity() + attributes.getIntelligence() + attributes.getFocus();
	}
	private int getTotalAttributes(Attributes attributes) {
		return attributes.getStrenght() + attributes.getDexterity() + attributes.getIntelligence() + attributes.getFocus();
	}
	
	private int setHealthPoints() {
		return BASE_HEALTH_POINTS - this.getTotalAttributes();
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
}
