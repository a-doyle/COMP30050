package monopoly_take2;

public enum CardType {
	
	COMMUNITY, CHANCE;
	
	public static CardType parseType(int s) {
		
		if(s == 2 || s == 17 || s == 33)
			return CardType.COMMUNITY;
		
		else if(s == 7 || s == 22 || s == 36)
			return CardType.CHANCE;
		
		return null;
	}

}

