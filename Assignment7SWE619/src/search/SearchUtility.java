package search;

public class SearchUtility
{
    private SearchUtility()
    {
        
    }
    
    public static <T> int search(Indexer<T> collection, T x)
    {
        //returns the index of x if x is in the collection
        //how big is it
        //get operation at a particular location
        
        if(collection == null)
        {
            throw new NullPointerException("The collection cannot be null.");
        }
        
        return collection.indexOf(x);
    }
}
