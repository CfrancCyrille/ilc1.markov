package markov;

import static org.junit.Assert.*;

import org.junit.Test;

import markov.MarkovChain;

public class MarkovChainTest {

	@Test
	public void testlearnTrue() { // pas d'accées vers quoi que ce soit
		boolean Expected ;
		MarkovChain mark = new MarkovChain(10);
		mark.learn("text");
		assert(false);
		//assertArrayEquals(mark.data, expecteds, actuals);
	}

	@Test
	public void testgenerateMarkovTrue() {
		String text = "t a" ;
		String res;
		MarkovChain mark = new MarkovChain(1);
		mark.learn("t a");
		res = mark.generateMarkov(1);
		text = "t";
		int result = text.compareTo(res);
		int expected = 0;
		assertEquals(expected, result);
		
	}
}
