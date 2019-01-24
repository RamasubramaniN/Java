//Assume Input is : 9 7 5 3 1

/*
 * Take the first iteration, compare the element in the first position with other elements in the array and exchange them if some other number is lesser than the element in the first position
 * After the first iteration first element will occupy the first place in the array
 * After the second iteration second element will occupy the second place in the array and so on
 * complexity : 4+3+2+1 (i.e.) (n-1)+(n-2)+...+1 = (n-1)n/2 ---> O(n^2)
7 9 5 3 1 Iteration : 1
5 9 7 3 1 Iteration : 1
3 9 7 5 1 Iteration : 1
1 9 7 5 3 Iteration : 1
1 7 9 5 3 Iteration : 2
1 5 9 7 3 Iteration : 2
1 3 9 7 5 Iteration : 2
1 3 7 9 5 Iteration : 3
1 3 5 9 7 Iteration : 3
1 3 5 7 9 Iteration : 4

Use selection sort to find minimum element  in the given array, after the first iteration first element will be the minimum element
 */
package com.subex.ramasubramani;

public class SelectionSort implements Sorting
{
	int a[];

	public SelectionSort( int a[] )
	{
		this.a = a;
	}

	@Override
	public int[] sort()
	{
		int index;
		for ( int i = 0; i < a.length; i++ )
		{
			index = i;
			for ( int j = i + 1; j < a.length; j++ )
			{
				if ( a[j] > a[index] )
					index = j;
				/*for ( int t : a )
				{
					System.out.print( t + " " );
				}
				System.out.println( "Iteration : " + ( i + 1 ) );*/
			}
			int temp = a[index];
			a[index] = a[i];
			a[i] = temp;
			for ( int t : a )
			{
				System.out.print( t + " " );
			}
			System.out.println();
		}
		return a;
	}

}
