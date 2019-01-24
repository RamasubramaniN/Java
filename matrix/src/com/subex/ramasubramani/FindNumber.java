package com.subex.ramasubramani;

public class FindNumber
{
	int a[][] =
	{
	{ 1, 4, 9, 14 },
	{ 2, 8, 10, 15 },
	{ 3, 9, 12, 16 } };

	public static void main( String[] args )
	{
		FindNumber instance = new FindNumber();
		int n = 10;
		instance.checkNumber( n );
	}

	private void checkNumber( int n )
	{
		int i = 0;
		int j = 3;
		boolean found = false;
		int y = 0;
		int t = 0, s = 0;
		while ( j >= 0 && i <= 2 )
		{
			if ( n < a[i][j] )
				j--;
			else if ( n > a[i][j] )
				i++;
			else
			{
				t = i;
				s = j;
				found = true;
				break;
			}
			y++;
		}
		if ( found )
		{
			System.out.println( "Number is present in(" + t + ", " + s + "). It was found out in " + y + " iteration" );
		}
		else
		{
			System.out.println( "Number not found" );
		}
	}
}
