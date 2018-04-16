
public class Player {
	
	private String name;
	private int propertiesOwned;
	private int balance;
	private int position;
	private boolean passedGo;
	private boolean inJail;
	
	
	public Player(String name) {
		this.name = name;
		propertiesOwned = 0;
		balance = 100;
		passedGo = false;
		inJail = false;
	}
	
	//Methods dealing with the players data.
	
	public String getName() {
		return name;
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
	
	public void transaction(int amount){
		balance += amount;
	}
	
}
