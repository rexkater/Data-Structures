package DataStructures;
import java.util.Stack;

import Exceptions.EmptyQueueException;
import Interfaces.Queue;

public class QueueByStacks<E> implements Queue<E> {

	private Stack<E> a = new Stack<E>();
	private Stack<E> b = new Stack<E>();
	private int size; 
	private E front;
	
	public QueueByStacks() {
		front = null; 
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E front() throws EmptyQueueException {
		return front;
	}

	// Ugly Big O' of squared n run time.
	
	@Override
	public E dequeue() throws EmptyQueueException {
		
		if (isEmpty())
			throw new EmptyQueueException("Queue is empty."); 
		
		while(!a.isEmpty())
			b.push(a.pop());
		
		E etr = b.peek();
		b.pop();
		front = b.peek();
		
		while(!b.isEmpty())
			a.push(b.pop());
		
		size--;
		return etr;
	}

	@Override
	public void enqueue(E e) {
		a.push(e);
		
		if(size == 0)
			front = a.peek();
		
		size++; 
	}

}
