package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Rule;
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
	static List<Integer> threeNumbers = new ArrayList<Integer>(Arrays.asList(3,4,5, null));
	
	
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
			                                               fillStackPublic(threeNumbers),
			                                               new ImmutableBag(),
			                                               new ImmutableQueue(),
			                                               new ImmutableStack()	
															};
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
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
		Assume.assumeTrue(a != null && a.equals(b));
		Assert.assertTrue(a.hashCode() == b.hashCode());
	}
	
	@Theory
	public void equalsNullAlwaysFalse(Object a)
	{
		Assume.assumeTrue(a != null);
		Assert.assertFalse(a.equals(null));
	}
	
	@Theory
	public void toStringTest(Object a, Object b)
	{
		Assume.assumeTrue(a != null && a.equals(b));
		Assert.assertEquals(a.toString(), b.toString());
	}
	
	@Theory
	public void getTest(AbstractIBag a, AbstractIBag b)
	{
		Assume.assumeTrue(a != null && a.size() != 0 && a.equals(b));
		Assert.assertEquals(a.get(),  b.get());
	}
	
	@Theory
	public void chooseTest(AbstractIBag a, AbstractIBag b)
	{
		Assume.assumeTrue(a != null && a.size() != 0 && a.equals(b));
		Assert.assertEquals(a.choose(),  b.choose());
	}
	
	
	@Theory
	public void throwExceptionIfArgumentIsIllegalGet(AbstractIBag a) throws Exception 
	{
		Assume.assumeTrue(a != null && a.size() == 0);
	    thrown.expect(IllegalStateException.class);
	    a.get();
	}
	
	@Theory
	public void throwExceptionIfArgumentIsIllegalChoose(AbstractIBag a) throws Exception
	{
		Assume.assumeTrue(a != null && a.size() == 0);
	    thrown.expect(IllegalStateException.class);
	    a.choose();
	}
}
