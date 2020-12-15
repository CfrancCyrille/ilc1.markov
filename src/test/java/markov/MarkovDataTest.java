package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	@Test
	public void testRenforceWordTrue(){
		String sample = "il fait beau";
		MarkovData data = new MarkovData();
		boolean result;
		data.learnWord("beau", sample);
		result = data.renforceWord("beau", sample);
		assertTrue(result);
	}

	@Test
	public void testRenforceWordFalse(){
		String sample = "il fait beau";
		MarkovData data = new MarkovData();
		boolean result;
		result = data.renforceWord("beau", sample);
		assertFalse(result);
	}
}
