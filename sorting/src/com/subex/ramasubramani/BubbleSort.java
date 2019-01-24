package com.subex.ramasubramani;

public class BubbleSort implements Sorting
{
	int a[];

	public BubbleSort( int a[] )
	{
		this.a = a;
	}

	@Override
	public int[] sort()
	{
		for ( int i = 0; i < a.length - 1; i++ )
		{
			for ( int j = 0; j < ( a.length - 1 ) - i; j++ )
			{
				if ( a[j] > a[j + 1] )
				{
					a[j] = a[j] ^ a[j + 1];
					a[j + 1] = a[j] ^ a[j + 1];
					a[j] = a[j] ^ a[j + 1];
				}
			}
			for ( int t : a )
			{
				System.out.print( t + " " );
			}
			System.out.println( "Iteration : " + ( i + 1 ) );
		}
		return a;
	}

}
