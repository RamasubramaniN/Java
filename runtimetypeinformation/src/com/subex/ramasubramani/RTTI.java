package com.subex.ramasubramani;

public class RTTI
{
	public static void main(String a[]) throws ClassNotFoundException
	{
		//Loads the .class file and create .class object from the byte code but this method does not initialise static blocks and members
		System.out.println("Method1");
		Class classChild = Child.class;
		System.out.println(classChild.getSuperclass());
		
		System.out.println();
		System.out.println("Method2");
		Class classDerived = Class.forName("com.subex.ramasubramani.Derived");
		System.out.println(classDerived.getSuperclass());
		System.out.println(classDerived.getName());
		System.out.println(classDerived.getCanonicalName());
		System.out.println(classDerived.getSimpleName());
		System.out.println(classDerived.isLocalClass());
		System.out.println(classDerived.isMemberClass());
		System.out.println(classDerived.isInterface());
		
	}

}
