package bag;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Jenifer Cochran
 *
 */
public abstract class AbstractIBag 
{
      protected List<Object> elements = new ArrayList<Object>();

      // Effects:  produce an AbstractIBag equal to this bagUnion {obj}
      public AbstractIBag put(Object obj) 
      {
         AbstractIBag newBag = getNewBag();
         newBag.elements = new ArrayList<Object>(this.elements);
         newBag.elements.add(obj);
         return newBag;
      }

      // Effects:  if this is empty throw ISE
      //           else return an arbitrary element of this
      public abstract Object choose() throws IllegalStateException;

      // Effects:  if this is empty throw ISE
      //           else produce an AbstractIBag equal to
      //           this less the element that choose() selects
      public abstract AbstractIBag get() throws IllegalStateException;

      // Effects:  Produce an empty AbstractIBag; for use by producers
      protected abstract AbstractIBag getNewBag();
}