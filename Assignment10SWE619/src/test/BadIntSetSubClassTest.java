package test;

import static org.junit.Assert.*;
import intset.BadIntSet;
import intset.BadIntSetSubClass;
import intset.IntSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BadIntSetSubClassTest {

	BadIntSetSubClass a;
	BadIntSetSubClass b;
	BadIntSet parent;
	
	@Before
	public void setUp() throws Exception {
		a = new BadIntSetSubClass("a");
		b = new BadIntSetSubClass("b");
		
		parent = new BadIntSet();
		
	}

	@Test
	public void test() {
		
		//
		assertTrue(parent.equals(parent));
		
		
	}

}
