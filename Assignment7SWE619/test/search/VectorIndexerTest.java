package search;

<<<<<<< Updated upstream
public class VectorIndexerTest 
{
=======
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

>>>>>>> Stashed changes

}
