package com.subex.rms;

import java.util.Iterator;

public class MyDataStructure<T> implements Iterable<T>
{
	private int size;
	private int allocatedLength;
	private Object[] elements;

	MyDataStructure()
	{
		elements = new Object[10];
		size = 10;
		allocatedLength = 0;
	}

	public void add( T element )
	{
		if ( allocatedLength >= size )
			reallocateArray();
		elements[allocatedLength++] = element;

	}

	private void reallocateArray()
	{
		Object[] backupElements = new Object[size];
		elements = new Object[2 * size];
		for ( int i = 0; i <= size - 1; i++ )
			elements[i] = backupElements[i];
	}

	public int getSize()
	{
		return size;
	}

	public T get( int index )
	{
		if ( index >= allocatedLength )
			throw new ArrayIndexOutOfBoundsException();
		return ( T ) elements[index];
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			int current = allocatedLength-1;
			@Override
			public boolean hasNext()
			{
				return current >= 0;
			}

			@Override
			public T next()
			{
				return get(current--);
			}
		};
	}

	public static void main( String args[] )
	{
		Integer[] s = { 1, 2, 3, 4, 5, 6 };
		MyDataStructure<Integer> myDataStructure = new MyDataStructure<Integer>();
		for ( int i : s )
			myDataStructure.add( i );
		for ( Integer element : myDataStructure )
			System.out.println( element );
	}
}
