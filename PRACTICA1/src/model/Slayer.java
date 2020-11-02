package model;

public class Slayer {

	private int x;
	private int y;
	private int health;
	
	public Slayer( int x, int y, int health) {
		this.x = x;
		this.y = y;
		this.health = health;
	}
	
	public String toString() {
		return "S";
	}
	
	public boolean isInPosition(int x , int y) {
		
		return this.x == x && this.y == y;
		
	}
	
	public  boolean idDead() {
		if(health == 0) return true;
		else return false;
	}
	
	public int puntosVidaS() {
		return health;
	}
	

	
}
