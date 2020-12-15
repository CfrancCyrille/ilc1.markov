package markov;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	@Test
	public void ReadtextTest() {
            MarkovData test = new MarkovData();
            String textBase = "je suis désolé ";
            test.read(textBase);
            ArrayList<String> ListeMots = new ArrayList<String>();
            for(int i =0;i<3;i++){
               ListeMots.add(test.getKeyWord(i));
            } 
            String textFinal = "";
            for(int i =0;i<3;i++){
               textFinal += ListeMots.get(i) + " ";
            }
            int expected = 0;
            int erreur =textBase.compareTo(textFinal);
             assertEquals(expected,erreur);
	}
        
        @Test
        public void renforceWordTestTrue(){
            String motsToLearnTest = "why"; 
            String keyTest = "help";
            MarkovData test = new MarkovData();
            test.learnWord(keyTest, motsToLearnTest);
            boolean result = test.renforceWord(keyTest, motsToLearnTest);
            boolean expected = true;
            assertEquals(expected,result);
            
        }

        @Test
        public void renforceWordTestFalse(){
            String motsToLearnTest = "why"; 
            String keyTest = "help";
            MarkovData test = new MarkovData();
            boolean result = test.renforceWord(keyTest, motsToLearnTest);
            boolean expected = false;
            assertEquals(expected,result);          
        }
}
