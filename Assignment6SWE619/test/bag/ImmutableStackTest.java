package bag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import bag.ImmutableStack;
/**
 * 
 * @author Jenifer Cochran
 *
 */
public class ImmutableStackTest
{
    @Test
    public void queueChooseTest()
    {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ImmutableStack bag5 = new ImmutableStack();
        for(Integer number: numbers)
        {
            bag5 = (ImmutableStack) bag5.put(number);
        }
        
        ImmutableStack bag4 = bag5.get();
        ImmutableStack bag3 = bag4.get();
        ImmutableStack bag2 = bag3.get();
        ImmutableStack bag1 = bag2.get();
        
        Integer five = (Integer) bag5.choose();
        Integer four = (Integer) bag4.choose();
        Integer three = (Integer) bag3.choose();
        Integer two = (Integer) bag2.choose();
        Integer one = (Integer) bag1.choose();
        
        assertTrue(five.equals(5));
        assertTrue(four.equals(4));
        assertTrue(three.equals(3));
        assertTrue(two.equals(2));
        assertTrue(one.equals(1));
    }
    
    @Test(expected = IllegalStateException.class)
    public void getIllegalStateException()
    {
        new ImmutableStack().get();
    }
    
    @Test(expected = IllegalStateException.class)
    public void chooseIllegalStateException()
    {
        new ImmutableStack().choose();
    }
    
    @Test
    public void toStringTest()
    {
        List<Integer> items = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5, null));
        ImmutableStack bag = new ImmutableStack();
        for(Integer item:items)
        {
            bag = (ImmutableStack) bag.put(item);
        }
        
        String expectedString = "<null>, 5, 4, 3, 2, 1";
        
        assertEquals(expectedString, bag.toString());
    }
}
