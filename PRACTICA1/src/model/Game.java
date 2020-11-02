package model;

import java.util.Random;

import model.Lists.SlayerList;
import model.Lists.VampireList;

public class Game {
	
	private SlayerList slayerList;
	private VampireList vampireList;
	private Level level;
	private Player player;
	Random rand;
	
	public Game (long seed, Level level) {
		
		  this.level = level;
		  player = new Player(50);
		  rand = new Random(seed);
		  slayerList = new SlayerList(Level.getRows(level));
		  vampireList = new VampireList(Level.getRows(level), rand);
	}

	
	public static int getX (Game game) {
		
		int x = Level.getRows(game.level);
		return x;
	}
	
	public static int getY (Game game) {
		
		int y = Level.getCols(game.level);
		return y;
	}
	
	public boolean isFinished(boolean end) {
		return end;
	}

	public String getPositiontoString( int x, int y) {
		
		//si el slayer/vamiro esta en la casilla x y me devuelve "  " o "   "
		
		if(slayerList.isInPosition(x, y))
			return slayerList.getSlayerInPosition(x, y).toString() + " ["+slayerList.vidaS(x, y)+"]";
		else if(vampireList.isInPosition(x, y))
			return vampireList.getVampireInPosition(x, y).toString() + " ["+vampireList.vidaV(x, y)+"]";
		
		
		else return " ";
	}


	public void update() {
		
		player.earn(rand);
	
		for(int i=0; i<Level.getRows(level); i++) {
			for (int j=0; j<Level.getCols(level); j++) {
			
				if(slayerList.isInPosition(j, i)) {
					//System.out.println("ESTA EN LAS POSICOINES X:  "+ i+ "    Y:    "+j);
					for(int n=i+1; n<Level.getRows(level); n++) {
						if(vampireList.isInPosition(j, n)) {
							//System.out.println("VVVVVVVVVVV X:  "+ i+ "    Y:    "+j);
							vampireList.getVampireInPosition(j, n).gotHitV();
						}
					}
				}
				
			}
			}
		
		for(int i=0; i<Level.getRows(level); i++) {
			for (int j=0; j<Level.getCols(level); j++) {
				
				if(vampireList.isInPosition(j, i)) {
					vampireList.getVampireInPosition(j, i).advance();
					System.out.println("LLLLLLLLLLLLLLLLLLLL    i:  "+ i+ "    j:    "+j);
				}
			}
		}
		
	}
	
	
	public boolean addSlayer(int x , int y) {
		if(!slayerList.isInPosition(x, y) && !vampireList.isInPosition(x, y)) {
		slayerList.addS(x, y);
		return true;
		}
		else return false;
	}
	
	public boolean addVampire() {
	if(rand.nextDouble()<Level.getProb(level)) {
		int pos = rand.nextInt(Level.getCols(level));
		if(!vampireList.isInPosition(pos, Level.getRows(level)-1) && !slayerList.isInPosition(pos, Level.getRows(level)-1)) {
		vampireList.addV(pos, Level.getRows(level)-1);
		return true;
		}
		else return false;
	}return false;
	}
	
	
	/*public static VampireList[] remueveElement(VampireList[] arrayObjetos, int i) {
		
	      System.arraycopy(arrayObjetos, i + 1, vampire,i, arrayObjetos.length - 1 - i);
	      return arrayObjetos; 
	   }*/
	
}


