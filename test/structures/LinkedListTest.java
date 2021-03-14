package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	private LinkedList<Integer, Integer> list;
	
	
	private void setup1()
	{
		list = new LinkedList<>();
	}
	
	private void setup2()
	{
		list = new LinkedList<>();
		list.add(0, 16);
		list.add(2, 18);
		list.add(1, 15);
	}
	
	
	@Test
	public void testAdd()
	{
		setup1();
		assertEquals(0, list.size());
		list.add(0, 16);
		assertEquals(1, list.size());
		
		list.add(2, 18);
		assertEquals(2, list.size());
		
		list.add(1, 15);
		assertEquals(3, list.size());
		
		assertEquals(0, list.getRoot().getKey());
		assertEquals(1, list.getRoot().getNext().getKey());
		assertEquals(2, list.getRoot().getNext().getNext().getKey());
		
		
	}
	
	@Test
	public void testRemove()
	{
		setup2();
		assertEquals(3, list.size());
		assertEquals(true,list.remove(0));
		assertEquals(2, list.size());
		assertEquals(false, list.remove(4));
		assertEquals(2, list.size());
	}
	
	

}
