package control;

import java.util.Scanner;

import model.Game;
import view.GamePrinter;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

	private GamePrinter printer;
    private Game game;
	private Scanner scanner;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
    
    public void  printGame() {
    	System.out.println(game);
   } 
    
    public void run() {
		boolean fin = false;
    	
    	while (!game.isFinished(fin)) {    
    		
    	
    		//mientras no termine el juego	
    			//leer del teclado ++
    			//ejecutar la orden 
    			//actualizar juego
    			//pintar el juego +++
    	
    	printer = new GamePrinter (game, Game.getX(game), Game.getY(game));
    	
    	System.out.print(printer);
    	
    	System.out.println(prompt);
    	
    	String[] cmdTokens = scanner.nextLine().toLowerCase().split(" ");
    	String cmd = cmdTokens[0];
    	
    	int x = -1;
    	int y = -1;
    	
    	switch(cmd) {
    		//---------------------------------------------
    		case"a":
    		case"add": 
    			x = Integer.parseInt(cmdTokens[1]);
    			y = Integer.parseInt(cmdTokens[2]);
    			if((y>=0 && y<Game.getX(game)-1) && (x>=0 && x<Game.getY(game))) {
    			if(!game.addSlayer(x, y))
    				System.out.println(invalidPositionMsg);
    			}
    			else System.out.println(invalidPositionMsg);
    		break;
    		//---------------------------------------------	
    		case"h":
    		case"help": 
    			System.out.println(helpMsg);
    			break;
    		//---------------------------------------------
    		case"r":
    		case"reset": 
    			System.out.println(helpMsg);
    			break;
    		//---------------------------------------------	
    		
    		case"e":
    		case"exit": 
    			fin = true;
    			System.out.println("   GG   ");
    			break;
    		//---------------------------------------------	
    			
    		case"":
    		case"n": 
    		case"none": 
    			System.out.println("HOLIIII");
    			if(game.addVampire()) {
    				System.out.println("Se ha generado un vampiro");
    			}
    			break;
    		//---------------------------------------------	
    	}// end switch
    	game.update();
    	System.out.println("-------------------------------------------------------------------");
    	}           
    }

}

