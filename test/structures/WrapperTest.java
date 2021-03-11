package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WrapperTest {
	
	private Wrapper<Integer> a;
	
	
	private void setup1()
	{
		a = new Wrapper<>();
	}
	
	
	@Test
	void testSetElement()
	{
		setup1();
		a.setElement(4);
		assertEquals(4, a.getElement());
	}
	
	@Test
	void testSetNext()
	{
		setup1();
		Wrapper<Integer> b = new Wrapper<>();
		b.setElement(5);
		a.setNext(b);
		assertEquals(5, a.getNext().getElement());
	}

}
