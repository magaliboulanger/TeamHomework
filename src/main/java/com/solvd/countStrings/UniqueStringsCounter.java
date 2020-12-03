package com.solvd.countStrings;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.connectionpool.MyConnectionPool;


public class UniqueStringsCounter {

	private static Logger l= LogManager.getLogger(UniqueStringsCounter.class);
	public static void main(String [] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		try {
			String words = FileUtils.readFileToString(new File("src/main/resources/auxiliar.txt"), null);
			for(String s: words.split(" ")){
				if(!map.containsKey(s)) {
					map.put(s, 0);
				}
				map.put(s, map.get(s)+1);
			}
			File result=new File("src/main/resources/result.txt");
			FileUtils.writeStringToFile(result,"The number of non-repeated words in the file is: "+ map.size()+ ", and the number of occurrences of each word: "+ map.toString(), null);
			
		} catch (IOException e) {
			l.error(e);
		}
	}
}
