package model;

import java.util.Random;

public class Player {

	private int money;
	
	public Player(int money) {
		this.money = money;

	}
	
	public void earn(Random rand) {
		if(rand.nextFloat() < 0.5)
			money = money + 10;
		
	}
}
