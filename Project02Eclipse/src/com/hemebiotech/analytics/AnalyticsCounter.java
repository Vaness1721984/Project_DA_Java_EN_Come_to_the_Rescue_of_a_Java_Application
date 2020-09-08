package com.hemebiotech.analytics;

/**
 * This class is the entry point into the application.It allows to execute the
 * method "exportSymptoms()". It is possible to modify in
 * this class each of the 2 arguments. In the new instance of object "exportsymptoms" there is
 * one argument that contains file "symptoms.txt" to read symptoms. In the new
 * method "exportsymptoms()" there is one argument that contains file
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
		// Generate output
		ExportSymptomDataFromFile exportsymptoms = new ExportSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		exportsymptoms.exportSymptoms("results.out.txt");
		System.out.println("Export généré!");
	}
}