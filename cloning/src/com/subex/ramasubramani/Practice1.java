package com.subex.ramasubramani;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Practice1{
	public static void main(String args[]) throws Exception {
		Practice1 practice1 = new Practice1();
		practice1.testCloning();
	}

	private void testCloning() throws Exception{
		Dummy dummy1 = new Dummy();
		dummy1.setA(new A1());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(dummy1);
		objectOutputStream.flush();
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		Dummy dummy2 = (Dummy) objectInputStream.readObject();
		System.out.println(dummy1);
		System.out.println(dummy2);
		
	}
}


class Dummy implements Serializable{
	private A1 a;

	public A1 getA() {
		return a;
	}

	public void setA(A1 a) {
		this.a = a;
	}
	
}

class A1 implements Serializable{
	private int x = 10;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}