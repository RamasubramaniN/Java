package com.subex.ramasubramani;

import java.util.Iterator;

public class NewDataStructure implements Iterable<Integer>{

	static int numbers[]={1,2,3,4,5};
	/*public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			int index=0;
			@Override
			public boolean hasNext() {
				return index<numbers.length;
			}

			@Override
			public Integer next() {
				return numbers[index++];
			}

			@Override
			public void remove() {
				System.out.println("Unsupported Operation");
			}
		};
	}*/

	@Override
	public java.util.Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			int index=numbers.length-1;
			@Override
			public boolean hasNext() {
				return index>-1;
			}

			@Override
			public Integer next() {
				return numbers[index--];
			}

			@Override
			public void remove() {
				System.out.println("Unsupported Operation");
			}
		};
	}


	public static void main(String args[])
	{
		for(int s: new NewDataStructure())
			System.out.println(s);
	}
}
