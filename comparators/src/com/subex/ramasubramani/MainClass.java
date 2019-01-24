package com.subex.ramasubramani;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Garbage collection relieves java programmer from memory management
//which is essential part of C++ programming and gives more time to focus on business logic.
//Garbage Collection in Java is carried by a daemon thread called Garbage Collector.
//Before removing an object from memory Garbage collection thread invokes finalize () method of that object
//and gives an opportunity to perform any sort of cleanup required. 
//Here, you can recreate the object also, which we won't do in general.
//So , here you get the reference of objects that are going to be garbage collected
//But don't rely on this functionality to do clean up, because we do not know when garbage collector will be invoked
//So, write your own cleanup methods to do clean up and do not rely on finalize() method to clean up resources
//You can force garbage collector by calling System.gc(), but this informs garbage collector to garbage collect,
//But still there is no guarantee that garbage collection takes place immediately
//If there is no memory space for creating new object in Heap Java Virtual Machine throws OutOfMemoryError or 
//java.lang.OutOfMemoryError heap space

//An Object becomes eligible for Garbage collection or GC if its not reachable from any live threads 
//or any static references in other words you can say that an object becomes eligible for garbage collection
//if its all references are null. Cyclic dependencies are not counted as reference 
//so if Object A has reference of object B and object B has reference of Object A and
//they don't have any other live reference then both Objects A and B will be eligible for Garbage collection.
//Generally an object becomes eligible for garbage collection in Java on following cases:
//1) All references of that object explicitly set to null e.g. object = null
//2) Object is created inside a block and reference goes out scope once control exit that block.
//3) Parent object set to null, if an object holds reference of another object and 
//when you set container object's reference null, child or contained object automatically becomes eligible for garbage collection.
//4) If an object has only live references via WeakHashMap it will be eligible for garbage collection. 
//To learn more about HashMap see here How HashMap works in Java.

//Java objects are created in Heap and Heap is divided into three parts or generations for sake of garbage collection in Java,
//these are called as Young generation, Tenured or Old Generation and Perm Area of heap.
//New Generation is further divided into three parts known as Eden space, 
//Survivor 1 and Survivor 2 space. When an object first created in heap 
//its gets created in new generation inside Eden space and after subsequent 
//Minor Garbage collection if object survives its gets moved to
//survivor 1 and then Survivor 2 before Major Garbage collection moved that object to Old or tenured generation.

//Permanent generation of Heap or Perm Area of Heap is somewhat special and it is used 
//to store Meta data related to classes and method in JVM,
//it also hosts String pool provided by JVM as discussed why String is immutable in Java.

public class MainClass
{
	@SuppressWarnings( "unchecked" )
	//indicates unchecked exceptions , we do not need to write try catch for these unchecked exceptions 
	//which may occur at runtime like ArrayIndexOutOfBound exception, (divide by zero) Arithmetic exception, null pointer exception,
	public static void main( String[] args )
	{
		Student s1 = new Student( 3, "Ramasubramani" );
		Student s2 = new Student( 2, "Vinoth" );
		Student s3 = new Student( 1, "Vivek" );
		Student s4 = new Student( 5, "Bharathi" );
		Student s5 = new Student( 4, "Anand" );

		ArrayList<Student> listStudent = new ArrayList<Student>();
		listStudent.add( s1 );
		listStudent.add( s2 );
		listStudent.add( s3 );
		listStudent.add( s4 );
		listStudent.add( s5 );
		System.out.println( "***********************************************************************************************************************************************************************************************************" );
		System.out.println( "Comparator before sorting" );
		System.out.println( listStudent );

		//Both Comparator and Comparable are interfaces. So, when we need to sort some collections we need to use comparators
		//We can create anonymous inner class of comparator to sort our collection. 
		//So, compare method takes two arguments of objects reside in collection
		//The implementation should be "When the first object is greater than the second object  it should return +ive,
		// if it is lesser then return -ive"

		//Comparable Vs Comparator
		//1) Comparator in Java is defined in java.util package while Comparable interface in Java is defined in java.lang package,
		//which very much says that Comparator should be used as an utility to sort objects which Comparable should be provided by default.

		//2) Comparator interface in Java has method public int compare (Object o1, Object o2) which returns a negative integer, zero, 
		//or a positive integer as the first argument is less than, equal to, or greater than the second. 
		//While Comparable interface has method public int compareTo(Object o) which returns a negative integer, zero,
		//or a positive integer as this object is less than, equal to, or greater than the specified object.

		//3) If you see then logical difference between these two is Comparator in Java compare two objects provided to him,
		//while Comparable interface compares "this" reference with the object specified. 
		//Comparator means external class we are creating but comparable we inform the object itself is comparable

		//4) Comparable in Java is used to implement natural ordering of object. 
		//In Java API String, Date and wrapper classes implements Comparable interface.
		//Its always good practice to override compareTo() for value objects.

		//5) If any class implement Comparable interface in Java then collection of that object either List or Array can be sorted automatically 
		//by using  Collections.sort() or Arrays.sort() method and object will be sorted based on there natural order defined by CompareTo method.

		//6)Objects which implement Comparable in Java  can be used as keys in a SortedMap like TreeMap or elements in a SortedSet
		//for example TreeSet, without specifying any Comparator.

		//NoClassDefFoundError is an Error and more critical than ClassNotFoundException which is an exception and recoverable. 
		//NoClassDefFoundError comes when a particular class was present in Java Classpath during compile time
		//but not available during run-time.
		//Classic example of this error is using log4j.jar for logging purpose and forgot to include log4j.jar on
		//classpath in java during run-time.

		Collections.sort( listStudent, new Comparator<Student>()
		{
			@Override
			public int compare( Student student1, Student student2 )
			{
				int comparisonResult;
				if ( student1.getStudentId() > student2.getStudentId() )
					comparisonResult = 1;
				else if ( student1.getStudentId() < student2.getStudentId() )
					comparisonResult = -1;
				else
					comparisonResult = 0;
				return comparisonResult;
			}

		} );
		System.out.println( "Comparator after sorting" );
		System.out.println( listStudent );

		System.out.println( "***********************************************************************************************************************************************************************************************************" );

		ComparableStudent s11 = new ComparableStudent( 3, "Ramasubramani" );
		ComparableStudent s12 = new ComparableStudent( 2, "Vinoth" );
		ComparableStudent s13 = new ComparableStudent( 1, "Vivek" );
		ComparableStudent s14 = new ComparableStudent( 5, "Bharathi" );
		ComparableStudent s15 = new ComparableStudent( 4, "Anand" );

		ArrayList<ComparableStudent> listComparableStudent = new ArrayList<ComparableStudent>();
		listComparableStudent.add( s11 );
		listComparableStudent.add( s12 );
		listComparableStudent.add( s13 );
		listComparableStudent.add( s14 );
		listComparableStudent.add( s15 );
		System.out.println( "Comparable before sorting" );
		System.out.println( listComparableStudent );

		Collections.sort( listComparableStudent ); //No need to provide external comparator, because class itself is comparable
		//and we have provided proper implementations also
		//If we use comparable at any time we can compare 2 objects but with anonymous comparator we cannot do
		//In our app we may need to sort a collection based on different factors at different part of the application
		//if we use comparable this can't be achieved because compareTo  has single implementation so we need to create anonymous comparator
		//this comparator implementation depends on the factors we consider.

		System.out.println( "Comparable after sorting" );
		System.out.println( listComparableStudent );
		System.out.println( "***********************************************************************************************************************************************************************************************************" );
	}
}

class Student
{
	private int studentId;
	private String name;

	Student()
	{

	}

	Student( int studentId, String name )
	{
		this.studentId = studentId;
		this.name = name;
	}

	public int getStudentId()
	{
		return studentId;
	}

	public void setStudentId( int studentId )
	{
		this.studentId = studentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Student Id: " + this.getStudentId() + "  Student Name: " + this.getName();
	}
}

class ComparableStudent implements Comparable
{
	private int studentId;
	private String name;

	ComparableStudent()
	{

	}

	ComparableStudent( int studentId, String name )
	{
		this.studentId = studentId;
		this.name = name;
	}

	public int getStudentId()
	{
		return studentId;
	}

	public void setStudentId( int studentId )
	{
		this.studentId = studentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Student Id: " + this.getStudentId() + "  Student Name: " + this.getName();
	}

	@Override
	public int compareTo( Object o )
	{
		ComparableStudent student2 = ( ComparableStudent ) o;
		int comparisonResult;
		if ( this.getStudentId() > student2.getStudentId() )
			comparisonResult = 1;
		else if ( this.studentId < student2.getStudentId() )
			comparisonResult = -1;
		else
			comparisonResult = 0;
		return comparisonResult;
	}
}