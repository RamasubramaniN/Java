package com.subex.ramasubramani;

/* 
 * order of n^2.
 * After each iteration of i output is shown below
 * 7 9 5 3 1 
 * 5 7 9 3 1 
 * 3 5 7 9 1 
 * 1 3 5 7 9
 * In each iteration, the current position element(a[i]) is compared with all other elements in the left hand side
 * until the left hand element is greater than the current element the element is interchanged,once it finds lesser element 
 * than the current position element inner loop breaks
 * so, take the third iteration (from 5,7,9,3,1) , we take 3, it should be compared with all the elements in the left hand side
 * so, 3<9 so 3 and 9 are interchanged, now the array changes to 5,7,3,9,1 compare 3 with 7, so 3 and 7 are interchanged
 * 3<5 also so 3 and 5 are interchanged, so the array becomes 1,3,5,7,9.
 * so in the worst case 1+2+3+4 interchanges n*(n-1)/2, O(n^2), best case is n, if the elements are already in proper order.
 */
public class InsertionSort implements Sorting
{
	int a[];

	public InsertionSort( int a[] )
	{
		this.a = a;
	}

	@Override
	public int[] sort()
	{
		for ( int i = 1; i < a.length; i++ )
		{
			for ( int k = i; k > 0; k-- )
			{
				if ( a[k] < a[k - 1] )
				{
					a[k] = a[k] + a[k - 1];
					a[k - 1] = a[k] - a[k - 1];
					a[k] = a[k] - a[k - 1];
				}
				else
					break;
			}
			/*for ( int t : a )
				System.out.print( t + " " );
			System.out.println();*/
		}
		return a;
	}

}
