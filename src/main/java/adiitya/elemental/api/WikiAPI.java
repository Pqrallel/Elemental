package adiitya.elemental.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import sx.blah.discord.handle.obj.IChannel;

public class WikiAPI {

	static JsonParser parser = new JsonParser();
	
	public static String requestPageId(String title, IChannel c) throws Exception {

		WikiBuilder b = new WikiBuilder();

		URL url = b.addModule(b.ACTION_QUERY).addModule(b.FORMAT_JSON).addModule(b.new Module("titles", title))
				.buildURL();
		
		HttpURLConnection con = getConnection(url);

		JsonObject o = parser.parse(new InputStreamReader(con.getInputStream())).getAsJsonObject();
		
		return ("" + o.get("query").getAsJsonObject().get("pages")).split("\"")[1];
	}

	public static String requestPageUrl(String id) throws Exception {

		WikiBuilder b = new WikiBuilder();

		URL url = b.addModule(b.ACTION_QUERY).addModule(b.FORMAT_JSON).addModule(b.new Module("prop", "info"))
				.addModule(b.new Module("inprop", "url")).addModule(b.new Module("pageids", id)).buildURL();

		HttpURLConnection con = getConnection(url);
		
		JsonObject o = parser.parse(new InputStreamReader(con.getInputStream())).getAsJsonObject();
		
		return ("" + o.get("query").getAsJsonObject().get("pages").getAsJsonObject().get(id).getAsJsonObject().get("fullurl")).replaceAll("\"", "");
	}

	private static HttpURLConnection getConnection(URL url) throws Exception{
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.addRequestProperty("User-Agent", "Elemental/1.0");
		
		return con;
	}
}
