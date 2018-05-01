package monopoly;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {

	private GameBoard gameBoard;
	private PropertyInfo propInfo;
	private PlayerPanel playerPanel;
	
	// constructor intializes the game window
	public Game(int playerAmount) {
		this.setTitle("Interdimensional Panopoly");
		this.setLocation(200, 200);
		this.setSize(1250, 1250);
		this.setResizable(false);
		
		GameBoard game = new GameBoard(playerAmount);
		this.getContentPane().add(game, BorderLayout.CENTER);
		this.gameBoard = game;
		
		PropertyInfo props = new PropertyInfo();
		this.getContentPane().add(props, BorderLayout.WEST);
		this.propInfo = props;
		
		PlayerPanel playerInfo = new PlayerPanel(playerAmount);
		this.getContentPane().add(playerInfo, BorderLayout.EAST);
		this.playerPanel = playerInfo;
	}
	
	// getters
	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
	public PropertyInfo getPropertyInfo() {
		return propInfo;
	}
	
	public PlayerPanel getPlayerInfo() {
		return playerPanel;
	}
}
