package markov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe permettant la gestion des données 
 * @author Mikrail
 *
 */
public class MarkovData {
	private Map<String, String> markovTable = new HashMap<String,String>();
	private List<String> textwords = new ArrayList<String>();

	/**
	 * Classe permettant de lire le texte que l'on a préablamement convertit en String
	 * @param text
	 */
	public void read(String text) {
		List<String> newWords = Arrays.asList(text.split(" "));
		this.textwords.addAll(newWords);
	}
	
	/**
	 * Méthode permettant de renforcer le poids d'un mot très présent
	 * @param keyString
	 * @param wordToLearn
	 * @return
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
	 * Méthode permet de renvoyer un mot appris
	 * @param keyString
	 * @return
	 */
	String getLearnedWord(String keyString) {
		return this.markovTable.get(keyString);
	}

	/**
	 * Méthode permettant d'enregistrer un mot
	 * @param keyString
	 * @return
	 */
	boolean containsKeyWord(String keyString) {
		return this.markovTable.containsKey(keyString);
	}

	/**
	 * Méthode permettant d'apprendre un mot
	 * @param keyString
	 * @param learnWord
	 */
	public void learnWord(String keyString, String learnWord) {
		this.markovTable.put(keyString, learnWord);
	}
	
	/**
	 * Méthodes permettant de renvoyer un mot
	 * @param k
	 * @return
	 */
	public String getKeyWord(int k) {
		return this.textwords.get(k);
	}

	/**
	 * Méthode permettant de renvoyer la taille d'un mot
	 * @return
	 */
	public int keyWordSize() {
		return this.textwords.size();
	}
}