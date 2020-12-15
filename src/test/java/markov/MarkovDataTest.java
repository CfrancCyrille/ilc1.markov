package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRead() {
		String depart="jour nuit";
		MarkovData markov= new MarkovData();
		markov.read(depart);
		String assemblage=markov.getKeyWord(0)+" "+markov.getKeyWord(1);
		int expected=0;
		int res=depart.compareTo(assemblage);
		assertEquals(res, expected);
	}
	
	@Test
	public void testRenforceWord_False() {
		String depart="jour nuit";
		MarkovData markov=new MarkovData();
		boolean res;
		res=markov.renforceWord("jour",depart );
		boolean expected=false;
		assertEquals(expected,res);
	}

}
