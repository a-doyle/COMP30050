package monopoly;

public class FreeParking implements Tile {
	
	private int taxCollected;
	private static final TileType TILE_TYPE = TileType.FREE_PARKING;
	
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

	// giveMoney() needs to be implemented in Player class
	@Override
	public GameState hasLandedOn(Player player) {
		player.addBalanceTransaction(taxCollected);
		return GameState.PLAYING;
	}

	@Override
	public TileType getTileType() {
		return TILE_TYPE;
	}
}