package model;

public class Vampire {

	private int x;
	private int y;
	private int health;
	private int canMove = -1; 
	
	public Vampire( int x, int y, int health) {
		this.x = x;
		this.y = y;
		this.health = health;
	}
	
	public String toString() {
		return "V";
	}
	
	public boolean isInPosition(int x , int y) {
		
		return this.x == x && this.y == y;
	}
	
	public  boolean idDead() {
		if(health == 0) return true;
		else return false;
	}
	
	public void advance() {
		System.out.println("LLLLLLLLLLLLLLLLLLLL    X:  "+ x+ "    Y:    "+y);
		if(canMove == 1) {
		y = y - 1;
		canMove = canMove * (-1);
		}
		else canMove = canMove * (-1);
	}
	
	public int puntosVidaV() {
		return health;
	}
	public void gotHitV() {
		health = health -1;
	}
}
