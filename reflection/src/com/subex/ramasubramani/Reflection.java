package com.subex.ramasubramani;

import java.util.Arrays;
import java.util.List;

public class Reflection
{
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		@SuppressWarnings("unchecked")
		//Class<Apple> a=(Class<Apple>) Class.forName("com.subex.ramasubramai.Apple");
		//System.out.println(Apple.class);
		//System.out.println(Class.forName("Apple"));
		Apple apple = new Apple();
		System.out.println(apple.getClass());
		Class<Apple> app = (Class<Apple>) apple.getClass();
		System.out.println(app);
		System.out.println(app.getName());
		System.out.println(app.getFields().length);
		System.out.println("Creating apple instances using its class");
		Apple apple2 = app.newInstance();
		System.out.println(app.getSuperclass());
		Class<Boolean> boolClass = Boolean.class;
		Object object = apple2;
		
		List<Apple> lstApple = Arrays.asList(new Child(),new Apple());
		Class cls = Class.forName("com.subex.ramasubramani.Reflection");
		System.out.println(cls);
	}

}
