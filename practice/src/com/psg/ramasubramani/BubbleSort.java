package com.psg.ramasubramani;

public class BubbleSort
{
	int a[] =
	{ 9, 5, 7, 8, 0, 6, 3, 1 };

	public static void main( String[] args )
	{
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort();
		for ( int i : bubbleSort.a )
			System.out.println( i );
	}

	private void sort()
	{
		int n = this.a.length;
		for ( int i = 0; i < n - 1; i++ )
		{
			for ( int j = 0; j < n - 1; j++ )
			{
				if ( a[j] > a[j + 1] )
				{
					a[j] = a[j] ^ a[j+1];
					a[j + 1] = a[j] ^ a[j + 1];
					a[j] = a[j] ^ a[j + 1];
				}
			}
		}
	}
}
