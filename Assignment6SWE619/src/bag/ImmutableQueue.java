package bag;

import java.util.List;
/**
 * 
 * @author Jenifer Cochran
 *
 */
public class ImmutableQueue extends AbstractIBag
{
    public ImmutableQueue()
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
        
        return super.elements.get(0);
    }

    @Override
    public ImmutableQueue get() throws IllegalStateException
    {
        if(super.elements.isEmpty())
        {
            throw new IllegalStateException("There are no items in the bag to get. It's empty.");
        }
        
        //make a copy of the elements
        List<Object> elementsCopy = ArrayCopyUtility.arrayCopy(super.elements);
        //remove the element 
        elementsCopy.remove(0);
        
        return this.fillBag(elementsCopy);
    }
    
    @Override
    protected ImmutableQueue getNewBag()
    {
        return new ImmutableQueue();
    }
    
    private ImmutableQueue fillBag(List<Object> elements)
    {
        ImmutableQueue bag = this.getNewBag();
        for(Object element: elements)
        {
            bag = (ImmutableQueue) bag.put(element);
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
}
