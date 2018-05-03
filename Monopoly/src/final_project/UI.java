package monopoly_take2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import monopoly_take2.Board;

@SuppressWarnings("serial")
public class UI extends JFrame {
	
	static JSplitPane paneRight;
	static JSplitPane paneLeft;
	private static JLabel gameBoard;
	static JPanel commandPanel;
	private JPanel gameBoardPanel;
	private JPanel infoPanel;
	private JScrollPane scrollPane;
	private JButton button;
	static JTextArea textArea = new JTextArea();
	static int playerCount = 0;
	public static boolean CanEnd = true;
	private JTextField textField = new JTextField("");
	// gives each token a unique location
	static int uqLoc = 16;
	
	public UI() throws IOException {
	    setTitle("Monopoly");
	    setBackground(Color.blue);
	    
	    //declares panel for the frame to be created 
	    JPanel leftPanel = new JPanel();
	    leftPanel.setLayout(new BorderLayout());
	    getContentPane().add(leftPanel);

	    // Create the panels
	    commandPanel();
	    gamePanel();
	    informationPanel();
	    textArea.setEditable(false);
	    textArea.setFont(new Font("Serif", Font.BOLD, 15));
	    // splits the right frame
	    paneRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    leftPanel.add(paneRight, BorderLayout.CENTER);
	    
	    // adds the panels to the split pane
	    paneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    
	    // shifting the panels to the correct locations
	    paneLeft.setBottomComponent(commandPanel);
	    paneLeft.setTopComponent(gameBoardPanel);
	    
	    // shifting the panels to the left
	    paneRight.setLeftComponent(paneLeft);
	    paneRight.setRightComponent(infoPanel);
	}
	
	public static void createJlabels() throws IOException {
		// takes a static monopoly board image as the game board to work off
		UI.gameBoard = new JLabel(Board.createImages("http://i.imgur.com/n3lFgwu.jpg"));
		for (int i=0;i<playerCount;i++) {
			Board.playerIcons[i]=new JLabel(Board.createImages(Board.listOfPlayerImages[i]));
		}
	}
	
	public void commandPanel() {
		//creates and aligns text entry field
		commandPanel = new JPanel();
		commandPanel.setLayout(new BorderLayout());  
		commandPanel.add(textField, BorderLayout.CENTER);
		commandPanel.add(button, BorderLayout.EAST);
		textField.setFont(new Font("Serif", Font.BOLD, 24));
		//when button is clicked beside input panel a listener is activated
		textField.addKeyListener
		
		(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textArea.append(textField.getText() +"\n");//counts line and adds text inputed
					Command.scroll();//increments each time input is added
					try {
						Board.checkInput();
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
					// resets text field
					textField.setText("");
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
		});
		
		button.addActionListener
		
		(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append( textField.getText() + "\n");//counts line and adds text inputed
				Command.scroll();
				try {
					Board.checkInput();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				textField.setText("");//setting text field back to be blank
			}  		
		});
		
	}
	
	public void informationPanel() {
		//Creates panel and sets its parameters
		infoPanel = new JPanel();
		infoPanel.setLayout(new BorderLayout());
		infoPanel.setPreferredSize(new Dimension(50, 50));
		infoPanel.setMinimumSize(new Dimension(50, 50));

		// adds text area to the scroll pane
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollPane = new JScrollPane(textArea);
		infoPanel.add(new JLabel( "Information Panel: *** input 'move' to move the blue token around the board ***"), BorderLayout.NORTH);
		infoPanel.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void gamePanel() throws IOException {
		//creating a new panel for the monopoly board
		gameBoardPanel = new JPanel();
		gameBoardPanel.setLayout(null);
		
		for(int i=0;i < playerCount;i++)
		{
			gameBoardPanel.add(Board.playerIcons[i]);//adding the blue dot image
		    Board.playerIcons[i].setSize(10, 10);//setting the pixel size of the blue dot
		    Board.playerIcons[i].setLocation(Board.boardPos[0][0]+((i%3)*uqLoc), Board.boardPos[0][1]+((i/3)*uqLoc));//sets starting location
		}
	    
	    //setting the size of the board panel and adding the board to the panel
		gameBoard.setSize(620,620);
		gameBoardPanel.add(gameBoard);
	}
	
	public static String help(){
		textArea.append("List of valid inputs: ");
		for(int i = 0; i < Board.validInstructions.length; i++){
			textArea.append(( Board.validInstructions[i] + ", "));
		}
		textArea.append("\n");
		Command.scroll();
		return null;
	}
}
