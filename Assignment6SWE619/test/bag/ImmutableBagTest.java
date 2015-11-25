package bag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * 
 * @author Jenifer Cochran
 *
 */
public class ImmutableBagTest
{
    @Test
    public void queueChooseTest()
    {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ImmutableBag originalBag = new ImmutableBag();
        for(Integer number: numbers)
        {
            originalBag = (ImmutableBag) originalBag.put(number);
        }
        
        ImmutableBag bagTwo = originalBag.get();
        ImmutableBag bagThree = bagTwo.get();
        ImmutableBag bagFour = bagThree.get();
        ImmutableBag bagFive = bagFour.get();
        
        Integer three = (Integer) originalBag.choose();
        Integer four = (Integer) bagTwo.choose();
        Integer two = (Integer) bagThree.choose();
        Integer five = (Integer) bagFour.choose();
        Integer one = (Integer) bagFive.choose();
        
        assertEquals(new Integer(3), three);
        assertEquals(new Integer(4), four);
        assertEquals(new Integer(2), two);
        assertEquals(new Integer(5), five);
        assertEquals(new Integer(1), one);
    }
    
    @Test
    public void testChoose()
    {
        String item = "item";
        AbstractIBag bag = new ImmutableBag();
        bag = bag.put(item);
        Object itemReturned = bag.choose();
        
        assertTrue("Did not returned a string.",itemReturned instanceof String);
        assertEquals("The bag did not return the expected item",item, (String)itemReturned);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testChooseIllegalStateException()
    {
        ImmutableBag bag = new ImmutableBag();
        bag.choose();
    }
    
    @Test
    public void testGet()
    {
        List<String> items = new ArrayList<String>(Arrays.asList("one", "two", "three", "four"));
        
        AbstractIBag bag = new ImmutableBag();
        
        for(String item: items)
        {
            bag = bag.put(item);
        }
        
        String itemRemoved = (String)bag.choose();
        bag = bag.get();
        assertTrue(items.contains(itemRemoved));
    }
    
    @Test
    public void toStringTest()
    {
        List<Integer> items = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5, null));
        ImmutableBag bag = new ImmutableBag();
        for(Integer item:items)
        {
            bag = (ImmutableBag) bag.put(item);
        }
        
        String expectedString = "1, 2, 3, 4, 5, <null>";
        
        assertEquals(expectedString, bag.toString());
    }
    
    
    
}
