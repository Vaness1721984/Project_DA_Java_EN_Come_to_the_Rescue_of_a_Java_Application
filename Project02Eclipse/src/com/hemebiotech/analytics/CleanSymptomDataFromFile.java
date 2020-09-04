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
	// Creation of an empty HashMap to store keys
	Map<String, Integer> hash_map = new HashMap<String, Integer>();
	// Creation of an empty TreeMap to store couples (key, occurrence) in ascending
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
		// For each loop defines hash_map keys following conditions
		for (String symptom : readData.GetSymptoms()) {
			// Condition if line doesn't contain any symptom so the key would be
			// {line,constant value = 1}
			if (!hash_map.containsKey(symptom)) {
				hash_map.put(symptom, 1);
				// Otherwise key would be {line, value increased by 1}
			} else {
				int newValue = Integer.valueOf(String.valueOf(hash_map.get(symptom)));
				newValue++;
				hash_map.put(symptom, newValue);
			}
		}
		// Creation of an "entry" object to sort symptoms in ascending order
		sorted.putAll(hash_map);
		for (Map.Entry<String, Integer> entry : sorted.entrySet())
			// Display results with a specific format {symptoms = number of occurrences}
			System.out.println(entry.getKey() + " = " + entry.getValue());
		return sorted;
	}
}
