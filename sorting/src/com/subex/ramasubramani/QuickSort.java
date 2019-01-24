package com.subex.ramasubramani;

public class QuickSort
{
	int a[] =
	{ 7, 8, 9, 9, 7, 6, 4, 3, 6, 7, 5 };;

	public static void main( String[] args )
	{
		QuickSort quickSort = new QuickSort();
		quickSort.sort( 0, quickSort.a.length - 1 );
		for ( int i : quickSort.a )
			System.out.println( i );
	}

	private void sort( int low, int high )
	{
		int pivot = low + ( high - low ) / 2;
		int i = low;
		int j = high;

		while ( i <= j )
		{
			while ( a[i] < a[pivot] )
			{
				i++;
			}
			while ( a[j] > a[pivot] )
			{
				j--;
			}
			if ( i <= j )
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if ( j > low )
		{
			sort( low, j );
		}
		if ( i < high )
		{
			sort( i, high );
		}
	}
}
