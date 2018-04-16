
public class Property {
	
	
	private boolean isOwned;
	private int price;
	private Player owner;
	private String shortName;
	private boolean mortgaged;
	private int mortgageValue;
	
	Property (String name, int price, String shortName, int mortgageValue) {
		this.price = price;
		this.shortName = shortName;
		isOwned = false;
		owner = null;
		mortgaged = false;
		this.mortgageValue = mortgageValue;
		return;
	}
		

// METHODS DEALING WITH PRICE

	public int getPrice () {
		return price;
	}
	
// METHODS DEALING WITH RENT : 	

	public int getRent () { // this method is overloaded by the subclasses
		return 0;  
	}
	
// METHODS DEALING WITH OWNERSHIP
	
	public Player getOwner () {
		return owner;
	}
	
	public boolean isOwned () {
		return isOwned;
	}
	
// METHODS DEALING WITH MORTGAGES 
	
	//Change to if statement so if it isnt mortgaged, mortgage the property || unmortgage
	public void setMortgaged() {
		mortgaged = true;
		return;
	}
	
	public boolean isMortgaged() {
		return mortgaged;
	}
	
	public int getMortgageValue() {
		return mortgageValue;
	}
	
}
