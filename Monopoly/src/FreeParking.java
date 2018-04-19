package monopoly;

public class FreeParking {
	
	private int taxCollected;
	
	// FreeParking Constructor
	public FreeParking(int startingAmount) {
		this.taxCollected = startingAmount;
	}
	
	public void addToTax(int amount) {
		taxCollected += amount;
	}
	
	// when a player lands on FreeParking
	public int retrieveTax() {
		return taxCollected;
	}
}