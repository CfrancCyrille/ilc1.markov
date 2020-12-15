package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	MarkovData data = new MarkovData();
	
        @Test
	public void test_read_true() {
		String sentence = "une souris verte";
                String newSentence = "";
                int actual;
                int expected =0;
                data.read(sentence);
                newSentence = data.getKeyWord(0)+" "+data.getKeyWord(1)+" "+data.getKeyWord(1);
                actual = sentence.compareTo(newSentence);
                assertEquals(expected, actual);
	}
        
        @Test
	public void test_renforceWord_false() {
		String sentence = "une souris verte";
                Boolean actual;
                Boolean expected = false;
                actual = data.renforceWord("une", sentence);
                assertEquals(expected, actual);
	}
}
