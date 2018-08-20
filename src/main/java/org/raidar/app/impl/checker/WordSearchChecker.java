package org.raidar.app.impl.checker;

import java.io.IOException;

/**
 *  Word search checker.
 */
// TODO: Add interface.
public class WordSearchChecker extends SearchChecker {

	public boolean checkForBadWord (String word) throws IOException {
		return (word != null) && !word.isEmpty();
	}

	public boolean checkForGoodWord (String word) throws IOException {
		return (word != null) && !word.isEmpty();
	}
}
