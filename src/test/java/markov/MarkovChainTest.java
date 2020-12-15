package markov;

import static org.junit.Assert.*;

import org.junit.Test;

import markov.MarkovChain;

public class MarkovChainTest {
        MarkovChain markChain = new MarkovChain(6);
	
        //@Test
	public void test_Learn_true() {
            Boolean expected = true;
            Boolean actual = true;
            markChain.learn("une");
            markChain.learn("souris");
            markChain.learn("verte");
            markChain.learn("mangais");
            markChain.learn("du");
            markChain.learn("fromage");
            assertEquals(expected, actual);
	}
        
        @Test
	public void test_generateMarkov_false() {
            String expected = "une souris verte mangais du fromage";
            String actual = "";
            
            markChain.learn("une");
            markChain.learn("souris");
            markChain.learn("verte");
            markChain.learn("mangais");
            markChain.learn("du");
            markChain.learn("fromage");
            
            actual = markChain.generateMarkov(6);
            
            assertFalse(expected.equals(actual));
	}
}
