package monopoly;

import monopoly.Player;

public class Railroads extends Property {
	
	int startingRent;

	public Railroads(String name, int netWorth, int rentalAmount, int mortgageValue, int startingRent) {
		super(name, netWorth, rentalAmount, mortgageValue);
		this.startingRent = startingRent;
	}

	// Property Rent Override
	@Override
	public int getRentalAmount() {
		
		// check if a player owns the property
		Player owner = getOwner();
		
		// the price is the startingRent raised to power of railroads owned
		if (getOwner() == null) {
			return startingRent;
		} else {
			return (startingRent / 2) * Math.pow(2,  (owner.getRailroadsOwned()) - 1);
		}
	}
}
