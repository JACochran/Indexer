package search;

public interface Indexer<E>
{
	/**
	 * Effects: returns the index of the first occurrence of the
	 *  specified element in the collection or -1 if this collection
	 *  does not contain the element. 
	 *  
	 *  @throws NullPointerException if the specified element is null
	 * @param element
	 * @return
	 */
    public int indexOf(E element);
    
    /**
     * Effects: returns the number of elements in this collection. 
     *
     * @return returns the number of elements in this collection.
     */
    public int size();
}
