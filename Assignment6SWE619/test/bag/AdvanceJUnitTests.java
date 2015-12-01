package bag;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

@RunWith(Theories.class)
public class AdvanceJUnitTests 
{
	public  static <T> ImmutableBag fillBagPublic(List<T> elements)
    {
        ImmutableBag bag = new ImmutableBag();
        for(T element: elements)
        {
            bag = (ImmutableBag) bag.put(element);
        }
        return bag;
    }
	
	public static <T> ImmutableStack fillStackPublic(List<T> elements)
    {
        ImmutableStack bag = new ImmutableStack();
        for( T element: elements)
        {
            bag = (ImmutableStack) bag.put(element);
        }
        return bag;
    }
	
	public static <T> ImmutableQueue fillQueuePublic(List<T> elements)
    {
        ImmutableQueue bag = new ImmutableQueue();
        for( T element: elements)
        {
            bag = (ImmutableQueue) bag.put(element);
        }
        return bag;
    }
	
	static List<Integer> fiveNumbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	static List<Integer> fourNumbers = new ArrayList<Integer>(Arrays.asList(2,3,4,5));
	static List<Integer> threeNumbers = new ArrayList<Integer>(Arrays.asList(3,4,5));
	
	public static List<ImmutableBag> bagList;// = new ImmutableBag();
	public static ImmutableBag bagOne = fillBagPublic(fiveNumbers);
	public static ImmutableBag bagTwo = fillBagPublic(fourNumbers);
	public static ImmutableBag bagThree = fillBagPublic(threeNumbers);
	public static ImmutableBag bagFour = fillBagPublic(threeNumbers);
	public static ImmutableBag bagFive = fillBagPublic(threeNumbers); 
	
	@DataPoints
	public static AbstractIBag[] bags = new AbstractIBag[]{fillBagPublic(fiveNumbers), 
			                                               fillBagPublic(fourNumbers), 
			                                               fillBagPublic(threeNumbers), 
			                                               fillBagPublic(threeNumbers), 
			                                               fillBagPublic(threeNumbers),
			                                               null, 
			                                               fillQueuePublic(fiveNumbers),
			                                               fillQueuePublic(fourNumbers),
			                                               fillQueuePublic(threeNumbers),
			                                               fillQueuePublic(threeNumbers),
			                                               fillQueuePublic(threeNumbers),
			                                               fillStackPublic(fiveNumbers),
			                                               fillStackPublic(fourNumbers),
			                                               fillStackPublic(threeNumbers),
			                                               fillStackPublic(threeNumbers),
			                                               fillStackPublic(threeNumbers)
			                                               };
	
	
	
	@Theory
	public void isEqualsSymmetric(Object a, Object b)
	{
		Assume.assumeTrue(a != null && a.equals(b));
		Assert.assertTrue(b.equals(a));
	}
	
	@Theory
	public void isEqualsReflexive(Object a)
	{
		Assume.assumeTrue(a != null);
		Assert.assertTrue(a.equals(a));
	}
	
	@Theory
	public void isEqualsTransitive(Object x, Object y, Object z)
	{
		
		Assume.assumeTrue(x != null && x.equals(y) && y.equals(z));
		Assert.assertTrue(x.equals(z));
	}
	
	@Theory
	public void hashCode(Object a, Object b)
	{
		//System.out.println(a.toString() + "\n" + b.toString() );
		Assume.assumeTrue(a != null && a.equals(b));
		
		Assert.assertTrue(a.hashCode() == b.hashCode());
	}
	
	@Theory
	public void equalsNullAlwaysFalse(Object a)
	{
		Assume.assumeTrue(a != null);
		Assert.assertFalse(a.equals(null));
	}

}
