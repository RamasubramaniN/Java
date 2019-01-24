package com.subex.ramasubramani;

public class Apple 
{
	Integer s,t;
	Apple()
	{
		System.out.println("Apple Instance has been created");
	}
	static
	{
		System.out.println("Class apple has been loaded");
	}

}

class Child extends Apple
{
	
}
