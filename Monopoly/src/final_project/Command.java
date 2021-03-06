package monopoly_take2;

import java.util.ArrayList;
import javax.swing.JTextArea;
import java.util.Random;

public class Command
{
	public static int roll;
	public static JTextArea textArea = Board.textArea;
	public static String[] valid_instructions = {"roll", "property", "balance", "done", "buy" ,"pay rent", "quit" }; 
	public static Dice di = new Dice();
	public static int currPlayer;
	public static CommunityChest ccCards = new CommunityChest();
	
	static void GAMEOVER(int winner)
	{
		textArea.append(Board.PlayerArray[winner].name+" Is the winner!");
		Scroll();
		Board.commandPanel.removeAll();
	}
	@SuppressWarnings("static-access")
	
	public static void roll(){
		
		currPlayer = Board.currentPlayer;
		int position = Board.PlayerArray[currPlayer].position;
		boolean threeDoubles = false;
		int diceValue1 = di.getDice1Value();
		int diceValue2 = di.getDice2Value();

		if(Board.canRoll != true){
			Board.textArea.append("Cannot roll again!\n");
			Scroll();
			return;
		}
		
		roll = di.total();
		position += roll;
		
		if(position >= 40) {
			position = position - 39;
			Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance + 200;
			textArea.append("You Passed Go! Heres $200\n");
		}
		
		Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset),
				Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));
		
		Board.canRoll = (diceValue1 == diceValue2);
		textArea.append("Rolled "+ diceValue1 +" and "+ diceValue2 +"\n");
		textArea.append("You Have landed on: "+ Properties.propList[position].propertyName +"\n Value: " +Properties.propList[position].value+". \n Buyable: "+ Properties.propList[position].buyable+ "\n");
		Scroll();
		
		if(Properties.propList[position].owned == true && Board.PlayerArray[currPlayer] != Properties.propList[position].Owner && !(Properties.propList[position].mortgaged))
		{
			textArea.append("You have landed on an owned property with rent of "+ Properties.propList[position].rents[Properties.propList[position].houseCount]+". \n This has been deducted from your balance.");
			//Properties.payRent();
			Scroll();
			Board.CanEnd = false;
		}
		else{
			Board.CanEnd = true;
		}
		
		//Two functions below deduct cash from the player if they land on a tax square
		
		if(position == 4){
			Board.textArea.append("Goverment is looking for their tax money. They took $100 from your balance. \n");
			Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 100;
			Scroll();
		}
		
		if(position == 38){
			Board.textArea.append("Goverment is looking for their Lux tax money. \n They took $200 from your balance. \n");
			Board.PlayerArray[currPlayer].balance = Board.PlayerArray[currPlayer].balance - 200;
			Scroll();
		}
		
		
		//Function must be able to deal with not allowing the player to move unless certain conditions are met
		if(position == 30){
			Board.textArea.append("You have commited crimes againest Monopoly and must pay the price in a cell.");
			position = 10;
			Board.Dots[currPlayer].setLocation(Board.BoardCoord[position][0] + ((currPlayer % 3) * Board.offset),
					Board.BoardCoord[position][1] + ((currPlayer / 3) * Board.offset));
		}
		
		
		//The negative balance statement
		if(Board.PlayerArray[currPlayer].balance < 0){
			
			Board.CanEnd = false;
			Board.textArea.append("You can not roll again cause your bank balance is negative \n"+
			"You must sell some of your Assets or mortgage a property");
			
		}
				
		Board.PlayerArray[currPlayer].position = position;
	
	}
	
	public static void EndTurn(){
		
		currPlayer = Board.currentPlayer;

		if(Board.CanEnd == false){
			textArea.append("Cannot end turn until rent or other debts are paid.\n");
			Scroll();
			return;
		}
		
		Board.CanEnd = false;
		int playerCount = Board.numberPlayers;
		
		currPlayer++;
		
		if(currPlayer >= playerCount){
			currPlayer -= playerCount;
		}
		
		while(Board.PlayerArray[currPlayer].inGame == false){
			
			currPlayer++;
			if(currPlayer >= playerCount){
				currPlayer -= playerCount;
			}
		}
		
		int i = currPlayer;
		i++;
		
		while(Board.PlayerArray[currPlayer].inGame == false){
			
			if(i >= playerCount){
				i = i - playerCount;
			}
			i++;
		}
		if(i == currPlayer){
			GAMEOVER(i);
			return;
		}
		
		Board.canRoll=true;
		textArea.append("Its "+Board.PlayerArray[currPlayer].name+"'s turn\n");
		Scroll();
		Board.currentPlayer = currPlayer;
	}
	
	public static void property() 
	{
		
		ArrayList<Properties> temp = Board.PlayerArray[Board.currentPlayer].getPropertyOwned();
		
		if(temp.size() == 0)
		{
			textArea.append("You own nothing.\n");
			Scroll();
		}	
		
		for(int i = 0; i < temp.size(); i++)
		{
			textArea.append("You own "+temp.get(i).propertyName+"\n");
			Scroll();
		}
		
	}
	
	public static String printHelp(){
		
		textArea.append("List of valid inputs: ");
		for(int i = 0; i < valid_instructions.length; i++){
			textArea.append(( valid_instructions[i] + ", "));
		}
		textArea.append("\n");
		Command.Scroll();
		return null;
	}
	
	public static void Scroll()
	{
		//Call this command after every append to keep a consistent autoscroll
		
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	public static void mortgageProperty(String property){
		
		int player = Board.currentPlayer;
		int position = Board.PlayerArray[player].position;
		
		if(Properties.propList[position].Owner.name == Board.PlayerArray[player].name){
			
			textArea.append("Mortgaged: " + Properties.propList[position].propertyName);
			Properties.propList[position].mortgaged = true;
			Board.PlayerArray[player].getMoney(Properties.propList[position].value / 2);
			Command.Scroll();
			return;
		}
		else if(Properties.propList[position].buyable == false){
			Board.textArea.append("You do not own this property and therefore can not Mortgage it !");
			return;
		}
		else if(Properties.propList[position].buyable == true){
			Board.textArea.append("Mortgaged: " + Properties.propList[position].propertyName);
			Properties.propList[position].mortgaged = true;
			Board.PlayerArray[player].getMoney(Properties.propList[position].value / 2);
			Command.Scroll();
			return;
		}
	}
	
	public static void unMortgage(String property){
		
		int position = Board.PlayerArray[currPlayer].position;
		
		if(!(Properties.Owner.name == Board.PlayerArray[currPlayer].name)){
			Board.textArea.append("You can not unmortgage because you did mortgage this property!");
			return;
		}
		else if(Properties.propList[position].Owner.name == Board.PlayerArray[currPlayer].name && Properties.propList[position].mortgaged == true){
			Board.textArea.append("Unmortgaged: " + Properties.propList[position].propertyName);
			Properties.propList[position].mortgaged = false;
			Board.PlayerArray[currPlayer].payment(Properties.propList[position].value / 2);
			Command.Scroll();
			return;
		}
	}
	
	public static void checkInput() throws InterruptedException
	{
			currPlayer = Board.currentPlayer;
			int position = Board.PlayerArray[currPlayer].position;

			String userInput = Board.textField.getText().toLowerCase();
			
			String oneWord = "";
			String manyWord = "";

		    if (userInput.indexOf(' ') > -1) //
		    { 
		      manyWord += userInput.substring(0, userInput.indexOf(' ')).toLowerCase(); // takes first word of many.
		      switch(manyWord.toLowerCase()){
					case "build":
						String buildDetail = manyWord.replaceFirst("build ", "");
						Houses.build(buildDetail);
						break;
					
					case "demolish":
						String demolishDetail = manyWord.replaceFirst("demolish ", "");
						Houses.demolish(demolishDetail);
						break;
					
						
					case "mortgage":
						String mortgageDetail = manyWord.replaceFirst("mortgage", "");
						mortgageProperty(mortgageDetail);
						break;
						
					case "unmortgage":
						String unmortgageDetail = manyWord.replaceFirst("unmortgage ", "");
						unMortgage(unmortgageDetail);
						break;
						
						
					default: 
						textArea.append("Invalid input, please try \"help\" \n");
						Command.Scroll();
						printHelp();
				}
			}
		    
		    else {
		      oneWord += userInput.toLowerCase(); // the first word
		      
		      switch(oneWord.toLowerCase()){
				
					case "roll": 
						Command.roll();
						break;
						
					case "property":
						Command.property();
						break;
						
					case "balance": 
						textArea.append("You have "+ Board.PlayerArray[currPlayer].getBalance()+" dolla\n");
						break;
						
					case "done":
						Command.EndTurn();
						break;
						
					case "buy":
						textArea.append(Properties.purchase(currPlayer)+"\n");
						break;
						
					case "pay":
						Properties.payRent(currPlayer);
						break;
						
					case "help":
						printHelp();
						break;
						
					case "draw":
						if(position == 7 || position == 22 || position == 36) {
							Command.drawChance();
						}
						break;
						
					case "bankrupt":
						Command.bankrupt();
						break;
						
					default: 
						textArea.append("Invalid input, heres some that are Valid: \n");
						Command.Scroll();
						printHelp();
				}
		      }
		    }
	
	public static void drawChance() {
		
		Random rand = new Random();
		int  n = rand.nextInt(16) + 1;

		switch(n) {
		case 1:
			ccCards.cc1();
			break;
		case 2:
			ccCards.cc2();
			break;
		case 3:
			ccCards.cc3();
			break;
		case 4:
			ccCards.cc4();
			break;
		case 5:
			ccCards.cc5();
			break;
		case 6:
			ccCards.cc6();
			break;
		case 7:
			ccCards.cc7();
			break;
		case 8:
			ccCards.cc8();
			break;
		case 9:
			ccCards.cc9();
			break;
		case 10:
			ccCards.cc10();
			break;
		case 11:
			ccCards.cc11();
			break;
		case 12:
			ccCards.cc12();
			break;
		case 13:
			ccCards.cc13();
			break;
		case 14:
			ccCards.cc14();
			break;
		case 15:
			ccCards.cc15();
			break;
		case 16:
			ccCards.cc6();
			break;
		}
	}
	
	public static void bankrupt() {
		ArrayList<Properties> temp = Board.PlayerArray[currPlayer].getPropertyOwned();
		for(int i=0;i<temp.size();i++){
			
			temp.get(i).owned = false;
			temp.get(i).Owner = null;
			temp.get(i).ownedByPlayer = null;
			temp.get(i).mortgaged = false;
			temp.get(i).houseCount = 0;
		}
		
		Board.PlayerArray[currPlayer].inGame = false;
		Board.CanEnd = true;
		textArea.append(Board.PlayerArray[currPlayer].name+" Is Out!");
		Scroll();
		EndTurn();
	}
}
