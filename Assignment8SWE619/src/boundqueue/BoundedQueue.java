package boundqueue;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * 
 * @author Jenifer Cochran
 * @author Erich O'Saben
 *
 * @param <E>
 */
public class BoundedQueue<E>
{
	private LinkedBlockingQueue<E> rep;

	/**
	 * BoundedQueue Creates a BoundedQueue with the given (fixed) capacity.
	 * 
	 * @throws IllegalArgumentException
	 *             - if size is not greater than zero
	 * @param size
	 *            the capacity of this Bounded queue
	 */
	public BoundedQueue(int size) 
	{
	    rep = new LinkedBlockingQueue<E>(size);
	}

	/**
	 * Returns true if this collection contains no elements. This implementation
	 * returns size() == 0.
	 * 
	 * @return true if there are no elements in this bounded Queue
	 */
	public boolean isEmpty()
	{
		return rep.isEmpty();
	}

	/**
	 * Returns true if the BoundedQueue has reached its capacity
	 * 
	 * @return true if the BoundedQueue has reached its capacity, false if there
	 *         is still space left to add more elements
	 */
	public boolean isFull()
	{
		return rep.remainingCapacity() == 0;
	}

	/**
	 * Returns the number of elements in the BoundedQueue
	 * 
	 * @return the number of elements in the BoundedQueue
	 */
	public int getCount()
	{
		return rep.size();
	}

	/**
	 * Adds the parameter element to this BoundedQueue if the Queue is not full
	 * and the element is not null.
	 * 
	 * @param element
	 *            element to be added to this BoundedQueue
	 */
	public void put(E element) 
	{
		if (element != null && !isFull()) 
		{
			rep.add(element);
		}
	}
	
	/**
	 * Retrieves and removes the head of this queue, or returns null if this
	 * queue is empty
	 * 
	 * @return retrieves and removes the head of this BoundedQueue, or returns
	 *         null if this is empty
	 */
	public E get()
	{
		return rep.poll();
	}

	/**
	 * Will retrieve and remove all elements from this and add them to the
	 * destination parameter.
	 * 
	 * @param destination
	 *            the collection that all the elements will be added to
	 */
	public void getAll(Collection<? super E> destination)
	{
		while(!isEmpty())
		{
			destination.add(get());
		}
	}
	
	/**
	 * Will add the elements in the parameter values to this BoundedQueue until
	 * this reaches capacity and if the element in values is not null.
	 * 
	 * @param values
	 *            the values to be added to this
	 */
	public void putAll(Iterable<? extends E> values)
	{
		for(E value: values)
		{
			put(value);
		}
	}
}
