package com.subex.ramasubramani;

//towers.java
//solves the towers of Hanoi puzzle
//to run this program: C>java TowersApp
////////////////////////////////////////////////////////////////
public class TowersApp
{
	static int nDisks = 4;

	public static void main( String[] args )
	{
		doTowers( nDisks, 'A', 'B', 'C' );
	}

	public static void doTowers( int topN, char from, char inter, char to )
	{
		if ( topN == 1 )
			System.out.println( "Disk 1 from " + from + " to " + to );
		else
		{
			doTowers( topN - 1, from, to, inter ); // from-->inter
			System.out.println( "Disk " + topN + " from " + from + " to " + to );
			doTowers( topN - 1, inter, from, to ); // inter-->to
		}
	}
	//----------------------------------------------------------
} // end class TowersApp
////////////////////////////////////////////////////////////////
