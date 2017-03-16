package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import DataStructures.QueueByStacks;

public class QueueByStacksTester {

	QueueByStacks<Integer> queue = new QueueByStacks<Integer>();

	@Test
	public void enqueueTest() {
		
		queue.enqueue(8);
		int front = queue.front();
		assertEquals(8, front);
		
		queue.enqueue(2);
		front = queue.front();
		assertNotEquals(2, front);
		assertEquals(8, front);
		
	}
	
	QueueByStacks<Integer> queue1 = new QueueByStacks<Integer>();
	
	@Test
	public void dequeueTest(){
		
		queue1.enqueue(8);
		queue1.enqueue(2);
		queue1.enqueue(5);
		
		int front = queue1.front();
		assertEquals(8, front);
		
		queue1.dequeue();
		front = queue1.front();
		assertEquals(2, front);
		
		queue1.enqueue(8);
		queue1.dequeue();
		front = queue1.front();
		assertEquals(5, front);
		
	}
	
	// The front(); method is tested implicitly within the previous tests.

}
