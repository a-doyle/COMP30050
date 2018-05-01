package monopoly;

import monopoly.GameState;
import monopoly.Player;

public class TaxProperty implements Taxable, Tile {
	
	private int taxRate;
	private int flatTax;
	FreeParking freeParking;
	
	// TaxProperty Constructor
	public TaxProperty(int taxRate, int flatTax) {
		this.taxRate = taxRate / 100;
		this.flatTax = flatTax;
		
		// initialise free parking for tax collection
		freeParking = null;
	}
	
	// calculate amount owed by player
	public GameState hasLandedOn(Player player) {
		int amountOwed = taxRate * player.getBalance();
		
		if (amountOwed < flatTax) {
			amountOwed = flatTax;
		}
		
		player.deductBalanceTransaction(amountOwed);
		return GameState.PLAYING;
	}

	@Override
	public int getIncomePercentage() {
		return 0;
	}

	@Override
	public int getFlatTax() {
		return flatTax;
	}
	
	@Override
	public TileType getTileType() {
		return TileType.TAX;
	}
}
