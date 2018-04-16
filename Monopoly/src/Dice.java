
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

	public static void main(String[] args) {
		Dice d = new Dice();
		
		System.out.println(d.total());
		System.out.println(d.isDouble());
		System.out.println(d.toString());
	}
}
