package markov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkovData {
	private Map<String, String> markovTable = new HashMap<String,String>();
	private List<String> textwords = new ArrayList<String>();
        
        /**
         * Lit le text
         * @param text String 
         */
	public void read(String text) {
		List<String> newWords = Arrays.asList(text.split(" "));
		this.textwords.addAll(newWords);
	}
	/**
         * Renforce un mot
         * @param keyString String
         * @param wordToLearn String
         * @return boolean
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
         * Retourne un mot apprit
         * @param keyString String
         * @return String
         */
	String getLearnedWord(String keyString) {
		return this.markovTable.get(keyString);
	}
        /**
         * 
         * @param keyString String
         * @return boolean
         */
	boolean containsKeyWord(String keyString) {
		return this.markovTable.containsKey(keyString);
	}
        /**
         * Apprend un nouveau mot
         * @param keyString String
         * @param learnWord String
         */
	public void learnWord(String keyString, String learnWord) {
		this.markovTable.put(keyString, learnWord);
	}
	/**
         * Retourne un mots clef
         * @param k int
         * @return String
         */
	public String getKeyWord(int k) {
		return this.textwords.get(k);
	}
        /**
         * Donne la taille du texte
         * @return int 
         */
	public int keyWordSize() {
		return this.textwords.size();
	}
}