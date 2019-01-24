package com.subex.ramasubramani;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessPrivate
{
	@SuppressWarnings( "unchecked" )
	public static void main( String[] args ) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
	{
		//3 members 1)Field   2)Method   3)Constructor.
		Class<Main> mainClass = ( Class<Main> ) Class.forName( "com.subex.ramasubramani.Main" );
		Class<Helper> helperClass = ( Class<Helper> ) Class.forName( "com.subex.ramasubramani.Helper" );

		//Access Private field of main and helper
		Field mainField = mainClass.getDeclaredField( "name" );
		mainField.setAccessible( true );
		//Set the accessible flag for this object to the indicated boolean value. 
		//A value of true indicates that the reflected object should suppress Java language access checking when it is used. 
		//A value of false indicates that the reflected object should enforce Java language access checks.
		System.out.println( "Accessing Main class private variable : " + mainField.get( mainClass.newInstance() ) );
		//Field value of which instance you wanted, instance should be arg to get()

		Field helperField = helperClass.getDeclaredField( "name" );
		helperField.setAccessible( true );
		Main mainInstance = mainClass.newInstance();
		Field memberObjectField = mainClass.getDeclaredField( "helper" );
		memberObjectField.setAccessible( true );
		Helper helper = ( Helper ) memberObjectField.get( mainInstance );
		System.out.println( "Accessing Helper class private variable : " + helperField.get( helper ) );

		//Accessing private methods

		Method mainMethod = mainClass.getDeclaredMethod( "getName");
		mainMethod.setAccessible( true );
		System.out.println( "Accessing Main class method : " + mainMethod.invoke( mainInstance, null ) );

		Method helperMethod = helperClass.getDeclaredMethod( "getHelperName");
		helperMethod.setAccessible( true );
		System.out.println( "Accessing Helper class method : " + helperMethod.invoke( helper, null ) );
	}
}

class Main
{
	private String name = "Main Class";
	private Helper helper = new Helper();

	private String getName()
	{
		return name;
	}
}

class Helper
{
	private String name = "Helper Class";

	private String getHelperName()
	{
		return name;
	}
}