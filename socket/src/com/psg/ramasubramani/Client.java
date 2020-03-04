package com.psg.ramasubramani;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;

/**
 * @author rn5
 *
 */
public class Client {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		LinkedList<String> messageList = new LinkedList<String>();
		messageList.add("Hi");
		messageList.add("How are you?");
		messageList.add("Bye");
		InetAddress localHost = InetAddress.getLocalHost();
		
		//The client must know the hostname or IP of the machine on which the server is running and the port 
		//number on which the server is listening. In this case, We connect to the same client same port.
		//In reality, Client ip address will be different and it will connect to server's ip address.
		boolean stop = false;
		while(!stop) {
			Socket socket = new Socket(localHost.getHostAddress(), 6666);

			// Send message to server
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(messageList.removeFirst());

			// Receive Message from server
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

			String line = (String) objectInputStream.readObject();
			if(line.equals("Good night"))
				stop = true;
			System.out.println("Message from Server : " + line);
			
			objectOutputStream.close();
			objectInputStream.close();

			if (stop) {
				socket.close();
				break;
			}
	        Thread.sleep(1000);
		}
	}

}
