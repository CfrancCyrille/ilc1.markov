package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	@Test
	public void testread() {
		String origine = "je suis Vscode";
		MarkovData dat  = new MarkovData();
		dat.read(origine);
		String reconstruction = dat.getKeyWord(0)+" "+dat.getKeyWord(1)+" "+dat.getKeyWord(2);
		int expected = 0 ;
		int result = origine.compareTo(reconstruction);
		assertEquals(expected, result);
	}

	@Test
	public void testrenforceWordFalse() {
		String origine = "je suis Vscode";
		MarkovData dat  = new MarkovData();
		boolean result;
		result = dat.renforceWord("je",origine);
		Boolean expected = false ;
		assertEquals(expected, result);
	}

	@Test
	public void testrenforceWordTrue() {
		String origine = "je suis Vscode";
		MarkovData dat  = new MarkovData();
		boolean result;
		dat.learnWord("tu", "je suis Vscode");
		result = dat.renforceWord("tu",origine);
		Boolean expected = true ;
		assertEquals(expected, result);
	}

}
