package org.raidar.app.impl.checker;

import java.io.IOException;

/**
 *  Search checker for Wikipedia.
 */
public class WikipediaSearchChecker extends WordSearchChecker {

	private static final String SITE_BASE_PART = "https://en.wikipedia.org";
	private static final String SITE_SEARCH_PART = "w/index.php?search=";
	private static final String SITE_SEARCH_FORMAT = "%s/%s%s";

	private static final String LOG_SEARCH_URL = "URL: %s";

	private static final String TEXT_SEARCH_BAD_WORD_TITLE = "<title>%s - Search results - Wikipedia</title>";
	private static final String TEXT_SEARCH_BAD_WORD_INDICATOR =
			"<div id=\"mw-indicator-mw-helplink\" class=\"mw-indicator\"><a href=\"/wiki/Help:Searching\"";
	private static final String TEXT_SEARCH_BAD_WORD_MAIN_HEAD =
			"<h1 id=\"firstHeading\" class=\"firstHeading\" lang=\"en\">Search results</h1>";
	private static final String TEXT_SEARCH_BAD_WORD_LIST_HEAD = "<ul class='mw-search-results'>";

	private static final String TEXT_SEARCH_GOOD_WORD_TITLE = "<title>%s - Wikipedia</title>";
	private static final String TEXT_SEARCH_GOOD_WORD_INDICATOR =
			"<div id=\"mw-indicator-good-star\" class=\"mw-indicator\"><a href=\"/wiki/Wikipedia:Good_articles\"";
	private static final String TEXT_SEARCH_GOOD_WORD_MAIN_HEAD =
			"<h1 id=\"firstHeading\" class=\"firstHeading\" lang=\"en\">%s</h1>";
	private static final String TEXT_SEARCH_GOOD_WORD_PAGE_HEAD =
			"<div id=\"siteSub\" class=\"noprint\">From Wikipedia, the free encyclopedia</div>";

	private String getWordSearchURL (String word) {
		return String.format(SITE_SEARCH_FORMAT, SITE_BASE_PART, SITE_SEARCH_PART, word);
	}

	public boolean checkForBadWord (String word) throws IOException {

		if (!super.checkForBadWord(word)) {
			return false;
		}

		String url = getWordSearchURL(word);
		logLine(String.format(LOG_SEARCH_URL, url));

		String body = getUrlBody(url);

		return body.contains(String.format(TEXT_SEARCH_BAD_WORD_TITLE, word)) &&
				body.contains(TEXT_SEARCH_BAD_WORD_INDICATOR) &&
				body.contains(TEXT_SEARCH_BAD_WORD_MAIN_HEAD) &&
				body.contains(TEXT_SEARCH_BAD_WORD_LIST_HEAD);
	}

	public boolean checkForGoodWord (String word) throws IOException {

		if (!super.checkForGoodWord(word)) {
			return false;
		}

		String url = getWordSearchURL(word);
		logLine(String.format(LOG_SEARCH_URL, url));

		String body = getUrlBody(url);

		String titleWord = word.substring(0, 1).toUpperCase() + word.substring(1);

		return body.contains(String.format(TEXT_SEARCH_GOOD_WORD_TITLE, titleWord)) &&
				body.contains(TEXT_SEARCH_GOOD_WORD_INDICATOR) &&
				body.contains(String.format(TEXT_SEARCH_GOOD_WORD_MAIN_HEAD, titleWord)) &&
				body.contains(TEXT_SEARCH_GOOD_WORD_PAGE_HEAD);
	}
}
