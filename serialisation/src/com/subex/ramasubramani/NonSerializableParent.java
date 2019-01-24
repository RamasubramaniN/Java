package com.subex.ramasubramani;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//3) What is serialVersionUID? What would happen if you don't define this?
//SerialVersionUID is an ID which is stamped on object when it get serialized usually hashcode of object,
//you can use tool serialver to see serialVersionUID of a serialized object . SerialVersionUID is used for version control of object.
//you can specify serialVersionUID in your class file also.  Consequence of not specifying  serialVersionUID is that 
//when you add or modify any field in class then already serialized class will not be able to recover 
//because serialVersionUID generated for new class and for old serialized object will be different. 
//Java serialization process relies on correct serialVersionUID for recovering state of serialized object 
//and throws java.io.InvalidClassException in case of serialVersionUID mismatch.


//4) While serializing you want some of the members not to serialize? How do you achieve it?
//This is sometime also asked as what is the use of transient variable, does transient and static variable gets serialized or not etc. 
//so if you don't want any field to be part of object's state then declare it either static or transient based on your need
//and it will not be included during Java serialization process.

//When to use transient variable?
//Suppose you have a class called picture and you have following Image objects inside
//1) original image in JPEG 2)Image in Png 3)Image in GIF
//so make 2 and 3rd transient  because anyway from 1 we can reproduce 2 and 3.
//This is good because we are reducing the number of bytes sent over the network.

//If you try to serialize an object of a class which implements Serializable, but the object includes a reference
//to an non- Serializable class then a ‘NotSerializableException’ will be thrown at runtime


public class NonSerializableParent
{
	public static void main( String[] args ) throws IOException, ClassNotFoundException
	{
		Child child = new Child();
		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( "serialized.txt" ) );
		oos.writeObject( child );
		System.out.println( child );
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream( "serialized.txt" ) );
		Child output = ( Child ) ois.readObject();
		System.out.println( output.x );//Parent is non-serializable here.So in such a scenario, 
		//values of members(coming from parent) are reset to parent's member values
		System.out.println( output.y );
	}
}
//Difference between Externalizable and Serializable in Java

//One obvious difference that Serializable is a marker interface and doesn't contain any methods whereas Externalizable interface 
//contains two methods: writeExternal(ObjectOutput) and readExternal(ObjectInput). But, the main difference between the two is 
//that Externalizable interface provides complete control to the class implementing the interface over the object serialization 
//process whereas Serializable interface normally uses default implementation to handle the object serialization process.

//While implementing Serializable, you are not forced to define any method as it's a marker interface. However, 
//you can use the writeObject or readObject methods to handle the serialization process of complex objects. But, while implementing
//Externalizable interface, you are bound to define the two methods: writeExternal and readExternal and all the object
//serialization process is solely handled by these two methods only.

//In case of Serializable interface implementation, state of Superclasses are automatically taken care by the default 
//implementation whereas in case of Externalizable interface the implementing class needs to handle everything on its own
//as there is no default implementation in this case.

//Example Scenario: when to use what?

//If everything is automatically taken care by implementing the Serializable interface, why would anyone
//like to implement the Externalizable interface and bother to define the two methods? Simply to have the complete 
//control on the process. OKay... let's take a sample example to understand this. Suppose we have an object having hundreds
//of fields (non-transient) and we want only few fields to be stored on the persistent storage and not all.
//One solution would be to declare all other fields (except those which we want to serialize) as transient and the 
//default Serialization process will automatically take care of that. But, what if those few fields are not fixed at
//design tiime instead they are conditionally decided at runtime. In such a situation, implementing Externalizable 
//interface will probably be a better solution. Similarly, there may be scenarios where we simply don't want to 
//maintain the state of the Superclasses (which are automatically maintained by the Serializable interface implementation).

class Parent
{
	int x = 10;
	int y = 10;
	
	Parent()
	{
		y = 90;
	}
}
//8) Suppose super class of a new class implement Serializable interface, how can you avoid new class to being serialized?
//One of the tricky interview question in Serialization in Java. If Super Class of a Class already implements Serializable interface 
//in Java then its already Serializable in Java, since you can not unimplemented an interface its not really possible to make it 
//Non Serializable class but yes there is a way to avoid serialization of new class. To avoid java serialization
//you need to implement writeObject() and readObject() method in your Class and need to throw NotSerializableException
//from those method.

//Static variables belong to the class and not to an object they are not the part of the state of object so they
//are not saved during Java Serialization process. As Java Serialization only persist state of object and not object itself.
//Transient variables are also not included in java serialization process and are not the part of the object’s serialized state.

class Child extends Parent implements Serializable
{
	Child()
	{
		x = 15;
		y = 18;
	}

}
