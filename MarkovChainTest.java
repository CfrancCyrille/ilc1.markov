package markov;

import static org.junit.Assert.*;

import org.junit.Test;

import markov.MarkovChain;

public class MarkovChainTest {

    @Test
    public void LearnTest() {
	MarkovChain test = new MarkovChain(2);
        String textBase = "help i need";
        test.learn(textBase);
        int expected = 0;
        String textAttendu = "help i";
        String textFinal = test.generateMarkov(2);
        int erreur =textAttendu.compareTo(textFinal);
        assertEquals(expected,erreur);           
    }
    
    @Test
    public void geneateMarkovTest() {
	
    }
}
