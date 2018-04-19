
public class Card{
		
		//Types of card
		public static final int TYPE_FINE = 0;
		public static final int TYPE_REWARD = 1; 
		public static final int TYPE_OUTOFJAILFREE = 2; 
		public static final int TYPE_GOTO = 3;
		public static final int TYPE_BUILDINGFINE = 4;
		public static final int TYPE_MONEYFROMEACHPLAYER = 5;
		public static final int TYPE_FINEORCHANCE = 6;
		public static final int TYPE_MOVEXSPACES = 7;
		
		private String explanation;
		private int amount;
		private int type;
		private int destination;
		private int spacesToMove;
		
		//Used for 'building fine' cards
		private int housecost;
		private int hotelcost;
		
		public boolean passGo;//Is player allowed to collect 200 when passing go
		public int cardNumber;
		
		public Card(int n, String s){
			this.cardNumber = n;
			this.amount = 0;
		}
		
		public boolean performActionOn() { //This method needs to be finished
			return false;
		}
		
		public void setExplanation(String s){
			this.explanation = s;
		}
		
		public String explainAction() {
			return this.explanation;
		}
		
		public void setAmount(int x){
			this.amount = x;
		}
		
		public int getAmount(){
			return this.amount;
		}
		
		public void setType(int x){
			this.type = x;
		}
		
		public int getType(){
			return this.type;
		}
		
		
		public void setDestination(int x){
			this.destination = x;
		}
		public int getDestination(){
			return this.destination;
		}
		
		public void setSpacesToMove(int x){
			this.spacesToMove = x;
		}
		public int getSpacesToMove(){
			return this.spacesToMove;
		}
		
		public void setBuildingCosts(int house, int hotel){
			this.housecost = house;
			this.hotelcost = hotel;
		}
		public int getHouseCost(){
			return this.housecost;
		}
		public int getHotelCost(){
			return this.hotelcost;
		}
	
	
}
