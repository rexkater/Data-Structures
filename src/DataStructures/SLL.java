package DataStructures;

import Interfaces.SinglyLinkedList;

public class SLL<E> implements SinglyLinkedList<E> {
	
	private int listSize = 0;
	private Node<E> head = null;
	private Node<E> tail = null;
	
	public SLL(){}
	
	@Override
	public int size() {
		return listSize;
	}

	@Override
	public boolean isEmpty() {
		
		if(listSize == 0)
			return true;
		
		return false;
	}

	@Override
	public E first() {
		if(isEmpty())
			return null;
		
		return head.getElement();
	}

	@Override
	public E last() {
		if(isEmpty())
			return null;
		
		return tail.getElement();
	}

	@Override
	public void addFirst(E e) {
		Node<E> nta = new Node<E>(e, head);
		head = nta;
		
		if(isEmpty())
			tail = nta;
		
		listSize++;
	}

	@Override
	public void addLast(E e) {
		Node<E> nta = new Node<E>(e);
		
		if(isEmpty())
			head = nta;
		else
			tail.setNext(nta);
		
		tail = nta;
		listSize++;
	}

	@Override
	public E removeFirst() {
		if(isEmpty()) 
			return null;
		
		E etr = head.getElement();
		head = head.getNext();
		listSize --;
		
		if(listSize == 0)
			tail = null;
		
		return etr;
	}
	
	/**
	 * 
	 * Class created specifically to deal with node objects.
	 * 
	 * @author rexkater
	 *
	 * @param <T>
	 */
	
	private class Node<T> {

		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n){
			this.element = e;
			this.next = n;
		}

		public Node(E element) {
			this(element, null);
		}
		
		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> e){
			next = e;
		}

	}

}


