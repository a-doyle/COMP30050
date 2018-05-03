package monopoly_take2;

public class CommunityChest {
	
	public static void cc1(){
		int player = Board.currPlayer;
		
		UI.textArea.append("You've been offered a sponsorship, collect your first pay package at Go!");
		Board.playerIcons[player].setLocation(Board.boardPos[0][0]+((player % 3) * UI.uqLoc),Board.boardPos[0][1]+((player / 3) * UI.uqLoc));
	}

	public static void cc2(){
		int player = Board.currPlayer;
		UI.textArea.append("Take a trip to your local supp store!");
		Board.playerIcons[player].setLocation(Board.boardPos[0][0]+((player % 3) * UI.uqLoc),Board.boardPos[0][1]+((player / 3) * UI.uqLoc));

	}
	
	public static void cc3(){
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		
		UI.textArea.append("Caught with roids? You've been slapped with cuffs and face extensive jail time!");
		position = 10;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc), Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
		Board.playerList[player].inJail = true;
	}

	public static void cc4(){
		int player = Board.currPlayer;
		
		UI.textArea.append("You drank some badd egg whites, and are forced to fork out a bill for the doctor!");
		Board.playerList[player].balance = Board.playerList[player].balance - 100;
	}
	
	public static void cc5(){
		int player = Board.currPlayer;
		
		UI.textArea.append("Payday leads to an expensive supp stock up!");
		Board.playerList[player].balance = Board.playerList[player].balance - 150;
	}

	public static void cc6(){
		int player = Board.currPlayer;
		
		UI.textArea.append("Direct debit on your gym membership is due, pay 50!");
		Board.playerList[player].balance = Board.playerList[player].balance - 50;
	}
	
	public static void cc7(){
		int player = Board.currPlayer;
		
		UI.textArea.append("You were charged twice for that protein order, here's 200!");
		Board.playerList[player].balance = Board.playerList[player].balance + 200;
	}

	public static void cc8(){
		int player = Board.currPlayer;
		
		UI.textArea.append("You set new records in the gym and were awarded 100!");
		Board.playerList[player].balance = Board.playerList[player].balance + 100;
	}
	
	public static void cc9(){
		int player = Board.currPlayer;
		
		UI.textArea.append("Investments have paid off and resulted in you getting 100!");
		Board.playerList[player].balance = Board.playerList[player].balance + 100;
	}

	public static void cc10(){
		int player = Board.currPlayer;
		
		UI.textArea.append("Dealing protein bars on the side result in a cash surplus of 50!");
		Board.playerList[player].balance = Board.playerList[player].balance  + 50;
	}
	
	public static void cc11(){
		int player = Board.currPlayer;
		
		UI.textArea.append("Interest in the gym pays dividends, here's 25!");
		Board.playerList[player].balance = Board.playerList[player].balance + 25;
	}

	public static void cc12(){
		int player = Board.currPlayer;
		
		UI.textArea.append("Taxback of 75!");
		Board.playerList[player].balance = Board.playerList[player].balance + 75;
	}
	
	public static void cc13(){
		int player = Board.currPlayer;
		
		UI.textArea.append("Pay your gym membership!");
		Board.playerList[player].balance = Board.playerList[player].balance - 200;
	}

	public static void cc14(){
		int player = Board.currPlayer;
		int money = 0; 
		
		UI.textArea.append("To mark your birthday, every player gives you cash to fuel your upcoming restock!");
		Board.playerList[player].balance = Board.playerList[player].balance + (15 * Board.playerCount);
		for(int i = 0; i < Board.playerCount - 1; i++){
			Board.playerList[i].balance = Board.playerList[i].balance - 15;
			money += 15;
			if(Board.playerList[player] == Board.playerList[i]){
				Board.playerList[player].balance = Board.playerList[player].balance + money;
			}	
		}
	}
	
	public static void cc15(){
		UI.textArea.append("You've been offered pure creatine, undetectable by the law. Use it if you're caught to escape!");
	}

	public static void cc16(){
		int player = Board.currPlayer;
		
		UI.textArea.append("Pay your dealer what you owe, or take a chance!");
		if(player != 3) {
			Board.playerList[player].balance = Board.playerList[player].balance - 25;
		} else {
			Command.drawChance();
		}
	}
}