package com.psg.ramasubramani;

public class InsertionSort
{
	int a[] =
	{ 9, 5, 7, 8, 0, 6, 3, 1 };

	public static void main( String[] args )
	{
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort();
		for ( int i : insertionSort.a )
			System.out.println( i );
	}

	private void sort()
	{
		int n = this.a.length;
		for ( int i = 1; i <= n - 1; i++ )
		{
			for ( int k = i; k > 0; k-- )
			{
				if ( a[k] < a[k - 1] )
				{
					a[k] = a[k] ^ a[k - 1];
					a[k - 1] = a[k] ^ a[k - 1];
					a[k] = a[k] ^ a[k - 1];
				}
				else
					break;
			}
		}
	}

}
