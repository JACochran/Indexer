package bag;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * 
 * @author Jenifer Cochran
 *
 */
public class ArrayCopyUtilityTest
{
    @Test
    public void arrayCopyTest()
    {
        List<Object> items = new ArrayList<Object>(Arrays.asList(1,2,3,4,5,6));
        List<Object> copy = ArrayCopyUtility.arrayCopy(items);
        int count = 0;
        for(Object item: items)
        {
            assertEquals(item, copy.get(count));
            count++;
        }
    }
}
