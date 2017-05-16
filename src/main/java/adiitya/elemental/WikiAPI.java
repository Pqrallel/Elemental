package adiitya.elemental;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.JsonParser;

import sx.blah.discord.handle.obj.IChannel;

public class WikiAPI {

	public static String requestPageId(String title, IChannel c) throws Exception {

		// url
		URI url = new URI("https://en.wikipedia.org/w/api.php?action=query&format=json&titles=" + title);
		
		// create an http client and create a response from wikipedia
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = client.execute(get);

		// create a BufferedReader from the response InputStream
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		// prepare for reading payload
		StringBuilder builder = new StringBuilder();
		String temp;

		// read payload
		while ((temp = br.readLine()) != null)
			builder.append(temp);

		// close BufferedReader
		br.close();

		// create parser
		String s = builder.toString();
		JsonParser parser = new JsonParser();

		// parse page id and return
		return ("" + parser.parse(s).getAsJsonObject().get("query").getAsJsonObject().get("pages"))
				.split("\"")[1];
	}

	public static String requestPageUrl(String id) throws Exception {

		// url
		URI url = new URI(
				"https://en.wikipedia.org/w/api.php?action=query&format=json&prop=info&inprop=url&pageids=" + id);
		
		// create an http client and create a response from wikipedia
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = client.execute(get);

		// create a BufferedReader from the response InputStream
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		
		// prepare for reading payload
		StringBuilder builder = new StringBuilder();
		String temp;
		
		// read payload
		while ((temp = br.readLine()) != null)
			builder.append(temp);
		
		// close BufferedReader
		br.close();
		
		// create parser
		String s = builder.toString();
		JsonParser parser = new JsonParser();
		
		// parse url and return
		return ("" + parser.parse(s).getAsJsonObject().get("query").getAsJsonObject().get("pages").getAsJsonObject().get(id).getAsJsonObject().get("fullurl")).replaceAll("\"", "");
	}
}
