package model.Lists;

import java.util.Random;

import model.Vampire;

public class VampireList {

	Vampire[] vampires;
	int nVampires;
	
	public VampireList(int tamano, Random rand) {
	
		vampires = new Vampire[tamano];
		nVampires=0;
		/*for(int i = 0; i< 8; i++) {
			if(rand.nextFloat() < 0.5) {
				System.out.println("Creando vampires:  " + i);
				
				vampires[nvampires] = new Vampire(2,i,5);
				nvampires++;
			}
		}
		System.out.println();*/
	}

	public boolean isInPosition(int x, int y) {
		
		
		for(int i = 0; i< nVampires; i++) {
			if(vampires[i].isInPosition(x, y)) return true;
		}
		return false;
	}

	public Vampire getVampireInPosition(int x, int y) {
		
		for(int i = 0; i< nVampires; i++) {
			if(vampires[i].isInPosition(x, y)) return vampires[i];
		}
		return null;
	}
	
	public int vidaV(int x , int y) {
		int puntos = 0;

		for(int i = 0; i< nVampires; i++) {
			if(vampires[i].isInPosition(x, y))
				puntos = vampires[i].puntosVidaV();
		}
		return puntos;
	}
	
	
	public void addV(int x, int y) {

		vampires[nVampires] = new Vampire(x,y,5);
		//System.out.println("++++++++++++++++++++++      "+nVampires);
		nVampires++;
	}
	

}
