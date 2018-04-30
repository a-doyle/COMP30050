import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Panopoly {
	
	public static final int START_BALANCE = 1000;
	public static final int FINE = 80;
	public static final int PASSED_START = 150;
	
	public static Player currentPlayer;
	public static Dice dice;
	
	public static boolean gameOver;
	public static boolean rollOver;
	public static boolean doubleRoll;
	public static boolean playerBankrupt;
	public static boolean turnOver;
	
	public static ArrayList<Player> players;


	
	public Panopoly() {
		/*
		 * Constructor to start the UI and other methods needed for the game.
		 * 
		 * */
		
		gameOver = false;
		rollOver = false;
		doubleRoll = false;
		playerBankrupt = false;
		players = new ArrayList<Player>();
		
	}
	
	public void addPlayers() {
		
		boolean validInput = false;
		int 	numberOfPlayers =  Integer.parseInt(JOptionPane.showInputDialog("Enter the number of players: \n(Max players: 6, Min: 3. The rest will be filled with bots.)"));
		Player p;
		
		if(numberOfPlayers < 2 && numberOfPlayers > 6) {
			while(!validInput) {
			
				numberOfPlayers =  Integer.parseInt(JOptionPane.showInputDialog("Enter the number of players: \n(Max players: 6, Min: 3. The rest will be filled with bots.)"));
			
				if(numberOfPlayers > 2 && numberOfPlayers < 6) {
					validInput = true;
				}
			}
		}
		
		for(int i = 0; i < numberOfPlayers; i++) {
			
			String playersInfo = JOptionPane.showInputDialog("Name:");
			p = new Player(playersInfo);
			players.add(p);
			
			System.out.println(players);
		}
		
	}
	
	public void decideStartPlayer() {
		
		boolean tie;
		int highestRoll = 0;
	
	}
	
	public void playerActions(){
		
	}

	public void rollCommands(){
		
		if(!rollOver) {
			if(currentPlayer.getBalance() > 0) {
				dice.total();
				/*
				 * Player moves to correct square
				 * 
				 */
				if(currentPlayer.isInJail() == true) {
					dice.isDouble();
					currentPlayer.escapeAttemptsMade();
				}
				if(currentPlayer.passedGo()) {
					
				}
				//if(currentPlayer.)
				/*
				 * Make the required updates to the game, board and other classes
				 * 
				 */
			}
		}
		
	}
	
	public void buyCommand() {
		
	}
	
	public static void main(String[] args) {
		
		Panopoly p = new Panopoly();
		
		p.addPlayers();
	}
}
