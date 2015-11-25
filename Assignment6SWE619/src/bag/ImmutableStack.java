package bag;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Jenifer Cochran
 *
 */
public class ImmutableStack extends AbstractIBag
{
    public ImmutableStack()
    {
        super();
    }

    @Override
    public Object choose() throws IllegalStateException
    {
        if(super.elements.isEmpty())
        {
            throw new IllegalStateException("There are no items in the bag to choose from. It's empty.");
        }
        
        return super.elements.get(super.elements.size() - 1);
    }

    @Override
    public ImmutableStack get() throws IllegalStateException
    {
        if(super.elements.isEmpty())
        {
            throw new IllegalStateException("There are no items in the bag to get. It's empty.");
        }
        
       //make a copy of the elements
        List<Object> elementsCopy = ArrayCopyUtility.arrayCopy(super.elements);
        //remove the element 
        elementsCopy.remove(super.elements.size() - 1);
        return this.fillBag(elementsCopy);
    }

    @Override
    protected ImmutableStack getNewBag()
    {
        return  new ImmutableStack();
    }
    
    private ImmutableStack fillBag(List<Object> elements)
    {
        ImmutableStack bag = this.getNewBag();
        for(Object element: elements)
        {
            bag = (ImmutableStack) bag.put(element);
        }
        return bag;
    }
    
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        for(int index = super.elements.size() - 1; index >= 0; index--)
        {
            Object element = super.elements.get(index);
            string.append(element == null ? "<null>" : element.toString());
            if(index != 0)
            {
                string.append(", ");
            }
        }
        
        return string.toString();
    }
    
    public int hashCode()
    {
    	return this.elements.hashCode();
    }
    
    
    public boolean equals(Object o)
	{ 
    	if ((o == null) || (!(o.getClass() == this.getClass())))
    		return false;
    	
    	  ImmutableStack s = (ImmutableStack) o;
    	
    	return this.elements.equals(s.elements);  	
    } 
}
