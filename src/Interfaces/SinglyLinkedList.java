package Interfaces;

public interface SinglyLinkedList<E> {
	
	int size();
	boolean isEmpty();
	void addFirst(E e);
	void addLast(E e);
	E removeFirst();
	E first();
	E last();

}
