package com.subex.ramasubramani;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Cloning using serialisation, using byte array input output streams
public class Cloning
{
	//WeakHashMap is a special implementation of the Map interface that references its keys via weak references. 
	//This allows the garbage collector to reclaim the key even though its still referenced by the Hashmap. 
	//If the garbage collector does reclaim the key then WeakHashMap automatically cleans out the key and its associated value.

	//WeakHashMaps work best when the keys are objects which are equal only to themselves. 
	//This is the default implementation in the Object class and is sometimes called "identity equality". 
	//If the keys implement "value equality" (where the equals method compares the object's contents, not their references) 
	//then you can sometimes observe odd behaviour. In particular, if you attempt to lookup a value using a different 
	//but equal key you may find that the WeakHashMap no longer has a mapping for it. 
	//This would happen if the original key was dereferenced and garbage collected prior to your search.

	//A good example of WeakHashMap is ThreadLocal class.
	//ThreadLocal uses a WeakHashMap internally where the keys are Threads. When you call get(), 
	//the ThreadLocal class gets a reference to the current thread and looks up its value in the WeakHashMap. 
	//When the thread dies, it becomes unreachable and the WeakHashMap automatically removes its mapping.
	//If ThreadLocal used a regular HashMap, then the Threads stored in it would never become unreachable 
	//and they could hang around for a long, long time. This would essentially be a memory leak.
	public static void main( String args[] )
	{
		Child child = new Child( 100 );
		child.a = new XYZ(); //If XYZ does not implement Serializable, we will get NotSerializableException because we are trying to serialize Child which has XYZ.
		System.out.println( "Original Object:" );
		System.out.println( child.childElement );
		System.out.println( child.parentElement );
		System.out.println( child.childString );
		System.out.println( child.parentString );

		Child clonedChild = null;
		//cloning using serialisation

		ByteArrayOutputStream baos = new ByteArrayOutputStream();//They write data into a byte array, internally they maintain this 
		//byte array to store data
		ObjectOutputStream oos;
		try
		{
			oos = new ObjectOutputStream( baos ); // ObjectOutputStream takes any of the Output Stream in its constructor argument
			oos.writeObject( child );
			oos.flush();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		
		ByteArrayInputStream bais = new ByteArrayInputStream( baos.toByteArray() );
		ObjectInputStream ois;
		try
		{
			ois = new ObjectInputStream( bais );
			clonedChild = ( Child ) ois.readObject();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}

		System.out.println( "Cloned Object:" );
		System.out.println( clonedChild.childElement );
		System.out.println( clonedChild.parentElement );
		System.out.println( clonedChild.childString );
		System.out.println( clonedChild.parentString );

		System.out.println( "Hashcode of OriginalObject :" + child.a );
		System.out.println( "Hashcode of ClonedObject :" + clonedChild.a );
	}
}

@SuppressWarnings( "serial" )
class Parent implements Serializable
{
	int parentElement;
	static int i = 1;
	String parentString = "PARENT:" + i++;
	XYZ a;

	Parent( int parentElement )
	{
		this.parentElement = parentElement;
	}
}

@SuppressWarnings( "serial" )
class Child extends Parent
{
	static int j = 1;
	int childElement;
	String childString = "CHILD:" + j++;

	Child( int childElement )
	{
		super( 2 * childElement ); //required because there is no default constructor with zero parameters defined by compiler, the reason is we explicitly defined parameterised constructor
		this.childElement = childElement;//This clearly explains serialization does not use the constructor.
	}
}

class XYZ implements Serializable{
	private int a = 10;
}