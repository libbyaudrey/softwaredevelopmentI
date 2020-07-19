
/**
 * @author libbysnedaker
 * purpose: add javadoc to word occurences project
 * July 19, 2020
 *
 */

package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class Working_TextAnalyzer {

		//variables
		static int count = 0;
		static int number = 0;
		static String words = null;
		static String printLine = "";
		
		/**
		 * this method reads the play and checks for all new word occurrences
		 * @return a printline of all the words and their occurrences
		 * @throws FileNotFoundException
		 */
		public static String getWords() throws FileNotFoundException {
			//get the file that's to be analyzed
			File thePlay = new File("macbethplay2.txt");
			//get data from the file
			Scanner input = new Scanner(thePlay);
			//create a map to map words with their frequencies
			Map<String,Integer> myMap = new HashMap<String,Integer>(); {
			//loop through the file
			while (input.hasNext()) {
				//we want to count words regardless of their case sensitivity, so we'll make it all lower case; also, replace most punctuation except for apostrophes
				words = input.next().toLowerCase().replaceAll("[. , : ; -- ? ! ]" ,  ""); 
				if (myMap.containsKey(words) == false) { //first we check out map to see if the word is it in and if it's not, we start its count at 1	
					myMap.put(words, 1);
				} else {
					count = myMap.get(words); //if the word is in the map already, we increase its count
					myMap.remove(words);
					myMap.put(words, count+1);
				}
			}
			
			//Use Set to access our map
			Set<Entry<String, Integer>> frequencies = myMap.entrySet();
		
			//we want to sort the words by frequency descending
			//we're going to create a comparator to compare frequencies to each other
			Comparator<Entry<String, Integer>> frequencyComp = new Comparator<Entry<String,Integer>>() { 
				@Override public int compare(Entry<String, Integer> frequency1, Entry<String, Integer> frequency2) { 
					Integer value1 = frequency1.getValue(); 
					Integer value2 = frequency2.getValue(); 
					return value2.compareTo(value1); 
					} 
				};

			//in order to sort them, we need to make the Set a List (array list)
			List<Map.Entry<String,Integer>> wordList = new ArrayList<Map.Entry<String,Integer>>(frequencies);
				//now we use a comparator so we can sort via the values aka our frequencies
				Collections.sort(wordList, frequencyComp);
				
				LinkedHashMap<String,Integer> frequencySorted = new LinkedHashMap<String, Integer>(wordList.size());
					for(Entry<String, Integer> frequenciesNow : wordList) {
						frequencySorted.put(frequenciesNow.getKey(),  frequenciesNow.getValue());
					}
				//print out a short header and then print the list started with the word with the highest frequency
				Set<Entry<String, Integer>> entrySortedByFrequencies = frequencySorted.entrySet();
					for(Entry<String,Integer> w : entrySortedByFrequencies) {
							//System.out.println(w.getKey()+" : " + w.getValue());
							  printLine = (printLine + (w.getKey() +" : " + w.getValue()) + "\n");
						
					}
					return printLine;
			} 
		}
	}
