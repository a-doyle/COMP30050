import java.util.ArrayList;

public class Player {
	
	private String name;
	private int propertiesOwned;
	private int balance;
	private int position;
	private int escapeAttempts;
	private boolean passedGo;
	private boolean inJail;
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

	//Other Methods needed to be properly implemented
	
	public void sendToJail(){
		
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
		balance += amount;
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
	
	public void totalAssets() {
		
	}
	
	public void getHousesOwned() {
		
	}
	
	public void getUtilitiesOwned() {
		
	}
	
	public void getTrainstationsOwned() {
		
	}
}

