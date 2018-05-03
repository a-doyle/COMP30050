package monopoly_take2;

import java.util.ArrayList;
import javax.swing.JTextArea;

public class Command
{
	public static int roll;
	public static JTextArea textArea = UI.textArea;
	static void GAMEOVER(int winner)
	{
		textArea.append(Board.playerList[winner].name + " won the game, free supplements for life!");
		scroll();
		UI.commandPanel.removeAll();
	}
	
	public static void roll()
	{
		int player = Board.currPlayer;
		int position=Board.playerList[player].position;
		
		if(Board.rollable != true)
		{
			UI.textArea.append("Cannot roll again!\n");
			scroll();
			return;
		}
		
		int dice1 = (int)(Math.random() * 6) + 1;
		int dice2 = (int)(Math.random() * 6) + 1;
		
		roll = dice1 + dice2;
		position += roll;
		
		if(position >= 40)
		{
			position = position - 39;
			Board.playerList[player].balance = Board.playerList[player].balance + 200;
			textArea.append("You Passed Go! Heres $200\n");
		}
		
		Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc),
				Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
		
		Board.rollable = (dice1 == dice2);
		textArea.append("Rolled "+ dice1 +" and "+ dice2 +"\n");
		textArea.append("You Have landed on: "+ Board.propertyList[position].propertyName +"\n Value: " +Board.propertyList[position].value+". \n Buyable: "+ Board.propertyList[position].buyable+ "\n");
		scroll();
		
		if(Board.propertyList[position].Owned == true && Board.playerList[player] != Properties.Owner && !(Board.propertyList[position].mortgaged))
		{
			textArea.append("You have landed on an owned property with rent of "+ Board.propertyList[position].Rents[Board.propertyList[position].houseCount]+". \n This has been deducted from your balance.");
			//Properties.payRent();
			scroll();
			UI.CanEnd = false;
		}
		else{
			UI.CanEnd = true;
		}
		
		//Two functions below deduct cash from the player if they land on a tax square
		
		if(position == 4){
			UI.textArea.append("Goverment is looking for their tax money. They took $100 from your balance. \n");
			Board.playerList[player].balance = Board.playerList[player].balance - 100;
			scroll();
		}
		
		if(position == 38){
			UI.textArea.append("Goverment is looking for their Lux tax money. \n They took $200 from your balance. \n");
			Board.playerList[player].balance = Board.playerList[player].balance - 200;
			scroll();
		}
		
		
		//Function must be able to deal with not allowing the player to move unless certain conditions are met
		if(position == 30){
			UI.textArea.append("You have commited crimes againest Monopoly and must pay the price in a cell.");
			position = 10;
			Board.playerIcons[player].setLocation(Board.boardPos[position][0] + ((player % 3) * UI.uqLoc),
					Board.boardPos[position][1] + ((player / 3) * UI.uqLoc));
		}
		
		// shows if balance is in minus
		if (Board.playerList[player].balance < 0){
			UI.CanEnd = false;
			UI.textArea.append("You can not roll again cause your bank balance is negative \n"+
			"You must sell some of your assets or mortgage a property");
		}
				
		 Board.playerList[player].position = position;
	}
	
	public static void endTurn() {
		if(UI.CanEnd == false)
		{
			textArea.append("Cannot end turn until rent or other debts are paid.\n");
			scroll();
			return;
		}
		
		UI.CanEnd=false;
		int ActivePlayer=Board.currPlayer;
		int playerCount=Board.playerCount;
		
		ActivePlayer++;
		
		if(ActivePlayer >= playerCount)
		{
			ActivePlayer = ActivePlayer - playerCount;
		}
		while(Board.playerList[ActivePlayer].inGame == false)
		{
			ActivePlayer++;
			if(ActivePlayer >= playerCount)
			{
				ActivePlayer = ActivePlayer - playerCount;
			}
		}
		
		int i = ActivePlayer;
		i++;
		
		while(Board.playerList[ActivePlayer].inGame == false)
		{
			if(i >= playerCount)
			{
				i = i - playerCount;
			}
			i++;
		}
		if(i == ActivePlayer)
		{
			GAMEOVER(i);
			return;
		}
		
		Board.rollable=true;
		textArea.append("Its "+Board.playerList[ActivePlayer].name+"'s turn\n");
		scroll();
		Board.currPlayer = ActivePlayer;
	}
	
	public static void property() 
	{
		
		ArrayList<Properties> temp = Board.playerList[Board.currPlayer].getPropertyOwned();
		
		if(temp.size() == 0)
		{
			textArea.append("You own nothing.\n");
			scroll();
		}	
		
		for(int i = 0; i < temp.size(); i++)
		{
			textArea.append("You own "+temp.get(i).propertyName+"\n");
			scroll();
		}
		
	}
	
	public static String help(){
		
		textArea.append("List of valid inputs: ");
		
		for(int i = 0; i < Board.validInstructions.length; i++)
		{
			textArea.append(( Board.validInstructions[i] + ", "));
		}
		
		textArea.append("\n");
		scroll();
		return null;
	}
	
	// this function allows for a smoother scroll of text
	public static void scroll()
	{
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	public static void quit()
	{
		int[] sum = new int[6];
		int currentWinner = 0;
		
		for(int i = 0; i < Board.playerCount; i++)
		{
			ArrayList<Properties> temp = Board.playerList[Board.currPlayer].getPropertyOwned();
			for(int j = 0;j < temp.size(); j++)
			{
				sum[i] = sum[i] + temp.get(j).value;
			}
			sum[i] = sum[i] + Board.playerList[Board.currPlayer].balance;
			
			if(sum[i] > sum[currentWinner])
				currentWinner=i;
			}
		
			textArea.append(Board.playerList[currentWinner].name+" Is the winner!");
			scroll();
			UI.commandPanel.removeAll();
		
		
	}
	
	public static void mortgageProperty(String property){
		
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		
		if(Properties.Owner.name == Board.playerList[player].name){
			UI.textArea.append("Mortgaged: " + Board.propertyList[position].propertyName);
			Board.propertyList[position].mortgaged = true;
			Board.playerList[player].getMoney(Board.propertyList[position].value / 2);
			Command.scroll();
			return;
		}
		else if(Board.propertyList[position].buyable == false){
			UI.textArea.append("You do not own this property and therefore can not Mortgage it !");
			return;
		}
		else if(Board.propertyList[position].buyable == true){
			UI.textArea.append("Mortgaged: " + Board.propertyList[position].propertyName);
			Board.propertyList[position].mortgaged = true;
			Board.playerList[player].getMoney(Board.propertyList[position].value / 2);
			Command.scroll();
			return;
		}
	}
	
	public static void unMortgage(String property){
		
		int player = Board.currPlayer;
		int position = Board.playerList[player].position;
		
		if(!(Properties.Owner.name == Board.playerList[player].name)){
			UI.textArea.append("You can not unmortgage because you did mortgage this property!");
			return;
		}
		else if(Properties.Owner.name == Board.playerList[player].name && Board.propertyList[position].mortgaged == true){
			UI.textArea.append("Unmortgaged: " + Board.propertyList[position].propertyName);
			Board.propertyList[position].mortgaged = false;
			Board.playerList[player].payment(Board.propertyList[position].value / 2);
			Command.scroll();
			return;
		}
	}
	
	public static void drawChance(){
		
	}
	
	public static void playerBankrupt() {
		ArrayList<Properties> temp = Board.playerList[Board.currPlayer].getPropertyOwned();
		for(int i=0;i<temp.size();i++)
		{
			temp.get(i).Owned=false;
			temp.get(i);
			Properties.Owner=null;
			temp.get(i);
			Properties.ownedByPlayer=null;
			temp.get(i).mortgaged=false;
			temp.get(i).houseCount=0;
		}
		Board.playerList[Board.currPlayer].inGame=false;
		UI.CanEnd=true;
		textArea.append(Board.playerList[Board.currPlayer].name+" Is Out!");
		scroll();
		endTurn();
	}
}
