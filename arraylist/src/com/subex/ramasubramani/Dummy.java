package com.subex.ramasubramani;

import java.util.ArrayList;

public class Dummy
{
	public static void main( String[] args )
	{
		A[] array = new A[10];// This just allocates memory in stack, it will not instantiate the individual elements of the array.
		//All stack references are pointing to null
		for ( A a : array )
			System.out.print( a + "\t" ); //all nulls
		A[] array1 = new A[]
		{ new A(), new A(), new A(), new A(), new A(), new A(), new A(), new A(), new A(), new A() };
		System.out.println();
		for ( A a : array1 )
			System.out.println( a + "\t" + a.hashCode()); //Object a's second part is not a's hashcode

		MyArrayList<A> array2 = new MyArrayList<A>();
		int i;
		for ( i = 1; i <= 20; i++ )
		{
			array2.addElement( new A() );
		}
		for ( i = 0; i <= 19; i++ )
		{
			System.out.print( array2.get( i ).i + "\t");
		}
		System.out.println();
		
		System.out.println(StringEnum.MODALBOX.toString());
	}
}

class A
{
	int i = 10;

	public A()
	{
		i = 18;
	}
}