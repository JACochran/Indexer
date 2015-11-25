package bag;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

@RunWith(Theories.class)
public class AdvanceJUnitTests 
{
	public <T> ImmutableBag fillBagPublic(List<T> elements)
    {
        ImmutableBag bag = new ImmutableBag();
        for(T element: elements)
        {
            bag = (ImmutableBag) bag.put(element);
        }
        return bag;
    }
	
	public <T> ImmutableStack fillStackPublic(List<T> elements)
    {
        ImmutableStack bag = new ImmutableStack();
        for( T element: elements)
        {
            bag = (ImmutableStack) bag.put(element);
        }
        return bag;
    }
	
	public <T> ImmutableQueue fillQueuePublic(List<T> elements)
    {
        ImmutableQueue bag = new ImmutableQueue();
        for( T element: elements)
        {
            bag = (ImmutableQueue) bag.put(element);
        }
        return bag;
    }
	
	
	
	@DataPoint
	public static List<ImmutableBag> bagList;// = new ImmutableBag();
	@DataPoint
	public static ImmutableBag bagOne;
	@DataPoint
	public static ImmutableBag bagTwo;
	@DataPoint
	public static ImmutableBag bagThree;
	@DataPoint
	public static ImmutableBag bagFour;
	@DataPoint
	public static ImmutableBag bagFive; 
	
	@Before
	public void setUp() throws Exception 
	{
		List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		
		
		 bagOne = new ImmutableBag();
		 bagTwo = new ImmutableBag();
		 bagThree = new ImmutableBag();
		 bagFour = new ImmutableBag();
		 bagFive = new ImmutableBag();
		
		//b1 == b2, b4 == b5
		bagOne = fillBagPublic(numbers);
		
		bagTwo = fillBagPublic(numbers);
		numbers.remove(0);
		
		bagThree = fillBagPublic(numbers);
		numbers.remove(0);
		
		bagFour = fillBagPublic(numbers);
		bagFive = fillBagPublic(numbers);
		
		bagList = new ArrayList<ImmutableBag>(Arrays.asList(bagOne,bagTwo,bagThree, bagFour, bagFive));
		
		//System.out.println(bagOne.hashCode() + " " + bagThree.hashCode());
		//System.out.println(bagOne.equals(bagThree));
	}
	
	
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
