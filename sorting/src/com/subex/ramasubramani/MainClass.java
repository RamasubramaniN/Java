package com.subex.ramasubramani;

import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass
{

	public static void main( String[] args )
	{
		int a[] =
		{ 9, 7, 5, 3, 1 };
		Scanner input = new Scanner( new InputStreamReader( System.in ) );
		Sorting sorting;
		if ( input.hasNext() )
		{
			int i = Integer.parseInt( input.next() );
			switch( i )
			{
			case 1:
				sorting = new SelectionSort( a );
				sorting.sort();
				break;
			case 2:
				sorting = new InsertionSort( a );
				sorting.sort();
				break;
			case 3:
				sorting = new BubbleSort( a );
				sorting.sort();
				break;
			case 4:
				int c[]={7,8,9,9,7,6,4,3,6,7,5};
				sorting = new MergeSort( c );
				c=sorting.sort();
				for ( int t : c )
					System.out.print( t + " " );
				break;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println( "Final Output In Main Class : " );
		for ( int i : a )
			System.out.print( i + " " );
	}

}
