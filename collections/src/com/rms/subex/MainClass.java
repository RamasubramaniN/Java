package com.rms.subex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.swing.text.html.parser.Entity;

public class MainClass
{
	//String is immutable, importance:
	//Memory Optimisation using string pools
	//performance Optimisation, because in a multi-threaded environment, immutable objects are not affected
	//When we try to change the string, it always creates a new string
	@SuppressWarnings( "rawtypes" )
	public static void main( String[] args )
	{
		//Array List Section
		ArrayListCollection arrayListCollection = ArrayListCollection.getInstance();
		arrayListCollection.createCollectionsForIntegers();
		arrayListCollection.printIntegersArrayList();
		Collections.sort( arrayListCollection.integersArrayList, Collections.reverseOrder() ); //Sorting modifies the order of elements in the collection how it stored
		arrayListCollection.printIntegersArrayList();
		Collections.sort( arrayListCollection.integersArrayList );//Sorting modifies the order of elements in the collection how it stored
		arrayListCollection.printIntegersArrayList();
		//Integer Pool, the same holds for Strings also,when we create Integer 7 it refers to the old object 7 which is in the Integer pool
		//Integer and string pool are applicable if and only if we don't use new operator. 
		//String s='abc'; Integer s = 9; If you use new operator, jvm will not make use of string, integer pools,
		//it goes and create new objects in the heap.
		System.out.println( arrayListCollection.integersArrayList.contains( new Integer( 7 ) ) );
		System.out.println( arrayListCollection.integersArrayList.containsAll( Arrays.asList( 7, 9 ) ) );

		//Linked List Section
		arrayListCollection.createLinkedListForIntegers();
		arrayListCollection.printIntegerLinkedList();

		Collections.sort( arrayListCollection.integerLinkedList, Collections.reverseOrder() ); //Use this when you sort strings in reverse order in a passage, put all strings in a list and do this operation, Sorting modifies the order of elements in the collection how it stored
		arrayListCollection.printIntegerLinkedList();

		Collections.sort( arrayListCollection.integerLinkedList );//Sorting modifies the order of elements in the collection how it stored
		arrayListCollection.printIntegerLinkedList();

		//Test
		Integer s = new Integer( 9 );
		Integer t = new Integer( 9 );// No integer pool concept here, because new operator is used. JVM creates a new Integer object in heap.
		System.out.println("Shallow comparison : " + (s == t) ); //false,checks for same references,shallow comparison
		System.out.println("Deep Comparison : " +  s.equals( t ) ); //deep comparison,it should check each value in the object with the other object,but equals method needs to be implemented in the integer class in the above manner.
		//By default it executes to Object's equals method, which checks (s==t)? shallow comparison

		String s1 = new String( "rms" );
		String s2 = new String( "rms" );
		System.out.println( "Shallow comparison : " + (s1 == s2) );//false,checks for same references,shallow comparison
		System.out.println( "Deep Comparison : " +  s1.equals( s2 ) );//deep comparison,it should check the value in the object,equals method needs to be implemented in the string class in the above manner.

		Integer s3 = 7;
		Integer t3 = 7;

		System.out.println( "Integer pool has been used ? " + ( s3 == t3 ) );//true, integer pool,since integer is not created using new operator, JVM is going to reuse the old thing.
		System.out.println( "Integer pool used. " + s3.equals( t3 ) );

		String s41 = "123";
		String s42 = s41.toUpperCase();//As long as there is no change in the resulting string old string will be always returned and new string won't be created for sure
		System.out.println( "There is no change in the string object,So string class will return the same instance s41, so (s41==s42) will be " + ( s41 == s42 ) );

		String s5 = "rms";
		String t5 = "rms";
		System.out.println( s5 == t5 );//true , string pool
		System.out.println( s5.equals( t5 ) );//deep comparison, check whether both has same content, if (x1==x2) returns true then, obviously x1.equals(x2) will always return the same

		String s51 = null;
		String s52 = null;
		System.out.println( "Check whether nulls are equal : " + ( s51 == s52 ) );//true, I feel they check they do compare stack addresses for '==' operator

		//Apple section
		ArrayList<Apple> listApple = new ArrayList<Apple>();
		listApple.add( new Apple( 1, 9, 9 ) );
		listApple.add( new Apple( 2, 9, 9 ) );
		listApple.add( new Apple( 3, 9, 9 ) );
		listApple.add( new Apple( 4, 9, 9 ) );
		listApple.add( new Apple( 5, 9, 9 ) );
		for ( Apple appleInstance : listApple )
		{
			appleInstance.no += 1;
		}
		System.out.println( "Apple Instances" );
		for ( Apple appleInstance : listApple )
		{
			System.out.print( appleInstance.no + "\t" );
		}
		System.out.println();

		//Using normal iterators
		Iterator<Apple> iterator = listApple.iterator();//Ordinary iterator
		Apple appleInstance;
		System.out.println( "Printing apple instances using normal iterators" );
		while ( iterator.hasNext() )
		{
			appleInstance = iterator.next();
			System.out.print( appleInstance.no + "\t" );
		}
		System.out.println();

		//using list iterators
		ListIterator<Apple> listIterator = listApple.listIterator();
		System.out.println( "List Iterator" );
		listIterator = listApple.listIterator();
		while ( listIterator.hasNext() )
		{
			//iterator9.set(null); this can do the magic you can modify the actual objects , 
			//but you can't modify the objects using advanced for (for each) loop.
			//this you can achieve only through iterators.
			//basically when you use for each, you can edit the members of the objects but you cannot make the reference to point to some other object in heap, because you won't be getting actual stack reference
			System.out.println( listIterator.next().no );
		}
		System.out.println( listApple.size() );

		//Removing objects making some of the objects to null
		System.out.println();
		System.out.print( "List before removing elements/making references to point to some other objects " + listApple );
		System.out.println();
		listIterator = listApple.listIterator();//already end is reached, so start from the beginning again
		int i = 1;
		Apple apple;
		while ( listIterator.hasNext() )
		{
			apple = listIterator.next();
			if ( i == listApple.size() - 1 )
			{
				listIterator.set( null );//see we are setting the stack reference, this set is specific to listiterator and not to any iterators
			}
			else if ( i == listApple.size() )
			{
				listIterator.remove();//we are shortening the array, all iterators have this property
				//listIterator.previous(); this method only list iterator has. you can traverse through an list in reverse order using this
			}
			i++;
		}
		System.out.println();
		System.out.print( "List after removing elements/making references to point to some other objects " + listApple );
		System.out.println();

		//Map Section
		Map<Integer, String> simpleMap = new HashMap<Integer, String>();
		simpleMap.put( 1, "A" );
		simpleMap.put( 2, "B" );
		simpleMap.put( 4, "D" );
		simpleMap.put( 3, "C" );
		simpleMap.put( 5, "E" );
		System.out.println( "key set : " + simpleMap.keySet() );
		System.out.println( "Value set : " + simpleMap.values() );
		System.out.println( "Map contains value A? " + simpleMap.containsValue( "A" ) );
		System.out.println( "Map contains key 1? " + simpleMap.containsKey( 1 ) );
		Iterator mapIterator = simpleMap.values().iterator();
		System.out.println( "Iterating values -> Iterator" );
		while ( mapIterator.hasNext() )
		{
			System.out.print( mapIterator.next() + "\t" );
		}
		System.out.println();
		mapIterator = simpleMap.keySet().iterator();
		System.out.println( "Iterating keys -> Iterator" );
		while ( mapIterator.hasNext() )
		{
			int key = ( Integer ) mapIterator.next();
			System.out.println( "key : " + key + "   value : " + simpleMap.get( key ) );
		}
		System.out.println( "Iterating using keyset (without Iterator) : " );
		for ( Integer key : simpleMap.keySet() )
		{
			System.out.println( "key : " + key + "   value : " + simpleMap.get( key ) );
		}

		System.out.println( "Using entry set objects" );
		for ( Entry<Integer, String> entrySet : simpleMap.entrySet() )
		{
			System.out.println( "key : " + entrySet.getKey() + "   value : " + entrySet.getValue() );
		}

		//Test section
		Integer[] intArray = new Integer[10];
		System.out.println( intArray.length );

		System.out.println( "System Environment Variables:" );
		for ( Map.Entry entry : System.getenv().entrySet() )
			System.out.print( entry.getKey() + ": " + entry.getValue() + "\t" );
		System.out.println();

		int a[] =
		{ 5, 9, 'a' };
		System.out.println( "Auto convert : char to int" );
		for ( int j : a )
			System.out.print( j + "\t" );
		System.out.println();
	}
}
