package monopoly_take2;

import javax.swing.JOptionPane;

public class PlayerStart {
	
	String name;
	int roll;

	
	public PlayerStart(String playerName, int number){
		name = playerName;
		roll = number;
		
	}
	
	public static void playersInitialise(int playerCount, Players[] PlayerArray){
		
		PlayerStart[] PlayerOrder = new PlayerStart[playerCount + 1];//class to see who goes first
		Dice di = new Dice();
		
		String[] names = new String[playerCount];
		
		//getting user input and calling roll function
		for(int i = 0; i < playerCount; i++)
		{
			String temp = JOptionPane.showInputDialog(null, "Enter name for player "+ (i+1) +" :");
			
			int roll = di.total();
			PlayerOrder[i] = new PlayerStart(temp, roll);//assigning values to player i	
			
		}
		
		
		//function if two players roll the same number
		for (int i = 0; i < playerCount; i++) { 
			for (int j = i + 1 ; j < playerCount; j++) { 
				if (PlayerOrder[i].roll == PlayerOrder[j].roll) { 
					PlayerOrder[j].roll = di.total();
				}
			}
		}
		
		//sorting the players based on player roll with temp variable of type PlayerStart
		PlayerStart temp;
		for (int a = 0; a < playerCount-1; ++a){
		    for (int b = 0; b < playerCount-1; ++b){
		        if ( PlayerOrder[b].roll < PlayerOrder[b + 1].roll){
		            temp = PlayerOrder[b];
		            PlayerOrder[b] = PlayerOrder[b + 1];
		            PlayerOrder[b + 1] = temp;
		        }
		    }
		}
		
		for(int i=0; i<playerCount; i++){
			names[i] = PlayerOrder[i].name;
			Board.textArea.append("player "+names[i]+" goes "+(i+1)+"\n");
		}
		for(int j = 0; j < playerCount; j++)
		{

			PlayerArray[j] = new Players(names[j]);
		}
	}
}
