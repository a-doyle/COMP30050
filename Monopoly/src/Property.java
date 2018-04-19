package monopoly;

public class Property implements Identifiable, Playable, Tradeable {
	
	// Member Variables
	private String name;
	private int netWorth;
//	private boolean isMortgagable;
//	private int mortgageValue;
//	private int rentalAmount;
	private int tradeValue;
	
	public String getIdentifier() {
		return name;
	}
	
	public int getNetWorth() {
		return netWorth;
	}
	
	public int getTradeValue() {
		return tradeValue;
	}
	
//	public boolean isMortgagable() {
//		return isMortgagable;
//	}
//	
//	public int getMortgageValue() {
//		return mortgageValue;
//	}
//	
//	public int getRentalAmount() {
//		return rentalAmount;
//	}
	
	public static void main(String args[]) {
		Property prop1 = new Property();
		Property prop2 = new Property();
		Property prop3 = new Property();
		
		prop1.getIdentifier();
		prop2.getNetWorth();
		prop3.getTradeValue();
	}	
}
