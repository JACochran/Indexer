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

public class InstrumentedCollectionTest
{
	List<Integer> listValues;
	@Before
	public void setUp() throws Exception
	{
		this.listValues = new ArrayList<Integer>(Arrays.asList(1,2,3,4,4,5));
	}

	@Test
	public void symmetricListTest() 
	{
		InstrumentedCollection<Integer> instrList = new InstrumentedCollection<Integer>(this.listValues);
		//x.equals(y)
		assertTrue(instrList.equals(listValues));
		//y.equals(x)
		assertTrue("Equals does not meet the Symmetric part of the contract.", listValues.equals(instrList));
	}
	
	@Test
	public void symmetricSetTest()
	{
		Set<Integer> setValues = new HashSet<Integer>();
		setValues.addAll(this.listValues);
		InstrumentedCollection<Integer> instraSet = new InstrumentedCollection<Integer>(setValues);
		//x.equals(y)
		assertTrue(instraSet.equals(setValues));
		//y.equals(x)
		assertTrue("Equals does not meet the Symmetric part of the contract.", setValues.equals(instraSet));
	}
}
