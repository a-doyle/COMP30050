package monopoly_take2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
class Board extends JFrame implements ActionListener 
{
	// sets the positions of each player
	private static int[] playerPos = {0,0,0,0,0,0};
    public static JLabel[] playerIcons = new JLabel[7];
	public static String[] listOfPlayerImages = {"https://i.imgur.com/tnB6sX5.jpg","https://i.imgur.com/GIHYPOx.jpg","https://i.imgur.com/KEfW1tG.jpg",
			"https://i.imgur.com/WzfRnDE.jpg","https://i.imgur.com/5Z7Pd.jpg","https://i.imgur.com/ZKFeKoB.jpg"};
	public static boolean GAMEOVER = false;
	public static boolean rollable = true;
	private static JTextField textField = new JTextField("");
	static JTextArea textArea = new JTextArea();
	public static String[] validInstructions = {"roll","property","balance","done","buy","pay rent","quit"}; 

	private static final int[] housePrices = {
		50,50,0,50,50,50,100,0,100,100,0,100,100,100,150,50,150,0,150,150,0,150,150,200,200,200,0,200,200
	};

	private static final int[] sitePrices = {
		60,60,200,100,100,120,140,150,140,160,200,180,180,200,220,220,240,200,260,260,150,280,300,300,320,200,350,400
	};
	
	private static final int[][] rentalPrices = {
		{2,10,30,90,160,250},{4,20,60,180,320,450},{25,50,100,200,200,200},{6,30,90,270,400,550},
		{6,30,90,270,400,550},{8,40,100,300,450,600},{10,50,150,450,625,750},{},{10,50,150,450,625,750},
		{12,60,180,500,700,900},{25,50,100,200,200,200},{14,70,200,550,750,950},{14,70,200,550,750,950},
		{16,80,220,600,800,1000},{18,90,250,700,875,1050},{18,90,250,700,875,1050},{20,100,300,750,925,1100},
		{25,50,100,200,200,200},{22,110,330,800,975,1150},{22,110,330,800,975,1150},{},{24,120,360,850,1025,1200},
		{26,130,390,900,1100,1275},{26,130,390,900,1100,1275},{28,150,450,1000,1200,1400},
		{25,50,100,200,200,200},{35,175,500,1100,1300,1500},{50,200,600,1400,1700,2000}
	};
	
	//coordinates array for location on the monopoly board
	public static final int[][] locations = {
		{1,3},{6,8,9},{11,13,14},{16,18,19},{21,23,24},{26,27,29},{31,32,34},{37,39}
	};
	
	static final int[][] boardPos = {
			{542,542},{491,542},{440,542},{389,542},{338,542},{287,542},{236,542},{185,542},{134,542},{83,542},{32,542},
			{32,491},{32,440},{32,389},{32,338},{32,287},{32,236},{32,185},{32,134},{32,83},{32,32},
			{83,32},{134,32},{185,32},{236,32},{287,32},{338,32},{389,32},{440,32},{491,32},{542,32},
			{542,83},{542,134},{542,185},{542,236},{542,287},{542,338},{542,389},{542,440},{542,491}
	};
	
	public static Players[] playerList = new Players[6];
	static Properties[] propertyList = new Properties[40];
	
	// basic placeholders for each property
	static String[] PlaceNames={"go","br1","com chest","br2","income tax","train1","wh1","chance","wh2","wh3","jail",
			"pi1","power","pi2","pi3","train2","or1","com chest","or2","or3","parking",
			"re1","chance","re2","re3","train3","ye1","ye2","water","ye3",
			"gotojail","gr1","gr2","com chest","gr3","train4","chance","bl1","luxtax","bl2"};
	
//	//buyable lists all buyable properties, set number to -1 if bought.-2 is com chest. -3 is chance.
	private static int[] functions =
		{
			0,1,-2,2,0,3,4,-3,5,6,0,
			7,8,9,10,11,12,-2,13,14,0,
			15,-3,16,17,18,19,20,21,22,0,
			23,24,-2,25,26,-3,27,0,28
		};


	// start off with 0 players before adding them in
	static int playerCount = 0;
	public static int currPlayer = 0;
	public static String[] playerNames = new String[6];

	public static void CreateProperties() {
		for (int i=0;i<40;i++) {
			if (functions[i]<1) {
				propertyList[i]= new Properties(i,PlaceNames[i],0,null, 0,false);
			} else {
				propertyList[i]= new Properties(i,PlaceNames[i],sitePrices[functions[i]-1],rentalPrices[functions[i]-1],housePrices[functions[i]-1],true);
			}
		}
	}
	
	public static void checkInput() throws InterruptedException {
		
		String userInput = textField.getText().toLowerCase();
		String oneWord = "";
		String manyWord = "";
	
	    if (userInput.indexOf(' ') > -1) { 
	    	// only takes the first word
	    	manyWord += userInput.substring(0, userInput.indexOf(' ')).toLowerCase();
	    	switch(manyWord.toLowerCase())
			{
				case "build":
					String buildDetail = manyWord.replaceFirst("build ", "");
					Houses.build(buildDetail);
					break;
				
				case "demolish":
					String demolishDetail = manyWord.replaceFirst("demolish ", "");
					Houses.demolish(demolishDetail);
					break;
				
					
				case "mortgage":
					String mortgageDetail = manyWord.replaceFirst("mortgage", "");
					Command.mortgageProperty(mortgageDetail);
					break;
					
				case "unmortgage":
					String unmortgageDetail = manyWord.replaceFirst("unmortgage ", "");
					Command.unMortgage(unmortgageDetail);
					break;
					
				default: 
					textArea.append("Invalid input, please try \"help\" \n");
					Command.scroll();
					UI.help();
			}
		} else {
			oneWord += userInput.toLowerCase();
			switch(oneWord.toLowerCase()) {
				case "roll": 
					Command.roll();
					break;
					
				case "property":
					Command.property();
					break;
					
				case "balance": 
					textArea.append("You have "+playerList[currPlayer].getBalance()+" dolla\n");
					break;
					
				case "done":
					Command.endTurn();
					break;
					
				case "buy":
					textArea.append(Properties.purchase()+"\n");
					break;
				
				case "pay rent":
					Properties.payRent();
					break;
					
				case "quit": 
					Command.quit();
					break;
					
				case "help":
					Command.help();
					break;
					
				case "draw chance":
					Command.drawChance();
					break;
					
				case "bankrupt":
					Command.playerBankrupt();
					break;
					
				default: 
					textArea.append("Invalid input, please try \"help\" \n");
					Command.scroll();
					UI.help();
			}
	    }
    }
	
	public void help() {
		textArea.append("List of valid inputs: ");
		for(int i = 0; i < validInstructions.length; i++) {
			textArea.append((validInstructions[i] + ", "));
		}
		
		textArea.append("\n");
		Command.scroll();
	}

	public static ImageIcon createImages(String URL) throws IOException {
		URL url = new URL(URL);
	    BufferedImage img = ImageIO.read(url);
	    ImageIcon icon = new ImageIcon(img);
	    
		return icon;
	}
	

	
	public static int BasicRoll() {
		int dice1 = (int)(Math.random() * 6) + 1;
		int dice2 = (int)(Math.random() * 6) + 1;
		int total = dice1 + dice2;
		
		return total;
	}
	
	public static void MoveAllByOne() throws InterruptedException
	{
		//to move the tokens the full 40 squares around the board
		for(int j = 0;j<playerCount;j++)
		{
			playerIcons[j].setLocation(boardPos[playerPos[j]][0]+((j%3)*uqLoc),boardPos[playerPos[j]][1]+((j/3)*uqLoc));
			playerPos[j]++;
		}
	}
	
	public static void main( String args[] ) throws IOException, InterruptedException
	{
		CreateProperties();
		//setting the look of the window
	    try 
	    {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	    
	    while(playerCount==0 || playerCount>6 || playerCount<2)
		{
			String count=JOptionPane.showInputDialog("Enter player count 2-6");
			playerCount = Integer.parseInt(count);
		}
	    PlayerStart.PlayersInitialise(playerCount, playerList);
	    UI.createJlabels();
	    
	   // Create an instance of the test application
	    Board monopoly = new Board();
	    //getting screen information
	    int width, height;
	    
	    Toolkit screen = Toolkit.getDefaultToolkit();
	    Dimension x = screen.getScreenSize();
	    
	    width = x.width;
	    height = x.height;
	    
	    //setting the application to almost the full size of the user window
	    monopoly.setSize((width-60), (height-60));
	    
	    //setting values for the instance
	    monopoly.setTitle("Interdimensional Panopoly");
	    monopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    monopoly.setResizable(false);
	    monopoly.setVisible(true);
	    //setting up the sizes of the panes
	    UI.paneRight.setDividerLocation(620);
	    UI.paneLeft.setDividerLocation(620); 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}	
}