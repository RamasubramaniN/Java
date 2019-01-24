package com.subex.ramasubramani;

import java.io.Serializable;

public class SingleTon implements Serializable
{
	private static SingleTon instance;

	private SingleTon()
	{
		//You cannot instantiate from any methods outside this class
	}

	//Dont use synchronized method, because synchronization is costly, so only one thread will execute the method at any point of time
	//So, use double checking, for the first time the object is created it enters synchronized block, from next time onwards it doesn't enter synchronized block, so no blocking happens here
	//There are possibilities that two threads execute step X, so one thread enters and executes step Z, because the block does not have 'this'reference, instead since it is a block inside static method it is locked on the 'Class' object
	//but when second thread enters step Y, it finds instance is not null, so it doesn't create new instance.

	//Singleton is used in logger classes, unique instance, have Stringbuffer(thread safe) as a member which stores log, finally read this object's member and write it in a file.
	//Read application's configuration settings, create a single ton class with required application parameters, now this object will be used as a cache object, you don't need to go and fetch from db every time.
	//Factory and abstract factory classes should be implemented as single ton because if more than one factory exists, there is a possibility that two factory return different object with same object ids

	public static SingleTon getInstance()
	{
		if ( instance == null )// step X
		{
			synchronized ( SingleTon.class )
			{
				if ( instance == null ) // step Y
				{
					instance = new SingleTon(); //step Z
				}
			}
		}
		return instance;
	}

	protected Object readResolve()
	{
		//This method is called immediately after the object is deserialized, in the event of serialization, it does not make use of constructor(private here), so serialization can break Singleton pattern, it will create one more instance if the Singleton class is serializable
		//so, implement this method to avoid this.
		return getInstance();
	}

}
