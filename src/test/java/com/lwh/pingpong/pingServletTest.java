package com.lwh.pingpong;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class pingServletTest {
	private final String input = "ping";

	@Test
	public void testdoGet() throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://localhost:9090/pingpong/pingServlet?string_input="
						+ input);
		CloseableHttpResponse response = client.execute(httpGet);
		String result = EntityUtils.toString(response.getEntity());

		assertEquals("pong\n", result);
	}
}
