package com.hemebiotech.analytics;

/**
 * Creation of Interface class named <b>ISymptomExport</b> that is used to
 * export data. There is one method with empty bodies :
 * <ul>
 * <li>exportSymptoms</li>
 * </ul>
 * Remark : Methods in Interface class are "public" by default so it is useless
 * to precise the "public" keyword before "void".
 * 
 * @author Vanessa DREUX
 * @version 1.0
 */
public interface ISymptomExport {
	void exportSymptoms(String FileNameOut);
}
