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
public class ImmutableQueueTest
{
    
    @Test
    public void queueChooseTest()
    {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ImmutableQueue originalBag = new ImmutableQueue();
        for(Integer number: numbers)
        {
            originalBag = (ImmutableQueue) originalBag.put(number);
        }
        
        ImmutableQueue bagTwo = originalBag.get();
        ImmutableQueue bagThree = bagTwo.get();
        ImmutableQueue bagFour = bagThree.get();
        ImmutableQueue bagFive = bagFour.get();
        
        Integer one = (Integer) originalBag.choose();
        Integer two = (Integer) bagTwo.choose();
        Integer three = (Integer) bagThree.choose();
        Integer four = (Integer) bagFour.choose();
        Integer five = (Integer) bagFive.choose();
        
        assertTrue(one.equals(1));
        assertTrue(two.equals(2));
        assertTrue(three.equals(3));
        assertTrue(four.equals(4));
        assertTrue(five.equals(5));
    }
    
    @Test(expected = IllegalStateException.class)
    public void getIllegalStateException()
    {
        ImmutableQueue bag = new ImmutableQueue();
        bag.get();
    }
    
    @Test(expected = IllegalStateException.class)
    public void chooseIllegalStateException()
    {
        ImmutableQueue bag = new ImmutableQueue();
        bag.choose();
    }
    
    @Test
    public void toStringTest()
    {
        List<Integer> items = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5, null));
        ImmutableQueue bag = new ImmutableQueue();
        for(Integer item:items)
        {
            bag = (ImmutableQueue) bag.put(item);
        }
        
        String expectedString = "1, 2, 3, 4, 5, <null>";
        
        assertEquals(expectedString, bag.toString());
    }
}
