package monopoly;

import monopoly.Player;

public class Railroads extends Property {
	
	int startingRent;
	private static final TileType TILE_TYPE = TileType.RAILROAD;

	public Railroads(String name, int netWorth, int rentalAmount, int mortgageValue, int startingRent) {
		super(name, netWorth, rentalAmount, mortgageValue, startingRent);
		this.startingRent = startingRent;
	}

	// Property Rent Override
	@Override
	public int getRentalAmount() {
		
		// check if a player owns the property
		Player owner = (Player) getOwner();
		
		// the price is the startingRent raised to power of railroads owned
		if (getOwner() == null) {
			return startingRent;
		} else {
			return (int) ((startingRent / 2) * Math.pow(2,  (owner.getRailroadsOwned()) - 1));
		}
	}
	
	@Override
	public TileType getTileType() {
		return TILE_TYPE;
	}
}
