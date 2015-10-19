package search;

/**
 * 
 * @author Jenifer Cochran 
 * @author Erich O
 *
 */
public class SearchUtility
{
    private SearchUtility()
    {
        
    }
    /**
     * Effects: returns the index of the first occurrence of x if x is in the collection, otherwise returns -1
     * if x is not in the collection
     * 
     * @throws NullPointerException if x is null or if the collection is null
     * @param collection the collection of items to search through
     * @param x the value being searched for
     * @return returns the index of the first occurrence of x if x is in the collection, otherwise returns -1
     * if x is not in the collection
     */
    public static <T> int search(Indexer<T> collection, T x)
    {
        if(collection == null)
        {
            throw new NullPointerException("The collection cannot be null.");
        }
        
        if(x == null)
        {
        	throw new NullPointerException("x cannot be null.");
        }
        
        return collection.indexOf(x);
    }
}
