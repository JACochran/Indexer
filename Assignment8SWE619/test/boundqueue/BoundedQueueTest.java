package boundqueue;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BoundedQueueTest {
	BoundedQueue<String> b1;
	BoundedQueue<String> b2;
	BoundedQueue<String> bEmpty;
		
	@Before
	public void setUp() throws Exception {
		b1 = new BoundedQueue<String>(3);
		b2 = new BoundedQueue<String>(3);
		bEmpty = new BoundedQueue<String>(1);
		
		b1.put("a");
		b1.put("b");
		b1.put("c");
	}


	
	@Test
	public void testIsEmpty() {
		assertTrue(bEmpty.isEmpty());
		assertFalse(b1.isEmpty());
		
	}
	
	@Test
	public void testIsFull() {
		assertTrue(b1.isFull());
		assertFalse(bEmpty.isFull());
	}
	
	@Test
	public void testGetCount() {
		assertEquals("a",b1.get());
		
	}
	
	@Test
	public void testPutAndGetCount() {
		assertEquals(0,bEmpty.getCount());
		bEmpty.put("a");
		assertEquals(1,bEmpty.getCount());
		
		//makes sure null isn't added
		bEmpty.put(null);
		assertEquals(1,bEmpty.getCount());
		
		//b1 is now full and can't add to a full container
		assertEquals(3,b1.getCount());
		b1.put("d");
		assertEquals(3,b1.getCount());
		
	}
	
	@Test
	public void testPutAll() {
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		
		b2.putAll(l);
		
		//b2 has the same elements as b1 and they are equal.
		assertEquals(b1.toString(), b2.toString());
		
	}
	
	@Test
	public void testGetAll() {
		List<String> l = new ArrayList<String>();
		
		//puts all elements in b1 into the l. b1 will become empty
		b1.getAll(l);
		assertEquals(bEmpty.toString(), b1.toString());
		
		//l now has all of the elements that were in b1
		assertEquals("a",l.get(0));
		assertEquals("b",l.get(1));
		assertEquals("c",l.get(2));
		
		assertEquals(3, l.size());
		
		
		
	}
	
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSizeIAE() {
		BoundedQueue<String> b0 = new BoundedQueue<String>(0);
		
		
	}

}
