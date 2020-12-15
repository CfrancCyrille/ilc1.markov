package markov;

import static org.junit.Assert.*;

import org.junit.Test;

import markov.MarkovChain;

public class MarkovChainTest {

	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void readTest() {
		String text = "Hello world";
		MarkovData data = new MarkovData();
		data.read(text);
		String testText = data.getKeyWord(0) + " " + data.getKeyWord(1);
		int expected = 0;
		int actual = text.compareTo(testText);
		assertEquals(expected, actual);
	}
	
	@Test
	public void renforceFalseTest() {
		String text = "Hello world";
		MarkovData data = new MarkovData();
		boolean actual = data.renforceWord("Hello", text);
		boolean expected = false;
		assertEquals(expected, actual);
	}

}
