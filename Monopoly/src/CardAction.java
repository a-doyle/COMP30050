
import java.util.ArrayList;
import Card;

public class CardAction {

	
	public void assignCards(){
		
		ArrayList<Card> ChanceCards = new ArrayList<Card>();
		ArrayList<Card> ChestCards = new ArrayList<Card>();
		
		//Create 8 blank cards in each deck
		for(int i = 1;i<=8;i++){
			ChanceCards.add(new Card(i, "Chance"));
			ChestCards.add(new Card(i, "Community Chest"));
		}

		//Assign information to each card
		for(Card c : ChanceCards){
			switch(c.cardNumber){
			case 0:
				c.setExplanation("Advance to Go.");
				c.setDestination(0);
				c.passGo = true;
				c.setType(Card.TYPE_GOTO);
				break;
			case 1:
				c.setExplanation("Go to jail. Move directly to jail. Do not pass Go. Do not collect $200.");
				c.setDestination(30);
				c.passGo = false;
				c.setType(Card.TYPE_GOTO);
				break;
			case 2:
				c.setExplanation("Advance to "+ "blank" +". If you pass Go collect $200.");  //Blank will be replaced with a method to return
				c.setDestination(11);                                                        //the name of a property
				c.passGo = true;
				c.setType(Card.TYPE_GOTO);
				break;
			case 3:
				c.setExplanation("Go back three spaces");
				c.setDestination(-3);
				c.passGo = false;
				c.setType(Card.TYPE_MOVEXSPACES);
				break;
			case 4:
				c.setExplanation("Make general repairs on all of your houses. For each house pay $25. For each hotel pay $100.");
				c.setBuildingCosts(25, 100);
				c.setType(Card.TYPE_BUILDINGFINE);
				break;
			case 5:
				c.setExplanation("Pay school fees of $150.");
				c.setAmount(150);
				c.setType(Card.TYPE_FINE);
				break;
			case 6:
				c.setExplanation("Your building loan matures. Receive $150");
				c.setAmount(150);
				c.setType(Card.TYPE_REWARD);
				break;
			case 7:
				c.setExplanation("Get out of jail free. This card may be kept until needed or sold.");
				c.setType(Card.TYPE_OUTOFJAILFREE);
				break;

			default:
				break;
			}
		}
		for(Card c : ChestCards){
			switch(c.cardNumber){
			case 0:
				c.setExplanation("Advance to Go.");
				c.setDestination(0);
				c.passGo = true;
				c.setType(Card.TYPE_GOTO);
				break;
			case 1:
				c.setExplanation("Go back to "+ "blank");
				c.setDestination(1);
				c.passGo = false;
				c.setType(Card.TYPE_GOTO);
				break;
			case 2:
				c.setExplanation("Go to jail. Move directly to jail. Do not pass Go. Do not collect $200.");
				c.setDestination(30);
				c.passGo = false;
				c.setType(Card.TYPE_GOTO);
				break;
			case 3:
				c.setExplanation("Pay hospital $100");
				c.setAmount(100);
				c.setType(Card.TYPE_FINE);
				break;
			case 4:
				c.setExplanation("Bank error in your favour. Collect $200.");
				c.setAmount(200);
				c.setType(Card.TYPE_REWARD);
				break;
			case 5:
				c.setExplanation("It is your birthday. Collect $10 from each player");
				c.setAmount(10);
				c.setType(Card.TYPE_MONEYFROMEACHPLAYER);
				break;
			case 6:
				c.setExplanation("Get out of jail free. This card may be kept until needed or sold.");
				c.setType(Card.TYPE_OUTOFJAILFREE);
				break;
			case 7:
				c.setExplanation("Pay a $10 fine or take a Chance.");
				c.setAmount(10);
				c.setType(Card.TYPE_FINEORCHANCE);
				break;

			default:
				break;
			}
		}
	}
	
	
}
