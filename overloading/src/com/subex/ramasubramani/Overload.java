package com.subex.ramasubramani;
public class Overload
{
	static int y;
	int z;

	public static void main( String[] args )
	{
		Overload overload = new Overload();
		overload.load( null );
		Overload.Nested nested1 = new Overload.Nested();
		Overload.Nested nested2 = new Overload.Nested();
		/* Use of nested static class (non static nested classes are known as inner classes
		 * The advantage of static nested class. This class is used only by the outer class,
		 * why to unnecessarily expose it to other classes. Better encapsulation 
		 * Second when you want to create the instance of inner class, you don't need to create instance of outer class
	    */
	}

	private void load( Object obj )
	{
		System.out.println( "Object" );
	}

	private void load( String obj )
	{
		System.out.println( "String" );
	}

	/*private void load(StringBuilder obj)
	{
		System.out.println("StringBuider");
	}*/
	//Compile time Polymorphism : Early Binding, 'One interface, different methods'
	//Overloading method resolution takes place at compile time. If the above method is uncommented it will result in
	//compile time error,because always compiler checks for most specific type, in this case, when we call the load()
	//method will arguments, it will first look for Object, then String. So, the above program with the commented code
	//executes overloaded method with string argument. But if the above code is uncommented, compiler will have confusion
	//in choosing between stringbuilder and String, so it results in compile time error
	private class InnerClass
	{
		InnerClass()
		{
			z = 100;
			y = 100;
			//Have access to static as well as non-static members of the outer class
		}
	}

	private static class Nested
	{
		int x;

		Nested()
		{
			y = 10;
			//Have access to only static members of the outer class
		}
	}

	/* Actually there are 2 reasons --> guess
	 * 1)Local variables will be cleared from stack once the method finishes its execution.
	 * But we do not when the inner classes will get executed. 
	 * Inner class can be a listener. so, the piece of code will be executed later. (i.e. you create a listened inside a method which will be invoked when the relative action is triggered.
	 * so, inner routine needs to take a copy of outer variables.
	 * 2) but, what if the variables change after the execution of inner class routine, (within the method)
	 * assume in this case inner class routine is executed in a different thread and in between outer class
	 * completes its execution inner routine is getting called.so, 
	 * after that outer class routine changes the value, this is not correct, inconsistency,
	 * e so make the variables final, there wont be change in data 
	 */

}

class X {
	private String msg1;
	
	private void display() {
		final String msg2 = "ram"; //Inner class takes a copy of msg2 while creating instance of innner class.
		//If value of msg2 changes after constructing instance of Y, Y's value is outdated and it will give different result when it executes msg()
		//so msg2 should be final
		class Y {
			private void msg() {
				System.out.println(msg1 + msg2); //Local inner classes (inside a method)
			}
		}
	}
}

class A
{
}

class B extends A
{

}

class Base
{
	public void method() throws Exception
	{
		//If Base class throws Parent Exception, Child class can throw the same exception or child of that exception,
	}

	public A method2()
	{
		return new A();
	}
}

class Derived extends Base
{
	public void method() throws NullPointerException
	{

	}

	public B method2()
	{
		return new B();
		// In the same way, if parent class method returns type 'A', 
		//child class method can return type 'A' or the child of 'A'
	}
}
