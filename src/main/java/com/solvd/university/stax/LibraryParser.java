package com.solvd.university.stax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.model.Address;
import com.solvd.university.model.Book;
import com.solvd.university.model.Library;

import jdk.internal.org.jline.utils.Log;

public class LibraryParser {

	private static Logger log = LogManager.getLogger(LibraryParser.class);
	public List<Library> getLibs() {
		Library library=null;
		List<Library> libs = new ArrayList<Library>();
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("src/main/resources/demo.xml"));
			while (eventReader.hasNext()) {
				XMLEvent nextEvent = eventReader.nextEvent();
				if (nextEvent.isStartElement()) {
					StartElement startElement = nextEvent.asStartElement();
					switch (startElement.getName().getLocalPart()) {
					case "library":
						library = new Library();
						Attribute id = startElement.getAttributeByName(new QName("id"));
						if (id != null) {
							library.setId(new Long(id.getValue()).longValue());
							log.info("id: "+new Long(id.getValue()).longValue());
						}
						break;
					case "name":
						nextEvent = eventReader.nextEvent();
						library.setName(nextEvent.asCharacters().getData());
						log.info("name: "+nextEvent.asCharacters().getData());
						break;
					case "address":
						nextEvent = eventReader.nextEvent();
						Address addr=null;
						switch (startElement.getName().getLocalPart()) {
						case "place":
							nextEvent = eventReader.nextEvent();
							addr.setAddr(nextEvent.asCharacters().getData());
							log.info("Address:");
							log.info("place: "+nextEvent.asCharacters().getData());
							break;
						case "coords":
							nextEvent = eventReader.nextEvent();
							log.info("coords: "+nextEvent.asCharacters().getData());
							break;
						}

						library.setAddress(addr);
						break;
					case "books":
						log.info("Books:");
						nextEvent = eventReader.nextEvent();
						List<Book> books = new ArrayList<Book>();
						while (!nextEvent.isEndElement()) {
							Book b=new Book();
							log.info("Book:");
							switch (startElement.getName().getLocalPart()) {
							case "title":
								nextEvent = eventReader.nextEvent();
								b.setTitle(nextEvent.asCharacters().getData());
								log.info("title: "+nextEvent.asCharacters().getData());
								break;
							case "author":
								nextEvent = eventReader.nextEvent();
								b.setAuthor(nextEvent.asCharacters().getData());
								log.info("author: "+nextEvent.asCharacters().getData());
								break;

							case "numPages":
								nextEvent = eventReader.nextEvent();
								b.setTitle(nextEvent.asCharacters().getData());
								log.info("Num. pages: "+nextEvent.asCharacters().getData());
								break;
							case "year":
								nextEvent = eventReader.nextEvent();
								b.setAuthor(nextEvent.asCharacters().getData());
								log.info("year: "+nextEvent.asCharacters().getData());
								break;}
							books.add(b);
						}
						library.setBooks(books);

					}
				}
				if (nextEvent.isEndElement()) {
					EndElement endElement = nextEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("website")) {
						libs.add(library);
					}
				}
			}

		} catch (FileNotFoundException|XMLStreamException e) {
			Log.error(e);
		}
		return libs; 
	}
}

