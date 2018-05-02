package monopoly;

import static org.junit.Assert.*;

import monopoly.Dice;

import org.junit.Test;

public class DiceTest {

	@Test
	public void diceTest() {
		Dice dice = new Dice();
		
		int tests = 100;
		for (int i = 0; i < tests; i++) {
			dice.roll();
			int dice1 = dice.getDice1Value();
			int dice2 = dice.getDice2Value();
			
			assertTrue(dice1 > 0 && dice1 < 7);
			assertTrue(dice2 > 0 && dice2 < 7);
		}
	}

}
