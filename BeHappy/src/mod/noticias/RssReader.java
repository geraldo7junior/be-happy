package mod.noticias;

import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RssReader {
	
	private String rssUrl;


	public RssReader(String rssUrl) {
		this.rssUrl = rssUrl;
	}

	public List<Item> getItems() throws Exception {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		NoticiasHandler handler = new NoticiasHandler();
		
		saxParser.parse(rssUrl, handler);

		return handler.getItems();
		
	}

}
