package monopoly_take2;

public class Dice {
	
	private int dice1;
    private int dice2;
	
	public boolean isDouble() {
		return dice1 == dice2;
	}
	
	public int total() {
		dice1 = (int)(Math.random() * 6 + 1);
		dice2 = (int)(Math.random() * 6 + 1);
		
		return dice1 + dice2;
	}
	
	public String toString() {
		return dice1 + " " + dice2;
	}

	public int getDice1Value() {
		// TODO Auto-generated method stub
		return dice1;
	}

	public int getDice2Value() {
		// TODO Auto-generated method stub
		return dice2;
	}
	
}
