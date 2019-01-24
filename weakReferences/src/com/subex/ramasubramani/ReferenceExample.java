package com.subex.ramasubramani;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ReferenceExample
{
	public static void main( String[] args )
	{
		WeakHashMap<Integer, String> s = new WeakHashMap<Integer, String>();
	}

	//I am not sure I would call it a disadvantage but one must be really careful with cleaning up ThreadLocals
	//properly since whatever data you put in there stays there as long as the thread lives unless it is explicitly removed. 
	//This is especially troublesome in an environment where the threads are reused using thread pools
	//so some garbage data maybe attached to thread unless it's cleaned properly.

	//ThreadLocals are used a lot actually - mainly by framework developers as they allow attaching "context" to user methods 
	//without changing method signature. Transaction management in J2EE for example is done with ThreadLocals -
	//the reference to current open transaction is always attached to the thread so that when you work with database
	//you will automatically access it using the currently open transaction. Without ThreadLocal you would need to pass 
	//those references as method parameters.
	
	private void someMethod( Student student )
	{
		Student copy = new Student();
		//Strong reference. The memory will be reclaimed only after if the object in the heap is 
		//not reachable from any active threads and from any strong references, so until copy goes out of scope, the memory
		//will not be reclaimed by the garbage collector.
		WeakReference<Student> weakReference = new WeakReference<Student>( student, new ReferenceQueue<Student>() );
		System.out.println( weakReference.get() );//Returns the student object referenced by the weak reference
		//Weak reference is pointing to a method parameter student. So, during the garbage collection,  weak reference will not be 
		//considered, GC only looks for strong references, so, the object only pointed by weak references and not pointed by any
		//strong references will be marked for garbage collection

		//How many times have you used a Map to store extra information about objects? Use weak hashmap for this case
		//Uses : Assume we have a function called calculate serial number for each product and we maintain in a hashmap
		//object as key and serial number as value, so when this product is actually removed from the shop, this entry should 
		//be deleted from the map, because it may lead to garbage collection, alternatively, hashmap's key points to the object
		//so, it is a strong reference and the garbage collector cannot collect the actual object as well as the entry in the map
		//Instead use a weak hashmap and the keys will be WeakReferences. So, the actual object will be reclaimed if it is referenced
		//only by this weak reference, and this hashmap entry also will be reclaimed, so after sometime if you try to get the value
		//by passing key object, you may get null sometimes because the entry object itself is already reclaimed.

		//Another practical example is Thread local. Each thread has key as ThreadLocal and value as actual object(ex dbConnection Object)
		//The entry object extends WeakReference<ThreadLocal> and this entry object has Valueobject as its member variable
		//Array of entry objects are maintained.But all the entries in this array are weak references. So, when a thread dies
		//other than this array of weak references no other strong references, so this will be removed from the map to avoid 
		//memory leakage.Because in a servlet development, we may maintain threadlocal for each request, so completed requests threadlocals
		//should be cleared because it may cause memory leak because requests keep coming
		
		//In the above weak Reference declaration I have declared Reference Queue, So, when an object does not have any strong
		//references all weak references are inserted to this queue first and then garbage collection happens->finalize method is called
		//Remember the object is inserted into queue and not the weak reference. So, you can do clean up on the actual object.
		//Once this queue gets the object if you try weakReference.get() will result in null 
		
		//Soft reference is exactly same as weak reference except one thing, the object will not be garbage collected immediately
		//Instead, these objects live for a period, and only when outOfMemory Situation comes, these objects are reclaimed
		//Soft references are a way of saying to the garbage collector, "As long as memory isn't too tight, 
		//I'd like to keep this object around. But if memory gets really tight, go ahead and collect it and I'll deal with that." 
		//The garbage collector is required to clear all soft references before it can throw OutOfMemoryError.
		
		//One more reference is there panthome reference, here when a object really removed from memory , then only it is put into queue.
		
		
		//Object obj = new Object();
		//SoftReference softRef = new SoftReference(obj);
		//obj = null;

		//Please note the setting of obj to null. This is critical to proper performance of the garbage collector.
		//A problem arises if no other stack frame places a value at that location -
		//the garbage collector will still believe that an active (strong) reference to the object exists. 
	}
}

class Student
{
	private int studentId;
	private String studentName;
}