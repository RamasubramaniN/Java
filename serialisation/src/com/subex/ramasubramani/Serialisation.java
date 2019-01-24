package com.subex.ramasubramani;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//Very important use : Does deep copy i.e. cloning very easily.
//One more use to transfer the object across the network, especially in RPC method parameters need to be serialized, because
//client and server are in different boxes, so argument object is transferred over a network.
//Most impressive is that the entire Serialisation process is JVM independent, 
//meaning an object can be serialized on one platform and deserialized on an entirely different platform.

//The ObjectOutputStream class contains many write methods for writing various data types, but one method in particular stands out:
//public final void writeObject(Object x) throws IOException
//The above method serializes an Object and sends it to the output stream.
//Similarly, the ObjectInputStream class contains the following method for deserializing an object:
//public final Object readObject() throws IOException, ClassNotFoundException
//This method retrieves the next Object out of the stream and deserializes it. The return value is Object, 
//so you will need to cast it to its appropriate data type.
public class Serialisation
{
	public static void main( String[] args ) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Test input = Test.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( "serialized.txt" ) );
		oos.writeObject( input );
		System.out.println( input );
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream( "serialized.txt" ) );
		Test output = ( Test ) ois.readObject();
		System.out.println( output );
	}

}

//One example of How Serialization can put constraints on your ability to change class is SerialVersionUID. 
//If you don't explicitly declare SerialVersionUID then JVM generates its based upon structure of class which depends
//upon interfaces a class implements and several other factors which is subject to change. Suppose you implement another
//interface than JVM will generate a different SerialVersionUID for new version of class files and when you try to load old object
//object serialized by old version of your program you will get InvalidClassException.



@SuppressWarnings( "serial" )
class Test implements Serializable
{
	int t = 5;
	ArrayList<Integer> list = new ArrayList<Integer>();
	private static Test instance;

	public static Test getInstance()
	{
		if ( instance == null )
			instance = new Test();
		return instance;
	}

	protected Test readResolve()
	{
		return instance;//Instance needs to be returned to avoid creation of multiple instances during serialization
	}

	private Test()
	{
		System.out.println( "Ramasubramani" );
		list.add( 1 );
		list.add( 2 );
		list.add( 3 );
		list.add( 4 );
		list.add( 5 );
	}
}
