package Sprint4;

public class CommunityChest {
	
	public static int currPlayer;

	public static void cc1(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Away ya go to GO! \n");
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[0][0]+((currPlayer % 3) * Board.offset),Board.BoardCoord[0][1]+((currPlayer / 3) * Board.offset));

	}

	public static void cc2(){
		
	    currPlayer = Board.currentPlayer;
		int position = Board.PlayerArray[currPlayer].position;
		
		Board.textArea.append("Away ya go back to  ! \n");
		
		position = 18;
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[0][0]+((currPlayer % 3) * Board.offset),Board.BoardCoord[0][1]+((currPlayer / 3) * Board.offset));

	}
	
	public static void cc3(){
		
		currPlayer = Board.currentPlayer;
		int position = Board.PlayerArray[currPlayer].position;
		
		Board.textArea.append("Illegal activity ? Away to jail ya go. \n Dont collect $200 if you pass go. \n");
		position = 10;
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset), Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));
		Board.PlayerArray[currPlayer].inJail = true;
	}

	public static void cc4(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Sick as a dog and have to go to hospital. $100 payment \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 100;
	}
	
	public static void cc5(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Doctors fine $50. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 50;
	}

	public static void cc6(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Car insurance due on your yoke. $50 bucks owed. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 50;
	}
	
	public static void cc7(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Bank messed your account up. Heres $200. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 200;
	}

	public static void cc8(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Amunity matures. Heres $100. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 100;
	}
	
	public static void cc9(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Oul boys after giving you $100 for food. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 100;
	}

	public static void cc10(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("From selling a bars out of your locker ya made $50. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance  + 50;
	}
	
	public static void cc11(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Recieve interest of 7% preference shares: $25 \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 25;
	}

	public static void cc12(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Tax refund of $20. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 20;
	}
	
	public static void cc13(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("You won second prize in a beauty contest: Collect $10. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 10;
	}

	public static void cc14(){
		
		currPlayer = Board.currentPlayer;
		int money = 0; 
		
		Board.textArea.append("Its your birthday ! Collect $10 from each player. Cheek of that. \n");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 10;
		
		for(int i = 0; i < Board.numberPlayers - 1; i++){
			
			Board.PlayerArray[i].balance = Board.PlayerArray[i].balance - 10;
			money += 10;
			
			if(Board.PlayerArray[currPlayer] == Board.PlayerArray[i]){
				Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + money;
			}
			
			
		}

	}
	
	public static void cc15(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Get out of jail free. This card may be kept until needed or sold \n");
	}

	public static void cc16(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Pay a $10 fine or take a chance card. \n");
		
		if(currPlayer != 3){
			Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 10;
		}
		else{
			//Command.drawChance();
		}
		//Get user input and use if statement to decide which route to go
	}
}
