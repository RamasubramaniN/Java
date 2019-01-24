package com.rms.subex;

public class Apple
{
	int no;
	int price;
	int size;

	Apple( int no, int price, int size )
	{
		this.no = no;
		this.price = price;
		this.size = size;
	}

	@Override
	public String toString()
	{
		if ( this == null )
			return "Null";
		else
			return "Apple@" + this.no;
	}
}
