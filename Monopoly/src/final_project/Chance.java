package monopoly_take2;

public class Chance {
	
	private static String cardDescription;
	public static String cardType = "chance";
	private static final CardType CARD_TYPE = CardType.CHANCE;

	public static void c1(){
		int player = Board.currPlayer;
		cardDescription = "You've been offered a sponsorship, collect your first pay package at Go!";
		
		UI.textArea.append(cardDescription);
		Board.playerIcons[player].setLocation(Board.boardPos[0][0]+((player % 3) * UI.uqLoc),Board.boardPos[0][1]+((player / 3) * UI.uqLoc));
	}
	
	public static void c2(){
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		cardDescription = "You've been caught in the gym selling steroids, that's a jailable offence!";

		UI.textArea.append(cardDescription);
		position = 10;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc), Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
		Board.playerList[player].inJail = true;
	}
	
	public static void c3(){
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		int temp = position;
		cardDescription = "Advance to BodyPower (who knows where it is?), and enjoy a free goodie bag if you pass Go!";
		
		UI.textArea.append(cardDescription);
		position = 13;
		if(temp > position){
			Board.playerList[player].balance = Board.playerList[player].balance + 200;
		}
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc), Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));

	}
	
	public static void c4(){
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		cardDescription = "Take a trip to your local supplement store, collecting a goodie bag at the door if you pass Go!";
		
		UI.textArea.append(cardDescription);
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc), Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
	}
	
	public static void c5(){	
		UI.textArea.append("You've been offered pure creatine, undetectable by the law. Use it if you're caught to escape!");
	}
	
	public static void c6(){
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		cardDescription = "Advance to WellFest to maintain a healthy body, free goodies for passing Go!";
		
		UI.textArea.append(cardDescription);
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc),
		Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
	}
	
	public static void c7(){
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		int tempPosition = position;
		cardDescription = "You've been asked to leave this spot for being too large; a compliment I guess?";
		
		UI.textArea.append(cardDescription);
		if(tempPosition > position){
			Board.playerList[player].balance = Board.playerList[player].balance + 200;
		}
		position = 31;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc), Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
	}
	
	public static void c8(){
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		cardDescription = "Oh no, you left your protein at home, go back three spaces and get it!";
		
		UI.textArea.append(cardDescription);
		position -= 3;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc), Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
	}
	
	public static void c9(){
		cardDescription = "Time to stock up on supps; pay 25 for tablets (houses) and 100 for powders (hotels)!";
		UI.textArea.append(cardDescription);
	}
	
	public static void c10(){
		cardDescription = "You are assessed for street repairs: $40 per house. $115 per hotel!";
		UI.textArea.append(cardDescription);
	}
	
	public static void c11(){
		cardDescription = "Pay your anabolic dealer what you owe, a nice 100!";
		int player = Board.currPlayer;
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance - 100;
	}
	
	public static void c12(){
		cardDescription = "Kicked out of coppers for some roid rage and attacking some poor soul, lose 20!";
		int player = Board.currPlayer;
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance - 20;

	}
	
	public static void c13(){
		int player = Board.currPlayer;
		cardDescription = "Garda have caught you racing your car, pay them 15 and they'll pretend they never saw you!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance - 10;

	}
	
	public static void c14(){		
		int player = Board.currPlayer;
		cardDescription = "You have been granted a pay package from your sponsorship, here's 200!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance + 200;

	}
	
	public static void c15(){	
		int player = Board.currPlayer;
		cardDescription = "You've been granted a referral reward from your gym by getting your family involved, here's 100!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance + 100;

	}
	
	public static void c16(){
		int player = Board.currPlayer;
		cardDescription = "You win a competition in the supp store and the prize is 50!";
		
		UI.textArea.append(cardDescription);
		Board.playerList[player].balance = Board.playerList[player].balance + 50;
	}
	
	public CardType getCardType() {
		return CARD_TYPE;
	}
}