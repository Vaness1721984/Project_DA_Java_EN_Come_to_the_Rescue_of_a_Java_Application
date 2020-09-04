package com.hemebiotech.analytics;

/**
 * This class is the entry point into the application.It allows to execute the 2
 * methods "GetSymptoms()" and "exportSymptoms()". It is possible to modify in
 * this class each of the 2 arguments. In the new object "readsymptoms" there is
 * one argument that contains file "symptoms.txt" to read symptoms. In the new
 * object "exportsymptoms" there is one argument that contains file
 * "results.out.txt" to write results in it.
 * 
 * @author Vanessa DREUX
 * @version 1.0
 */

public class AnalyticsCounter {
	/**
	 * @param args Java main method accepts a single argument of type String array.
	 */
	public static void main(String args[]) {
		// first get input
		ReadSymptomDataFromFile readsymptoms = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		readsymptoms.GetSymptoms();

		// then rearrange data
		/*
		 * CleanSymptomDataFromFile cleanSymptoms = new
		 * CleanSymptomDataFromFile("Symptoms.txt"); cleansymptoms.clean();
		 */

		// next generate output
		ExportSymptomDataFromFile exportsymptoms = new ExportSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		exportsymptoms.exportSymptoms("results.out.txt");
	}
}