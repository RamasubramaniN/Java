package com.subex.ramasubramani;

public class MergeSortInPlace
{
	int a[] =
	{ 7, 8, 9, 9, 7, 6, 4, 3, 6, 7, 5 };

	public int[] sort()
	{
		split( 0, a.length - 1 );
		for ( int i : a )
			System.out.println( i );
		return a;
	}

	private void split( int low, int high )
	{
		if ( low < high )
		{
			int mid = ( low + high ) / 2;
			split( low, mid );
			split( mid + 1, high );
			merge( low, mid, high );
		}
	}

	private void merge( int low, int mid, int high )
	{
		int f = low;
		int s = mid + 1;

		while ( ( f <= mid ) && ( s <= high ) )
		{
			if ( a[f] < a[s] )
			{
				f++;
			}
			else
			{
				int temp = a[s];
				System.arraycopy( a, f, a, f + 1, s - f );
				a[f] = temp;
				s++;
				mid++;
				f++;
			}
		}
	}

	public static void main( String args[] )
	{
		new MergeSortInPlace().sort();
	}
}
