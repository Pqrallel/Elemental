package adiitya.elemental.api;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import lombok.Getter;

public class WikiBuilder {

	private StringBuilder b = new StringBuilder("https://en.wikipedia.org/w/api.php?");

	public final Module ACTION_QUERY = new Module("action", "query");
	public final Module FORMAT_JSON = new Module("format", "json");

	public WikiBuilder addModule(Module module) {

		b.append(module.name + "=" + module.value + "&");
		return this;
	}

	public URL buildURL() throws MalformedURLException {

		return new URL(b.toString().substring(0, b.length() - 1));
	}

	public URI buildURI() throws URISyntaxException {

		return new URI(b.toString().substring(0, b.length() - 1));
	}

	class Module {

		@Getter
		private String name;
		@Getter
		private String value;

		public Module(String name, String value) {

			this.name = name;
			this.value = value;
		}
	}
}
