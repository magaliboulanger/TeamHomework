 package com.solvd.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static Logger l= LogManager.getLogger(Main.class);
	public static void main(String [] args) {
		
		LinkedList list = new LinkedList();
		//using add
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		l.info("Size: "+ list.size()+", Is Empty: "+list.isEmpty());
		//using iterator
		Iterator i = list.iterator();
		l.info("items in the list:");
		while(i.hasNext()) {
			l.info(i.next().toString());
		}
		//using to array
		Object[] arr = list.toArray();
		l.info("-------------------------------------------------");
		l.info("items in array created from list:");
		for(int j=0; j<arr.length; j++) {
			l.info(arr[j].toString());
		}
		l.info("-------------------------------------------------");
		//using remove
		l.info("Remove 'a' from the list: "+ list.remove("a"));
		Iterator it = list.iterator();
		while(it.hasNext()) {
			l.info(it.next().toString());
		}
		//using to array (array)
		Object[] s =list.toArray(arr);
		l.info("items in array created from list with an array as a parameter:");
		int k = 0;
		while (s[k]!=null) {
			l.info(s[k].toString());
			k++;
		}
		l.info("-------------------------------------------------");
		
		//contains
		l.info("List contains elemen'b'?:" + list.contains("b"));
		l.info("-------------------------------------------------");
		
		//add all
		ArrayList<String> collec = new ArrayList<String>();
		collec.add("g");
		collec.add("f");
		collec.add("z");
		Iterator iter = list.iterator();
		l.info("Adding 'g', 'f', 'z' using addAll: "+list.addAll(collec));
		l.info("items in the list:");
		while(iter.hasNext()) {
			l.info(iter.next().toString());
		}
		l.info("-------------------------------------------------");
		
		//contains all
		l.info("Contains'g', 'f', 'z'?: "+list.containsAll(collec));
		collec.clear();
		collec.add("b");
		collec.add("r");
		collec.add("x");
		collec.add("e");
		l.info("Contains'b', 'r', 'x', 'e'?: "+list.containsAll(collec));
		l.info("-------------------------------------------------");
		
		//remove all
		l.info("Remove'b', 'r', 'x', 'e'?: "+list.removeAll(collec));
		iter = list.iterator();
		l.info("items in the list:");
		while(iter.hasNext()) {
			l.info(iter.next().toString());
		}
		l.info("-------------------------------------------------");
		
		//retains all
		collec.clear();
		collec.add("d");
		collec.add("f");
		collec.add("x");
		collec.add("z");
		l.info("Retains'd', 'f', 'x', 'z'?: "+ list.retainAll(collec));
		iter = list.iterator();
		l.info("items in the list:");
		while(iter.hasNext()) {
			l.info(iter.next().toString());
		}
		l.info("-------------------------------------------------");
		
		//get 
		l.info("Get the 2° item: "+ list.get(2));
		l.info("Get the 5° item: "+ list.get(5));
		l.info("-------------------------------------------------");
		
		//add in a pos 
		l.info("Adding 'h' in the position 3° ... ");
		list.add(3, "h");
		iter = list.iterator();
		l.info("items in the list:");
		while(iter.hasNext()) {
			l.info(iter.next().toString());
		}
		l.info("-------------------------------------------------");
		
	}
	
}
