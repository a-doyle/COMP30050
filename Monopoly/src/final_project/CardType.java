package monopoly_take2;

public enum CardType {
	COMMUNITY, CHANCE;
	
	public static CardType parseType(String s) {
		
		switch (s) {
			case "community":
				return CardType.COMMUNITY;
			
			case "chance":
				return CardType.CHANCE;
		}
		
		return null;
	}
}
