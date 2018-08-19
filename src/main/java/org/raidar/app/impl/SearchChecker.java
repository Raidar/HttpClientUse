package org.raidar.app.impl;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SearchChecker {

	private static final String LOG_REQUEST_LINE = "Request line:\n%s";
	private static final String LOG_RESPONSE_BODY = "Request body:\n%s";
	private static final String LOG_RESPONSE_CODE = "Request status code: %d";

	protected static void logLine(String line) {
		System.out.println(line);
	}

	public String getUrlBody (String url) throws IOException {

		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(url);
			logLine(String.format(LOG_REQUEST_LINE, request.getRequestLine().toString()));

			String body = client.execute(request, new ResponseHandlerCallback());
			logLine(String.format(LOG_RESPONSE_BODY, body));

			return body;
		}
	}

	private class ResponseHandlerCallback implements ResponseHandler<String> {

		private static final String ERROR_RESPONSE_UNEXPECTED_STATUS = "Unexpected response status: %d";

		@Override
		public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

			int code = response.getStatusLine().getStatusCode();
			logLine(String.format(LOG_RESPONSE_CODE, code));

			// TODO: Extract as method isSuccessfull of static class HTTP_STATUS_CODE.
			if ((code >= 200) && (code < 300)) {
				HttpEntity entity = response.getEntity();
				return (entity != null) ? EntityUtils.toString(entity) : null;

			} else {
				throw new ClientProtocolException(String.format(ERROR_RESPONSE_UNEXPECTED_STATUS, code));
			}

		}
	}

}
