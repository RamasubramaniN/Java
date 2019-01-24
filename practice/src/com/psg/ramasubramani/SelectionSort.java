package com.psg.ramasubramani;

public class SelectionSort
{
	int a[] =
	{ 9, 5, 7, 8, 0, 6, 3, 1 };

	public static void main( String[] args )
	{
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort();
		for ( int i : selectionSort.a )
			System.out.println( i );
	}

	private void sort()
	{
		int n = this.a.length;
		for ( int i = 0; i < n - 1; i++ )
		{
			int index = i;
			for ( int j = i + 1; j <= n - 1; j++ )
			{
				if ( a[index] > a[j] )
					index = j;
			}
			if ( i != index )
			{
				a[i] = a[i] ^ a[index];
				a[index] = a[i] ^ a[index];
				a[i] = a[i] ^ a[index];
			}
		}
	}

}
