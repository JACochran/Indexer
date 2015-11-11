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
	public void test() throws CloneNotSupportedException {
		
		BadIntSet c = new BadIntSetSubClass("c");
		BadIntSet d = c.clone();
		
		//cloned object and original object are not the exact same
		assertTrue(c != d);
		//Breaks the clone contract, they are not the same type of object
		assertFalse(c.getClass() == d.getClass());
		//Breaks the clone contract, the cloned object is not equal to the original
		assertFalse(c.equals(d));
		
		
	}

}
