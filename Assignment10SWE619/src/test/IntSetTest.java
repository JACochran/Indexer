package test;

import static org.junit.Assert.*;
import intset.IntSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntSetTest {

	IntSet a;
	IntSet b;
	
	@Before
	public void setUp() throws Exception 
	{
		a = new IntSet();
		b = new IntSet();
	}

	@Test
	public void testIntSet() throws CloneNotSupportedException
	{
		IntSet c = null;
		
		c = a.clone();
		
		//tests equals and clone
		//reflexive
		assertTrue(a.equals(a));
		
		//symmetric
		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
		
		//transitive
		assertTrue(a.equals(b));
		assertTrue(b.equals(c));
		assertTrue(a.equals(c)); //**shows that clone also works
		
		//tests hashcode
		assertTrue(a.hashCode() == b.hashCode());
	}

}
