package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;
/**
 * Counts the frequencies of words in a file and generates a frequency graph
 */
public class WordFrequencyCounter {

	// ADD YOUR INSTANCE VARIABLES HERE
	private Hashtable<String, Integer> wordFreq;
	/**
	 * Constructor
	 * 
	 * @param fileName name of file from which to count word frequencies
	 */
	public WordFrequencyCounter(String fileName) {
		// FILL IN
		this.wordFreq = new Hashtable<>();
		try(Scanner in = new Scanner(new File(fileName))){
			while (in.hasNext()) {
				String temp = in.next().toLowerCase();
				temp = temp.replaceAll("\\p{Punct}","");
				if (wordFreq.containsKey(temp)) {
					wordFreq.put(temp, wordFreq.get(temp) + 1);
				}
				else {
					wordFreq.put(temp, 1);
				}
			}
			
			
		} catch(FileNotFoundException e) {
			System.out.print("File: " + fileName + " not found");
		}
	}


	/**
	 * Returns a word frequency graph based on the input file. Words are sorted
	 * based on frequency (more frequent words appear first) and then by name
	 * (lexicographically). 
	 * 
	 * Convert all words into lower case for the analysis and graph generation.
	 * 
	 * @return a word frequency graph based on the input file
	 */
	public String getFrequencyGraph() {		
        StringBuilder sb = new StringBuilder();		
		List<Map.Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(wordFreq.entrySet());
		
		
		// Algorithm to sort hashtable found at:
		// https://www.javacodeexamples.com/sort-hashtable-by-values-in-java-example/3169
		
	    list.sort((a, b) -> {
	    	int freq = b.getValue().compareTo(a.getValue());
	        if (freq != 0) {
	        	return freq;
	        } else {
	            return a.getKey().compareTo(b.getKey());
	        }
	        });
		
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append(": ");
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
		}
	
	public static void main(String[] args) {
		
	}
}