package monopoly;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private int propertiesOwned;
	private int balance;
	private int position;
	private int escapeAttempts;
	private boolean passedGo;
	private boolean inJail;
	private int numberOfMortgagedProperties;
	private ArrayList<Card> cardDeck;
	private ArrayList<Property> properties;
	
	
	public Player(String name) {
		this.name = name;
		propertiesOwned = 0;
		balance = 100;
		passedGo = false;
		inJail = false;
		position = 0;
		escapeAttempts = 0;
		cardDeck = new ArrayList<Card>();
		properties = new ArrayList<Property>();
		
	}
	
	//Methods dealing with the players data.
	
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}
	
	public boolean isInJail() {
		return inJail;
	}
	
	public boolean passedGo() {
		return passedGo;
	}
	
	public int numOfPropertiesOwned() {
		return propertiesOwned;
	}
	
	public int numOfGroupProperties(int group) {
		int num = 0;
		
		for (Property property: properties) {
			if (group == property.getGroup()) {
				num++;
			}
		}
		return num;
	}

	//Other Methods needed to be properly implemented
	
	public void sendToJail(){
		position = 4;
		inJail = true;
	}
	
	//Methods for dealing with users balance
	
	public int getBalance() {
		return balance;
	}
	
	public void addBalanceTransaction(int amount){
		balance += amount;
	}
	
	public void deductBalanceTransaction(int amount){
		balance -= amount;
	}
	
	public void escapeAttemptsMade() {
		escapeAttempts++;
	}
	
	public void addCards(Card c) {
		cardDeck.add(c);
	}
	
	public void addProperty(Property p) {
		properties.add(p);
	}
	
	//Loops through and calculates all properties owned by player and totals it
	
	public int totalAssets() {
		
		int assets = balance;
		
		for(Property property : properties) {
			assets +=  property.getNetWorth();
		}
		
		return assets;
		
	}
	
	public int getHousesOwned() {
		
		int housesOwned = 0;
		
		for(Property property : properties) {
			housesOwned = property.getNumHouses();
			
			if (housesOwned > 4) {
				deductBalanceTransaction(40);
			} else if (housesOwned > 10) {
				deductBalanceTransaction(100);
			}
			
			housesOwned++;
		}
		
		return housesOwned;
		
	}
	
	public int getUtilitiesOwned() {
		
		int utilitiesOwned = 0;
		
		for (Property property : properties) {
			if (property.getTileType() == TileType.UTILITY) {
				utilitiesOwned++;
			}
		}
		
		return utilitiesOwned;
	}
	
	public int getRailroadsOwned() {
		
		int railroadsOwned = 0;
		
		for (Property property : properties) {
			if (property.getTileType() == TileType.RAILROAD) {
				railroadsOwned++;
			}
		}
		return railroadsOwned;
	}
	
	public int getMortgagedProperties() {
		
		int num = 0;
		
		for(Property property : properties) {
			if(property.isMortgagable() == true){
				num++;
			}
		}
		
		return num;
	}
	
	public void addMortgagedProperties(int x) {
		this.numberOfMortgagedProperties += x;
	}
	
	public String toString() {
		return name + " " + propertiesOwned + " " + balance;
	}
}