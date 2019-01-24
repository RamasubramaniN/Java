package com.subex.ramasubramani;

public class Base
{
	static int x = 10;
	static
	{
		System.out.println( "base class:" + x );
	}
}

class Child extends Base
{
	static int y = 15;
	static
	{
		System.out.println( "child class:" + y );
	}
}
