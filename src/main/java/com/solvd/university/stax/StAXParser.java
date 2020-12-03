package com.solvd.university.stax;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.model.Library;

public class StAXParser {
	private static Logger log = LogManager.getLogger(StAXParser.class);

	public static void main (String[] args) {

		LibraryParser lp=new LibraryParser();
		List<Library> libs=lp.getLibs();
		for (Library l:libs) {
			log.info(l.toString());
		}
	}
}

