package markov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe Data
 * @author Sevrin
 */
public class MarkovData {
	private Map<String, String> markovTable = new HashMap<String,String>();
	private List<String> textwords = new ArrayList<String>();
        /**
         * Read text and split each word
         * @param text text path 
         */
	public void read(String text) {
		List<String> newWords = Arrays.asList(text.split(" "));
		this.textwords.addAll(newWords);
	}
	/**
         * renforce the learning of a word 
         * @param keyString the key of the word
         * @param wordToLearn the word to learn
         * @return true if the word would be renforced
         */
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
        /**
         * Get a word learned
         * @param keyString key for the word
         * @return learned word
         */
	String getLearnedWord(String keyString) {
		return this.markovTable.get(keyString);
	}
        /**
         * checks if a word is learned
         * @param keyString key of the word
         * @return true of word is contained
         */
	boolean containsKeyWord(String keyString) {
		return this.markovTable.containsKey(keyString);
	}
        /**
         * Learn a new word
         * @param keyString key of the word
         * @param learnWord word
         */
	public void learnWord(String keyString, String learnWord) {
		this.markovTable.put(keyString, learnWord);
	}
	/**
         * get key y index
         * @param k index of the key
         * @return word
         */
	public String getKeyWord(int k) {
		return this.textwords.get(k);
	}
        /**
         * get the size of the array containing the keys
         * @return size of array
         */
	public int keyWordSize() {
		return this.textwords.size();
	}
}