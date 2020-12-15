package app;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import markov.MarkovChain;

/**
 * Classe principale qui permet de lancer la chaîne de markov afin de génerer un texte à paritr d'un autre
 * Dans notre cas nous voulons générer un code à partir des Miserables de Victor Hugo
 * @author Mikrail
 *
 */
public class MarkovApp {
	/**
	 * Programme principal qui permet de générer 3 petit texte à partir du Livre de Victor Hugo
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
        String sentences = readFileAsString("./target/VictorHugo_LesMiserables-II-Cosette.txt");
        System.out.println(sentences);
        
        MarkovChain markov = new MarkovChain(3);
        markov.learn(sentences);
        
        System.out.println("Generation :\n");
        System.out.println(markov.generateMarkov(6));
        System.out.println(markov.generateMarkov(9));
        System.out.println(markov.generateMarkov(12));
	}

	/**
	 * Methode qui permet de convertir un fichier texte en une variable string
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
    public static String readFileAsString(String fileName) throws Exception { 
        String data = ""; 
        Path path = Paths.get(fileName); 
        data = Files.readString(path, StandardCharsets.UTF_8); 
        return data; 
    } 
    
}
