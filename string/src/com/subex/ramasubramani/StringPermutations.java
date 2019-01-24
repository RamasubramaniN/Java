package com.subex.ramasubramani;

public class StringPermutations
{
	static int x = 0;

	public static void main( String[] args )
	{
		permutation( "", "abcde" );
	}

	private static void permutation( String prefix, String str )
	{
		System.out.println( ++x );
		int n = str.length();
		if ( n == 0 )
			System.out.println( prefix );
		else
		{
			for ( int i = 0; i < n; i++ )
				permutation( prefix + str.charAt( i ), str.substring( 0, i ) + str.substring( i + 1, n ) );
		}
	}
}
