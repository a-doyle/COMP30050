package monopoly_take2;

import java.util.ArrayList;

public class Players {
	
	String name;
	int balance;
	private String colour;
	private boolean isWinner;
	ArrayList<Properties> propertyOwned = new ArrayList<Properties>();
	boolean inJail;
	private boolean rollDouble;
	public int position;
	public boolean inGame=true;	
	
	
	public Players(String playerName){
		name = playerName;
		balance = 1500;
		inJail = false;
		rollDouble = false;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public boolean win(boolean result){
		return isWinner = result;
	}
	
	
	public void getMoney(int amount){
		balance += amount;
	}
	
	public void payment(int amount){
		balance -= amount;
	}

	public void payRent(int amount){
		balance -= amount;
	}
	
	public void sellProperty(Properties mortgagedProperty){
		balance -= mortgagedProperty.getPrice();
		propertyOwned.remove(mortgagedProperty);
		//sets the property to the owner
	}
	
	public void buyProperty(Properties property){
		balance -= property.getPrice();
		propertyOwned.add(property);
		//sets the property to the owner
	}
	
	public ArrayList<Properties> getPropertyOwned(){
		return propertyOwned;		
	}		
	
	public int getBalance(){
		return balance;
	}
	
	public void setBalance(int balance){
		this.balance = balance;
	}

	
	public String toString(){
		return name+ " " +propertyOwned + " "+ colour + " "+balance;
	}
}
