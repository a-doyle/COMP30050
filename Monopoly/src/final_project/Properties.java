package monopoly_take2;

public class Properties
{
	public String propertyName;
	int value;
	int BoardPos;
	public int houseCount;
	public boolean buyable;
	public int[] rents = new int[6];
	public boolean owned = false;
	public static String ownedByPlayer;
	public int houseCost;
	public boolean mortgaged;
	public int mortgageCost = value/2;
	public static boolean monopoly = false;
	static Players Owner;
	static Properties[] propList = new Properties[40];

	//buyable lists all buyable properties, set number to -1 if bought.-2 is com chest. -3 is chance.

	private static int[] functions = {
			0,1,-2,2,0,3,4,-3,5,6,0,
			7,8,9,10,11,12,-2,13,14,0,
			15,-3,16,17,18,19,20,21,22,0,
			23,24,-2,25,26,-3,27,0,28
		};
	
	private static final int[] HOUSE_PRICE = {
			50,50,0,50,50,50,
			100,0,100,100,0,100,100,100,
			150,50,150,0,150,150,0,150,150,
			200,200,200,0,200,200};

	//coordinates array for location on the monopoly board
			public static final int[][] MONOPOLYSETS = {
					{1,3},{6,8,9},{11,13,14},{16,18,19},{21,23,24},{26,27,29},{31,32,34},{37,39}
			};
	
	private static final int[] SITE_PRICES = {
			60,60,200,100,100,120,
			140,150,140,160,200,180,180,200,
			220,220,240,200,260,260,150,280,
			300,300,320,200,350,400};
	
	private static String[] placeNames = {"Go","Woodbine Avenue","Community Chest","Woodbine Road","Income taxes","Heuston Station","O Willy Hall",
			"Chance your arm!","Science East","Science West","Library(Jail)",
			"Pi Cafe","Poolbeg","Pulse Cafe","Donald Trumps Armpit","Connolly Station","Gangsters Paradise","Community chest","Newman","Merville","Free Parking?",
			"Computer Science","Chance your leg?","RTE Radio Mast","Obamas Secret Hash Garden","Dundalk Station","Trump Tower",
			"Bertie Aherns secret man cave","Grand Canal","Kim Jong Uns secret Ibiza Villa",
			"Go to Library","Greenoaks","B106","Community Chest","Centra","Pearse St Dart","Do it for a chewit?","Ag Building","Sutherland","Quinn"};
	
	private static final int[][] SITE_RENTS = {
			{2,10,30,90,160,250},{4,20,60,180,320,450},{25,50,100,200,200,200},{6,30,90,270,400,550},{6,30,90,270,400,550},{8,40,100,300,450,600},
			{10,50,150,450,625,750},{},{10,50,150,450,625,750},{12,60,180,500,700,900},{25,50,100,200,200,200},{14,70,200,550,750,950},{14,70,200,550,750,950},{16,80,220,600,800,1000},
			{18,90,250,700,875,1050},{18,90,250,700,875,1050},{20,100,300,750,925,1100},{25,50,100,200,200,200},{22,110,330,800,975,1150},{22,110,330,800,975,1150},{},{24,120,360,850,1025,1200},
			{26,130,390,900,1100,1275},{26,130,390,900,1100,1275},{28,150,450,1000,1200,1400},{25,50,100,200,200,200},{35,175,500,1100,1300,1500},{50,200,600,1400,1700,2000}};
	
	
	public Properties(int BoardPos, String name,int Cost,int[] RentList,int housePrice,boolean buyable)
	{
		propertyName=name;
		value=Cost;
		rents = RentList;
		houseCost=housePrice;
		this.buyable=buyable;
	}
	public String WhoOwns()
	{
		if(owned == false) {
			return "No one owns it yet.\n";
		}
		else {
			return "This property is owned by "+ ownedByPlayer + "\n";
		}
	}
	public static String purchase(int currPlayer){
		int position = Board.PlayerArray[currPlayer].position;
		int temppos;
		boolean monopolystate = true;
		
		if(propList[position].owned==true|| Board.PlayerArray[currPlayer].balance < propList[position].value || propList[position].buyable==false) {
			return "This property is not taking any offers\n";
		}
		else {
			propList[position].owned = true;
			propList[position].ownedByPlayer=Board.PlayerArray[currPlayer].name;
			Board.PlayerArray[currPlayer].buyProperty(propList[position]);
			propList[position].Owner = Board.PlayerArray[currPlayer];
		}
			
		for(int i = 0; i< MONOPOLYSETS[position / 5].length; i++){
			
			temppos = MONOPOLYSETS[position / 5][i];
			
			if(propList[temppos].Owner != Board.PlayerArray[currPlayer]) {
				monopolystate = false;
			}
		}
		if(monopolystate==true)
		{
			for(int i = 0; i<MONOPOLYSETS[position / 5].length; i++)
			{
				temppos = MONOPOLYSETS[position / 5][i];
				propList[temppos].monopoly=true;
			}
		}
		return "Purchased.";
	}
	
	public int getPrice() {
		return value;
	}
	
	public static void payRent(int player){
		int rent = 0;
		int position = Board.PlayerArray[player].position;
		int multipliers = 0;
		
		if(propList[position].mortgaged == true){
			Board.textArea.append("You can not pay rent on a Mortgaged property.");
			return;
		}
		
		if(propList[position].Owner.name == Board.PlayerArray[player].name){
			Board.textArea.append("You own this property, fool!\n");
			Command.Scroll();
			return;
		}
		
		if(propList[position].owned == false || Board.CanEnd == true){
			Board.textArea.append("You have no rent to pay\n");
			Command.Scroll();
			return;
		}
		//Following checks are for stations
		
		if((position%10)==5){
			for(int i=0; i < 4; i++){
				
				if(propList[position].Owner==propList[5+(10*i)].Owner) {
					multipliers++;
				}
			}
			rent = (int) (25 * java.lang.Math.pow(2, multipliers));
		}
		
		else if(position == 12 || position == 28){
			if((propList[336/position].Owner==propList[position].Owner)) {
				rent = 10 * Command.roll;
			}
			else {
				rent = 4 * Command.roll;
			}
		}
		else{
			rent = propList[position].rents[propList[position].houseCount];
			}
		
		//AFTER THIS POINT RENT HAS BEEN SET OKAY
		if(Board.PlayerArray[player].balance  <  rent){
			Board.textArea.append("You cannot afford to pay rent, mortgage, sell houses or declare bankruptcy\n");
			Command.Scroll();
			return;
		}
 		else{
 			Board.PlayerArray[player].balance = Board.PlayerArray[player].balance  - rent;
			Owner.balance=Owner.balance+rent;
			propList[position].Owner.balance=propList[position].Owner.balance+rent;
 			Board.textArea.append("Rent of "+rent+" paid");
 			Board.CanEnd = true;
 			return;
		}

	}
	
	//Function creates all the properties and puts into array
	public static void createProperties()
	{
		for(int i = 0; i < 40; i++){
			if(functions[i]<1) {
				propList[i]= new Properties(i,placeNames[i], 0, null, 0, false);
			}
			else{
				propList[i]= new Properties(i,placeNames[i], SITE_PRICES[functions[i]-1],SITE_RENTS[functions[i]-1], HOUSE_PRICE[functions[i]-1],true);
			}
		}
	}
					
			
	public void setMortgage(boolean mort){
		this.mortgaged = mort;
	}
	
	public boolean isMortgaged(){
		return this.mortgaged;
	}
}
