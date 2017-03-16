package Interfaces;
import Exceptions.EmptyQueueException;

public interface Queue<E> {
	
	int size(); 
	boolean isEmpty(); 
	E front() throws EmptyQueueException; 
	E dequeue() throws EmptyQueueException; 
	void enqueue(E e); 
	
}
