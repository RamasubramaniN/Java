package com.subex.ramasubramani;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Cache
{
	private static LinkedHashMap<Integer, Student> leastRecentlyUsedCache = new LinkedHashMap<Integer, Student>( 100, 0.75f, true );//Last parameter here tells access order
	private static LinkedHashMap<Integer, Student> FIFOCache = new LinkedHashMap<Integer, Student>( 100, 0.75f, false );

	//Weak Hashmap :A hashtable-based Map implementation with weak keys. An entry in a WeakHashMap will automatically
	//be removed when its key is no longer in ordinary use. More precisely, the presence of a mapping for a given key
	//will not prevent the key from being discarded by the garbage collector, that is, made finalizable, finalized, 
	//and then reclaimed. When a key has been discarded its entry is effectively removed from the map, so this class 
	//behaves somewhat differently from other Map implementations. 

	//Both null values and the null key are supported. This class has performance characteristics similar to those of the 
	//HashMap class, and has the same efficiency parameters of initial capacity and load factor. 

	//Like most collection classes, this class is not synchronized. A synchronized WeakHashMap may be constructed 
	//using the Collections.synchronizedMap method. 

	//This class is intended primarily for use with key objects whose equals methods test for object identity using the == operator.
	//Once such a key is discarded it can never be recreated, so it is impossible to do a lookup of that key in a WeakHashMap
	//at some later time and be surprised that its entry has been removed. This class will work perfectly well with key objects
	//whose equals methods are not based upon object identity, such as String instances. With such recreatable key objects,
	//however, the automatic removal of WeakHashMap entries whose keys have been discarded may prove to be confusing. 

	//The behavior of the WeakHashMap class depends in part upon the actions of the garbage collector, 
	//so several familiar (though not required) Map invariants do not hold for this class. 
	//Because the garbage collector may discard keys at any time, a WeakHashMap may behave as though an unknown thread is silently
	//removing entries. In particular, even if you synchronize on a WeakHashMap instance and invoke none of its mutator methods, 
	//it is possible for the size method to return smaller values over time, for the isEmpty method to return false and then true, 
	//for the containsKey method to return true and later false for a given key, for the get method to return a value
	//for a given key but later return null, for the put method to return null and the remove method to return false for a key
	//that previously appeared to be in the map, and for successive examinations of the key set, the value collection, 
	//and the entry set to yield successively smaller numbers of elements. 

	public static void main( String[] args )
	{
		Student student1 = new Student( 1, "Vinoth" );
		Student student2 = new Student( 2, "Anand" );
		Student student3 = new Student( 3, "Bharathi" );
		Student student4 = new Student( 4, "Kanagaraj" );
		Student student5 = new Student( 5, "Vivek" );

		leastRecentlyUsedCache.put( student1.getId(), student1 );
		leastRecentlyUsedCache.put( student2.getId(), student2 );
		leastRecentlyUsedCache.put( student3.getId(), student3 );
		leastRecentlyUsedCache.put( student4.getId(), student4 );
		leastRecentlyUsedCache.put( student5.getId(), student5 );

		leastRecentlyUsedCache.get( 1 );
		leastRecentlyUsedCache.get( 3 );
		leastRecentlyUsedCache.get( 5 );

		System.out.println( "Least Recently Used Cache" );
		for ( Entry<Integer, Student> entry : leastRecentlyUsedCache.entrySet() )
		{
			System.out.println( entry.getKey() );
		}

		FIFOCache.put( student1.getId(), student1 );
		FIFOCache.put( student2.getId(), student2 );
		FIFOCache.put( student3.getId(), student3 );
		FIFOCache.put( student4.getId(), student4 );
		FIFOCache.put( student5.getId(), student5 );

		FIFOCache.get( 1 );
		FIFOCache.get( 3 );
		FIFOCache.get( 5 );

		System.out.println( "FIFO cache" );
		for ( Entry<Integer, Student> entry : FIFOCache.entrySet() )
		{
			System.out.println( entry.getKey() );
		}

		//They maintain a doubly linked list internally for entry objects(key and value pair).
		//FIFO : 
		//So, during the normal iteration where 'accessOrder' = false which is by default,
		//they traverse from front end to rear, so we get the elements in the way we inserted
		//but if you try to insert a key again it will not change the order of elements, it will just 
		//replace the value of the object with the new object for the existing key

		//LEAST RECENTLY USED (LRU) :
		//We need to use constructor with accessOrder parameter to get LRU functionality
		//'accessOrder' = true should be passed to constructor
		//So, whenever we invoke map.get(key) the corresponding entry will be fetched and
		//this doubly linked list entry is removed from its position and it is inserted at
		//the end. Because it has been used just now and it should be accessed at the last

		//How to implement MOST RECENTLY USED CACHE?
		//Create your own data structure same as above except when you call get() you have
		//to insert the element in the front so that this element will come first during iteration

		//How to implement MOST FREQUENTLY USED CACHE
		//Create your own data structure, singly linked list. Maintain one count variable in the entry
		//object to keep track of how many times this element has been accessed
	}

}

class Student
{
	int id;
	String name;

	public Student( int id, String name )
	{
		this.id = id;
		this.name = name;
	}

	public Student()
	{
		super();
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}
}
