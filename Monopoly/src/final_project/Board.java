package Panopoly;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
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

class Board extends JFrame implements ActionListener 
{
	private static int[] movePos={0,0,0,0,0,0};//ARRAY OF POSITIONS FOR PLAYERS 
    private static JLabel board;
    public static JLabel[] Dots = new JLabel[7];
	public static final long serialVersionUID = 1L;
	public static String[] UrlList={"http://i.imgur.com/VbSecNL.png","http://i.imgur.com/OspXIUI.png","http://i.imgur.com/qIxtgOY.png","http://i.imgur.com/7KE7dLV.png",
	"http://i.imgur.com/CfsO3YF.png","http://i.imgur.com/l12Qyvd.png"};
	public static boolean GAMEOVER=false;
	public static boolean CanRoll=true;		
	public static Dice dice = new Dice();

	private static final int[] HOUSE_PRICE = {
			50,50,0,50,50,50,
			100,0,100,100,0,100,100,100,
			150,50,150,0,150,150,0,150,150,
			200,200,200,0,200,200};

	private static final int[] SITE_PRICES = {
			60,60,200,100,100,120,
			140,150,140,160,200,180,180,200,
			220,220,240,200,260,260,150,280,
			300,300,320,200,350,400};
	private static final int[][] SITE_RENTS = {
			{2,10,30,90,160,250},{4,20,60,180,320,450},{25,50,100,200,200,200},{6,30,90,270,400,550},{6,30,90,270,400,550},{8,40,100,300,450,600},
			{10,50,150,450,625,750},{},{10,50,150,450,625,750},{12,60,180,500,700,900},{25,50,100,200,200,200},{14,70,200,550,750,950},{14,70,200,550,750,950},{16,80,220,600,800,1000},
			{18,90,250,700,875,1050},{18,90,250,700,875,1050},{20,100,300,750,925,1100},{25,50,100,200,200,200},{22,110,330,800,975,1150},{22,110,330,800,975,1150},{},{24,120,360,850,1025,1200},
			{26,130,390,900,1100,1275},{26,130,390,900,1100,1275},{28,150,450,1000,1200,1400},{25,50,100,200,200,200},{35,175,500,1100,1300,1500},{50,200,600,1400,1700,2000}};
	//coordinates array for location on the monopoly board
			public static final int[][] MONOPOLYSETS = {
					{1,3},{6,8,9},{11,13,14},{16,18,19},{21,23,24},{26,27,29},{31,32,34},{37,39}
			};
			
	static final int[][] BoardCoord={
	{542,542},{491,542},{440,542},{389,542},{338,542},{287,542},{236,542},{185,542},{134,542},{83,542},{32,542},
	{32,491},{32,440},{32,389},{32,338},{32,287},{32,236},{32,185},{32,134},{32,83},{32,32},
	{83,32},{134,32},{185,32},{236,32},{287,32},{338,32},{389,32},{440,32},{491,32},{542,32},
	{542,83},{542,134},{542,185},{542,236},{542,287},{542,338},{542,389},{542,440},{542,491}};
	
	public static Players[] PlayerArray = new Players[6];
	static Property[] PropList = new Property[40];
	//below to be changed to proper names, using placeholder for now
	
	static String[] PlaceNames = {"Go","Woodbine Avenue","Community Chest","Woodbine Road","Income taxes","Heuston Station","O Willy Hall",
			"Chance your arm!","Science East","Science West","Library(Jail)",
			"Pi Cafe","Poolbeg","Pulse Cafe","Donald Trumps Armpit","Connolly Station","Gangsters Paradise","Community chest","Newman","or3","Free Parking?",
			"Computer Science","Chance your leg?","RTE Radio Mast","Obamas Secret Hash Garden","Dundalk Station","Trump Tower",
			"Bertie Aherns secret man cave","Grand Canal","Kim Jong Uns secret Ibiza Villa",
			"Go to Library","gr1","gr2","Community Chest","gr3","Pearse St Dart","Do it for a chewit?","Ag Building","Sutherland","Quinn"};
	
	//buyable lists all buyable properties, set number to -1 if bought.-2 is com chest. -3 is chance.
	private static int[] functions = {
			0,1,-2,2,0,3,4,-3,5,6,0,
			7,8,9,10,11,12,-2,13,14,0,
			15,-3,16,17,18,19,20,21,22,0,
			23,24,-2,25,26,-3,27,0,28
		};
	
        static int offset = 16; // offset applied to each token to give it a unique location on board
        static int playerCount = 0;//number of players in game, can be changed at later date
        public static int ActivePlayer = 0;
        public static boolean CanEnd = true;
        private static boolean nextTurn = false;
        public static String[] Playernames = new String[6];
        private static JSplitPane splitPaneRight;
        private static JSplitPane splitPaneLeft;

        static JPanel commandPanel;// panel for inputting commands
        private JPanel boardPanel;//panel holding board image and tokens
        private JPanel informationDisplayPanel;// panel displaying notes as they occur
	
	//below are declarations for text box for command panel and info panel
        static JTextArea textArea = new JTextArea();
        private JTextField textField = new JTextField("");
        private JButton button = new JButton("Click");
		private JScrollPane scrollPane;
	
	public Board() throws IOException{
		
	    setTitle("seshBot");
	    setBackground(Color.blue);
	    
	    //declares panel for the frame to be created 
	    JPanel leftPanel = new JPanel();
	    leftPanel.setLayout(new BorderLayout());
	    getContentPane().add(leftPanel);

	    // Create the panels
	    commandLinePanel();
	    monopolyBoardPanel();
	    informationPanel();
	    textArea.setEditable(false);
	    textArea.setFont(new Font("Serif", Font.BOLD, 15));
	    
	    // Creates a spliter for right frame
	    splitPaneRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    leftPanel.add(splitPaneRight, BorderLayout.CENTER);
	    
	    //adding all panels to the splitpane
	    splitPaneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    
	    //putting the panels to the right side of the split pane
	    splitPaneLeft.setBottomComponent(commandPanel);
	    splitPaneLeft.setTopComponent(boardPanel);
	    
	    //putting the panels to the left side of the split pane
	    splitPaneRight.setLeftComponent(splitPaneLeft);
	    splitPaneRight.setRightComponent(informationDisplayPanel);
	}
	
	public static ImageIcon createImages(String URL) throws IOException{
		URL url = new URL(URL);
	    BufferedImage img = ImageIO.read(url);
	    ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	
	public static void createJlabels() throws IOException
	{
		board = new JLabel(createImages("http://i.imgur.com/n3lFgwu.jpg"));
		
		for(int i=0;i<playerCount;i++){
			Dots[i]=new JLabel(createImages(UrlList[i]));
		}
	}
	public void monopolyBoardPanel() throws IOException{
		
		//creating a new panel for the monopoly board
		boardPanel = new JPanel();
		boardPanel.setLayout(null);
		
		for(int i=0;i<playerCount;i++)
		{
		    boardPanel.add(Dots[i]);//adding the blue dot image
		    Dots[i].setSize(10, 10);//setting the pixel size of the blue dot
		    Dots[i].setLocation(BoardCoord[0][0]+((i%3)*offset),BoardCoord[0][1]+((i/3)*offset));//sets starting location
		}
	    
	    //setting the size of the board panel and adding the board to the panel
	    board.setSize(620,620);
	    boardPanel.add(board);
	}

	public void informationPanel(){
		
		//Creates panel and sets its parameters
		informationDisplayPanel = new JPanel();
		informationDisplayPanel.setLayout(new BorderLayout());
		informationDisplayPanel.setPreferredSize(new Dimension(50, 50));
		informationDisplayPanel.setMinimumSize(new Dimension(50, 50));

		//Adds the textarea to a scollpane 
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollPane = new JScrollPane(textArea);
		informationDisplayPanel.add(new JLabel( "Information Panel: *** input 'move' to move the blue token around the board ***"), BorderLayout.NORTH);
		
		informationDisplayPanel.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void commandLinePanel()
	{
		//creates and aligns text entry field
		commandPanel = new JPanel();
		commandPanel.setLayout(new BorderLayout());  
		commandPanel.add(textField, BorderLayout.CENTER);
		commandPanel.add(button, BorderLayout.EAST);
		textField.setFont(new Font("Serif", Font.BOLD, 24));
		//when button is clicked beside input panel a listener is activated
		textField.addKeyListener
		(new KeyListener(){
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textArea.append(textField.getText() +"\n");//counts line and adds text inputed
					Command.Scroll();//increments each time input is added
					try {
						checkInput();
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
					textField.setText("");//setting text field back to be blank
					} 
				}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			}
		);
		button.addActionListener
		
		(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					textArea.append( textField.getText() + "\n");//counts line and adds text inputed
					Command.Scroll();
					try {
						checkInput();
					}catch (InterruptedException e1) {
						e1.printStackTrace();
		}
		textField.setText("");//setting text field back to be blank
		}  		
	}
);
	}
	
	public static void CreateProperties(){	
		for(int i = 0;i < 40; i++)
		{
			if(functions[i]<1) {
				PropList[i]= new Property(i,PlaceNames[i],0,null,0,false);
			}
			else{
			PropList[i]= new Property(i,PlaceNames[i],SITE_PRICES[functions[i]-1],SITE_RENTS[functions[i]-1],HOUSE_PRICE[functions[i]-1],true);
			}
		}
	}
	
	public void checkInput() throws InterruptedException
	{
		//TO BE CHANGED TO ACCOMODATE ALL COMMANDS
		
			String userInput = textField.getText().toLowerCase();
			
			String oneWord = "";
			String manyWord = "";

		    if (userInput.indexOf(' ') > -1) //
		    { 
		      manyWord += userInput.substring(0, userInput.indexOf(' ')).toLowerCase(); // takes first word of many.
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
						Command.Scroll();
						Command.help();
				}
			}
		    
		    else 
		    {
		      oneWord += userInput.toLowerCase(); // the first word
		      
		      switch(oneWord.toLowerCase())
				{
				
					case "roll": 
						Command.roll();
						break;
						
					case "property":
						Command.property();
						break;
						
					case "balance": 
						if(PlayerArray[ActivePlayer].balance > 4000)
							textArea.append("You have €" + PlayerArray[ActivePlayer].getBalance() + "ya rich bastard\n");
						else 
							textArea.append("You have €" + PlayerArray[ActivePlayer].getBalance() + "ya cheap bastard\n");
						
						break;
						
					case "done":
						Command.EndTurn();
						break;
						
					case "buy":
						textArea.append(Property.purchase()+"\n");
						break;
					
					case "pay rent":
						Property.payRent();
						break;
						
					case "help":
						Command.help();
						break;
						
					case "draw chance":
					//	Command.drawChance();
						break;
						
					case "bankrupt":
						Command.bankrupt();
						break;
						
					default: 
						textArea.append("Invalid input, please try \"help\" \n");
						Command.Scroll();
						Command.help();
				}
		      }
		    }
	
	public static int BasicRoll(){
		return dice.total();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
	}//needed
	//class to decide what movement will happen initially
	
	public static void main( String args[] ) throws IOException, InterruptedException
	{
		CreateProperties();
		//setting the look of the window
	    try 
	    {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	    
	    while(playerCount == 0 || playerCount > 6 || playerCount < 2)
		{
			String count = JOptionPane.showInputDialog("Enter player count 2-6");
			playerCount = Integer.parseInt(count);
		}
	    PlayerStart.PlayersInitialise(playerCount, PlayerArray);
	    createJlabels();
	    
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
	    monopoly.setTitle("Monopoly");
	    monopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    monopoly.setResizable(false);
	    monopoly.setVisible(true);
	    //setting up the sizes of the panes
	    splitPaneRight.setDividerLocation(620);
	    splitPaneLeft.setDividerLocation(620); 
	}
	
}
