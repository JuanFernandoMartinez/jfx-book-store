package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	private Stack<Integer> a;
	
	private void setup1()
	{
		a = new Stack<>();
	}
	
	private void setup2()
	{
		setup1();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
	}
	
	
	@Test
	void testAdd()
	{
		setup1();
		assertEquals(0,a.size());
		a.add(1);
		assertEquals(1, a.size());
		a.add(2);
		assertEquals(2, a.size());
	}
	
	@Test
	void testRemove()
	{
		setup2();
		assertEquals(4, a.size());
		a.remove();
		assertEquals(3, a.size());
		a.remove();
		assertEquals(2, a.size());	
	}
	
	@Test
	void testPush()
	{
		setup1();
		assertEquals(0, a.size());
		a.push(1);
		assertEquals(1, a.size());
		a.push(2);
		assertEquals(2, a.size());
		assertEquals(2, a.top());
	}
	
	@Test
	void testPop()
	{
		setup2();
		assertEquals(4, a.size());
		a.pop();
		assertEquals(3, a.size());
	}
	
	@Test
	void testTop()
	{
		setup2();
		assertEquals(4, a.top());
		a.pop();
		assertEquals(3, a.top());
		a.pop();
		assertEquals(2, a.top());
		
	}
	
	@Test
	void sise()
	{
		setup2();
		assertEquals(4, a.size());
	}
	
	

}
