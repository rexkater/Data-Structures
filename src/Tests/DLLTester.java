package Tests;
import static org.junit.Assert.*;
import org.junit.Test;

import DataStructures.DLL;

public class DLLTester {
	
	DLL<Integer> list = new DLL<>();

	@Test
	public void addFirstTest() {
		
		list.addFirst(8);
		int first = list.getFirst();
		assertEquals(8, first);
		
		// Tests for a negative number.
		list.addFirst(-8);
		first = list.getFirst();
		int second = list.getLast();
		assertEquals(-8, first);
		assertEquals(8, second);
		
		// Tests for zero.
		list.addFirst(0);
		first = list.getFirst();
		assertEquals(0, first);
		
	}
	
	DLL<Integer> list1 = new DLL<>();
	
	@Test
	public void addLastTest() {
		
		// Tests for a positive number.
		list1.addLast(1);
		int last = list1.getLast();
		assertEquals(1, last);
		
		// Tests for a negative number.
		list1.addLast(-1);
		last = list1.getLast();
		assertEquals(-1, last);
		
		// Tests for zero.
		list1.addLast(0);
		last = list1.getLast();
		assertEquals(0, last);
		
	}
	
	DLL<Integer> list2 = new DLL<>();
	
	@Test
	public void removeFirstTest(){
		
		list2.addFirst(8);
		int first = list2.getFirst();
		assertEquals(8, first);

		list2.addLast(1);
		int last = list2.getLast();
		assertEquals(1, last);
		
		int removed = list2.removeFirst();
		assertEquals(8, removed);
		first = list2.getFirst();
		assertEquals(1, first);
		
	}
	
	DLL<Integer> list3 = new DLL<>();
	
	@Test
	public void removeLastTest(){
		
		list2.addFirst(8);
		int first = list2.getFirst();
		assertEquals(8, first);

		list2.addLast(1);
		int last = list2.getLast();
		assertEquals(1, last);
		
		int removed = list2.removeLast();
		assertEquals(1, removed);
		first = list2.getFirst();
		assertEquals(8, first);
		
	}

}
