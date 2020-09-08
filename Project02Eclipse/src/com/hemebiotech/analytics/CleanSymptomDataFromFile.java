package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Implements class "CleanSymptomDataFromFile" implements the Interface
 * class "ISymptomCleaner". It defines the following method :
 * <ul>
 * <li>cleanSymptoms()</li>
 * <ul>
 * 
 * @author Vanessa DREUX
 * @version 1.0
 *
 */

public class CleanSymptomDataFromFile implements ISymptomCleaner {
	// Creation of an empty HashMap to store couples (symptom, occurrence)
	Map<String, Integer> hashMap = new HashMap<String, Integer>();
	// Creation of an empty TreeMap to store couples (symptom, occurrence) in ascending
	// order
	TreeMap<String, Integer> sorted = new TreeMap<>();

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public CleanSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public Map<String, Integer> cleanSymptoms() {
		// Creation of a new instance of object ReadSymptomDataFromFile to retrieve the
		// raw listing of all symptoms
		ReadSymptomDataFromFile readData = new ReadSymptomDataFromFile(filepath);
		// For each loop defines hash_map following conditions
		for (String symptom : readData.GetSymptoms()) {
			// Condition if line contains a new symptom so the value would be 1
			if (!hashMap.containsKey(symptom)) {
				hashMap.put(symptom, 1);
				// Otherwise value would be current value increased by 1
			} else {
				int occurrence = hashMap.get(symptom);
				occurrence++;
				hashMap.put(symptom, occurrence);
			}
		}
		// Method to copy all of the elements in "HashMap" into TreeMap "sorted" to sort symptoms in ascending order
		sorted.putAll(hashMap);
		return sorted;
	}
}
