package search;

import java.util.List;
import java.util.Vector;

public class VectorIndexer<T> implements Indexer<T>
{
    private Vector<T> vector;
    public VectorIndexer(List<T> elements)
    {
        this.vector = new Vector<T>();
        this.vector.addAll(elements);
    }
    
    @SafeVarargs
    public VectorIndexer(T... elements)
    {
        this.vector = new Vector<T>();
        for(T element: elements)
        {
            this.vector.addElement(element);
        }
    }
    
    @Override
    public int indexOf(T element)
    {
        if(element == null)
        {
            throw new NullPointerException("Element cannot be null.");
        }
        
        return vector.indexOf(element);
    }

    @Override
    public int size()
    {
        return vector.size();
    }

}
