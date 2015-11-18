package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import instrumentedList.InstrumentedList;
import instrumentedMap.InstrumentedMap;
import intstrumentedCollection.InstrumentedCollection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InstrumentedListTest {
	InstrumentedList<String> a;
	InstrumentedList<String> b;
	
	List<String> l;
	@Before
	public void setUp() throws Exception {
		l = new ArrayList<String>(Arrays.asList("a","b","c","c"));
		
		a = new InstrumentedList<String>(Arrays.asList("a","b","c","c"));
		b = new InstrumentedList<String>(Arrays.asList("a","b","c","c"));
	}

	@Test
	public void testEqualsContract()
	{
		
		//Symmetry
		assertTrue(a.equals(l));
		assertTrue(l.equals(a));
		
		//Reflexive
		assertTrue(a.equals(a));
			
		//Transitive
		assertTrue(a.equals(b));
		assertTrue(b.equals(l));
		assertTrue(a.equals(l));
	}

}
