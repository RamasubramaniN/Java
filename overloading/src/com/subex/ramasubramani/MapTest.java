package com.subex.ramasubramani;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MapTest
{

	public static void main( String[] args )
	{
		System.out.println( "Hashmap Section" );
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put( 1, 1 );
		hashmap.put( 9, 50 );
		hashmap.put( 6, 50 );
		hashmap.put( 7, 50 );
		hashmap.put( 5, 50 );

		/*Linked hash Map : Hash table and linked list implementation of the Map interface, 
		 * with predictable iteration order. This implementation differs 
		 * from HashMap in that it maintains a doubly-linked list running through all of its entries. 
		 * This linked list defines the iteration ordering, which is normally 
		 * the order in which keys were inserted into the map (insertion-order).
		 *  Note that insertion order is not affected if a key is re-inserted into the map. 
		 *  (A key k is reinserted into a map m if m.put(k, v) is invoked when m.containsKey(k)
		 *   would return true immediately prior to the invocation.) 

		This implementation spares its clients from the unspecified, generally 
		chaotic ordering provided by HashMap (and Hashtable), without incurring the
		 increased cost associated with TreeMap. It can be used to produce a copy of a
		  map that has the same order as the original, regardless of the original map's implementation: 

		  
		This technique is particularly useful if a module takes a map on input,
		 copies it, and later returns results whose order is determined by
		  that of the copy. (Clients generally appreciate having things 
		  returned in the same order they were presented.) 
		A special constructor is provided to create a linked hash map whose 
		order of iteration is the order in which its entries were last accessed, 
		from least-recently accessed to most-recently (access-order). This kind 
		of map is well-suited to building LRU caches. Invoking the put or get method 
		results in an access to the corresponding entry (assuming it exists after the invocation completes). 
		The putAll method generates one entry access for each mapping in the specified map, 
		in the order that key-value mappings are provided by the specified map's entry set iterator.
		 No other methods generate entry accesses. In particular, operations on collection-views 
		 do not affect the order of iteration of the backing map. 

		The removeEldestEntry(Map.Entry) method may be overridden to impose a policy for removing stale mappings automatically 
		when new mappings are added to the map. 

		This class provides all of the optional Map operations, and permits null elements. Like HashMap, 
		it provides constant-time performance for the basic operations (add, contains and remove), assuming the hash function 
		disperses elements properly among the buckets. Performance is likely to be just slightly below that of HashMap, 
		due to the added expense of maintaining the linked list, with one exception: Iteration over the collection-views 
		of a LinkedHashMap requires time proportional to the size of the map, regardless of its capacity.
		Iteration over a HashMap is likely to be more expensive, requiring time proportional to its capacity. 

		A linked hash map has two parameters that affect its performance: initial capacity and load factor. 
		They are defined precisely as for HashMap. Note, however, that the penalty for choosing an excessively high value for 
		initial capacity is less severe for this class than for HashMap, as iteration times for this class are unaffected by capacity. 
		*/

		for ( Entry<Integer, Integer> s : hashmap.entrySet() )
		{
			System.out.print( s.getKey() + " " );
		}
		System.out.println();
		System.out.println( "Linked Hashmap Section" );

		LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
		linkedHashMap.put( 1, 1 );
		linkedHashMap.put( 9, 50 );
		linkedHashMap.put( 6, 50 );
		linkedHashMap.put( 7, 50 );
		linkedHashMap.put( 5, 50 );

		for ( Entry<Integer, Integer> s : linkedHashMap.entrySet() )
		{
			System.out.print( s.getKey() + " " );
		}
	}

}
