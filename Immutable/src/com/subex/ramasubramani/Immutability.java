package com.subex.ramasubramani;

import java.util.HashSet;
import java.util.Set;

public class Immutability
{
	public static void main( String[] args )
	{
		//If an object is immutable we should not be able to change the state of the object after its creation. 
		//Setting state of the immutable object takes place only during object construction,
		//(i.e.)Theoretically object need not be final but all object's members 
		//and nested members needs to be final and non editable. 
		//Why final itself is not enough object needs to be non editable? 
		//because if some of the members are collection data type but final(ex hashmap), 
		//you can still go and edit the collection members
		A a = new A();
		//A.a =10;
		//A.b=100; Not possible both are immutable
		B b = new B();
		b.obj = new Object();//b is mutable object
	}
}

class A
{
	final int a = 5;
	final int b;
	//Compiler verifies all constructors and statements outside all methods
	//If a initialization of final is missing in both places it reports error at compile time itself
	A()
	{
		b = 10;
	}

	A( int b )
	{
		this.b = b;
	}
}

class B
{
	final int a;
	final int b;
	Object obj = new Object();

	B()
	{
		a = 100;
		b = 100;
	}
}

class C
{
	private final Set<String> s = new HashSet<String>();
	//Even though it is final we are able to edit the existing objects and can insert new entries
	//So, 'final' keyword just prevents "new operator"(or existing some other Hashmap to 's' reference being assigned to s) .
	//You cannot assign a different hashmap again.
	//To create a immutable class, create constructor with all instance variables as parameters, because all should
	//be initialised when the object is created and there should not be any setters and getters should return clone of the objects
	//to avoid object modification.
	C()
	{
		s.add( "A" );
		s.add( "B" );
		s.add( "C" );
	}

	public void someMethod()
	{
		s.add( "D" );//Possible
	}
}