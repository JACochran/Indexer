package search;

/**
 * 
 * @author Jenifer Cochran 
 * @author Erich O'Saben
 *
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import java.util.List;

public class VectorIndexerTest {
	VectorIndexer<String> v1;
	VectorIndexer<String> v2;
	
	@Before
	public void setUp() throws Exception {
		List<String> l = new ArrayList();
				
		l.add("a");
		l.add("b");
		l.add("c");
		
		v1 = new VectorIndexer(l);
		v2 = new VectorIndexer("d", "e", "f", "g");
	}

	
	@Test
	public void testElipsesConstructor(){
		//shows that the Ellipses constructor and the "list" constructor create equivalent objects
		VectorIndexer<String> v3 = new VectorIndexer("a", "b", "c");
		
		assertEquals(v1.indexOf("a"),v3.indexOf("a"));
		assertEquals(v1.indexOf("b"),v3.indexOf("b"));
		assertEquals(v1.indexOf("c"),v3.indexOf("c"));
		
		assertEquals(v1.size(),v3.size());
	}
	
	
	@Test
	public void testIndexOf(){
		//search for items in V.I.
		assertEquals(0,v1.indexOf("a"));
		assertEquals(0, v2.indexOf("d"));
		
		//search for items not in V.I.
		assertEquals(-1,v1.indexOf("d"));
		assertEquals(-1, v2.indexOf("a"));
		
	}
	
	@Test
	public void testsize(){
		assertEquals(3,v1.size());
		assertEquals(4, v2.size());
	}

	@Test
	public void testIndexOfNull() 
	{
		assertEquals(-1, v1.indexOf(null));
	}

}
