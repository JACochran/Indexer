package search;

/**
 * 
 * @author Jenifer Cochran 
 * @author Erich O'Saben
 *
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SearchUtilityTest 
{
	VectorIndexer<String> v1;
	
	@Before
	public void setUp() throws Exception {
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		
		
		v1 = new VectorIndexer<String>(l);
	}

		
	
	@Test
	public void testSearch() 
	{
		assertEquals(0, SearchUtility.search(v1, "a"));
		assertEquals(-1, SearchUtility.search(v1, "d"));
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testColletionNPE() {
		SearchUtility.search(null,"a");
	}
	

	@Test
	public void testElementNullNotExists() {
		
		//the element being searched for is null
		assertEquals(-1, SearchUtility.search(v1,null));
	}
	
	@Test
	public void testElementNulleExists()
	{
		VectorIndexer<String> vectorWithNull = new VectorIndexer<String>("a", "b", null, "c");
		assertEquals(2, SearchUtility.search(vectorWithNull, null));
	}

}
