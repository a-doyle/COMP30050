package monopoly_take2;

import java.util.LinkedList;
import java.util.Collections;

public class CardDeck {
	private LinkedList<Card> deck;
	private Card topCard;
	
	public CardDeck(Card card) {
		deck = new LinkedList<Card>();
		
		for (int i = 0; i < card.length; i++) {
			deck.add(card);
		}
		
		Collections.shuffle(deck);
		topCard = deck.get(0);
	}
	
	public Card getTopCard() {
		return topCard;
	}

}