package com.subex.ramasubramani;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Cloning using serialization, using file input output streams
//Parent class is serializable, so child class is automatically serializable
public class CloningMethod2
{
	public static void main( String args[] )
	{
		Child2 child = new Child2( 100 );
		System.out.println( "Original Object:" );
		System.out.println( child.childElement );
		System.out.println( child.parentElement );
		System.out.println( child.childString );
		System.out.println( child.parentString );

		Child2 clonedChild = null;
		//cloning using serialisation

		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream( "D://Softwares//object.txt" );
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		} 
		ObjectOutputStream oos = null;
		
		try
		{
			oos = new ObjectOutputStream( fos );
			oos.writeObject( child );
			oos.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		ObjectInputStream ois = null;
		FileInputStream fis = null; 
		
		try
		{
			fis = new FileInputStream( "D://Softwares//object.txt" );
			try
			{
				ois = new ObjectInputStream( fis );
			}
			catch ( IOException e )
			{
				e.printStackTrace();
			}
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		
		try
		{
			clonedChild = ( Child2 ) ois.readObject();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		catch ( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		
		
		System.out.println( "Cloned Object:" );
		System.out.println( clonedChild.childElement );
		System.out.println( clonedChild.parentElement );
		System.out.println( clonedChild.childString );
		System.out.println( clonedChild.parentString );

		System.out.println( "Hashcode of OriginalObject :" + child.d );
		System.out.println( "Hashcode of ClonedObject :" + clonedChild.d );
	}
}

@SuppressWarnings( "serial" )
class Parent2 implements Serializable
{
	int parentElement;
	static int i = 1;
	String parentString = "PARENT:" + i++;

	Parent2( int parentElement )
	{
		this.parentElement = parentElement;
	}
}

@SuppressWarnings( "serial" )
class Child2 extends Parent
{
	static int j = 1;
	int childElement;
	String childString = "CHILD:" + j++;
	D d = new D();

	Child2( int childElement )
	{
		super( 2 * childElement ); //required because there is no default constructor with zero parameters defined by compiler, the reason is we explicitly defined parameterised constructor
		this.childElement = childElement;
	}
}

class D implements Serializable{
	int d = 10;
}
