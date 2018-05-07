package monopoly_take2;

import java.util.ArrayList;

public class Chance{
	
	public static int currPlayer;

	public static void chance1(){
		
		currPlayer = Board.currentPlayer;
		int position = Board.PlayerArray[currPlayer].position;

		
		Board.textArea.append("Advance to Go and recieve 200 dollas !");
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[0][0]+((currPlayer % 3) * Board.offset),Board.BoardCoord[0][1]+((currPlayer / 3) * Board.offset));
		
	}
	
	public static void chance2(){
		currPlayer = Board.currentPlayer;

		int position = Board.PlayerArray[currPlayer].position;
		
		Board.textArea.append("Go to the Library immediately. Do not pass Go. Do not collect €200.");
		position = 10;
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset), Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));
		Board.PlayerArray[currPlayer].inJail = true;
	}
	
	public static void chance3(){
		currPlayer = Board.currentPlayer;

		int position = Board.PlayerArray[currPlayer].position;
		int temp = position;
		Board.textArea.append("Advance to Pall Mall. (arent they a box of fags ?) If you pass Go collect �200.");

		position = 13;

		if(temp > position){
			Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 200;
		}
		
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset), Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));

	}
	
	public static void chance4(){
		
		currPlayer = Board.currentPlayer;

		int position = Board.PlayerArray[currPlayer].position;
		
		Board.textArea.append("Take a trip to Marylebone Station and if you pass Go collect �200.");
		
		//Same again
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset), Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));
	}
	
	public static void chance5(){
		
		currPlayer = Board.currentPlayer;

		int position = Board.PlayerArray[currPlayer].position;
		
		Board.textArea.append("Get out of jail free (ya lucky bollox). This card may be kept until needed or sold.");
	}
	
	public static void chance6(){
		
		currPlayer = Board.currentPlayer;

		int position = Board.PlayerArray[currPlayer].position;
		
		Board.textArea.append("Advance to Trafalgar Square. If you pass Go collect �200.");
		
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset),
				Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));
	}
	
	public static void chance7(){
		
		currPlayer = Board.currentPlayer;

		int position = Board.PlayerArray[currPlayer].position;
		int tempPosition = position;
		
		Board.textArea.append("Advance to Gr1 \n");
		
		if(tempPosition > position){
			Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 200;

		}
		
		position = 31;
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset), Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));
	}
	
	public static void chance8(){
		
		currPlayer = Board.currentPlayer;

		int position = Board.PlayerArray[currPlayer].position;
		
		Board.textArea.append("OOPS. Go back 3 spaces !");
		
		position -= 3;
		
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset), Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));
	}
	
	
	public static void chance9(){
		
		currPlayer = Board.currentPlayer;

		Board.textArea.append("Make general repairs to your houses. For each house $25 or $100 fo yo hotelz");
	}
	
	public static void chance10(){
		
		currPlayer = Board.currentPlayer;

		Board.textArea.append("You are assessed for street repairs: $40 per house. $115 per hotel");

	}
	
	
	//Deducts 150 from the users balance
	public static void chance11(){
		
		currPlayer = Board.currentPlayer;
				
		Board.textArea.append("Pay your college levy of $150");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 150;
	}
	
	public static void chance12(){
		
		currPlayer = Board.currentPlayer;
		
		Board.textArea.append("Kicked out of coppers and arrested for drunken disorder. Fined $20. \n Stay off that vodka hey !");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 20;

	}
	
	public static void chance13(){
	
		currPlayer = Board.currentPlayer;

		
		Board.textArea.append("Boy racer ya caught by the Gardai. Fined $50");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 50;

	}
	
	public static void chance14(){
		
		currPlayer = Board.currentPlayer;

		
		Board.textArea.append("You've somehow got a 4.1 GPA. Heres a cheeky $150 ya rooster.");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 150;

	}
	
	public static void chance15(){
		
		currPlayer = Board.currentPlayer;

		
		Board.textArea.append("Yourself and your granny have won a crossword competition ? (yikes). Heres $100");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 100;

	}
	
	public static void chance16(){
		
		currPlayer = Board.currentPlayer;
	
		
		Board.textArea.append("Bank pays you (unlikely nowadays) heres $50");
		Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 50;
	}	
}
