package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Creation of Interface class named <b>ISymptomCleaner</b> that is used to
 * rearrange data. There is one method with empty bodies :
 * <ul>
 * <li>cleanSymptoms</li>
 * </ul>
 * Remark : Methods in Interface class are "public" by default so it is useless
 * to precise the "public" keyword before "Map".
 * 
 * @author Vanessa DREUX
 * @version 1.0
 */

public interface ISymptomCleaner {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a listing of Symptoms with occurrence and sorted in ascending order,
	 *         no duplicates are possible/probable
	 */
	Map<String, Integer> cleanSymptoms();
}
