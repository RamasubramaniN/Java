package com.subex.ramasubramani;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CompleteReflection
{
	/**
	 * For RTTI to work, all classes should be available at compile time. RTTI is used in two places.
	 * 1) During downcasting Shape shape = new Square(); List<Corner> = (Square)shape.getCorners();
	 * Here, getCorners() method is available only in 'Square' class and it is not available in 'Shape' class.
	 * We know downcasting is not safe.If 'shape' is downcasted to square, shape's actual object type should be square,else RTTI
	 * throws ClassCastException at run time. Type is verified only at run time and not at compile time.
	 * 2) During use of 'instanceOf' operator. if(shape instanceOf Square) { List<Corner> = (Square)shape.getCorners();}
	 * Checking before a cast is always safe.Here RTTI is used. One problem with instanceOf is it returns true even when child object
	 * is verified against parent's type. In the above case, if(square instanceOf Shape) will also return true.
	 * Child is always of parent type.
	 * 
	 * 			RTTI    Vs     Reflection
	 * For Reflection, classes need not be available at compile time. It is enough to have class files at run time.
	 * For example, Class squareClass = Class.forName("com.subex.ramasubramani.Square"); Object object = squareClass.newInstance();
	 * Here, Class is not expected to be available at compile time because during compile time compiler will not verify string value.
	 * Reflection solves the following problems.
	 * 1) Distributed computing. class files may exist in remote machine and you may get class files in your local drive during run time.
	 * 2) The classes may not exist during compile time. '.java' files are created at run time based on input parameters, 
	 * These java files are Compiled using a our java code at run time and '.class' files exist only during run time.
	 * 3) To access private variables. To better know about classes, members, parent class, interfaces it implements,
	 * to know about modifiers(final,static) about its members and member functions.
	 */
	@SuppressWarnings( "unchecked" )
	public static void main( String[] args ) throws SecurityException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
	{
		// Accessing private Fields
		Class<Parent> parentClass = ( Class<Parent> ) ( Class.forName( "com.subex.ramasubramani.Parent" ) );
		Field field = parentClass.getDeclaredField( "name" );
		field.setAccessible( true );

		Field objectField = parentClass.getDeclaredField( "helper" );
		objectField.setAccessible( true );
		System.out.println( "Accessing private field of parent : " + field.get( parentClass.newInstance() ) );

		Helper helper = ( Helper ) objectField.get( parentClass.newInstance() );
		Class<Helper> helperClass = ( Class<Helper> ) Class.forName( "com.subex.ramasubramani.Helper" );
		Field fieldHelper = helperClass.getDeclaredField( "name" );
		fieldHelper.setAccessible( true );
		System.out.println( "Accessing private field of helper : " + fieldHelper.get( helper ) );

		// Accessing private methods
		Method parentMethod = parentClass.getDeclaredMethod( "getName", null );
		parentMethod.setAccessible( true );
		System.out.println( "Invoking private method of parent class : " + parentMethod.invoke( parentClass.newInstance() ) );

		Method helperMethod = helperClass.getDeclaredMethod( "getHelperName", null );
		helperMethod.setAccessible( true );
		System.out.println( "Invoking private method of helper class : " + helperMethod.invoke( helperClass.newInstance() ) );
	}

}

class Parent
{
	private String name = "Ramasubramani";
	private Helper helper = new Helper();

	private String getName()
	{
		return name;
	}

}

class Helper
{
	private int x = 10;
	private String name = "helper";

	private String getHelperName()
	{
		return name;
	}
}
