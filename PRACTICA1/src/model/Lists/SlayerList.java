package model.Lists;

import java.util.Random;

import model.Slayer;

public class SlayerList {

	Slayer[] slayers;
	int nSlayers;
	Random rand = new Random();
	
	public SlayerList(int tamano) {
	
		slayers = new Slayer[tamano];
		nSlayers=0;
		/*
		 * for(int i = 0; i< 8; i++) {
			if(rand.nextFloat() < 0.5) {
				System.out.println("Creando slayers:  " + i);
				slayers[nSlayers] = new Slayer(1,i,3);
				nSlayers++;
			}
		}
		System.out.println();
		*/
	}

	public boolean isInPosition(int x, int y) {
		
		
		for(int i = 0; i< nSlayers; i++) {
			if(slayers[i].isInPosition(x, y)) return true;
		}
		return false;
	}

	public Slayer getSlayerInPosition(int x, int y) {
		
		for(int i = 0; i< nSlayers; i++) {
			if(slayers[i].isInPosition(x, y)) return slayers[i];
		}
		return null;
	}
	
	public int vidaS(int x , int y) {
		int puntos = 0;

		for(int i = 0; i< nSlayers; i++) {
			if(slayers[i].isInPosition(x, y))
				puntos = slayers[i].puntosVidaS();
		}
		return puntos;
	}
	
	public void addS(int x, int y) {
		
		
		slayers[nSlayers] = new Slayer(x,y,3);
		nSlayers++;

	}
	
}
