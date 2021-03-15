package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {
	
	private HashTable<Integer, Integer> table;
	
	private void setup1()
	{
		table = new HashTable<>(11);
	}

	@Test
	public void testInsert()
	{
		setup1();
		assertEquals(0, table.size());
		table.insert(1, 5);
		assertEquals(1, table.size());
		assertEquals(5, table.search(1));
		table.insert(528, 9000);
		assertEquals(2, table.size());
		table.insert(237, 6000);
		assertEquals(3, table.size());
		assertEquals(true, table.insert(200, 4000));
		assertEquals(false, table.insert(200, 4000));
		
	}
	
	
	@Test
	public void testRemove()
	{
		setup1();
		table.insert(578, 60);
		assertEquals(1, table.size());
		assertEquals(false, table.remove(320));
		assertEquals(1, table.size());
		assertEquals(true, table.remove(578));
		assertEquals(0, table.size());
	}
	
	@Test
	public void testContains()
	{
		setup1();
		assertEquals(false, table.contains(528));
		table.insert(528, 20000);
		assertEquals(true, table.contains(528));
	}
	
	@Test
	public void testModify()
	{
		setup1();
		table.insert(528, 4000);
		assertEquals(4000, table.search(528));
		assertEquals(true, table.modify(528, 7000));
		assertEquals(7000, table.search(528));
		assertEquals(false, table.modify(530, 5000));
	}
	
	@Test
	public void testSearch()
	{
		setup1();
		table.insert(634, 2870);
		assertEquals(2870, table.search(634));
		assertEquals(null,table.search(528));
	}
	
	
	@Test
	public void testSize()
	{
		setup1();
		assertEquals(0, table.size());
		table.insert(528, 800);
		assertEquals(1, table.size());
		table.remove(528);
		assertEquals(0, table.size());
	}
	
	
	

}
