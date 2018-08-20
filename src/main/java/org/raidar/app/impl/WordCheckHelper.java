package org.raidar.app.impl;

import org.raidar.app.impl.checker.WordSearchChecker;

import java.io.IOException;

/**
 * Helper for {@link WordSearchChecker}.
 */
public class WordCheckHelper {

	private static final String LOG_IOEXCEPTION = "IOException:\n%s";

	private static final String LOG_BAD_WORD_CHECKING = "Checking bad word: %s";
	private static final String LOG_GOOD_WORD_CHECKING = "Checking good word: %s";
	private static final String LOG_BAD_WORD_CHECKED = "Bad word is checked: %s";
	private static final String LOG_GOOD_WORD_CHECKED = "Good word is checked: %s";

	private static void logLine(String line) {
		System.out.println(line);
	}

	private static String BoolToStr (boolean value) {
		return (value) ? "true" : "false";
	}

	public boolean checkForBadWord (WordSearchChecker checker, String word) {

		logLine(String.format(LOG_BAD_WORD_CHECKING, word));
		try {
			boolean result = checker.checkForBadWord(word);
			logLine(String.format(LOG_BAD_WORD_CHECKED, BoolToStr(result)));

			return result;

		} catch (IOException e){
			logLine(String.format(LOG_IOEXCEPTION, e.getMessage()));

			return false;
		}
	}

	public boolean checkForGoodWord (WordSearchChecker checker, String word) {

		logLine(String.format(LOG_GOOD_WORD_CHECKING, word));
		try {
			boolean result = checker.checkForGoodWord(word);
			logLine(String.format(LOG_GOOD_WORD_CHECKED, BoolToStr(result)));

			return result;

		} catch (IOException e){
			logLine(String.format(LOG_IOEXCEPTION, e.getMessage()));

			return false;
		}
	}

}
