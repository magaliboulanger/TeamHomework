package com.solvd.linkedlist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E>{
    private Node first;
    private Node last;
    private int n;
	
    private class Node<E>{  
        E item;  
        Node previous;  
        Node next;  

        public Node(E item) {  
            this.item = item; 
            this.next = null;
            this.previous = null;
        }

        public Node() {
        	this.item = null;
        	this.previous = null;
        	this.next = null;
        }
    }  

    private class LinkedListIterator implements Iterator<E> {
        Node node;

        
		public LinkedListIterator() {
			super();
			this.node = first.next;
		}

		@Override
		public boolean hasNext() {
			return node.next!=null;
		}

		@Override
		public E next() {
			if(!this.hasNext())
				throw new NoSuchElementException();
			E item=(E) node.item;
			node=node.next;
			return item;
		}
		
		public E previous() {
			if(!this.hasNext())
				throw new NoSuchElementException();
			E item=(E) node.item;
			node=node.previous;
			return item;
		}

    }
    
    public LinkedList() {
		this.first = new Node();
		this.last = new Node();
		first.next=last;
	    last.previous=first;
		n=0;
	}
     
 
	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n==0;
	}

	public boolean contains(Object o) {
		Node aux = first.next;
		while(aux.next!=null) {
			if(aux.item.equals(o))
				return true;
			aux = aux.next;
		}
		return false;
	}

	public Iterator iterator() {
		return new LinkedListIterator();
	}

	public E[] toArray() {
		int i=0;
		E array[] = (E[]) new Object[size()];
		Node aux = first.next;
		while (aux.next!=null) {
			array[i] = (E) aux.item ;
			i++;
			aux = aux.next;
		}
		return array;
	}

	//Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array
	public E[] toArray(Object[] a) {
		int i=0;
		if (a.length < n)
			  return (E[]) Arrays.copyOf(this.toArray(), n, a.getClass());
		System.arraycopy(this.toArray(), 0, a, 0, n);
		if (a.length > n)
			a[n] = null;
		return (E[]) a;
	}

	//Appends the specified element to the end of this list.
	public boolean add(E e) {
		Node newNode = new Node(e);
		last.previous.next = newNode;
		newNode.previous = last.previous;
		last.previous = newNode;
		newNode.next = last;
        n++;
		return true;
	}

	public boolean remove(Object o) {
		Node aux = first.next;
		while(aux.next!=null) {
			if(aux.item.equals(o)) {
				aux.previous.next = aux.next;
				aux.next.previous = aux.previous;
				return true;
			}
			aux=aux.next;
		}
		return false;
	}

	public boolean containsAll(Collection c) {
		Object [] elems = c.toArray();
		for(int i=0;i<elems.length;i++) {
			if(!this.contains(elems[i]))
				return false;
		}
		return true;
	}

	//Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
	public boolean addAll(Collection c) {
		E [] elems = (E[]) c.toArray();
		for(int i=0;i<elems.length;i++) {
			this.add(elems[i]);
		}
		return true;
	}

	public boolean removeAll(Collection c) {
		E [] elems = (E[]) c.toArray();
		for(int i=0;i<elems.length;i++) {
			this.remove(elems[i]);
		}
		return true;
	}

	public boolean retainAll(Collection c) {
		Node aux = first.next;
		while(aux.next!=null){
			if(!c.contains(aux.item))
				this.remove(aux.item);
			aux = aux.next;
		}
		return true;
	}

	//Removes all of the elements from this list.
	public void clear() {
		this.first = new Node();
		this.last = new Node();
		first.next=last;
	    last.previous=first;
		n=0;
	}
	
	public Object get(int index) {
		int i=1;
		Node aux = first.next;
		while((i<index)&&(aux.next!=null)) {
			aux = aux.next;
			i++;
		}
		if(aux.next==null)
			return null;
		return aux.item;
	}
	
	public void add(int index, E element) {
		int i=1;
		if(index>n)
			throw new IndexOutOfBoundsException();
		Node aux = first.next;
		Node newNode = new Node(element);
		while((i<index)&&(aux.next!=null)) {
			aux = aux.next;
			i++;
		}
		aux.previous.next = newNode;
		newNode.next = aux;
		newNode.previous = aux.previous;
		newNode.next = aux;
	}



}