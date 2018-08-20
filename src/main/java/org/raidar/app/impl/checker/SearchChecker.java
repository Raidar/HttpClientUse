package org.raidar.app.impl.checker;

import org.raidar.app.impl.HttpGetExecutor;

import java.io.IOException;

/**
 *  Search checker using {@link HttpGetExecutor}.
 */
public class SearchChecker {

	protected static void logLine(String line) {
		System.out.println(line);
	}

	protected String getUrlBody (String url) throws IOException {
		HttpGetExecutor executor = new HttpGetExecutor();
		return executor.getUrlBody(url);
	}

}
