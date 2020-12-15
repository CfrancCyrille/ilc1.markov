package markov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkovData {
	private Map<String, String> markovTable = new HashMap<String,String>();
	private List<String> textwords = new ArrayList<String>();
	
	/** Add words to String */
	public void read(String text) {
		List<String> newWords = Arrays.asList(text.split(" "));
		this.textwords.addAll(newWords);
	}
	
	/** define key for new Words */
	public boolean renforceWord(String keyString, String wordToLearn) {
		String value;
		boolean isNewKey = containsKeyWord(keyString);
		
		// if chain in list then add extra word
		if(isNewKey){
			value = getLearnedWord(keyString);
			value += " " + wordToLearn;
			learnWord(keyString, value);
		}
		return isNewKey;
	}
	
	/** Get table of Markov */
	String getLearnedWord(String keyString) {
		return this.markovTable.get(keyString);
	}
	
	/** Return key of table of Markov */
	boolean containsKeyWord(String keyString) {
		return this.markovTable.containsKey(keyString);
	}
	
	/** Set table of Markov */
	public void learnWord(String keyString, String learnWord) {
		this.markovTable.put(keyString, learnWord);
	}
	
	/** Get keywords */
	public String getKeyWord(int k) {
		return this.textwords.get(k);
	}

	/** Get size of textwords */
	public int keyWordSize() {
		return this.textwords.size();
	}
}