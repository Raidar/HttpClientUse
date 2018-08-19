package org.raidar.app;

import org.raidar.app.impl.WikipediaSearchChecker;

import java.io.IOException;

/**
 * WordChecker.
 */
public class WordChecker {

	private static final String SEARCH_BAD_WORD = "hores";
	private static final String SEARCH_GOOD_WORD = "horse";

	private static void logLine(String line) {
		System.out.println(line);
	}

	private static String BoolToStr (boolean value) {
		return (value) ? "true" : "false";
	}

	public static void main(String[] args) {
		logLine("Wikipedia word search checker.");

		WikipediaSearchChecker checker = new WikipediaSearchChecker();

		logLine("Checking bad word.");
		try {
			boolean result = checker.checkForBadWord(SEARCH_BAD_WORD);

			logLine(String.format("Word is checked: %s", BoolToStr(result)));

		} catch (IOException e){
			logLine("IOException:");
			logLine(e.getMessage());
		}

		//logLine("Checking good word.");
	}
}
