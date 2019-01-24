package com.subex.ramasubramani;


import java.io.File;
/*JRE JVM and JDK in Java Programming language 

Java Runtime Environment (JRE)
Difference between JVM JRE and JDK in Java Programming languageJava is every where in browser, in mobile, in TV 
or in set-top boxes and if you are into Java programming language than you know that Java code which is bundled in JAR 
(Java archive) file require Java virtual machine JVM to execute it. Now JVM is an executable or program like any other
program and you can install that into your machine. You have seen browser often suggesting download JRE to run a Java Applet
downloaded from Internet. Various version of JRE are available in java.oracle.com and most of the user 
who just want to execute Java program inside browser or standalone downloads JRE. All browsers including Internet Explorer, 
Firefox and Chrome can work with JRE.

Java Virtual Machine (JVM)
When you download JRE and install on your machine you got all the code required to create JVM.
Java Virtual Machine is get created when you run a java program using java command e.g. java HelloWorld.
JVM is responsible for converting byte code into machine specific code and that's why you have different JVM for Windows,
Linux or Solaris but one JAR can run on all this operating system. Java Virtual machine is at heart of Java programming
language and provide several feature to Java programmer including Memory Management and Garbage Collection, Security
and other system level services. Java Virtual Machine can be customized e.g we can specify starting memory or
maximum memory of heap size located inside JVM at the time of JVM creation. If we supplied invalid argument
to java command it may refuse to create Java Virtual Machine by saying "failed to create Java virtual machine: 
invalid argument". In short Java Virtual Machine or JVM is the one who provides Platform independence to Java.

Java Development Kit (JDK)
JDK is also loosely referred as JRE but its lot more than JRE and it provides all the tools and executable
require to compile debug and execute Java Program. Just like JRE, JDK is also platform specific and you need to use 
separate installer for installing JDK on Linux and Windows. Current Version of JDK is 1.7 which is also referred as Java7 
and it contains javac (java compiler) based on programming rules of Java7 and Java which can execute java7 code with new features
like String in Switch, fork-join framework or Automatic Resource Management. When you install JDK, installation folder is often
referred as JAVA_HOME. All binaries are located inside JAVA_HOME/bin which includes javac, java and other binaries and they
must be in your system PATH in order to compile and execute Java programs. 
For details on Path see how to set PATH for Java in Windows and UNIX.

Difference between JRE, JDK and JVM
In short here are few differences between JRE, JDK and JVM:

1)  JRE and JDK come as installer while JVM are bundled with them.
2)  JRE only contain environment to execute java program but doesn’t contain other tool for compiling java program.
3)  JVM comes along with both JDK and JRE and created when you execute Java program by giving “java” command.

Just in Time Compiler (JIT)
Initially Java has been accused of poor performance because it’s both compiles and interpret instruction. 
Since compilation or Java file to class file is independent of execution of Java program do not confuse.
Here compilation word is used for byte code to machine instruction translation. JIT are advanced part of Java Virtual machine
which optimize byte code to machine instruction conversion part by compiling similar byte codes at same time and 
thus reducing overall execution time. JIT is part of Java Virtual Machine and also performs several other optimizations 
such as in-lining function.

That’s all on JRE, JDK and Java Virtual machine and difference between them. Though they look similar they are 
different and having a clear idea of JVM, JIT or JDK helps in java programming.

*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile
{

	public static void main( String[] args )
	{
		createProperties();
		readProperties();
	}

	private static void createProperties()
	{
		Properties properties = new Properties();
		properties.setProperty( "database", "XE" );
		properties.setProperty( "schema", "ramasubramani" );
		properties.setProperty( "username", "ramasubramani" );
		properties.setProperty( "password", "ramasubramani" );

		try
		{
			File file = new File( "config.properties" );
			properties.store( new FileOutputStream( file ), "Data base configuration things" );
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}

	private static void readProperties()
	{
		Properties properties = new Properties();
		try
		{
			properties.load( new FileInputStream( "config.properties" ) );
			System.out.println( "Database name : " + properties.getProperty( "database" ) );
			System.out.println( "Schema name : " + properties.getProperty( "schema" ) );
			System.out.println( "User name : " + properties.getProperty( "username" ) );
			System.out.println( "Password : " + properties.getProperty( "password" ) );
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}

}
