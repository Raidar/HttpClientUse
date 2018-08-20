package org.raidar.app;

import org.raidar.app.impl.WordCheckHelper;
import org.raidar.app.impl.checker.WikipediaSearchChecker;
import org.raidar.app.impl.checker.WordSearchChecker;

/**
 * WordCheckApp.
 */
public class WordCheckApp {

	private static final String LOG_WIKIPEDIA_SEARCH = "Wikipedia word search checker.";

	private static final String SEARCH_BAD_WORD = "hores";
	private static final String SEARCH_GOOD_WORD = "horse";

	private static void logLine(String line) {
		System.out.println(line);
	}

	public static void main(String[] args) {

		logLine(LOG_WIKIPEDIA_SEARCH);
		WordCheckHelper helper = new WordCheckHelper();
		WordSearchChecker checker = new WikipediaSearchChecker();

		helper.checkForBadWord(checker, SEARCH_BAD_WORD);
		helper.checkForGoodWord(checker, SEARCH_GOOD_WORD);
	}
}
