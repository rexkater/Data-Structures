package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import DataStructures.SLL;

public class SLLTester {
	
	SLL<Integer> list = new SLL<>();

	@Test
	public void addFirstTest() {
		
		// Tests for a positive number.
		list.addFirst(8);
		int first = list.first();
		assertEquals(8, first);
		
		// Tests for a negative number.
		list.addFirst(-8);
		first = list.first();
		int second = list.last();
		assertEquals(-8, first);
		assertEquals(8, second);
		
		// Tests for zero.
		list.addFirst(0);
		first = list.first();
		assertEquals(0, first);
		
	}
	
	SLL<Integer> list1 = new SLL<>();
	
	@Test
	public void addLastTest() {
		
		// Tests for a positive number.
		list1.addLast(1);
		int last = list1.last();
		assertEquals(1, last);
		
		// Tests for a negative number.
		list1.addLast(-1);
		last = list1.last();
		assertEquals(-1, last);
		
		// Tests for zero.
		list1.addLast(0);
		last = list1.last();
		assertEquals(0, last);
		
	}
	
	SLL<Integer> list2 = new SLL<>();
	
	@Test
	public void removeFirstTest(){
		
		list2.addFirst(8);
		int first = list2.first();
		assertEquals(8, first);

		list2.addLast(1);
		int last = list2.last();
		assertEquals(1, last);
		
		int removed = list2.removeFirst();
		assertEquals(8, removed);
		first = list2.first();
		assertEquals(1, first);
		
	}
}
