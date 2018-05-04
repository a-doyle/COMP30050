package monopoly_take2;

public class Card {
	
	String description;
	String typeOfCard;
	public int length;

	public Card(String cardDescription, String cardType) {
		this.description = cardDescription;
		this.typeOfCard = cardType;
	}
	
	public String getCardDescription() {
		return description;
	}
	
	public String getTypeOfCard() {
		return typeOfCard;
	}

}
