package com.subex.ramasubramani;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//addElement , get ,size methods only implemented other methods are not implemented
//Idea : have array of objects (all are 'Object' type, so in the array each slot is object,
//so you can put element of your own class instance in each slot and while accessing the element you just downcast it and use it
//Don't have array of T (i.e.) T[] objArray; because in the constructor you need to make
//this statement T[] objArray = (T[]) new Object[10] which will ClassCast exception at run time.(by RTTI)
//because you can downcast one element, but array of source list cannot be down casted
//to array of destination list, even though individual elements in the source list is of destination type,
//you need to extract each element and need to downcast it
public class MyArrayList<T> implements List<T>
{
	Object[] objArray;
	public int length;
	private int allottedSize;

	MyArrayList()
	{
		objArray = new Object[10];//Just allocate 10 references in stack, but all these references points to null objects. (i.e.) Actual object creation in heap is not yet taken place 
		length = 0;// This variable indicates how many actual objects are created in heap
		allottedSize = 10;
	}

	MyArrayList( int initialCapacity )
	{
		objArray = new Object[initialCapacity];//Just allocate 'initialCapacity' references in stack, but all these references points to null objects. (i.e.) Actual object creation in heap is not yet taken place 
		length = 0;// This variable indicates how many actual objects are created in heap
		allottedSize = initialCapacity;	}

	public void addElement( T t ) //equivalent to add method
	{
		if ( length + 1 > allottedSize )
			reallocateArray();
		objArray[length++] = t;

	}

	private void reallocateArray()
	{
		Object[] backup = objArray;
		allottedSize += 10;
		objArray = new Object[allottedSize*2];
		for ( int i = 0; i <= allottedSize - 11; i++ )
			objArray[i] = backup[i];
	}

	@Override
	public int size()
	{
		return length;
	}

	@Override
	public boolean isEmpty()
	{
		return length == 0;
	}

	@Override
	public boolean contains( Object o )
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray( T[] a )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove( Object o )
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll( Collection< ? > c )
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll( Collection< ? extends T> c )
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll( int index, Collection< ? extends T> c )
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll( Collection< ? > c )
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll( Collection< ? > c )
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public T get( int index )
	{
		T t = null;
		if ( length >= index )
			t = ( T ) objArray[index];
		return t;
	}

	@Override
	public T set( int index, T element )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add( int index, T element )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public T remove( int index )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf( Object o )
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf( Object o )
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator( int index )
	{
		return new ListIterator<T>()
		{

			@Override
			public boolean hasNext()
			{
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public T next()
			{
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasPrevious()
			{
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public T previous()
			{
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int nextIndex()
			{
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int previousIndex()
			{
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void remove()
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void set( T e )
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void add( T e )
			{
				// TODO Auto-generated method stub

			}
		};
	}

	@Override
	public List<T> subList( int fromIndex, int toIndex )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add( T e )
	{
		// TODO Auto-generated method stub
		return false;
	}
}
