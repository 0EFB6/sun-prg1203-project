package Assignment;

public class Stats{
	public int health;
	public int special_attack;
	public int defend;
	public int special_defend;
	public int speed;
	
	public Stats(){
		health = 0;
		special_attack = 0;
		defend = 0;
		special_defend = 0;
		speed = 0;
	}
	
	public Stats(int health, int special_attack, int defend, int special_defend, int speed) {
		super();
		this.health = health;
		this.special_attack = special_attack;
		this.defend = defend;
		this.special_defend = special_defend;
		this.speed = speed;
	}

	public final int getHealth() {
		return health;
	}

	public final void setHealth(int health) {
		this.health = health;
	}

	public final int getSpecial_attack() {
		return special_attack;
	}

	public final void setSpecial_attack(int special_attack) {
		this.special_attack = special_attack;
	}

	public final int getDefend() {
		return defend;
	}

	public final void setDefend(int defend) {
		this.defend = defend;
	}

	public final int getSpecial_defend() {
		return special_defend;
	}

	public final void setSpecial_defend(int special_defend) {
		this.special_defend = special_defend;
	}

	public final int getSpeed() {
		return speed;
	}

	public final void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "stats [health=" + health + ", special_attack=" + special_attack + ", defend=" + defend
				+ ", special_defend=" + special_defend + ", speed=" + speed + "]";
	}
	
	
	
}
