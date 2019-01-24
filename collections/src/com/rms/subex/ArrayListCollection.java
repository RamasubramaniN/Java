package com.rms.subex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListCollection
{
	private static ArrayListCollection arrayListCollection;
	List<Integer> integersArrayList;
	List<Integer> integerLinkedList;

	private ArrayListCollection()
	{

	}

	public void createCollectionsForIntegers()
	{
		integersArrayList = new ArrayList<Integer>();
		Integer i1 = new Integer( 9 );
		Integer i2 = new Integer( 5 );
		Integer i3 = new Integer( 7 );
		Integer i4 = new Integer( 6 );
		Integer i5 = new Integer( 5 );
		Integer i6 = new Integer( 9 );
		integersArrayList.add( i1 );
		integersArrayList.add( i2 );
		integersArrayList.add( i3 );
		integersArrayList.add( i4 );
		integersArrayList.add( i5 );
		integersArrayList.add( i6 );
	}

	public void createLinkedListForIntegers()
	{
		integerLinkedList = new LinkedList<Integer>();
		integerLinkedList.add( new Integer( 7 ) );
		integerLinkedList.add( new Integer( 9 ) );
		integerLinkedList.add( new Integer( 12 ) );
		integerLinkedList.add( new Integer( 15 ) );
		integerLinkedList.add( 2, new Integer( 18 ) );
	}

	public static ArrayListCollection getInstance()
	{
		if ( arrayListCollection == null )
			arrayListCollection = new ArrayListCollection();
		return arrayListCollection;
	}

	void printIntegerLinkedList()
	{
		System.out.println( integerLinkedList );
	}

	void printIntegersArrayList()
	{
		System.out.println( integersArrayList );
	}

}
