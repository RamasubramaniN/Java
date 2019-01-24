package com.subex.ramasubramani;

public class Parent
{
	static int x=10;
	static
	{
		System.out.println("Parent class:"+x);
	}
}

class Derived extends Parent
{
	static int y=15;
	static
	{
		System.out.println("Derived class:"+y);
	}
}

