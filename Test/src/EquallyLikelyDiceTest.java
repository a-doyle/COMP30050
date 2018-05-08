import java.lang.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class EquallyLikelyDiceTest
{
    @Test
    public void rollDice() throws Exception {
    	
        EquallyLikelyDice testDice=new EquallyLikelyDice();
        double[] expected={0,0,.027,.054,.081,.11,.138,.166,.138,.11,.081,.054,.027};
        double[] results=new double[13];
        for(double result:results)
        {
            result = 0;
        }
        for(int i=0; i < 100000 ; i++)
        {
            results[testDice.rollDice(2, 6)]++;
        }
        for(int i=0; i<12 ; i++)
        {
            results[i]=results[i]/100000;
            assertTrue("test fail",results[i]<(.005+expected[i])&&results[i]>(expected[i]-.005));
        }
    }

}
