package search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class VectorIndexerTest {
	VectorIndexer<String> v1;
	
	@Before
	public void setUp() throws Exception {
		List<String> l = new ArrayList();

		v1 = new VectorIndexer(l);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	}
	

	@Test(expected=NullPointerException.class)
	public void testIndexOfNPE() {
		v1.indexOf(null);
		
	}

}
