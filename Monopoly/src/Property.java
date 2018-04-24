package monopoly;

public class Property implements Identifiable, Playable, Mortgagable, Tile, Improvable {
	
	// Member Variables
	private String name;
	private int group;
	private Playable owner;
	private int netWorth;
	private int mortgageValue;
	private int rentalAmount;
	private boolean isMortgaged;
	private int numHouses;
	private int housePrice;
	private int numHotels;
	private int hotelPrice;
	private Player player;
	// get number of group properties owned by player
	private int numGroupProperties = owner.numOfGroupProperties(group);
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
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public int getNumHotels() {
		return numHotels;
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
	
	public int setHousePrice(int group) {
		
		if (group == 0 || group == 1) {
			housePrice = 25;
		} else if (group == 2 || group == 3) {
			housePrice = 50;
		} else if (group == 4 || group == 5) {
			housePrice = 75;
		} else {
			housePrice = 100;
		}
	
		return housePrice;
	}
	
	public int setHotelPrice(int group) {
		
		if (group == 0 || group == 1) {
			hotelPrice = 125;
		} else if (group == 2 || group == 3) {
			hotelPrice = 150;
		} else if (group == 4 || group == 5) {
			hotelPrice = 175;
		} else {
			hotelPrice = 200;
		}
	
		return hotelPrice;
	}
	
	public int buyHouse(int housePrice) {
		// can only buy a house if all properties in group are owned
		if (numGroupProperties >= 2) {
			numHouses += 1;
			rentalAmount *= 1.5;
			player.loseMoney(housePrice);
		}	
	}
	
	public int sellHouse() {
		player.giveMoney(housePrice/2);
		numHouses -= 1;
		getNumHouses();
	}
	
	public int buyHotel(int hotelPrice) {
		// can only buy a house if all properties in group are owned
		if (numHouses == 4) {
			numHotels += 1;
			rentalAmount *= 2.0;
			player.loseMoney(hotelPrice);
		}	
	}
	
	public int sellHotel() {
		player.giveMoney(hotelPrice/2);
		numHotels -= 1;
		getNumHotels();
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