package com.subex.ramasubramani;

public class MainClass
{

	public static void main( String[] args )
	{
		Child child = new Child();
		
		//output
		
		/*In Parent method
		In Parent constructor
		In Child method
		In Child constructor*/
		
		
		//Execution Order:
		//Parent class Static statements (This is only one time, not each time the object is created, i.e. when the first time our class is used in the program---> class loading takes place)
		//Parent class Static block(This is only one time, not each time the object is created)
		//Child class static statements(This is only one time, not each time the object is created)
		//Child class static block(This is only one time, not each time the object is created)
		//Parent object creation
		//Child object creation
		
		//Allocate memory for Parent object, initialise with default initial values(null,false,0 etc)
		//Read the Parent class
		//Execute Parent class's constructor
		
		//Allocate memory for Child object, initialise with default initial values(null,false,0 etc)
		//Read the Child class
		//Execute Child class's constructor
	}

}
