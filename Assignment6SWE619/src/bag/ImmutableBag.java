package bag;

import java.util.List;
/**
 * 
 * @author Jenifer Cochran
 *
 */
public class ImmutableBag extends AbstractIBag
{
    public ImmutableBag()
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
        
        return super.elements.get(getMiddleIndex());
    }

    @Override
    public ImmutableBag get() throws IllegalStateException
    {
        if(super.elements.isEmpty())
        {
            throw new IllegalStateException("There are no items in the bag to get. It's empty.");
        }
        //make a copy of the elements
        List<Object> elementsCopy = ArrayCopyUtility.arrayCopy(super.elements);
        //remove the item chosen from the bag
        elementsCopy.remove(getMiddleIndex());
        //return the bag minus that element chosen
        return this.fillBag(elementsCopy);
    }

    @Override
    protected ImmutableBag getNewBag()
    {
        return new ImmutableBag();
    }
    
    private int getMiddleIndex()
    {
        return super.elements.size()/2;
    }
    
    private ImmutableBag fillBag(List<Object> elements)
    {
        ImmutableBag bag = this.getNewBag();
        for(Object element: elements)
        {
            bag = (ImmutableBag) bag.put(element);
        }
        return bag;
    }
    
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        for(int index = 0; index < super.elements.size(); index++)
        {
            Object element = super.elements.get(index);
            string.append(element == null ? "<null>" : element.toString());
            if(index != super.elements.size() - 1)
            {
                string.append(", ");
            }
        }
        
        return string.toString();
    }
    
    @Override
    public int hashCode()
    {
    	int sum = 0;
    	for(Object element : this.elements)
    	{
    		sum += element.hashCode();
    	}
    	
    	return sum;
    }
    
    @Override
    public boolean equals(Object object)
    {
    	if(object == null)
    	{
    		return false;
    	}
    	
    	if(object.getClass() == this.getClass())
    	{
    		ImmutableBag bag = (ImmutableBag)object;
    		return bag.elements.containsAll(this.elements) && this.elements.containsAll(bag.elements);
    	}
    	
    	return false;
    }
}
