package monopoly_take2;

import java.util.Arrays;

public class Houses {
	
	public static void build(String propertyDetail){
		int player = Board.currentPlayer;
		int position = Board.PlayerArray[player].position;
		
		
		String propertyName;
		String numOfHouses;
		int numHouses;
		int x;//used for index checking
		int placePosition;
		
		boolean monopolystate=true;
		int tempPos;
		
		//build is gone so the remaining part of the string is split
		try{
			String[] part = propertyDetail.split("\\s+");
			propertyName = part[0];
			numOfHouses = part[1];
			
		}catch(Exception ex){
			Board.textArea.append("Error with 'build'");
			
			Board.CanEnd = true;
			return;
		}
		
		try{
			//getting rid of the word build from string
			
			x = propertyDetail.indexOf(' ');
			
			if(x == -1){
				Board.textArea.append("invalid property name entered");
				
				Board.CanEnd = true;
				return;
			}
			else{
				placePosition = Arrays.asList(Properties.placeNames).indexOf(propertyName);
			}
			
		}catch(Exception ex){
			
			Board.CanEnd=true;
			return;
		}
		
		try{
			//getting number of houses wanting to build
			numHouses = Integer.parseInt(numOfHouses);
		}catch(Exception ex){
			Board.textArea.append("number of houses was not recognised");
			
			Board.CanEnd=true;
			return;
		}
				
		placePosition = Arrays.asList(Properties.placeNames).indexOf(propertyName);
		
				
		for(int i = 0; i<Properties.MONOPOLYSETS[position/5].length; i++){		
			tempPos = Properties.MONOPOLYSETS[position/5][i];
			if(Properties.propList[tempPos].Owner != Board.PlayerArray[player]){
				Properties.monopoly = false;
			}			
		}
		if(monopolystate==true)
		{
			for(int i = 0;i<Properties.MONOPOLYSETS[position/5].length;i++)
			{
				tempPos = Properties.MONOPOLYSETS[position/5][i];
				Properties.propList[tempPos].monopoly=true;
			}
		}
		
		if(Properties.propList[placePosition].monopoly = true)
		{
			if(numHouses <= 0)
			{
				Board.textArea.append("You cannot add "+numHouses+" amount of houses");
				
				Board.CanEnd=true;
				return;
			}
			else if(Properties.propList[placePosition].houseCount >= 5)
			{	
				Board.textArea.append("You already have a hotel on this property");
				
				Board.CanEnd=true;
				return;
			}
			
			else if(Properties.propList[placePosition].houseCount == 4)
			{
				if(numHouses>1)
				{
					Board.textArea.append("You cannot build " + numHouses + " houses on this property but buying one property now a hotel on this property will be built");
					
					Board.CanEnd=true;
					return;
				}
				else
				{
					
					Properties.propList[placePosition].houseCount += numHouses;
					if(Properties.propList[placePosition].houseCount >= 5)
					{
						Board.textArea.append("You have a hotel on this property and can build no more on this site");
						Properties.propList[placePosition].houseCount -= numHouses;
					}
					
					int costOfBuild = numHouses * Properties.propList[placePosition].houseCost;
					if(Board.PlayerArray[player].balance  <  costOfBuild)
					{
						Properties.propList[placePosition].houseCount -= numHouses;
						
						Board.textArea.append("You cannot afford to buy "+numHouses+", mortgage, sell houses or declare bankruptcy\n");
						Command.Scroll();
						
						Board.CanEnd=true;
						return;
					}
					else
					{
						Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  - costOfBuild;
						Properties.propList[position].Owner.balance = Properties.propList[position].Owner.balance+costOfBuild;
						
						Board.textArea.append(numHouses+" bought at "+costOfBuild+"." 
												+ "You have " + Properties.propList[placePosition].houseCount + " on this property");
						Board.CanEnd=true;
						return;
					}
				}
			}
			
			else if(Properties.propList[placePosition].houseCount == 3)
			{
				if(numHouses>2)
				{
					Board.textArea.append("You cannot build " + numHouses + " houses on this property.");
					
					Board.CanEnd=true;
					return;
				}
				else
				{
					Properties.propList[placePosition].houseCount += numHouses;
					if(Properties.propList[placePosition].houseCount >= 5)
					{
						Board.textArea.append("You have a hotel on this property and can build no more on this site");
						Properties.propList[placePosition].houseCount -= numHouses;
						
						Board.CanEnd=true;
						return;
					}
					
					int costOfBuild = numHouses * Properties.propList[placePosition].houseCost;
					
					if(Board.PlayerArray[player].balance  <  costOfBuild)
					{
						Properties.propList[placePosition].houseCount -= numHouses;
						Board.textArea.append("You cannot afford to buy "+numHouses+", mortgage, sell houses or declare bankruptcy\n");
						Command.Scroll();
						
						Board.CanEnd=true;
						return;
					}
					else
					{
						Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  - costOfBuild;
						Properties.propList[position].Owner.balance = Properties.propList[position].Owner.balance+costOfBuild;
						
						Board.textArea.append(numHouses+" bought at "+costOfBuild+"." 
												+ "You have " + Properties.propList[placePosition].houseCount + " on this property");
						Board.CanEnd=true;
						return;
					}
				}
			}
			
			else if(Properties.propList[placePosition].houseCount == 2)
			{
				if(numHouses>3)
				{
					Board.textArea.append("You cannot build " + numHouses + " houses on this property.");
					
					Board.CanEnd=true;
					return;
				}
				else
				{
					Properties.propList[placePosition].houseCount += numHouses;
					if(Properties.propList[placePosition].houseCount >= 5)
					{
						Board.textArea.append("You have a hotel on this property and can build no more on this site");
						Properties.propList[placePosition].houseCount -= numHouses;
						
						Board.CanEnd=true;
						return;
					}
					
					int costOfBuild = numHouses * Properties.propList[placePosition].houseCost;
					
					if(Board.PlayerArray[player].balance  <  costOfBuild)
					{
						Properties.propList[placePosition].houseCount -= numHouses;
						Board.textArea.append("You cannot afford to buy "+numHouses+", mortgage, sell houses or declare bankruptcy\n");
						Command.Scroll();
						
						Board.CanEnd=true;
						return;
					}
					else
					{
						Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  - costOfBuild;
						Properties.propList[position].Owner.balance = Properties.propList[position].Owner.balance+costOfBuild;
						
						Board.textArea.append(numHouses+" bought at "+costOfBuild+"." 
												+ "You have " + Properties.propList[placePosition].houseCount + " on this property");
						Board.CanEnd=true;
						return;
					}
				}
			}
			
			else if(Properties.propList[placePosition].houseCount == 1)
			{
				if(numHouses>4)
				{
					Board.textArea.append("You cannot build " + numHouses + " houses on this property.");
					
					Board.CanEnd=true;
					return;
				}
				else
				{
					Properties.propList[placePosition].houseCount += numHouses;
					if(Properties.propList[placePosition].houseCount >= 5)
					{
						Board.textArea.append("You have a hotel on this property and can build no more on this site");
						Properties.propList[placePosition].houseCount -= numHouses;
						
						Board.CanEnd=true;
						return;
					}
					
					int costOfBuild = numHouses * Properties.propList[placePosition].houseCost;
					
					if(Board.PlayerArray[player].balance  <  costOfBuild)
					{
						Properties.propList[placePosition].houseCount -= numHouses;
						Board.textArea.append("You cannot afford to buy "+numHouses+", mortgage, sell houses or declare bankruptcy\n");
						Command.Scroll();

						Board.CanEnd=true;
						return;
					}
					else
					{
						Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  - costOfBuild;
						Properties.propList[position].Owner.balance = Properties.propList[position].Owner.balance+costOfBuild;
						
						Board.textArea.append(numHouses+" bought at "+costOfBuild+"." 
												+ "You have " + Properties.propList[placePosition].houseCount + " on this property");
						Board.CanEnd=true;
						return;
					}
				}
			}
			
			else if(Properties.propList[placePosition].houseCount == 0)
			{
				if(numHouses>5)
				{
					Board.textArea.append("You cannot build " + numHouses + " houses on this property.");
					
					Board.CanEnd=true;
					return;
				}
				else
				{
					Properties.propList[placePosition].houseCount += numHouses;
					if(Properties.propList[placePosition].houseCount >= 5)
					{
						Board.textArea.append("You have a hotel on this property and can build no more on this site");
						Properties.propList[placePosition].houseCount -= numHouses;
						
						Board.CanEnd=true;
						return;
					}
					
					int costOfBuild = numHouses * Properties.propList[placePosition].houseCost;
					
					if(Board.PlayerArray[player].balance  <  costOfBuild)
					{
						Properties.propList[placePosition].houseCount -= numHouses;
						Board.textArea.append("You cannot afford to buy "+numHouses+", mortgage, sell houses or declare bankruptcy\n");
						Command.Scroll();

						Board.CanEnd=true;
						return;
					}
					else
					{
						Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  - costOfBuild;
						Properties.propList[position].Owner.balance = Properties.propList[position].Owner.balance+costOfBuild;
						
						Board.textArea.append(numHouses+" bought at "+costOfBuild+"." 
												+ "You have " + Properties.propList[placePosition].houseCount + " on this property");
						Board.CanEnd = true;
						return;
					}
				}
			}
		}
		Properties.propList[placePosition].houseCount += numHouses; //will result in a change of rent because of multipliers
	}
	
	public static void demolish(String propertyDetail)
	{
		int player = Board.currentPlayer;
		int position = Board.PlayerArray[player].position;
		
		String propertyName;
		String numOfHouses;
		int numHouses;
		int x;//used for index checking
		int placePosition;
		
		boolean monopolystate=true;
		int tempPos;
		
		//build is gone so the remaining part of the string is split
		try{
			String[] part = propertyDetail.split("\\s+");
			propertyName = part[0];
			numOfHouses = part[1];
			
		}catch(Exception ex){
			Board.textArea.append("error with input with 'build'");
			
			Board.CanEnd=true;
			return;
		}
		
		try{
			//getting rid of the word build from string
			
			x = propertyDetail.indexOf(' ');
			
			if(x == -1)
			{
				Board.textArea.append("invalid property name entered");
				
				Board.CanEnd=true;
				return;
			}
			else
			{
				placePosition = Arrays.asList(Properties.propList).indexOf(propertyName);
			}
			
		}catch(Exception ex){
			
			Board.CanEnd=true;
			return;
		}
		
		try{
			//getting number of houses wanting to build
			numHouses = Integer.parseInt(numOfHouses);
		}catch(Exception ex){
			Board.textArea.append("number of houses was not recognised");
			
			Board.CanEnd=true;
			return;
		}
				
		
		if(numHouses < 0)
		{
			Board.textArea.append("You demolish a negative amount of houses");
			
			Board.CanEnd=true;
			return;
		}
		
		else if(Properties.propList[placePosition].houseCount == 0)
		{
			Board.textArea.append("You have no propety to demolish");
			Board.CanEnd=true;
			return;
		}
		
		else if(Properties.propList[placePosition].houseCount == 1)
		{
			if(numHouses>1)
			{
				Board.textArea.append("You do not have " + numHouses + " houses on this property to demolish.");
				
				Board.CanEnd=true;
				return;
			}
			else
			{
				Properties.propList[placePosition].houseCount -= numHouses;
				
				int costOfDemolish = ((numHouses * Properties.propList[placePosition].houseCost)/2);
				
				Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  + costOfDemolish;
				
				Properties.propList[position].Owner.balance += costOfDemolish;
				
				Board.textArea.append(numHouses+" bought at "+costOfDemolish*2+". sold at " + costOfDemolish+"."
											+ "You have " + Properties.propList[placePosition].houseCount + " houses on this property");
				Board.CanEnd=true;					
				return;
			}
		}
		else if(Properties.propList[placePosition].houseCount == 2)
		{
			if(numHouses>2)
			{
				Board.textArea.append("You do not have " + numHouses + " houses on this property to demolish.");
				
				Board.CanEnd=true;
				return;
			}
			else
			{
				Properties.propList[placePosition].houseCount -= numHouses;
				
				int costOfDemolish = ((numHouses * Properties.propList[placePosition].houseCost)/2);
				
				Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  + costOfDemolish;
				
				Properties.propList[position].Owner.balance += costOfDemolish;
				
				Board.textArea.append(numHouses+" bought at "+costOfDemolish*2+". sold at " + costOfDemolish+"."
											+ "You have " + Properties.propList[placePosition].houseCount + " houses on this property");
				Board.CanEnd=true;					
				return;
			}
		}
		else if(Properties.propList[placePosition].houseCount == 3)
		{
			if(numHouses>3)
			{
				Board.textArea.append("You do not have " + numHouses + " houses on this property to demolish.");
				
				Board.CanEnd=true;
				return;
			}
			else
			{
				Properties.propList[placePosition].houseCount -= numHouses;
				
				int costOfDemolish = ((numHouses * Properties.propList[placePosition].houseCost)/2);
				
				Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  + costOfDemolish;
				
				Properties.propList[position].Owner.balance += costOfDemolish;
				
				Board.textArea.append(numHouses+" bought at "+costOfDemolish*2+". sold at " + costOfDemolish+"."
											+ "You have " + Properties.propList[placePosition].houseCount + " houses on this property");
				Board.CanEnd=true;					
				return;
			}
		}
		
		else if(Properties.propList[placePosition].houseCount == 4)
		{
			if(numHouses>4)
			{
				Board.textArea.append("You do not have " + numHouses + " houses on this property to demolish.");
				
				Board.CanEnd=true;
				return;
			}
			else
			{
				Properties.propList[placePosition].houseCount -= numHouses;
				
				int costOfDemolish = ((numHouses * Properties.propList[placePosition].houseCost)/2);
				
				Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  + costOfDemolish;
				
				Properties.propList[position].Owner.balance += costOfDemolish;
				
				Board.textArea.append(numHouses+" bought at "+costOfDemolish*2+". sold at " + costOfDemolish+"."
											+ "You have " + Properties.propList[placePosition].houseCount + " houses on this property");
				Board.CanEnd=true;					
				return;
			}
		}
		
		else if(Properties.propList[placePosition].houseCount == 5)
		{
			if(numHouses>5)
			{
				Board.textArea.append("You do not have " + numHouses + " houses on this property to demolish.");
				
				Board.CanEnd=true;
				return;
			}
			else
			{
				Properties.propList[placePosition].houseCount -= numHouses;
				
				int costOfDemolish = ((numHouses * Properties.propList[placePosition].houseCost)/2);
				
				Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  + costOfDemolish;
				
				Properties.propList[position].Owner.balance += costOfDemolish;
				
				Board.textArea.append(numHouses+" bought at "+costOfDemolish*2+". sold at " + costOfDemolish+"."
											+ "You have " + Properties.propList[placePosition].houseCount + " houses on this property");
				Board.CanEnd=true;					
				return;
			}
		}
			
	}


}
