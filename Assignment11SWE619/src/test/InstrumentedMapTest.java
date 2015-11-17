package test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import instrumentedMap.InstrumentedMap;

public class InstrumentedMapTest 
{
	Map<String, Integer> myMap;
	Map<String, Integer> myMapCopy;
	
	@Before
	public void setUp()
	{
		this.myMap = new HashMap<String, Integer>();
		this.myMap.put("Anna", 22);
		this.myMap.put("Kevin", 18);
		this.myMap.put("Steve", 32);
		this.myMap.put("Dan", 29);
		
		this.myMapCopy = new HashMap<String, Integer>();
		this.myMapCopy.putAll(this.myMap);
	}
	
	@Test
	public void symmetricTest()
	{
		InstrumentedMap<String, Integer> map = new InstrumentedMap<String, Integer>(this.myMap);
		//x.equals(y)
		assertTrue(map.equals(this.myMap));
		//y.equals(x)
		assertTrue(this.myMap.equals(map));
	}
	
	@Test
	public void transitiveTest()
	{
		InstrumentedMap<String, Integer> map = new InstrumentedMap<String, Integer>(this.myMap);
		InstrumentedMap<String, Integer> map2 = new InstrumentedMap<String, Integer>(this.myMapCopy);
		//x.equals(y)
		assertTrue(map.equals(this.myMap));
		//y.equals(z)
		assertTrue(this.myMap.equals(map2));
		//x.equals(z)
		assertTrue(map.equals(map2));
	}
	
	@Test
	public void reflexiveTest()
	{
	    InstrumentedMap<String, Integer> map = new InstrumentedMap<String, Integer>(this.myMap);
	    //x.equals(x)
		assertTrue(map.equals(map));
	}
	
	
	
}
