package search;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchUtilityTest {
	
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testSearch() 
	{
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testNPE() {
		SearchUtility.search(null,"a");
	}

}
