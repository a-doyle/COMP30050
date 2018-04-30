package monopoly;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import monopoly.TileType;
import monopoly.Property;
import monopoly.Tile;

@SuppressWarnings("serial")
public class PropertyInfo extends JPanel {
	
	JLabel name;
	JLabel cost;
	JLabel owner;
	JLabel mortgageValue;
	JLabel isMortgaged;
	JLabel rentValue;
	JButton button;
	Font font = new Font("Consolas", Font.BOLD, 12);
	private Tile prop;
	
	// constructor for all the property info
	public PropertyInfo() {
		
		name = labelMaker("");
		name.setFont(font);
		
		cost = labelMaker("");
		cost.setFont(font);
		
		owner = labelMaker("");
		owner.setFont(font);
		
		mortgageValue = labelMaker("");
		mortgageValue.setFont(font);
		
		isMortgaged = labelMaker("");
		isMortgaged.setFont(font);
		
		rentValue = labelMaker("");
		rentValue.setFont(font);
		
		button = new JButton("Add to your collection");
		button.setSize(75, 50);
	
	}
	
	// function to change property info based on tile type
	public void changeInfo() {
		TileType tileType = this.prop.getTileType();
		if (tileType == TileType.TAX) {
			JLabel display = labelMaker("Pay Tax or face the consequences");
			this.add(display);
		} else if (tileType == TileType.CHANCE || tileType == TileType.COMMUNITY) {
			JLabel display = labelMaker("See your card before it's too late");
			this.add(display);
		} else if (tileType == TileType.PROPERTY || tileType == TileType.RAILROAD || tileType == TileType.UTILITY) {
			this.model((Property) this.prop);
		} else if (tileType == TileType.GO_JAIL || tileType == TileType.JAIL) {
			JLabel display = labelMaker("You've been caught...time for justice");
			this.add(display);
		} else if (tileType == TileType.GO || tileType == TileType.FREE_PARKING) {
			JLabel display = labelMaker("You've made some more of the good stuff");
			this.add(display);
		}
	}
	
	public JLabel labelMaker(String s) {
		JLabel display = new JLabel(s);
		// centres the display
		display.setHorizontalAlignment(SwingConstants.CENTER);
		return display;
	}
	
	// adds relevant info to each label
	public void model(Property p) {
		JLabel nameLabel = labelMaker("Name: ");
		nameLabel.setText(p.getIdentifier());
		this.add(nameLabel);
		
		JLabel costLabel = labelMaker("Cost: ");
		costLabel.setText(Integer.toString(p.getNetWorth()));
		this.add(costLabel);
		
		JLabel ownerLabel = labelMaker("Owner: ");
		if (p.isOwned()) {
			ownerLabel.setText(p.getOwner().getIdentifier());
		} else {
			ownerLabel.setText("Owned by no man");
		}
		this.add(ownerLabel);
		
		JLabel mortgageValueLabel = labelMaker("Mortgage value: ");
		mortgageValueLabel.setText(Integer.toString(p.getMortgageValue()));
		this.add(mortgageValueLabel);
		
		JLabel isMortgagedLabel = labelMaker("Mortgaged? ");
		isMortgagedLabel.setText(Boolean.toString(p.isMortgagable()));
		this.add(isMortgagedLabel);
		
		JLabel rentValueLabel = labelMaker("Rent Value: ");
		rentValueLabel.setText(Integer.toString(p.getRentalAmount()));
		this.add(rentValueLabel);
		
		if (p.isOwned()) {
			button.setEnabled(false);
		} else {
			button.setEnabled(true);
		}
		this.add(button);
	}
	
	public JButton getButton() {
		return this.button;
	}
}
