package org.raidar.app.impl;

import java.io.IOException;

public class WikipediaSearchChecker extends SearchChecker {

	private static final String SITE_BASE_PART = "https://en.wikipedia.org";
	private static final String SITE_SEARCH_PART = "w/index.php?search=";
	private static final String SITE_SEARCH_FORMAT = "%s/%s%s";

	private static final String LOG_SEARCH_BAD_WORD = "Bad word is '%s'";
	private static final String LOG_SEARCH_GOOD_WORD = "Good word is '%s'";

	private String getWordSearchURL (String word) {
		return String.format(SITE_SEARCH_FORMAT, SITE_BASE_PART, SITE_SEARCH_PART, word);
	}

	public boolean checkForBadWord (String word) throws IOException {

		logLine(String.format(LOG_SEARCH_BAD_WORD, word));

		String body = getUrlBody(getWordSearchURL(word));

		return false;
	}

	public boolean checkForGoodWord (String word) throws IOException {

		logLine(String.format(LOG_SEARCH_GOOD_WORD, word));

		String body = getUrlBody(getWordSearchURL(word));

		return false;
	}
}
