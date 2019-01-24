package com.subex.ramasubramani;

public class UnrealCloning
{
	public static void main( String[] args )
	{
		Test test = new Test();
		UnrealCloning unrealCloning1 = new UnrealCloning();
		//UnrealCloning unrealCloning2 = ( UnrealCloning ) unrealCloning1.clone(); //Clone not supported exception because it does not implement cloneable
		Test clonedTest = ( Test ) test.clone();

		System.out.println(test + "\t" + clonedTest);//both objects are different but Shallow copy.
		
		System.out.println( test.x );
		System.out.println( test.y );

		System.out.println( clonedTest.x );
		System.out.println( clonedTest.y );

		//Our implementation of clone has done only shallow copy and it has not done deep copy.
		//Object A inside both test and clonedTest objects are pointing to the same object "a" residing in heap
		//But for the primitives separate copy of primitives have been created.
		//So, you have to implement the clone for member objects ie implement clone for the web of objects whose root is Test(the class type we want to clone)
		System.out.println( test.a ); //com.subex.ramasubramani.A@42e816
		System.out.println( clonedTest.a );//com.subex.ramasubramani.A@42e816
	}
}

class Test implements Cloneable
{
	int x = 5;
	int y = 10;
	A a = new A();

	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch ( CloneNotSupportedException e )
		{
			return null;
		}
	}
}

class A
{
	int a = 100;
}