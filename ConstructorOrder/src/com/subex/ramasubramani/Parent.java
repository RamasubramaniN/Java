package com.subex.ramasubramani;

public class Parent
{
	int x = method();
	int y;

	Parent()
	{
		System.out.println( "In Parent constructor" );
	}

	private int method()
	{
		System.out.println( "In Parent method" );
		return 9;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals( Object obj )
	{
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		Parent other = ( Parent ) obj;
		if ( x != other.x )
			return false;
		if ( y != other.y )
			return false;
		return true;
	}
	
	private static int z = call();
	private static int call (){
		System.out.println("In parent static method");
		return 10;
	}
	
	static {
		System.out.println("In parent static block");
	}
}
