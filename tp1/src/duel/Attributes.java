package duel;

public class Attributes {

	private int strenght;
	private int dexterity;
	private int intelligence;
	private int focus;
	
	public Attributes(int strenght, int dexterity, int intelligence, int focus) {
		this.setStrenght(strenght);
		this.setDexterity(dexterity);
		this.setIntelligence(intelligence);
		this.setFocus(focus);
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getFocus() {
		return focus;
	}

	public void setFocus(int focus) {
		this.focus = focus;
	}
	
}
