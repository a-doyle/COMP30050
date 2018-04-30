package monopoly;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.ImageIcon;

import monopoly.Board;
import monopoly.Dice;

@SuppressWarnings("serial")
public class GameBoard extends JPanel {
	
	JLabel[] players;
	private int boardPositions[][];
	JLabel d1;
	JLabel d2;
	int playerAmount;
	// array containing player tokens
	private final String[] filePathTokens = {};
	
	// game board constructor
	public GameBoard(int numPlayers) {
		this.playerAmount = numPlayers;
		// 40 tiles split into threes for ease of management
		this.boardPositions = new int[40][2];
		this.players = new JLabel[playerAmount];
		// sets size of game board
		this.setSize(925, 925);
		// generate player tokens
		for (int i=0; i < playerAmount; i++) {
			this.players[i] = new JLabel();
			this.players[i].setIcon(new ImageIcon(()));
			this.players[i].setSize(35, 35);
			this.movePlayer(i, 0);
			this.add(this.players[i]);
		}
		
		// creating the dice images
		d1 = new JLabel();
		d1.setIcon(new ImageIcon(()));
		d1.setBounds(200, 425, 50, 50);
		d2 = new JLabel();
		d2.setIcon(new ImageIcon(()));
		d2.setBounds(200, 510, 75, 75);
		add(d1);
		add(d2);
		
		// creating the boxes for each tile
		
		// goTile
		Box goTile = Box.createVerticalBox();
		goTile.setBounds(800, 800, 125, 125);
		add(goTile);
		JLabel goImg = newJLabel();
		goImg.setIcon(new ImageIcon(()));
		goTile.add(goImg);
		
		// first property
		Box tile1 = Box.createVerticalBox();
		tile1.setBounds(725, 800, 75, 125);
		add(tile1);
		JLabel prop1Color = newJLabel();
		prop1Color.setIcon(new ImageIcon(()));
		tile1.add(prop1Color);
		
		// first community chest
		Box tile2 = Box.createVerticalBox();
		tile2.setBounds(650, 800, 75, 125);
		add(tile2);
		JLabel comm1 = newJLabel();
		comm1.setIcon(new ImageIcon(()));
		tile2.add(comm1);
		
		// second property
		Box tile3 = Box.createVerticalBox();
		tile3.setBounds(575, 800, 75, 125);
		add(tile3);
		JLabel prop2Color = newJLabel();
		prop2Color.setIcon(new ImageIcon(()));
		tile3.add(prop2Color);
		
		// first tax
		Box tile4 = Box.createVerticalBox();
		tile4.setBounds(500, 800, 75, 125);
		add(tile4);
		JLabel tax1 = newJLabel();
		tax1.setIcon(new ImageIcon(()));
		tile4.add(tax1);
		
		// first railroad
		Box tile5 = Box.createVerticalBox();
		tile5.setBounds(425, 800, 75, 125);
		add(tile5);
		JLabel rail1 = newJLabel();
		rail1.setIcon(new ImageIcon(()));
		tile5.add(rail1);
		
		// third property
		Box tile6 = Box.createVerticalBox();
		tile6.setBounds(350, 800, 75, 125);
		add(tile6);
		JLabel prop3Color = newJLabel();
		prop3Color.setIcon(new ImageIcon(()));
		tile6.add(prop3Color);
		
		// first chance
		Box tile7 = Box.createVerticalBox();
		tile7.setBounds(275, 800, 75, 125);
		add(tile7);
		JLabel chan1 = newJLabel();
		chan1.setIcon(new ImageIcon(()));
		tile7.add(chan1);
		
		// fourth property
		Box tile8 = Box.createVerticalBox();
		tile8.setBounds(200, 800, 75, 125);
		add(tile8);
		JLabel prop4Color = newJLabel();
		prop4Color.setIcon(new ImageIcon(()));
		tile8.add(prop4Color);
		
		// fifth property
		Box tile9 = Box.createVerticalBox();
		tile9.setBounds(125, 800, 75, 125);
		add(tile9);
		JLabel prop5Color = newJLabel();
		prop5Color.setIcon(new ImageIcon(()));
		tile9.add(prop5Color);
		
		// jail
		Box tile10 = Box.createVerticalBox();
		tile10.setBounds(0, 800, 125, 125);
		add(tile10);
		JLabel jail = newJLabel();
		jail.setIcon(new ImageIcon(()));
		tile10.add(jail);
		
		// sixth property
		Box tile11 = Box.createHorizontalBox();
		tile11.setBounds(0, 725, 125, 75);
		add(tile11);
		JLabel prop6Color = new JLabel();
		prop6Color.setIcon(new ImageIcon(()));
		tile11.add(prop6Color);
		
		// first utility
		Box tile12 = Box.createHorizontalBox();
		tile12.setBounds(0, 650, 125, 75);
		add(tile12);
		JLabel util1 = new JLabel();
		util1.setIcon(new ImageIcon(()));
		tile12.add(util1);
		
		// seventh property
		Box tile13 = Box.createHorizontalBox();
		tile13.setBounds(0, 575, 125, 75);
		add(tile13);
		JLabel prop7Color = new JLabel();
		prop7Color.setIcon(new ImageIcon(()));
		tile13.add(prop7Color);
		
		// eighth property
		Box tile14 = Box.createHorizontalBox();
		tile14.setBounds(0, 500, 125, 75);
		add(tile14);
		JLabel prop8Color = new JLabel();
		prop8Color.setIcon(new ImageIcon(()));
		tile14.add(prop8Color);
		
		// second railroad
		Box tile15 = Box.createHorizontalBox();
		tile15.setBounds(0, 425, 125, 75);
		add(tile15);
		JLabel rail2 = new JLabel();
		rail2.setIcon(new ImageIcon(()));
		tile15.add(rail2);
		
		// ninth property
		Box tile16 = Box.createHorizontalBox();
		tile16.setBounds(0, 350, 125, 75);
		add(tile16);
		JLabel prop9Color = new JLabel();
		prop9Color.setIcon(new ImageIcon(()));
		tile16.add(prop9Color);

		// second community chest
		Box tile17 = Box.createHorizontalBox();
		tile17.setBounds(0, 275, 125, 75);
		add(tile17);
		JLabel comm2 = new JLabel();
		comm2.setIcon(new ImageIcon(()));
		tile17.add(comm2);

		// tenth property
		Box tile18 = Box.createHorizontalBox();
		tile18.setBounds(0, 200, 125, 75);
		add(tile18);
		JLabel prop10Color = new JLabel();
		prop10Color.setIcon(new ImageIcon(()));
		tile18.add(prop10Color);
		
		// eleventh property
		Box tile19 = Box.createHorizontalBox();
		tile19.setBounds(0, 125, 125, 75);
		add(tile19);
		JLabel prop11Color = new JLabel();
		prop11Color.setIcon(new ImageIcon(()));
		tile19.add(prop11Color);
		
		// free parking
		Box tile20 = Box.createHorizontalBox();
		tile20.setBounds(0, 0, 125, 125);
		add(tile20);
		JLabel freeParking = new JLabel();
		freeParking.setIcon(new ImageIcon(()));
		tile20.add(freeParking);
		
		// twelfth property
		Box tile21 = Box.createVerticalBox();
		tile21.setBounds(125, 0, 75, 125);
		add(tile21);
		JLabel prop12Color = newJLabel();
		prop12Color.setIcon(new ImageIcon(()));
		tile21.add(prop12Color);

		// second chance
		Box tile22 = Box.createVerticalBox();
		tile22.setBounds(200, 0, 75, 125);
		add(tile22);
		JLabel chan2 = newJLabel();
		chan2.setIcon(new ImageIcon(()));
		tile22.add(chan2);

		// thirteenth property
		Box tile23 = Box.createVerticalBox();
		tile23.setBounds(275, 0, 125, 125);
		add(tile23);
		JLabel prop13Color = newJLabel();
		prop13Color.setIcon(new ImageIcon(()));
		tile23.add(prop13Color);
		
		// fourteenth property
		Box tile24 = Box.createVerticalBox();
		tile24.setBounds(350, 0, 125, 125);
		add(tile24);
		JLabel prop14Color = newJLabel();
		prop14Color.setIcon(new ImageIcon(()));
		tile24.add(prop14Color);
		
		// third railroad
		Box tile25 = Box.createVerticalBox();
		tile25.setBounds(425, 0, 125, 125);
		add(tile25);
		JLabel rail3 = newJLabel();
		rail3.setIcon(new ImageIcon(()));
		tile25.add(rail3);
		
		// fifteenth property
		Box tile26 = Box.createVerticalBox();
		tile26.setBounds(500, 0, 125, 125);
		add(tile26);
		JLabel prop15Color = newJLabel();
		prop15Color.setIcon(new ImageIcon(()));
		tile26.add(prop15Color);
		
		// sixteenth property
		Box tile27 = Box.createVerticalBox();
		tile27.setBounds(575, 0, 125, 125);
		add(tile27);
		JLabel prop16Color = newJLabel();
		prop16Color.setIcon(new ImageIcon(()));
		tile27.add(prop16Color);
		
		// second utility
		Box tile28 = Box.createVerticalBox();
		tile28.setBounds(650, 0, 125, 125);
		add(tile28);
		JLabel util2 = newJLabel();
		util2.setIcon(new ImageIcon(()));
		tile28.add(util2);
		
		// seventeenth property
		Box tile29 = Box.createVerticalBox();
		tile29.setBounds(725, 0, 125, 125);
		add(tile29);
		JLabel prop17Color = newJLabel();
		prop17Color.setIcon(new ImageIcon(()));
		tile29.add(prop17Color);
		
		// go to jail
		Box tile30 = Box.createHorizontalBox();
		tile30.setBounds(800, 0, 125, 125);
		add(tile30);
		JLabel gotoJail = newJLabel();
		gotoJail.setIcon(new ImageIcon(()));
		tile30.add(gotoJail);
		
		// eighteenth property
		Box tile31 = Box.createHorizontalBox();
		tile31.setBounds(800, 125, 125, 75);
		add(tile31);
		JLabel prop18Color = new JLabel();
		prop18Color.setIcon(new ImageIcon(()));
		tile31.add(prop18Color);
		
		// nineteenth property
		Box tile32 = Box.createHorizontalBox();
		tile32.setBounds(800, 200, 125, 75);
		add(tile32);
		JLabel prop19Color = new JLabel();
		prop19Color.setIcon(new ImageIcon(()));
		tile32.add(prop19Color);
		
		// third community chest
		Box tile33 = Box.createHorizontalBox();
		tile33.setBounds(800, 275, 125, 75);
		add(tile33);
		JLabel comm3 = new JLabel();
		comm3.setIcon(new ImageIcon(()));
		tile33.add(comm3);
		
		// twentieth property
		Box tile34 = Box.createHorizontalBox();
		tile34.setBounds(800, 350, 125, 75);
		add(tile34);
		JLabel prop20Color = new JLabel();
		prop20Color.setIcon(new ImageIcon(()));
		tile34.add(prop20Color);
		
		// fourth railroad
		Box tile35 = Box.createHorizontalBox();
		tile35.setBounds(800, 425, 125, 75);
		add(tile35);
		JLabel rail4 = new JLabel();
		rail4.setIcon(new ImageIcon(()));
		tile35.add(rail4);
		
		// third chance
		Box tile36 = Box.createHorizontalBox();
		tile36.setBounds(800, 500, 125, 75);
		add(tile36);
		JLabel chan3 = new JLabel();
		chan3.setIcon(new ImageIcon(()));
		tile36.add(chan3);
		
		// twenty-first property
		Box tile37 = Box.createHorizontalBox();
		tile37.setBounds(800, 575, 125, 75);
		add(tile37);
		JLabel prop21Color = new JLabel();
		prop21Color.setIcon(new ImageIcon(()));
		tile37.add(prop21Color);
		
		// second tax
		Box tile38 = Box.createHorizontalBox();
		tile38.setBounds(800, 625, 125, 75);
		add(tile38);
		JLabel tax2 = new JLabel();
		tax2.setIcon(new ImageIcon(()));
		tile38.add(tax2);
		
		// twenty-second property
		Box tile39 = Box.createHorizontalBox();
		tile39.setBounds(800, 675, 125, 75);
		add(tile39);
		JLabel prop22Color = new JLabel();
		prop22Color.setIcon(new ImageIcon(()));
		tile39.add(prop22Color);		
	}
	
	
	// changes the dice images based on what value is rolled
	public void diceChange(Dice dice) {
		switch (dice.getDice1Value()) {
			case 1:
				d1.setIcon(new ImageIcon(GameBoard.class.getResource("diceOne.jpeg")));
				break;
			case 2:
				d1.setIcon(new ImageIcon(GameBoard.class.getResource("diceTwo.jpeg")));
				break;
			case 3:
				d1.setIcon(new ImageIcon(GameBoard.class.getResource("diceThree.jpeg")));
				break;
			case 4:
				d1.setIcon(new ImageIcon(GameBoard.class.getResource("diceFour.jpeg")));
				break;
			case 5:
				d1.setIcon(new ImageIcon(GameBoard.class.getResource("diceFive.jpeg")));
				break;
			case 6:
				d1.setIcon(new ImageIcon(GameBoard.class.getResource("diceSix.jpeg")));
				break;
		}
		
		switch (dice.getDice2Value()) {
			case 1:
				d2.setIcon(new ImageIcon(GameBoard.class.getResource("diceOne.jpeg")));
				break;
			case 2:
				d2.setIcon(new ImageIcon(GameBoard.class.getResource("diceTwo.jpeg")));
				break;
			case 3:
				d2.setIcon(new ImageIcon(GameBoard.class.getResource("diceThree.jpeg")));
				break;
			case 4:
				d2.setIcon(new ImageIcon(GameBoard.class.getResource("diceFour.jpeg")));
				break;
			case 5:
				d2.setIcon(new ImageIcon(GameBoard.class.getResource("diceFive.jpeg")));
				break;
			case 6:
				d2.setIcon(new ImageIcon(GameBoard.class.getResource("diceSix.jpeg")));
				break;
		}
	}
	
	// moves the player to specified tile
	public void movePlayer(int player, int destination) {
		if (destination < 11 || (destination > 19 && destination < 31)) {
			this.players[player].setBounds(this.boardPositions[destination][0], this.boardPositions[destination][1], 25, 25);
		} else {
			this.players[player].setBounds(this.boardPositions[destination][0], this.boardPositions[destination][1], 25, 25);
		}
	}
	
	// resets the board for new game
	public void boardReset() {
		for (int i = 0; i < playerAmount; i++) {
			this.movePlayer(i, 0);
		}
	}
}
