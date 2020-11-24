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
		this.attributes = attributes;//MS: Prendre une copie de l'instance d'objet Abilities (encapsulation)
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
	
	private int getTotalAttributes() {//MS: supprimer le code mort
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
	
	public int setHealthPoints() {//MS: méthode devrait être privée
		return BASE_HEALTH_POINTS - this.getTotalAttributes();
	}
	public void heal(int hpToAdd) {
		this.healthPoints += hpToAdd;
		
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
	
	@Override
	public String toString() {
		return getName() + " Attributs: " + getStrenght() +" "+ getDexterity() +" "+ getIntelligence() +" "+ getFocus() + " Skills: " + getSkills().toString() + " HP: "+getHealthPoints();
	}
	
	
	public void giveBonusAttributes() {//MS: SRP->Single Responsability Ce n'est pas la responsabilité du fighter de donner le bonus. Doit seulement offrir des get/set.
		this.setAttributes(getStrenght() + BONUS_ATTRIBUTES,
				getDexterity() + BONUS_ATTRIBUTES, 
				getIntelligence() + BONUS_ATTRIBUTES, 
				getFocus() + BONUS_ATTRIBUTES);
	}


	public void givePenalityAttributes() {//MS: SRP->Single Responsability Ce n'est pas la responsabilité du fighter de donner les pénalités. Doit seulement offrir des get/set.
		this.setAttributes(getStrenght() - PENALITY_ATTRIBUTES,
				getDexterity() - PENALITY_ATTRIBUTES, 
				getIntelligence() - PENALITY_ATTRIBUTES, 
				getFocus() - PENALITY_ATTRIBUTES);
	}


	public void setAttributes(int newStrenght, int newDexterity, int newIntelligence, int newFocus) {//MS: méthode devrait être privée
		this.attributes.setStrenght(newStrenght);
		this.attributes.setDexterity(newDexterity);
		this.attributes.setIntelligence(newIntelligence);
		this.attributes.setFocus(newFocus);
	}
}
