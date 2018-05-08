import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DiceTest{
	
    @Test
    public void rollDice() throws Exception {
    	
        Dice testDice = new Dice();
        
        //Probability distribution
        
        double[] expectedOutcome = {0,0,.027,.054,.081,.11,.138,.166,.138,.11,.081,.054,.027};
        double[] resultsOfTest = new double[13];
        
        for(double results : resultsOfTest){
            results = 0;
        }
        
        for(int i = 0; i < 100000; i++){
        	
            resultsOfTest[ testDice.rollDice(2, 6)]++;
        }
        
        for(int i = 0; i < 12; i++){
        	
            resultsOfTest[i] = resultsOfTest[i]/100000;
            assertTrue("Test failed at: ", resultsOfTest[i] < (.005 + expectedOutcome[i]) && resultsOfTest[i] > (expectedOutcome[i] - .005));
        }
    }
}
