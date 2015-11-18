package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
		//Fails because the collections can contain Sets or Lists and doesn't know the correct implementation of equals() to use (Sets or Lists)
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
		//Fails because the collections can contain Sets or Lists and doesn't know the correct implementation of equals() to use (Sets or Lists)
		assertTrue("Equals does not meet the Symmetric part of the contract.", setValues.equals(instraSet));
	}
	
	@Test
	public void TransitiveTest()
	{
		
		InstrumentedCollection<Integer> a = new InstrumentedCollection<Integer>(listValues);
		InstrumentedCollection<Integer> b = new InstrumentedCollection<Integer>(listValues);
		InstrumentedCollection<Integer> c = new InstrumentedCollection<Integer>(listValues);
		
		//These tests fail because the equals is dispatched to the list interface which will be dispatched
		//to the list equals(), and it will find that the InstrumentedCollection is not a List and return false.
		//source: https://piazza.com/class/ie4cv8rg6o91qv?cid=100
		assertTrue(a.equals(b));
		assertTrue(b.equals(c));
		assertTrue(a.equals(c));
		
	}
	
	@Test
	public void ReflexiveTest()
	{
		
		InstrumentedCollection<Integer> a = new InstrumentedCollection<Integer>(listValues);
		
		
		//These tests fail because the equals is dispatched to the list interface which will be dispatched
		//to the list equals(), and it will find that the InstrumentedCollection is not a List and return false.
		//source https://piazza.com/class/ie4cv8rg6o91qv?cid=100
		assertTrue(a.equals(a));
		
		
	}
	
}
