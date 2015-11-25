package bag;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Jenifer Cochran
 *
 */
public class ArrayCopyUtility
{
    public static List<Object> arrayCopy(List<Object> source)
    {
        List<Object> items = new ArrayList<Object>();
        
        for(Object item: source)
        {
            items.add(item);
        }
        
        return items;
    }
}
