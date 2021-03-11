package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	
	private Queue<Integer> a;
	
	private void setup1()
	{
		a = new Queue<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
	}

	@Test
	void testAdd()
	{
		setup1();
		assertEquals(4, a.size());
		a.add(7);
		assertEquals(5, a.size());
	}
	
	@Test
	void testPush()
	{
		setup1();
		assertEquals(4, a.size());
		a.add(7);
		assertEquals(5, a.size());
	}
	
	@Test
	void testTop()
	{
		setup1();
		assertEquals(1, a.top());
		a.remove();
		assertEquals(2, a.top());
		a.remove();
		assertEquals(3, a.top());
		a.add(6);
		assertEquals(3, a.top());
	}
	
	@Test
	void testSize()
	{
		setup1();
		assertEquals(4, a.size());
	}
	
	@Test
	void testPop()
	{
		setup1();
		assertEquals(4, a.size());
		a.pop();
		assertEquals(3, a.size());
	}
	
	@Test
	void testRemove()
	{
		setup1();
		assertEquals(4, a.size());
		a.remove();
		assertEquals(3, a.size());
	}
	
	@Test
	void testElement()
	{
		setup1();
		assertEquals(1, a.top());
		a.remove();
		assertEquals(2, a.top());
		a.remove();
		assertEquals(3, a.top());
		a.add(6);
		assertEquals(3, a.top());
	}
}
