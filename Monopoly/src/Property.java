package monopoly;

public class Property implements Identifiable, Playable, Mortgagable, Tile {
	
	// Member Variables
	private String name;
	private int group;
	private Playable owner;
	private int netWorth;
	private int mortgageValue;
	private int rentalAmount;
	private boolean isMortgaged;
	private static final TileType TILE_TYPE = TileType.PROPERTY;
	
	// Property Constructor
	public Property(String name, int netWorth, int rentalAmount, int mortgageValue, int group) {
		this.name = name;
		this.netWorth = netWorth;
		this.rentalAmount = rentalAmount;
		this.mortgageValue = mortgageValue;
		this.group = group;
		this.isMortgaged = false;
	}
	
	public String getIdentifier() {
		return name;
	}
	
	public int getGroup() {
		return group;
	}
	
	public Playable getOwner() {
		return owner;
	}
	
	public int getNetWorth() {
		return netWorth;
	}
	
	public boolean isMortgagable() {
		// check if house is owned and already mortgaged
		if (owner == null || isMortgaged == true) {
			return false;
		}
		
		/* Niall, these methods need to be implemented in the player class */
		// give mortgage value to player
		owner.giveMoney(mortgageValue);
		owner.addMortgagedProperties(1);
		
		isMortgaged = true;
		return true;
	}
	
	public int getMortgageValue() {
		return mortgageValue;
	}
	
	public int getRentalAmount() {
		// if no owner, staple rent price
		if (owner == null) {
			return rentalAmount;
		}
		
		// get number of group properties owned by player
		int numGroupProperties = owner.numOfGroupProperties(group);
		
		// change rentalAmount based on this number
		switch (numGroupProperties) {
		case 1:
			return rentalAmount;
			
		case 2:
			return 2 * rentalAmount;
			
		// all properties owned
		default:
			return 4 * rentalAmount;
		}
	}

	@Override
	public int numOfGroupProperties(int group) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public GameState hasLandedOn(Player player) {
		// if there is no owner, BUY_PROPERTY kicks in
		// a player also owes rent if they land on an owned property
		if (owner == null) {
			return GameState.BUY_PROPERTY;
		} else {
			int moneyOwed = getRentalAmount();
			player.loseMoney(moneyOwed);
		}
	}
	
	@Override
	public TileType getTileType() {
		return TILE_TYPE;
	}	
}