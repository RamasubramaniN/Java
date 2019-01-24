package com.subex.ramasubramani;

public class RTTISample extends Sample implements I, J
{
	public int x = 7, y = 7;

	public static void main( String args[] ) throws ClassNotFoundException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException
	{
		Class classObject = Class.forName( "com.subex.ramasubramani.RTTISample" );
		printClassInformation( classObject );
		printDetailedInfo( classObject );
		for ( Class classObj : classObject.getInterfaces() )
		{
			printClassInformation( classObj );
		}
		printClassInformation( classObject.getSuperclass() );
		RTTISample rttiSampleObject = ( RTTISample ) classObject.newInstance();
		rttiSampleObject.add();
		rttiSampleObject.multiply();

	}

	private static void printDetailedInfo( Class classObject ) throws SecurityException, NoSuchFieldException
	{
		System.out.println( classObject.getFields() );
	}

	private static void printClassInformation( Class classObject )
	{
		System.out.println( classObject + " is a Interface? : " + classObject.isInterface() );
	}

	@Override
	public void multiply()
	{
		System.out.println( x * y );
	}

	@Override
	public void add()
	{
		System.out.println( x + y );
	}
}

class Sample
{

}

interface I
{
	void add();
}

interface J
{
	void multiply();
}
