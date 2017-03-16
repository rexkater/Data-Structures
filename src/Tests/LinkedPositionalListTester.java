package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import DataStructures.LinkedPositionalList;

public class LinkedPositionalListTester {
	
	LinkedPositionalList<Integer> a = new LinkedPositionalList<Integer>();
	LinkedPositionalList<Integer> b = new LinkedPositionalList<Integer>();
	LinkedPositionalList<Integer> c = new LinkedPositionalList<Integer>();
	
	@Test
	public void addMethodsTester() {
		
		int front, rear, mid;
		
		a.addFirst(8);
		front = a.first().getElement();
		assertEquals(front, 8);
		
		a.addBefore(a.first(), 2);
		front = a.first().getElement();
		assertEquals(front, 2);
		
		a.addAfter(a.first(), 4);
		rear = a.last().getElement();
		assertEquals(rear, 8);
		
		mid = a.after(a.first()).getElement();
		assertEquals(mid, 4);
		
		a.addLast(9);
		rear = a.last().getElement();
		assertEquals(rear, 9);
		
		mid = a.before(a.last()).getElement();
		assertEquals(mid, 8);
		
	}
	
	@Test
	public void setTester(){
		
		b.addFirst(8);
		b.addLast(7);
		b.addBefore(b.last(), 6);
		
		int front, rear, mid;
		b.set(b.first(), 3);
		front = b.first().getElement();
		assertEquals(front, 3);
		
		b.set(b.after(b.first()), 2);
		mid = b.after(b.first()).getElement();
		assertEquals(mid, 2);
		
		b.set(b.last(), 0);
		rear = b.last().getElement();
		assertEquals(rear, 0);
		
	}
	
	@Test
	public void removeTester(){
		
		c.addFirst(8);
		c.addLast(9);
		
		int front;
		c.remove(c.first());
		front = c.first().getElement();
		assertEquals(front, 9);
		assertEquals(c.size(), 1);
		
		
	}

}
