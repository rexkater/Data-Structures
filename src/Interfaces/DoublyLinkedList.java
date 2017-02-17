package Interfaces;

public interface DoublyLinkedList<E> {
	
	int size();
	boolean isEmpty();
	E getFirst();
	E getLast();
	void addFirst(E e);
	void addLast(E e);
	E removeFirst();
	E removeLast();

}
