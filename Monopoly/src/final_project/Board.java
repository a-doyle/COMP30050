package monopoly_take2;

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
    private static JLabel board;
    public static JLabel[] Dots = new JLabel[7];
	public static final long serialVersionUID = 1L;
	public static String[] UrlList={"http://i.imgur.com/VbSecNL.png","http://i.imgur.com/OspXIUI.png","http://i.imgur.com/qIxtgOY.png","http://i.imgur.com/7KE7dLV.png",
	"http://i.imgur.com/CfsO3YF.png","http://i.imgur.com/l12Qyvd.png"};
	public static boolean GAMEOVER = false;
	public static boolean canRoll = true;	
	public static Properties prop;	
	
	static final int[][] BoardCoord = {
	{542,542},{491,542},{440,542},{389,542},{338,542},{287,542},{236,542},{185,542},{134,542},{83,542},{32,542},
	{32,491},{32,440},{32,389},{32,338},{32,287},{32,236},{32,185},{32,134},{32,83},{32,32},
	{83,32},{134,32},{185,32},{236,32},{287,32},{338,32},{389,32},{440,32},{491,32},{542,32},
	{542,83},{542,134},{542,185},{542,236},{542,287},{542,338},{542,389},{542,440},{542,491}};
	
	
	public static Players[] PlayerArray = new Players[7];
	
	static int offset = 16; // offset applied to each token to give it a unique location on board
	static int numberPlayers = 0;//number of players in game, can be changed at later date
	public static int currentPlayer = 0;
	public static String[] Playernames = new String[6];
	private static JSplitPane  splitPaneRight;
	private static JSplitPane  splitPaneLeft;
	private static PlayerStart player;
	
	
	//JPanels for the command, board, and the information display 
	static JPanel  commandPanel;
	private JPanel  boardPanel;
	private JPanel  informationDisplayPanel;
	
	public static JTextArea textArea = new JTextArea();
	public static boolean CanEnd=true;
	public static JTextField textField = new JTextField("");
	private JButton button = new JButton("Click");
	private JScrollPane scrollPane;
	
	
	public Board() throws IOException
	{
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
	    
	    splitPaneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    
	    //Adds both the command and board panels to the left
	    
	    splitPaneLeft.setBottomComponent(commandPanel);
	    splitPaneLeft.setTopComponent(boardPanel);
	    
	    //Adds both the information panel to the right
	    splitPaneRight.setLeftComponent(splitPaneLeft);
	    splitPaneRight.setRightComponent(informationDisplayPanel);
	}
	
	public void commandLinePanel(){
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
						Command.checkInput();
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
						Command.checkInput();
					}catch (InterruptedException e1) {
						e1.printStackTrace();
		}
		textField.setText("");//setting text field back to be blank
		}  		
	}
);
	}
	

	public static ImageIcon createImages(String URL) throws IOException{
		URL url = new URL(URL);
	    BufferedImage img = ImageIO.read(url);
	    ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	
	public static void createJlabels() throws IOException{
		board = new JLabel(createImages("http://i.imgur.com/n3lFgwu.jpg"));
		
		for(int i = 0;i < numberPlayers; i++){
			Dots[i]=new JLabel(createImages(UrlList[i]));
		}
	}
	public void monopolyBoardPanel() throws IOException{
		
		//creating a new panel for the monopoly board
		boardPanel = new JPanel();
		boardPanel.setLayout(null);
		
		for(int i = 0;i < numberPlayers;i++)
		{
		    boardPanel.add(Dots[i]);//adding the blue dot image
		    Dots[i].setSize(10, 10);//setting the pixel size of the blue dot
		    Dots[i].setLocation(BoardCoord[0][0]+((i%3)*offset),BoardCoord[0][1]+((i/3)*offset));//sets starting location
		}
	    
	    //setting the size of the board panel and adding the board to the panel
	    board.setSize(620,620);
	    boardPanel.add(board);
	}

	public void informationPanel()
	{
		
		//Creates panel and sets its parameters
		informationDisplayPanel = new JPanel();
		informationDisplayPanel.setLayout(new BorderLayout());
		informationDisplayPanel.setPreferredSize(new Dimension(50, 50));
		informationDisplayPanel.setMinimumSize(new Dimension(50, 50));

		//Adds the textarea to a scollpane 
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollPane = new JScrollPane(textArea);
		informationDisplayPanel.add(new JLabel( "Information Panel: Details all events of the game."), BorderLayout.NORTH);
		
		informationDisplayPanel.add(scrollPane, BorderLayout.CENTER);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
	}//needed
	//class to decide what movement will happen initially
	
	public static void main( String args[] ) throws IOException, InterruptedException{
		
		prop.createProperties();
		
		//setting the look of the window
	    try 
	    {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	    
	    while(numberPlayers == 0 || numberPlayers > 6 || numberPlayers < 2){
			String count = JOptionPane.showInputDialog("Enter player count 2-6");
			numberPlayers = Integer.parseInt(count);
		}
	    
	    player.playersInitialise(numberPlayers, PlayerArray);
	    createJlabels();
	    
	   // Create an instance of the test application
	    Board monopoly = new Board();
	    Toolkit screen = Toolkit.getDefaultToolkit();
	    Dimension x = screen.getScreenSize();
	    int width, height;
	    
	    width = x.width;
	    height = x.height;
	    
	    //setting the application size on the users screen
	    monopoly.setSize((width - 100), (height - 100));
	    
	    monopoly.setTitle("Panopoly");
	    monopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    monopoly.setResizable(false);
	    monopoly.setVisible(true);
	    
	    //Set the size of the panes.
	    splitPaneRight.setDividerLocation(620);
	    splitPaneLeft.setDividerLocation(620); 
	    
	}	
}
