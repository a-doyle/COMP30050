import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI extends JPanel{
	
	private final JPanel playerPanel;
	private final JPanel inputPanel;
	private final JPanel boardPanel;
	private final JButton roll;
	private final JButton buyButton;
	private final JFrame frame;


	public UI() {
		
		frame = new JFrame("Doctor Nos.");
		playerPanel = new JPanel();
		inputPanel = new JPanel();
		boardPanel = new JPanel();
		roll = new JButton("Roll");
		buyButton = new JButton("Buy");
	
	}
	
	public void run() {
		frame.setSize(500, 500);
		playerPanel.setLayout(new BorderLayout());
		frame.add(playerPanel);
		frame.add(inputPanel);
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
		playerPanel.add(roll);
		playerPanel.add(buyButton);
		frame.setVisible(true);
	}
	
	public static void main(String args[]){
       
		UI u = new UI();
		u.run();
    }
}
