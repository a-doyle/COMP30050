package monopoly_take2;

public class CommunityChest {
	
	public static void cc1(){
		int player = Board.currPlayer;
		
		Board.textArea.append("You've been offered a sponsorship, collect your first pay package at Go!");
		Board.playerIcons[player].setLocation(Board.boardPos[0][0]+((player % 3) * Board.offset),Board.boardPos[0][1]+((player / 3) * Board.offset));
	}

	public static void cc2(){
		int player = Board.currPlayer;
		Board.textArea.append("Take a trip to your local supp store!");
		Board.playerIcons[player].setLocation(Board.boardPos[0][0]+((player % 3) * Board.offset),Board.boardPos[0][1]+((player / 3) * Board.offset));

	}
	
	public static void cc3(){
		int player = Board.currPlayer;
		int position = Board.PlayerArray[player].position;
		
		Board.textArea.append("Caught with roids? You've been slapped with cuffs and face extensive jail time!");
		position = 10;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * Board.offset), Board.boardPos[position][1] + ((player / 3) * Board.offset));
		Board.PlayerArray[player].inJail = true;
	}

	public static void cc4(){
		int player = Board.currPlayer;
		
		Board.textArea.append("You drank some badd egg whites, and are forced to fork out a bill for the doctor!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance - 100;
	}
	
	public static void cc5(){
		int player = Board.currPlayer;
		
		Board.textArea.append("Payday leads to an expensive supp stock up!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance - 150;
	}

	public static void cc6(){
		int player = Board.currPlayer;
		
		Board.textArea.append("Direct debit on your gym membership is due, pay 50!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance - 50;
	}
	
	public static void cc7(){
		int player = Board.currPlayer;
		
		Board.textArea.append("You were charged twice for that protein order, here's 200!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 200;
	}

	public static void cc8(){
		int player = Board.currPlayer;
		
		Board.textArea.append("You set new records in the gym and were awarded 100!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 100;
	}
	
	public static void cc9(){
		int player = Board.currPlayer;
		
		Board.textArea.append("Investments have paid off and resulted in you getting 100!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 100;
	}

	public static void cc10(){
		int player = Board.currPlayer;
		
		Board.textArea.append("Dealing protein bars on the side result in a cash surplus of 50!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  + 50;
	}
	
	public static void cc11(){
		int player = Board.currPlayer;
		
		Board.textArea.append("Interest in the gym pays dividends, here's 25!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 25;
	}

	public static void cc12(){
		int player = Board.currPlayer;
		
		Board.textArea.append("Taxback of 75!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 75;
	}
	
	public static void cc13(){
		int player = Board.currPlayer;
		
		Board.textArea.append("Pay your gym membership!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance - 200;
	}

	public static void cc14(){
		int player = Board.currPlayer;
		int money = 0; 
		
		Board.textArea.append("To mark your birthday, every player gives you cash to fuel your upcoming restock!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + (15 * Board.playerCount);
		for(int i = 0; i < Board.playerCount - 1; i++){
			Board.PlayerArray[i].balance = Board.PlayerArray[i].balance - 15;
			money += 15;
			if(Board.PlayerArray[player] == Board.PlayerArray[i]){
				Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + money;
			}	
		}
	}
	
	public static void cc15(){
		Board.textArea.append("You've been offered pure creatine, undetectable by the law. Use it if you're caught to escape!");
	}

	public static void cc16(){
		int player = Board.currPlayer;
		
		Board.textArea.append("Pay your dealer what you owe, or take a chance!");
		if(player != 3) {
			Board.PlayerArray[player].balance = Board.PlayerArray[player].balance - 25;
		} else {
			Command.drawChance();
		}
	}
}