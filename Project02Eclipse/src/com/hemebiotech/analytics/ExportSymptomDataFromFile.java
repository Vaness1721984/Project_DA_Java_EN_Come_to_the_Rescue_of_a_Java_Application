package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Implements class "ExportSymptomDataFromFile" implements the Interface
 * class "ISymptomExport". It defines the following method :
 * <ul>
 * <li>exportSymptoms()</li>
 * <ul>
 * 
 * @author Vanessa DREUX
 * @version 1.0
 *
 */
public class ExportSymptomDataFromFile implements ISymptomExport {
	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ExportSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void exportSymptoms(String FileNameOut) {
		// Creation of a new instance of object CleanSymptomDataFromFile to retrieve the
		// listing of all cleaned symptoms
		CleanSymptomDataFromFile cleanData = new CleanSymptomDataFromFile(filepath);
		// Creation of "resultsout" object to write in the file
		FileWriter resultsout = null;
		try {
			// Creation of a new instance of "resultsout" object with "FileNameOut"
			// parameter
			resultsout = new FileWriter(FileNameOut);
		} catch (IOException e) {
			// Prints a stack trace for the "resultsout" object on the standard error output
			// stream
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(resultsout);
		// Creation of "key" object and using entrySet() to get the set view with format {symptom=occurrence}
		for (Object key : cleanData.cleanSymptoms().entrySet()) {
			// try statement to define block of code (between try and catch) to be tested
			// for errors
			try {
				/*
				 * Writting results in the file with specific format as defined in
				 * cleanSymptoms() method. "System.lineSeparator" method allows carriage return
				 */
				out.write(key + System.lineSeparator());
			} catch (IOException e) {
				// Prints a stack trace for the "key" object on the standard error output stream
				e.printStackTrace();
			}
		}
		// try statement to define block of code (between try and catch) to be tested
		// for errors
		try {
			// Close the stream
			out.close();
		} catch (IOException e) {
			// Prints a stack trace for the "resultsout" object on the standard error output
			// stream
			e.printStackTrace();
		}
	}
}
