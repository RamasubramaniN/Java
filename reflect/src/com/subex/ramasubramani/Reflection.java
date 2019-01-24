package com.subex.ramasubramani;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.regex.Pattern;



//By Run Time Type Identification (RTTI) we denote a mechanism to find the type of an object at run time.
//Typically, there are two situations when the RTTI mechanism is used:
	//• Downcasting to a child class.
	//• Checking an object type via instanceof.
//For RTTI all the classes should be present for the compile time verification
//But for reflection, classes need not be present at compile time, these class files may come from a network

class Shape {
	
}
class Square extends Shape {
	
}

class Circle extends Shape {
	
}

public class Reflection
{
	private Reflection()
	{

	}

	@SuppressWarnings(
	{ "rawtypes", "unused" } )
	public static void main( String[] args ) throws InstantiationException, IllegalAccessException
	{
		Object[] instanceArray = new Object[3];
		Class[] classArray = {Shape.class, Square.class, Circle.class};
		System.out.println("Shape example outputs");
		for(int i = 0; i<instanceArray.length ; i++){
		
			instanceArray[i] = classArray[i].newInstance(); // throws InstantiationException, IllegalAccessException
			
			//Use of isinstance operator. To check if instance object's class is the given class object.
			//Here instanceArray[i] is instance of Square/Circle/Shape. classArray[i] is class object of Square/Circle/Shape.
			System.out.println(classArray[i].isInstance( instanceArray[i] )); 
		}
		System.out.println(new Circle().getClass() == Circle.class);
		System.out.println(Shape.class.isInstance( new Circle ()));
		System.out.println(new Circle() instanceof Shape);
		//System.out.println(Circle.class == Shape.class); --Compile time error - Incompatible operand types Class<Circle> and Class<Shape>
		/*
		 * circle.getClass() == Circle.class; // true
		 * circle.getClass() == Shape.class; // false, compile time error
		 * circle instanceof Shape; //true
		 * Shape.class.isinstance(circle); //true
		 */
		Class cls = null;
		try
		{
			cls = Class.forName( "com.subex.ramasubramani.Reflection" );//This is reflection because the availability of class files in the specified location won't be verified at compile time
		}
		catch ( ClassNotFoundException e1 )
		{
			e1.printStackTrace();
		}
		System.out.println( cls.getMethods() );
		Method[] methods = cls.getMethods();
		Pattern p = Pattern.compile( "\\w+\\." );
		Constructor[] construct = cls.getConstructors();
		for ( Method method : methods )
			System.out.println( method.toString() );
		//constructor will be shown only if it is public
		for ( Constructor cons : construct )
			System.out.println( p.matcher( construct.toString() ).replaceAll( "" ) );

		System.out.println();
		System.out.println();
		System.out.println();

		//Class<?> x ; equivalent to Class x
		Class< ? extends Parent> childClass = Child.class;//This is not reflection, because Child class should be available at compile time.
		System.out.println( childClass.getName() );
		System.out.println( childClass.getSuperclass().getName() );
		for ( Class interfaces : childClass.getInterfaces() ) //Determines the interfaces implemented by the class or interface represented by this object. 
		{
			System.out.println(interfaces.getCanonicalName());
			System.out.println( interfaces.isInterface() );//This tells you whether the class file represents an interface or not
		}

		System.out.println();
		System.out.println( "Parent interfaces as follows : " );
		Class<Parent> parentClass = Parent.class;
		for ( Class interfaces : parentClass.getInterfaces() )
		{
			System.out.println( interfaces.getName() );
			System.out.println( interfaces.isInterface() );
		}

		System.out.println();
		System.out.println();
		System.out.println( "Creating instances using class objects. invoking default constructors" );
		try
		{
			Parent parent = parentClass.newInstance();//first way of creating objects using class objects, but it always invoke no argument constructor, 
			//so if you want to create an instance with argument constructor you have to follow the second way which is using Constructor object
			parent.publicMethod();
			//An IllegalAccessException is thrown when an application tries to reflectively create an instance (other than an array), 
			//set or get a field, or invoke a method, but the currently executing method 
			//does not have access to the definition of the specified class, field, method or constructor. (private fields)
		}
		catch ( InstantiationException e )
		{
			e.printStackTrace();
		}
		catch ( IllegalAccessException e ) //Checked exception because you may have fall back plan. Other such example is NumberFormatException. What if you get a string in place of number.
		{
			e.printStackTrace();
		}

		//Method, Field and Constructor are 3 different classes, they all inherit Member interface 
		System.out.println();
		System.out.println();
		System.out.println( "Creating instances using class objects. invoking parameterized constructors" );
		Integer size = new Integer( 10 );
		try
		{
			Constructor constructor = childClass.getConstructor( int.class );
			try
			{
				Child child = ( Child ) constructor.newInstance( size );//second way of creating objects using constructor
			}
			catch ( IllegalArgumentException e )
			{
				e.printStackTrace();
			}
			catch ( InstantiationException e )
			{
				e.printStackTrace();
			}
			catch ( IllegalAccessException e )
			{
				e.printStackTrace();
			}
			catch ( InvocationTargetException e )
			{
				e.printStackTrace();
			}
		}
		catch ( SecurityException e )
		{
			e.printStackTrace();
		}
		catch ( NoSuchMethodException e )
		{
			e.printStackTrace();
		}

		System.out.println();
		System.out.println( "Printing available methods : only public methods can be identified" );
		for ( Method method : parentClass.getMethods() )
			System.out.println( method.getReturnType() + " " + method.getName() );

		System.out.println();
		System.out.println( "Printing available fields : only public fields can be identified, default, protected and private fields cannot be extracted using reflection. Use Declared field and setAccessible method to get remaining fields." );
		for ( Field field : childClass.getFields() )
		{
			System.out.println( ( identifyModifiers( field.getModifiers() ) ) + field.getType() + " " + field.getName() );
		}

		System.out.println();
		System.out.println( "Printing constructors : Only public constructors can be identified by reflection" );
		for ( Constructor constructor : childClass.getConstructors() )
		{
			System.out.println( constructor.getName() + "(" + constructor.getParameterTypes() + ")" );
		}

		try
		{
			System.out.println();
			System.out.println("Invoking public method using reflection");
			Method method = childClass.getMethod( "publicMethod", null ); 
			System.out.println(parentClass.getSuperclass());
			try
			{
				method.invoke( new Child(), null );
			}
			catch ( IllegalArgumentException e )
			{
				e.printStackTrace();
			}
			catch ( IllegalAccessException e )
			{
				e.printStackTrace();
			}
			catch ( InvocationTargetException e )
			{
				e.printStackTrace();
			}
		}
		catch ( SecurityException e )
		{
			e.printStackTrace();
		}
		catch ( NoSuchMethodException e )
		{
			e.printStackTrace();
		}
	} 

	private static String identifyModifiers( int modifierFlag )
	{
		String modifier = "";

		//example flag 9 represents both public and static, so single flag itself is enough to tell it is both public and static
		if ( Modifier.isPublic( modifierFlag ) )
		{
			modifier += "public ";
		}
		if ( Modifier.isPrivate( modifierFlag ) )
		{
			modifier += "private ";
		}
		if ( Modifier.isProtected( modifierFlag ) )
		{
			modifier += "protected ";
		}
		if ( Modifier.isStatic( modifierFlag ) )
		{
			modifier += "static ";
		}
		if ( Modifier.isFinal( modifierFlag ) )
		{
			modifier += "final ";
		}
		return modifier;
	}
}

class Parent implements Behavior, PrintBehavior
{
	public void publicMethod()
	{
		System.out.println( "This is public method in the parent" );
	}

	private void privateMethod()
	{
		System.out.println( "This is private method in the parent" );
	}
}

class Child extends Parent implements Serializable
{
	public static int x;
	public String y;
	Boolean z;

	public Child()
	{

	}

	public Child( int x )
	{

	}
}