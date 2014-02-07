package mod.noticias;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class NoticiasHandler extends DefaultHandler {

	private List<Item> rssItems;
	private Item currentItem;	
	private boolean parsingTitle;
	private StringBuffer currentTitleSb;
	

	private boolean parsingLink;
	
	public NoticiasHandler() {
		rssItems = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return rssItems;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("item".equals(qName)) {
			currentItem = new Item();
		} else if ("title".equals(qName)) {
			parsingTitle = true;
			
			currentTitleSb = new StringBuffer();
		} else if ("link".equals(qName)) {
			parsingLink = true;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("item".equals(qName)) {
			rssItems.add(currentItem);
			currentItem = null;
		} else if ("title".equals(qName)) {
			
			parsingTitle = false;
			
	
			if (currentItem != null) {
				
				currentItem.setTitle(currentTitleSb.toString());
			}
			
		} else if ("link".equals(qName)) {
			parsingLink = false;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (parsingTitle) {
			if (currentItem != null) {
				
				currentTitleSb.append(new String(ch, start, length));
			}
		} else if (parsingLink) {
			if (currentItem != null) {
				currentItem.setLink(new String(ch, start, length));
				parsingLink = false;
			}
		}
	}
	
}
