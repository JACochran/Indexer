package search;

import java.util.List;
import java.util.Vector;

/**
 * 
 * @author Jenifer Cochran 
 * @author Erich O'Saben
 *
 * @param <T>
 */
public class VectorIndexer<T> implements Indexer<T>
{
    private Vector<T> vector;
    /**
     * Constructor
     * @param elements list of elements to add to this 
     */
    public VectorIndexer(List<T> elements)
    {
        this.vector = new Vector<T>();
        this.vector.addAll(elements);
    }
    
    /**
     * Constructor
     * @param elements elements to add to this 
     */
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
        return vector.indexOf(element);
    }

    @Override
    public int size()
    {
        return vector.size();
    }

}
