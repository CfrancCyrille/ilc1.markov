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
	 * Permet de séparer le texte donné en paramètre en plusieurs mots
	 * @param text Le texte rentré en paramètre
	 */
	public void read(String text) {
		List<String> newWords = Arrays.asList(text.split(" "));
		this.textwords.addAll(newWords);
	}
	
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
	 * Un getter dans la Map markovtable
	 * @param keyString la clé de l'élément de la Map markovTable que l'on veut récupérer
	 * @return l'élément associé à la clé rentrée en paramètre
	 */
	String getLearnedWord(String keyString) {
		return this.markovTable.get(keyString);
	}

	/**
	 * Vérifie la présence de la clé donnée en paramètre 
	 * @param keyString
	 * @return true ou false en fonction de la présence ou non de la clé
	 */
	boolean containsKeyWord(String keyString) {
		return this.markovTable.containsKey(keyString);
	}

	/**
	 * Ajoute une nouvelle occurence clé -valeur dans la Map markovtable
	 * @param keyString la clé 
	 * @param learnWord la valeur associée
	 */
	public void learnWord(String keyString, String learnWord) {
		this.markovTable.put(keyString, learnWord);
	}
	
	/**
	 * récupère le mot du texte à l'indice souhaité
	 * @param k l'indice souhaité
	 * @return le mot à l'indice
	 */
	public String getKeyWord(int k) {
		return this.textwords.get(k);
	}

	/**
	 * Renvoie la taille du texte
	 * @return la taille du texte
	 */
	public int keyWordSize() {
		return this.textwords.size();
	}
}