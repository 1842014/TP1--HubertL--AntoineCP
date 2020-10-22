package duel;

import java.util.ArrayList;
import java.util.List;

import abstraction.Skills;

public abstract class Fighter {

	private String name;
	private Attributes attributes;
	private Skills firstSkill;
	private Skills secondSkill;
	private int healthPoints;
	
	private List<Skills> skills = new ArrayList<Skills>();
	
	
	public Fighter(String name, Attributes attributes, Skills firstSkill, Skills secondSkill, int healthPoints) {
		this.name = name;
		this.attributes = attributes;
		this.firstSkill = firstSkill;
		this.secondSkill = secondSkill;
		this.healthPoints = healthPoints;
	}
	
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
		if(this.healthPoints > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean hasTheSkill(Skills skill) {
		return true;
	}
}
