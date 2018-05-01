package monopoly;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {
	
	JLabel[] playerNames;
	JLabel[] playerMoney;	
	JButton rollDiceButton;
	int playerAmount;
	Font font = new Font("Consolas", Font.BOLD, 12);
	
	//constructor for panel showing player information
	public PlayerPanel(int numPlayers) {
		this.playerAmount = numPlayers;
		this.playerNames = new JLabel[playerAmount];
		this.playerMoney = new JLabel[playerAmount];
		
		// loops the player info and makes the labels for each player
		for (int i = 0; i < playerAmount; i++) {
			playerNames[i] = labelMaker("Player " + i + "owns: ");
			playerNames[i].setFont(font);
			playerMoney[i] = labelMaker("");
		}
		
		// dice roll button
		rollDiceButton = new JButton("Roll if you dare");
		rollDiceButton.setSize(75, 50);
		
		for (int j = 0; j < playerAmount; j++) {
			this.add(playerNames[j]);
			this.add(playerMoney[j]);
		}
		
		this.add(rollDiceButton);	
	}
	
	public JLabel labelMaker(String s) {
		JLabel display = new JLabel(s);
		display.setHorizontalAlignment(SwingConstants.CENTER);
		return display;
	}
	
	// setters
	public void setPlayerNames(String[] players) {
		for (int i = 0; i < playerAmount; i++) {
			playerNames[i].setText(players[i] + " currency");
		}
	}
	
	public void setPlayerMoney(int player, int money) {
		playerMoney[player].setText(Integer.toString(money));
	}
	
	public void setRollDiceButton(ActionListener a) {
		rollDiceButton.addActionListener(a);
	}
}
