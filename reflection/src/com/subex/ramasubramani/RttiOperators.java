package com.subex.ramasubramani;

public class RttiOperators 
{ 
	//static Class<? extends A>[] arrayClass=new Class<? extends A>[];
	private static void printClass(Class<?  extends A>  obj) throws InstantiationException, IllegalAccessException
	{
		A a = obj.newInstance();
		if(a instanceof C)
			System.out.println("Class C");//should be in the reverse order. because even C will be instance of A and B, B will be instance of A
		else if(a instanceof B)
			System.out.println("Class B");
		else if(a instanceof A)
			System.out.println("Class A");
		
	}
	
	private static void printClassWrongImpl(Class<?  extends A>  obj) throws InstantiationException, IllegalAccessException
	{
		A a = obj.newInstance();
		if(a instanceof A)
			System.out.println("Class A"); // This is executed all the time
		else if(a instanceof B)
			System.out.println("Class B");
		else if(a instanceof C)
			System.out.println("Class C");
	}
	
	private static void printClass2(Class obj) throws InstantiationException, IllegalAccessException
	{
		A a = (A) obj.newInstance();
		if(a instanceof C)
			System.out.println("Class C");
		else if(a instanceof B)
			System.out.println("Class B");
		else if(a instanceof A)
			System.out.println("Class A");
		
	}
	private static void printClass3(Class obj) throws InstantiationException, IllegalAccessException
	{
		//for(Class a : arrayClass)
		{
			//if(a.isInstance(obj))
			{
				System.out.println(obj.getSimpleName());
			}
		}
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		System.out.println( "Wrong implementation" );
		printClassWrongImpl( A.class );
		printClassWrongImpl( B.class );
		printClassWrongImpl( C.class );
		
		System.out.println();
		System.out.println( "Method 1" );
		printClass( A.class );
		printClass( B.class );
		printClass( C.class );

		System.out.println();
		System.out.println( "Method 2" );
		printClass2( A.class );
		printClass2( Class.forName( "com.subex.ramasubramani.B" ) ); // method parameter is of type Class,so forname can be used, 
		//if parameter is Class<? extends A> then we cannot use class.forname to create the required parameter. You can use - printClass((Class<B>) Class.forName( "com.subex.ramasubramani.B" ) );
		printClass2( C.class );
		
		System.out.println();
		System.out.println( "Dynamic instance of Method : " );
		printClass3( A.class );
		printClass3( Class.forName( "com.subex.ramasubramani.B" ) ); // method parameter is of type Class,so forname can be used, if parameter is Class<? extends A> then 
		//we cannot use class.forname to create the required parameter.
		printClass3( C.class );

	}

}

class A
{
	
}

class B extends A
{
	
}

class C extends B
{
	
}


