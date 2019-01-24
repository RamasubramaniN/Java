package com.subex.ramasubramani;

public class Child extends Parent
{
	int a = childMethod();

	Child()
	{
		a = 9;
		System.out.println( "In Child constructor" );
	}

	private int childMethod()
	{
		System.out.println( "In Child method" );
		return 0;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + a;
		return result;
	}

	@Override
	public boolean equals( Object obj )
	{
		if ( this == obj )
			return true;
		if ( !super.equals( obj ) )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		Child other = ( Child ) obj;
		if ( a != other.a )
			return false;
		return true;
	}
	
	private static int x = call();
	private static int call (){
		System.out.println("In child static method");
		return 10;
	}
	
	static {
		System.out.println("In child static block");
	}
}
	