package com.subex.ramasubramani;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.StringTokenizer;

public class Strings
{

	//StringBuilder and StringBuffer are mutable, means you can edit the strings. The difference is StringBuffer is thread safe but StringBuilder is not.So overhead is there for StringBuffer. So,StringBuilder is fast.
	//String is immutable, they have done performance improvement using string pools concept,(This concept is applicable only for string literals and not for the strings which are created using new operator)assume you have a string, String a = "abc". Here, string is created using string literal. String b ="abc", this time it will not create new string.The old object will be reused since the content is same.
	//Instead 'b' is made to point to the old string object location. When we edit string 'a', it should not affect 'b'.But now,both strings are pointing to the same location.So,when we edit 'a',new string will be created and 'a' is made to point to the new string and the old string remains intact, 'b' is still pointing to this string
	//So, whenever a new string is created using string literals, (i.e.)not using new operator,jvm first look into string pools, if the string is already present in string pool,new string will not be created and the old string address will be returned. If the string is unavailable in string pool,new string will be created in string pool and this address is returned.
	//Two advantages, performance - no need to handle threading thing, because string is immutable resource. Memory optimisation - saves the new object creation by reusing existing strings.
	public static void main( String args[] )
	{
		//section1
		String a = "abc";
		System.out.println( a.hashCode() );
		String b = a;
		System.out.println( b.hashCode() );
		a = a.toUpperCase();
		System.out.println( a.hashCode() );
		System.out.println( b.hashCode() );
		;

		//section2
		String s = "abcde";
		System.out.println( s + s.hashCode() );
		s = s.toUpperCase();
		System.out.println( s + s.hashCode() );
		StringBuilder s1 = new StringBuilder( "abcde" );
		System.out.println( s1.toString() + s1.hashCode() );
		s1.append( "fgh" );
		System.out.println( s1.toString() + s1.hashCode() );
		Object obj = new Object();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		System.out.println( arr.hashCode() );
		arr.add( 1 );
		System.out.println( arr.hashCode() );
		for ( int iterator = 2; iterator <= 100; iterator++ )
			arr.add( iterator );
		System.out.println( arr.hashCode() );

		//section 4
		int i = 10;
		System.out.format( "This is c style machi : %d\n", i );
		Formatter f = new Formatter();

		//section 5
		String name = "My name is Ramasubramani";
		StringTokenizer st = new StringTokenizer( name );
		while ( st.hasMoreElements() )
			System.out.println( st.nextToken() );
		String names = "Ramu,Raju,Sankar,Bharathi";
		st = new StringTokenizer( names, "," );
		while ( st.hasMoreElements() )
			System.out.println( st.nextElement() );

		//Array section
		String t[] = new String[10];
		t[0] = "ABC";
		t[1] = "ABCD";

	}
}
