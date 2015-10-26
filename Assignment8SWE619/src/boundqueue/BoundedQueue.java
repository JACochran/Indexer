package boundqueue;

import java.util.Collection;

public class BoundedQueue<E>
{
	protected E[] rep;
	protected int front = 0;
	protected int back = -1;
	protected int size = 0;
	protected int count = 0;
	
	@SuppressWarnings("unchecked")
	public BoundedQueue(int size) 
	{
		if (size > 0) 
		{
			this.size = size;
			rep = (E[]) new Object[size];
			back = size - 1;
		}
	}

	public boolean isEmpty()
	{
		return (count == 0);
	}

	public boolean isFull()
	{
		return (count == size);
	}

	public int getCount()
	{
		return count;
	}

	public void put(E e) 
	{
		if (e != null && !isFull()) 
		{
			back++;
			if (back >= size)
				back = 0;
			rep[back] = e;
			count++;
		}
	}

	public E get()
	{
		E result = null;
		if (!isEmpty()) 
		{
			result = rep[front];
			rep[front] = null;
			front++;
			if (front >= size)
				front = 0;
			count--;
		}
		return result;
	}
	
	public void getAll(Collection<? super E> destination)
	{
		while(!isEmpty())
		{
			destination.add(get());
		}
	}
	
	public void putAll(Iterable<? extends E> values)
	{
		for(E value: values)
		{
			put(value);
		}
	}
}
