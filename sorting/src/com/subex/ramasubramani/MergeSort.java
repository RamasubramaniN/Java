package com.subex.ramasubramani;

public class MergeSort implements Sorting
{

/**
 * Divide: 
compute q as the average of p and r: D(n) = Thetta(1)
Conquer: 
recursively solve 2 subproblems, each of size n/2 Thetta 2T (n/2)
Combine: 
MERGE on an n-element subarray takes Thetta(n) time Thetta C(n) = Thetta(n)
	 		 Thetta(1)			if n =1 
      T(n) = 	 2T(n/2) + Thetta(n) 	if n > 1

 */
	int a[];

	public MergeSort( int a[] )
	{
		this.a = a;
	}

	@Override
	public int[] sort()
	{
		split( 0, a.length - 1 );
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
		int i = low;
		int b[] = new int[a.length];

		while ( ( f <= mid ) && ( s <= high ) )
		{
			if ( a[f] < a[s] )
			{
				b[i] = a[f];
				f++;
				i++;
			}
			else
			{
				b[i] = a[s];
				s++;
				i++;
			}
		}

		if ( f <= mid )
		{
			while ( f <= mid )
			{
				b[i] = a[f];
				f++;
				i++;
			}
		}
		else
		{
			while ( s <= high )
			{
				b[i] = a[s];
				i++;
				s++;
			}
		}

		for ( int k = low; k <= high; k++ )
		{
			a[k] = b[k];
		}

	}
}
