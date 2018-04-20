package monopoly;

import monopoly.Player;
import monopoly.Dice;

public class Utilities extends Property {
	
	private static final TileType TILE_TYPE = TileType.UTILITY;
	
	// Utility Constructor
	public Utilities(String name, int netWorth, int rentalAmount, int mortgageValue) {
		super(name, netWorth, rentalAmount, mortgageValue, mortgageValue);
	}

	// Property Rent Override
	@Override
	public int getRentalAmount() {
		Dice dice = new Dice();
		int diceTotal = dice.total();
		
		if (getOwner() == null) {
			// method in Dice
			return 4 * diceTotal;
		}
		// if one owned, four times the dice roll
		// if both, ten times the dice roll
		if (getOwner().getUtilitiesOwned() == 2) {
			return 10 * diceTotal;
		} else {
			return 4 * diceTotal;
		}
	}
	
	@Override
	public TileType getTileType() {
		return TILE_TYPE;
	}
}
