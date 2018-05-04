package monopoly_take2;

public class CommunityChest {
	
	private static String cardDescription;
	public static String cardType = "community";
	public static int player;
	private static final CardType CARD_TYPE = CardType.COMMUNITY;
	
	public static void cc1(){
		player = Board.currPlayer;
		cardDescription = "You've been offered a sponsorship, collect your first pay package at Go!";
		
		UI.textArea.append(cardDescription);
		Board.playerIcons[player].setLocation(Board.boardPos[0][0]+((player % 3) * UI.uqLoc),Board.boardPos[0][1]+((player / 3) * UI.uqLoc));
	}

	public static void cc2(){
		player = Board.currPlayer;
		cardDescription = "Take a trip to your local supp store!";
		
		UI.textArea.append(cardDescription);
		Board.playerIcons[player].setLocation(Board.boardPos[0][0]+((player % 3) * UI.uqLoc),Board.boardPos[0][1]+((player / 3) * UI.uqLoc));

	}
	
	public static void cc3(){
		player = Board.currPlayer;
		int position = Board.playerList[player].position;
		cardDescription = "Caught with roids? You've been slapped with cuffs and face extensive jail time!";
		
		UI.textArea.append(cardDescription);
		position = 10;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc), Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
		Board.playerList[player].inJail = true;
	}

	public static void cc4(){
		player = Board.currPlayer;
		cardDescription = "You drank some badd egg whites, and are forced to fork out a bill for the doctor!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance - 100;
	}
	
	public static void cc5(){
		player = Board.currPlayer;
		cardDescription = "Payday leads to an expensive supp stock up!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance - 150;
	}

	public static void cc6(){
		player = Board.currPlayer;
		cardDescription = "Direct debit on your gym membership is due, pay 50!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance - 50;
	}
	
	public static void cc7(){
		player = Board.currPlayer;
		cardDescription = "You were charged twice for that protein order, here's 200!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance + 200;
	}

	public static void cc8(){
		player = Board.currPlayer;
		cardDescription = "You set new records in the gym and were awarded 100!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance + 100;
	}
	
	public static void cc9(){
		player = Board.currPlayer;
		cardDescription = "Investments have paid off and resulted in you getting 100!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance + 100;
	}

	public static void cc10(){
		player = Board.currPlayer;
		cardDescription = "Dealing protein bars on the side result in a cash surplus of 50!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance  + 50;
	}
	
	public static void cc11(){
		player = Board.currPlayer;
		cardDescription = "Interest in the gym pays dividends, here's 25!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance + 25;
	}

	public static void cc12(){
		player = Board.currPlayer;
		cardDescription = "Taxback of 75!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance + 75;
	}
	
	public static void cc13(){
		player = Board.currPlayer;
		cardDescription = "Pay your gym membership!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance - 200;
	}

	public static void cc14(){
		player = Board.currPlayer;
		int money = 0;
		cardDescription = "To mark your birthday, every player gives you cash to fuel your upcoming restock!";
		
		UI.textArea.append(cardDescription);
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
		cardDescription = "You've been offered pure creatine, undetectable by the law. Use it if you're caught to escape!";
		
		UI.textArea.append(cardDescription);
	}

	public static void cc16(){
		player = Board.currPlayer;
		cardDescription = "Pay your dealer what you owe, or take a chance!";
		
		UI.textArea.append(cardDescription);
		if(player != 3) {
			Board.playerList[player].balance = Board.playerList[player].balance - 25;
		} else {
			Command.drawChance();
		}
	}
	
	public CardType getCardType() {
		return CARD_TYPE;
	}
}