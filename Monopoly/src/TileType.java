package monopoly;

public enum TileType {
	PROPERTY, CARD, FREE_PARKING, GO_JAIL, JAIL, GO, CHANCE, COMMUNITY, RAILROAD, TAX, UTILITY;
	
	public static TileType parseType(String s) {
		// return the proper TileType for the string
      
        switch (s) {
        	case "Property":
        		return TileType.PROPERTY;
        		
        	case "CardTile":
        		return TileType.CARD;
        		
        	case "FreeParking":
        		return TileType.FREE_PARKING;
        		
        	case "GoJail":
        		return TileType.GO_JAIL;
        		
        	case "Jail":
        		return TileType.JAIL;
        		
        	case "Go":
        		return TileType.GO;
        	
        	case "Chance":
        		return TileType.CHANCE;
        		
        	case "Community":
        		return TileType.COMMUNITY;
        		
        	case "Railroad":
        		return TileType.RAILROAD;
        	
        	case "Utility":
        		return TileType.UTILITY;
        		
        	case "Tax":
        		return TileType.TAX;
        }
		return null;
	}
	
	public boolean isAProperty(TileType t) {
		if (t == TileType.PROPERTY || t == TileType.RAILROAD || t == TileType.UTILITY) {
			return true;
		} else {
			return false;
		}
	}
}
