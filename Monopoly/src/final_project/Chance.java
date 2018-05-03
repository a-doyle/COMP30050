package monopoly_take2;

public class Chance{

	public static void c1(){
		int player = Board.ActivePlayer;
		
		Board.textArea.append("You've been offered a sponsorship, collect your first pay package at Go!");
		Board.playerIcons[player].setLocation(Board.boardPos[0][0]+((player % 3) * Board.offset),Board.boardPos[0][1]+((player / 3) * Board.offset));
	}
	
	public static void c2(){
		int player = Board.ActivePlayer;
		int position = Board.PlayerArray[player].position;

		Board.textArea.append("You've been caught in the gym selling steroids, that's a jailable offence!");
		position = 10;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * Board.offset), Board.boardPos[position][1] + ((player / 3) * Board.offset));
		Board.PlayerArray[player].inJail = true;
	}
	
	public static void c3(){
		int player = Board.ActivePlayer;
		int position = Board.PlayerArray[player].position;
		int temp = position;
		
		Board.textArea.append("Advance to BodyPower (who knows where it is?), and enjoy a free goodie bag if you pass Go!");
		position = 13;
		if(temp > position){
			Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 200;
		}
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * Board.offset), Board.boardPos[position][1] + ((player / 3) * Board.offset));

	}
	
	public static void c4(){
		int player = Board.ActivePlayer;
		int position = Board.PlayerArray[player].position;
		
		Board.textArea.append("Take a trip to your local supplement store, collecting a goodie bag at the door if you pass Go!");
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * Board.offset), Board.boardPos[position][1] + ((player / 3) * Board.offset));
	}
	
	public static void c5(){	
		Board.textArea.append("You've been offered pure creatine, undetectable by the law. Use it if you're caught to escape!");
	}
	
	public static void c6(){
		int player = Board.ActivePlayer;
		int position = Board.PlayerArray[player].position;
		
		Board.textArea.append("Advance to WellFest to maintain a healthy body, free goodies for passing Go!");
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * Board.offset),
		Board.boardPos[position][1] + ((player / 3) * Board.offset));
	}
	
	public static void c7(){
		int player = Board.ActivePlayer;
		int position = Board.PlayerArray[player].position;
		int tempPosition = position;
		
		Board.textArea.append("You've been asked to leave this spot for being too large; a compliment I guess?");
		if(tempPosition > position){
			Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 200;
		}
		position = 31;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * Board.offset), Board.boardPos[position][1] + ((player / 3) * Board.offset));
	}
	
	public static void c8(){
		int player = Board.ActivePlayer;
		int position = Board.PlayerArray[player].position;
		
		Board.textArea.append("Oh no, you left your protein at home, go back three spaces and get it!");
		position -= 3;
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * Board.offset), Board.boardPos[position][1] + ((player / 3) * Board.offset));
	}
	
	public static void c9(){
		Board.textArea.append("Time to stock up on supps; pay 25 for tablets (houses) and 100 for powders (hotels)!");
	}
	
	public static void c10(){
		Board.textArea.append("You are assessed for street repairs: $40 per house. $115 per hotel!");
	}
	
	public static void c11(){
		int player = Board.ActivePlayer;
		
		Board.textArea.append("Pay your anabolic dealer what you owe, a nice 100!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance - 100;
	}
	
	public static void c12(){
		int player = Board.ActivePlayer;
		
		Board.textArea.append("Kicked out of coppers for some roid rage and attacking some poor soul, lose 20!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance - 20;

	}
	
	public static void c13(){
		int player = Board.ActivePlayer;
		
		Board.textArea.append("Garda have caught you racing your car, pay them 15 and they'll pretend they never saw you!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance - 10;

	}
	
	public static void c14(){		
		int player = Board.ActivePlayer;
		
		Board.textArea.append("You have been granted a pay package from your sponsorship, here's 200!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 200;

	}
	
	public static void c15(){	
		int player = Board.ActivePlayer;
		
		Board.textArea.append("You've been granted a referral reward from your gym by getting your family involved, here's 100!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 100;

	}
	
	public static void c16(){
		int player = Board.ActivePlayer;
		
		Board.textArea.append("You win a competition in the supp store and the prize is 50!");
		Board.PlayerArray[player].balance = Board.PlayerArray[player].balance + 50;
	}	
}