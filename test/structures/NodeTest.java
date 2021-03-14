package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

	private Node<Integer, Integer> node;
	
	private void setup1()
	{
		node = new Node<Integer, Integer>(0,16);
	}

	
	@Test
	public void testGetters()
	{
		setup1();
		assertEquals(0, node.getKey());
		assertEquals(16, node.getValue());
	}
	
	@Test
	public void testSetters()
	{
		setup1();
		node.setNext(new Node<Integer, Integer>(1,24));
		assertEquals(1, node.getNext().getKey());
		assertEquals(24, node.getNext().getValue());
		
	}
	
	@Test
	public void testIsTheKey()
	{
		setup1();
		assertEquals(true, node.isTheKey(0));
	}
	
	
	@Test
	public void testCompareTo()
	{
		setup1();
		assertEquals(1, node.compareTo(-1));
		assertEquals(-1,node.compareTo(2));
		assertEquals(0, node.compareTo(0));
	}
}
