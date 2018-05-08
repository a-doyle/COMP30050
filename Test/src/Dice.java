import java.util.Random;

public class Dice implements Rollable {
	
    private final static Random RND = new Random();
    
    public int rollDice(int numDice, int numSides) {
    	
        int sumOfDice = 0;
        
        for (int i = 0; i < numDice; i++) {
            sumOfDice += RND.nextInt(numSides)+1;
        }
        return sumOfDice;
    }
}
