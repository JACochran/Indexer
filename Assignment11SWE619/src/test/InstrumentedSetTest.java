package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import intstrumentedCollection.InstrumentedCollection;

public class InstrumentedSetTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		List<Integer> listValues = new ArrayList<Integer>(Arrays.asList(1,2,3,4,4,5));
		Set<Integer> setValues = new HashSet<Integer>();
		setValues.addAll(listValues);
		InstrumentedCollection<Integer> instraSet = new InstrumentedCollection<Integer>(setValues);
		InstrumentedCollection<Integer> instrList = new InstrumentedCollection<Integer>(listValues);
		boolean equal2 = instraSet.equals(setValues);
		boolean reflexiveSet = setValues.equals(instraSet);
		
		boolean equal = instrList.equals(listValues);
		boolean reflexive = listValues.equals(instrList);
		fail("Not yet implemented");
	}

}
